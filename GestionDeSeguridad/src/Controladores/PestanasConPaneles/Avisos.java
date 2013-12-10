package Controladores.PestanasConPaneles;

import Controladores.Mediator;
import Modelos.EntityDB;
import java.util.ArrayList;
import java.util.Date;
import java.util.Stack;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JTextPane;
import javax.swing.text.BadLocationException;

/**
 *
 * @author Itzcoatl90
 */
public class Avisos implements Pestana {
    private Mediator m;
    private JPanel pizarra;
    private boolean init = true;
    public Avisos(Mediator m){
        pizarra = new JPanel();
        pizarra.setSize(595,489);
        this.m = m;
    }
    private void changePanel(JPanel panel){
        m.changePanel(6, panel);
    }
    
    @Override
    public void init(){
        if(init){
            init =false;
            prepararPanel();
        }
    }
    
    @Override
    public void prepararPanel(){
        JTextPane listaDeAvisos = new JTextPane();
        ArrayList avisos = new ArrayList();
        Date fecha = new Date();
        for (int i = 0; i < EntityDB.getInstance().getActivos().size(); i++) {
            Estructuras.Activo activoi = (Estructuras.Activo)EntityDB.getInstance().getActivos().get(i);
            ArrayList tokenRiesgos = (activoi).getRiesgos();
            //Reviso que todos los activos tengan riesgos asociados
            if(tokenRiesgos.size() < 1){
                avisos.add(activoSinRiesgo(activoi));
            }
            //Reviso que todos los activos tengan un monitoreo actual
            if(activoi.getProximoMonitoreo().getTime() < fecha.getTime()){
                avisos.add(monitoreoPasado(activoi.getNombre()));
            }
            //Reviso que todos los activos tengan riesgos que existan y que estén ligados correctamente
            for (int j = 0; j < tokenRiesgos.size(); j++) {
                Estructuras.Riesgo riesgoj = EntityDB.getInstance().encuentraRiesgo((String)tokenRiesgos.get(j));
                if(riesgoj == null){
                    avisos.add(riesgoQueNoExiste((String)tokenRiesgos.get(j),activoi.getNombre()));
                }
                if(!riesgoj.getActivo().equals(activoi.getNombre())){
                    avisos.add(relacionActivoRiesgoCorrupto(activoi.getNombre(),riesgoj.getAmenaza()));
                }
                //Reviso que la evaluación de todos los riesgos sean la suma de ocurrencia e impacto
                if(riesgoj.getRiesgo()!= (riesgoj.getImpacto()+riesgoj.getOcurrencia())){
                    evaluacionCorrupta(riesgoj);
                }
                //Reviso que todos los riesgos tengan uno de los tratamientos válidos (mitigar, aceptar, transferir)
                if(!riesgoj.getTratamiento().equals("Mitigarlo") && !riesgoj.getTratamiento().equals("Aceptarlo") && !riesgoj.getTratamiento().equals("Transferirlo")){
                    tratamientoIncorrecto(riesgoj);
                }
                //Reviso que todos los riesgos tengan un resultado válido
                if(!riesgoj.getTratamiento().equals("Modificar") && !riesgoj.getTratamiento().equals("Interrumpir") && !riesgoj.getTratamiento().equals("Revelar")){
                    resultadoIncorrecto(riesgoj);
                }
                //Reviso que todos los riesgos tengan un monitoreo actual
                if(riesgoj.getProximoMonitoreo().getTime() < fecha.getTime()){
                    avisos.add(monitoreoPasado(riesgoj.getAmenaza()));
                }
            }
        }
        //Reviso los riesgos que no tienen activos o que no se revisaron en el paso anterior
        for (int i = 0; i < EntityDB.getInstance().getRiesgos().size(); i++) {
            Estructuras.Riesgo riesgoi = (Estructuras.Riesgo)EntityDB.getInstance().getRiesgos().get(i);
            if(riesgoi.getActivo().equals("") || EntityDB.getInstance().encuentraActivos(riesgoi.getActivo()) == null){
                avisos.add(riesgoSinActivo(riesgoi));
            }
        }
        //Reviso que todos los riesgos "Mitigados" tengan un control que lo haga
        ArrayList tokenRiesgos = new ArrayList();
        for (int i = 0; i < EntityDB.getInstance().getRiesgos().size(); i++) {
            Estructuras.Riesgo riesgo = (Estructuras.Riesgo)EntityDB.getInstance().getRiesgos().get(i);
            if(riesgo.getTratamiento().equals("Mitigarlo")){
                tokenRiesgos.add(riesgo.getAmenaza());
            }
        }
        for (int i = 0; i < EntityDB.getInstance().getControles().size(); i++) {
            Estructuras.Control control = (Estructuras.Control)EntityDB.getInstance().getControles().get(i);
            //Reviso que todos los controles tengan un monitoreo actual
            if(control.getProximoMonitoreo().getTime() < fecha.getTime()){
                avisos.add(monitoreoPasado(control.getNombre()));
            }
            int costoActivos = control.getCostoDeAdquisicion();
            int costoInt = 0;
            int costoRev = 0;
            int costoMod = 0;
            ArrayList costoIntNoMonetario = new ArrayList();
            ArrayList costoRevNoMonetario = new ArrayList();
            ArrayList costoModNoMonetario = new ArrayList();
            for (int j = 0; j < control.getRiesgosAsociados().size(); j++) {
                Estructuras.Riesgo riesgoj = EntityDB.getInstance().encuentraRiesgo((String)control.getRiesgosAsociados().get(j));
                Estructuras.Activo activoj = EntityDB.getInstance().encuentraActivos(riesgoj.getActivo());
                //Reviso que el control no cueste más que sus activos
                try{
                    costoInt += Integer.parseInt(activoj.getCostoInterrupcion());
                }catch(java.lang.NumberFormatException e){
                    costoIntNoMonetario.add(activoj.getNombre()+":"+activoj.getCostoInterrupcion());
                }
                try{
                    costoRev += Integer.parseInt(activoj.getCostoRevelacion());
                }catch(java.lang.NumberFormatException e){
                    costoRevNoMonetario.add(activoj.getNombre()+":"+activoj.getCostoRevelacion());
                }
                try{
                    costoMod += Integer.parseInt(activoj.getCostoModificacion());
                }catch(java.lang.NumberFormatException e){
                    costoModNoMonetario.add(activoj.getNombre()+":"+activoj.getCostoModificacion());
                }
                //Reviso si hay controles con riesgos que no existen o recurrentes
                if(!tokenRiesgos.remove(riesgoj.getAmenaza())){
                    avisos.add(riesgoNulo(control,j));
                }
            }
            if(costoActivos > costoInt+costoRev+costoMod){
                avisos.add(precioDeControl(control.getNombre(),costoIntNoMonetario,costoRevNoMonetario,costoModNoMonetario));
            }
        }
        for (int i = 0; i < tokenRiesgos.size(); i++) {
            avisos.add(riesgoNoMitigado((String)tokenRiesgos.get(i)));
        }
        //Reviso que los todos los procesos tengan un plan de soporte
        Stack s = new Stack();
        s.push(EntityDB.getInstance().getRoot());
        while(s.size() > 0){
            boolean tiene = false;
            for (int i = 0; i < EntityDB.getInstance().getPlanesDeSoporte().size(); i++) {
                ArrayList politicasSoportadas = ((Estructuras.PlanDeSoporte)EntityDB.getInstance().getPlanesDeSoporte().get(i)).getPoliticasQueSoporta();
                for (int j = 0; j < politicasSoportadas.size(); j++) {
                    if(politicasSoportadas.get(j).equals(((Estructuras.Entidad_P)s.peek()).getNombre())){
                        tiene = true;
                        break;
                    }
                }
                if(tiene){
                    break;
                }
            }
            Estructuras.Entidad_P pop = (Estructuras.Entidad_P)s.pop();
            if(!tiene){
                if(pop.getHijas().length > 0){
                    for (int i = 0; i < pop.getHijas().length; i++) {
                        s.push(pop.getHijas()[i]);
                    }
                } else {
                    avisos.add(politicaSinSoporte(pop));
                }
            }
        }
        for (int i = 0; i < EntityDB.getInstance().getPlanesDeSoporte().size(); i++) {
            //Reviso que todos los planes de soporte tengan un monitoreo actual
            if(((Estructuras.PlanDeSoporte)EntityDB.getInstance().getPlanesDeSoporte().get(i)).getProximoMonitoreo().getTime() < fecha.getTime()){
                avisos.add(monitoreoPasado(((Estructuras.PlanDeSoporte)EntityDB.getInstance().getPlanesDeSoporte().get(i)).getNombre()));
            }
        }
        ArrayList totalControles = new ArrayList();
        ArrayList totalActivos = new ArrayList();
        s = new Stack();
        s.push(EntityDB.getInstance().getRoot());
        while(s.size() > 0){
            Estructuras.Entidad_P pop = (Estructuras.Entidad_P)s.pop();
            //Reviso que todas las políticas tengan un monitoreo actual
            if(pop.getProximoMonitoreo().getTime() < fecha.getTime()){
                avisos.add(monitoreoPasado(pop.getNombre()));
            }
            //Reviso que los responsables de todas las políticas existan
            if(EntityDB.getInstance().encuentraRoles(pop.getResponsable())==null){
                avisos.add(politicaSinResponsable(pop));
            }
            //Reviso que todas las políticas se liguen a todos los controles
            totalControles.addAll(pop.getControlesAsociados());
            //Reviso que todas las políticas se liguen a todos los activos
            totalActivos.addAll(pop.getActivosAsociados());
            //Reviso que todos los nodos del arbol sean procesos
            if(pop.getHijas().length > 0){
                for (int i = 0; i < pop.getHijas().length; i++) {
                    s.push(pop.getHijas()[i]);
                }
            } else {
                if(!(pop instanceof Estructuras.Proceso)){
                    avisos.add(politicaNodo(pop.getNombre()));
                }
            }
        }
        ArrayList totalControlesReales = new ArrayList();
        for (int i = 0; i < EntityDB.getInstance().getControles().size(); i++) {
            totalControlesReales.add(((Estructuras.Control)EntityDB.getInstance().getControles().get(i)).getNombre());
        }
        ArrayList totalActivosReales = new ArrayList();
        for (int i = 0; i < EntityDB.getInstance().getActivos().size(); i++) {
            totalActivosReales.add(((Estructuras.Activo)EntityDB.getInstance().getActivos().get(i)).getNombre());
        }
        totalControlesReales.removeAll(totalControles);
        totalActivosReales.removeAll(totalActivos);
        if(totalControlesReales.size() > 0){
            avisos.add(controlesSinPolitica(totalControlesReales));
        }
        if(totalActivosReales.size() > 0){
            avisos.add(activosSinPolitica(totalActivosReales));
        }
        if(avisos.size() == 0){
            avisos.add(mensajeDefault());
        }
        for (int i = 0; i < avisos.size(); i++) {
            try {
                listaDeAvisos.getStyledDocument().insertString(listaDeAvisos.getStyledDocument().getLength(), avisos.get(i) +"\n", null);
            } catch (BadLocationException ex) { ex.printStackTrace(); }
        }
        listaDeAvisos.setEditable(false);
        listaDeAvisos.setEnabled(false);
        listaDeAvisos.setBounds(0,0,650,150);
        pizarra.add(listaDeAvisos);
        pizarra.setBounds(0, 0, 700,489);
        changePanel(pizarra);
    }

