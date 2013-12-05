package Controladores;

import Controladores.PestanasConPaneles.Asociaciones;
import Controladores.PestanasConPaneles.Avisos;
import Controladores.PestanasConPaneles.Calendario;
import Controladores.PestanasConPaneles.Organizacion;
import Controladores.PestanasConPaneles.Politicas;
import Controladores.PestanasConPaneles.Salidas;
import Controladores.PestanasConPaneles.VisualizacionDB;
import Controladores.paneles.PerfilDeActivo;
import Controladores.paneles.PerfilDeControl;
import Controladores.paneles.PerfilDePlanDeSoporte;
import Controladores.paneles.PerfilDeRiesgo;
import Controladores.paneles.PerfilDeRol;
import Controladores.paneles.Politica;
import Estructuras.Rol;
import Estructuras.Tarea;
import Modelos.EntityDB;
import Vistas.Login;
import Vistas.Menu;
import java.text.Format;
import java.text.SimpleDateFormat;
import javax.swing.JPanel;

/**
 *
 * @author Itzcoatl90
 */
public class Mediator {
    
    //Controladores hermanos
    Escritura Control_escritura;
    Perfil Control_perfil;
    Privilegios Control_privilegio;
    
    //Controladores del paquete PestanasConPaneles
    Asociaciones Controlador_asos;
    Calendario Controlador_calendario;
    Avisos Controlador_aviso;
    Organizacion Controlador_organizacion;
    Politicas Controlador_politicas;
    VisualizacionDB Controlador_recursos;
    Salidas Controlador_salida;
    
    //Vistas
    Vistas.Perfil Vista_perfil;
    Menu Vista_menu;
    Login Vista_login;
    
    //Perfiles
    PerfilDeActivo ACTIVO;
    PerfilDeControl CONTROL;
    PerfilDePlanDeSoporte SOPORTE;
    PerfilDeRiesgo RIESGO;
    PerfilDeRol ROL;
    Politica POLITICA;
    
    public Mediator(){
        Control_escritura = new Escritura();
        Vista_login  = new Login();
        Vista_login.setMediator(this);
        Vista_login.setVisible(true);
    }
    
    public void autenticar(String login, String password){
        if(Control_escritura.autenticar(login,password)){
            
            //Controles hermanos
            Control_perfil = new Perfil();
            Control_privilegio = Privilegios.getInstance();
            
            //Controladores de pestañas
            Controlador_asos = new Asociaciones(this);
            Controlador_calendario = new Calendario(this);
            Controlador_aviso = new Avisos(this);
            Controlador_organizacion = new Organizacion(this);
            Controlador_politicas = new Politicas(this);
            Controlador_recursos = new VisualizacionDB(this);
            Controlador_salida = new Salidas(this);
            
            //Vistas
            Vista_perfil = new Vistas.Perfil();
            Vista_menu = new Menu();
            Vista_perfil.setMediator(this);
            Vista_menu.setMediator(this);
            
            //Procedimiento
            Control_escritura.leerDatos();
            Controlador_asos.init();
            Controlador_calendario.init();
            Controlador_aviso.init();
            Controlador_organizacion.init();
            Controlador_politicas.init();
            Controlador_recursos.init();
            Controlador_salida.init();
            
            //Cambio de panel
            this.Vista_login.setVisible(false);
            Vista_menu.setVisible(true);
        
        } else {
            this.Vista_login.errorDeAuten();
        }
    }
    
    public void changePanel(int indice, JPanel panel){
        Vista_menu.setCalendario(indice,panel);
    }
    