    @Override
    public void mostrarPerfil(Object obj) {
        m.mostrarPerfil(obj);
    }
    
    private String mensajeDefault(){
        return "Todo parece estar en orden.\n"
                + "\tEsto (en S.I.) puede deberse a que te falta trabajo por hacer o a que no estás haciendo algo bien.";
    }
    
    private String politicaNodo(String nombre){
        return "La política: <"+nombre+"> es un Nodo en el arbol y no es proceso.\n"
                + "\tEsto puede deberse a que no está vigente y/o le faltan procesos que la implementen.";
    }
    
    private String activosSinPolitica(ArrayList activos){
        String salida = "Existen activos que no están ligados a ninguna política:\n";
        for (int i = 0; i < activos.size(); i++) {
            salida += "\t["+activos.get(i) +"]";
        }
        return salida;
    }
    
    private String controlesSinPolitica(ArrayList controles){
        String salida = "Existen controles que no están ligados a ninguna política:\n";
        for (int i = 0; i < controles.size(); i++) {
            salida += "\t["+controles.get(i) +"]";
        }
        return salida;
    }
    
    private String politicaSinResponsable(Estructuras.Entidad_P p){
        return "La política: <"+p.getNombre()+"> no tiene responsable, o el responsable <"+p.getResponsable()+"> no existe como rol";
    }
    