    public void mostrarPerfil(Object obj){
        //Rol r = EntityDB.getInstance().getPersona().getRol();
        //POR AHORITA
        Rol r = new Rol();
        if(Control_privilegio.ver(r, obj)){
            if(obj instanceof Estructuras.Activo){
                ACTIVO = new PerfilDeActivo();
                Estructuras.Activo puntero = (Estructuras.Activo)obj;
                Format formatter = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
                ACTIVO.setNombre(puntero.getNombre());
                ACTIVO.setCostoModif(puntero.getCostoModificacion());
                ACTIVO.setCostoInt(puntero.getCostoInterrupcion());
                ACTIVO.setCostoRev(puntero.getCostoRevelacion());
                ACTIVO.setTiempoMon(formatter.format(puntero.getTiempoDeMonitoreo()));
                ACTIVO.setProximaMon(formatter.format(puntero.getProximoMonitoreo()));
                ACTIVO.setRiesgos(puntero.getRiesgos().toArray());
                ACTIVO.setNombreEnabled(Control_privilegio.modificar(r, obj, 1));//Revisar esto
                ACTIVO.setCostoModifEnabled(Control_privilegio.modificar(r, obj, 2));//Revisar esto
                ACTIVO.setCostoIntEnabled(Control_privilegio.modificar(r, obj, 3));//Revisar esto
                ACTIVO.setCostoRevEnabled(Control_privilegio.modificar(r, obj, 4));//Revisar esto
                ACTIVO.setTiempoMonEnabled(Control_privilegio.modificar(r, obj, 5));//Revisar esto
                ACTIVO.setProximaMonEnabled(Control_privilegio.modificar(r, obj, 6));//Revisar esto
                Vista_perfil.change(ACTIVO);
            }else
            if(obj instanceof Estructuras.Control){
                CONTROL = new PerfilDeControl();
                Estructuras.Control puntero = (Estructuras.Control)obj;
                Format formatter = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
                CONTROL.setNombre(puntero.getNombre());
                CONTROL.setTiempoMon(formatter.format(puntero.getTiempoDeMonitoreo()));
                CONTROL.setProximaMon(formatter.format(puntero.getProximoMonitoreo()));
                CONTROL.setRiesgos(puntero.getRiesgosAsociados().toArray());
                Object object[] = new Object[puntero.getTareasARealizar().size()*2];
                for (int i = 0; i < object.length; i++) {
                    if(i%2==0){
                        object[i] = ((Tarea)puntero.getTareasARealizar().get(i/2)).getNombre();
                    } else {
                        object[i] = "\t"+((Tarea)puntero.getTareasARealizar().get(i/2)).getDescripcion();
                    }
                }
                CONTROL.setTareas(object);
                CONTROL.setNombreEnabled(Control_privilegio.modificar(r, obj, 1));//Revisar esto
                CONTROL.setTiempoMonEnabled(Control_privilegio.modificar(r, obj, 2));//Revisar esto
                CONTROL.setProximaMonEnabled(Control_privilegio.modificar(r, obj, 3));//Revisar esto
                Vista_perfil.change(CONTROL);
            }else
            if(obj instanceof Estructuras.Entidad_P){
                POLITICA = new Politica();
                Estructuras.Entidad_P puntero = (Estructuras.Entidad_P)obj;
                Format formatter = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
                POLITICA.setNombre(puntero.getNombre());
                POLITICA.setDescripcion(puntero.getDescripcion());
                POLITICA.setEstado(puntero.getEstado());
                POLITICA.setTiempoMon(formatter.format(puntero.getTiempoDeMonitoreo()));
                POLITICA.setProximoMon(formatter.format(puntero.getProximoMonitoreo()));
                POLITICA.setResponsable(puntero.getResponsable().getNombre());
                if(puntero.getNombre()!="Mision de seguridad"){
                    POLITICA.setPadre(puntero.getPadre().getNombre());
                }else{
                    POLITICA.setPadre("-");
                }
                POLITICA.setControles(puntero.getControlesAsociados().toArray());
                POLITICA.setActivos(puntero.getActivosAsociados().toArray());
                POLITICA.setHijas(puntero.getNombreHijas());
                POLITICA.setNombreEnable(Control_privilegio.modificar(r, obj, 1));//Revisar esto
                POLITICA.setDescripcionEnable(Control_privilegio.modificar(r, obj, 2));//Revisar esto
                POLITICA.setEstadoEnable(Control_privilegio.modificar(r, obj, 3));//Revisar esto
                POLITICA.setTiempoMonEnable(Control_privilegio.modificar(r, obj, 4));//Revisar esto
                POLITICA.setProximoMonEnable(Control_privilegio.modificar(r, obj, 5));//Revisar esto
                POLITICA.setResponsableEnable(Control_privilegio.modificar(r, obj, 6));//Revisar esto
                POLITICA.setPadreEnable(Control_privilegio.modificar(r, obj, 7));//Revisar esto
                Vista_perfil.change(POLITICA);
            }else
            if(obj instanceof Estructuras.PlanDeSoporte){
                SOPORTE = new PerfilDePlanDeSoporte();
                Estructuras.PlanDeSoporte puntero = (Estructuras.PlanDeSoporte)obj;
                Format formatter = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
                SOPORTE.setNombre(puntero.getNombre());
                SOPORTE.setDescripcion(puntero.getDescripcion());
                SOPORTE.setTiempoMon(formatter.format(puntero.getTiempoDeMonitoreo()));
                SOPORTE.setProximoMon(formatter.format(puntero.getProximoMonitoreo()));
                SOPORTE.setPoliticas(puntero.getPoliticasQueSoporta().toArray());
                Object object[] = new Object[puntero.getTareasARealizar().size()*2];
                for (int i = 0; i < object.length; i++) {
                    if(i%2==0){
                        object[i] = ((Tarea)puntero.getTareasARealizar().get(i/2)).getNombre();
                    } else {
                        object[i] = "\t"+((Tarea)puntero.getTareasARealizar().get(i/2)).getDescripcion();
                    }
                }
                SOPORTE.setTareas(object);
                Vista_perfil.change(SOPORTE);
            }else
            if(obj instanceof Estructuras.Riesgo){
                RIESGO = new PerfilDeRiesgo();
                Estructuras.Riesgo puntero = (Estructuras.Riesgo)obj;
                Format formatter = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
                System.out.println(puntero.getActivo());
                RIESGO.setActivo(puntero.getActivo());
                RIESGO.setAmenaza(puntero.getAmenaza());
                RIESGO.setImpacto(""+puntero.getImpacto());
                RIESGO.setOcurrencia(""+puntero.getOcurrencia());
                RIESGO.setResultado(puntero.getResultado());
                RIESGO.setTratamiento(puntero.getTratamiento());
                RIESGO.setTiempoMon(formatter.format(puntero.getTiempoDeMonitoreo()));
                RIESGO.setProximoMon(formatter.format(puntero.getProximoMonitoreo()));
                RIESGO.setRiesgo(""+puntero.getRiesgo());
                RIESGO.setActivoEnabled(Control_privilegio.modificar(r, obj, 1));//Revisar esto
                RIESGO.setAmenazaEnabled(Control_privilegio.modificar(r, obj, 2));//Revisar esto
                RIESGO.setImpactoEnabled(Control_privilegio.modificar(r, obj, 3));//Revisar esto
                RIESGO.setOcurrenciaEnabled(Control_privilegio.modificar(r, obj, 4));//Revisar esto
                RIESGO.setResultadoEnabled(Control_privilegio.modificar(r, obj, 5));//Revisar esto
                RIESGO.setTratamientoEnabled(Control_privilegio.modificar(r, obj, 6));//Revisar esto
                RIESGO.setTiempoMonEnabled(Control_privilegio.modificar(r, obj, 7));//Revisar esto
                RIESGO.setProximoMonEnabled(Control_privilegio.modificar(r, obj, 8));//Revisar esto
                RIESGO.setRiesgoEnabled(Control_privilegio.modificar(r, obj, 9));//Revisar esto
                Vista_perfil.change(RIESGO);
            }else
            if(obj instanceof Estructuras.Rol){
                Estructuras.Rol puntero = (Estructuras.Rol)obj;
                Format formatter = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
                //ROL//DEPENDE DE PRIVILEGIOS
                Vista_perfil.change(ROL);
            }
            Vista_perfil.setVisible(true);
        }
    }
    
}