    private String politicaSinSoporte(Estructuras.Entidad_P politica){
        return "La política: <"+politica.getNombre()+"> no tiene quién la soporte.\n"
                + "\tEsto puede deberse a que no existe plan de soporte que esté ligado a ella o a que no sea proceso crítico";
    }
    
    private String precioDeControl(String nombre,ArrayList cint,ArrayList crev,ArrayList cmod){
        String sint="";
        for (int i = 0; i < cint.size(); i++) {
            sint+="["+cint.get(i)+"]";
        }
        String srev="";
        for (int i = 0; i < crev.size(); i++) {
            srev+="["+crev.get(i)+"]";
        }
        String smod="";
        for (int i = 0; i < cmod.size(); i++) {
            smod+="["+cmod.get(i)+"]";
        }
        String salida = "El control <"+nombre+"> tiene un costo de adquisición mayor a la suma del costo de sus activos.\n"
                + "\tEsto puede deberse a que: No se debería utilizar ese control, Los costos no son monetarios:\n"
                + "\tINTERRUPCION:"+sint+"\n"
                + "\tREVELACION:"+srev+"\n"
                + "\tMODIFICACION:"+smod;
        return salida;
    }
    
    private String riesgoNulo(Estructuras.Control control, int i){
        return "El control <"+control.getNombre()+"> mitiga un riesgo que no se encontró.\n"
                + "\tEsto puede deberse a que su riesgo: <"+control.getRiesgosAsociados().get(i)+"> no existe o que\n"
                + "\t\tes mitigado por varios controles.";
    }
    
    private String riesgoNoMitigado(String nombre){
        return "El riesgo <"+nombre+"> cuyo tratamiento es \"Mitigarlo\" no parece ser mitigado por ningún control";
    }
    
    private String activoSinRiesgo(Estructuras.Activo activo){
        return "El activo: <"+activo.getNombre()+"> no tiene riesgos asociados.\n\tEsto puede deberse a que: No se ha hecho su "
                + "análisis de riesgos, No se ha asociado con sus riesgos, No tiene riesgos.";
    }
    
    private String riesgoSinActivo(Estructuras.Riesgo riesgo){
        return "El riesgo: <"+riesgo.getAmenaza()+"> no tiene activos asociados que existan. <"+riesgo.getActivo()+">\n"
                + "\tEsto puede deberse a que: El activo asociado no existe, No tiene activos";
    }
    
    private String monitoreoPasado(String nombre){
        return "La fecha del próximo monitoreo de la entidad: <"+nombre+"> es anterior a la actual.\n\tEsto puede deberse a que: No se ha realizado su monitoreo.";
    }
    
    private String relacionActivoRiesgoCorrupto(String activo, String riesgo){
        return "El activo: <"+activo+"> y el riesgo: <"+riesgo+"> parecen tener una relacion corrupta.\n\tUno no se enlaza con el otro y el otro si";
    }
    
    private String evaluacionCorrupta(Estructuras.Riesgo riesgo){
        return "El riesgo: <"+riesgo.getAmenaza()+","+riesgo.getActivo()+"> parece estar evaluado incorrectamente.\n\tEsto puede deberse"
                + " a que su nivel de ocurrencia ("+riesgo.getOcurrencia()+") y su impacto ("+riesgo.getImpacto()+") no de su \n"
                + "\t\tevaluacion("+riesgo.getRiesgo()+")";
    }
    
    private String tratamientoIncorrecto(Estructuras.Riesgo riesgo){
        return "El riesgo: <"+riesgo.getAmenaza()+","+riesgo.getActivo()+"> parece no tener un tratamiento correcto.\n"
                + "\t<"+riesgo.getTratamiento()+"> no es \"Mitigarlo\" ni \"Aceptarlo\" ni \"Transferirlo\"";
    }
    
    private String resultadoIncorrecto(Estructuras.Riesgo riesgo){
        return "El riesgo: <"+riesgo.getAmenaza()+","+riesgo.getActivo()+"> parece no tener un resultado correcto.\n"
                + "\t<"+riesgo.getResultado()+"> no es \"Modificar\" ni \"Interrumpir\" ni \"Revelar\"";
    }
    
    private String riesgoQueNoExiste(String riesgo, String activo){
        return "El riesgo: <"+riesgo+"> asociado a <"+activo+"> parece no existir.";
    }
    
}
