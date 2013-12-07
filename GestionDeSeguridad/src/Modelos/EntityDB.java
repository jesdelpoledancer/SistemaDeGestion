package Modelos;

import Estructuras.Activo;
import Estructuras.Control;
import Estructuras.Entidad_P;
import Estructuras.Persona;
import Estructuras.PlanDeSoporte;
import Estructuras.Politica;
import Estructuras.Proceso;
import Estructuras.Riesgo;
import Estructuras.Rol;
import Estructuras.Tarea;
import java.sql.Date;
import java.sql.Time;
import java.util.ArrayList;

/**
 *
 * @author Itzcoatl90
 */
public class EntityDB {
    private ArrayList Tareas;
    private ArrayList Riesgos;
    private ArrayList Roles;
    private ArrayList Activos;
    private ArrayList PlanesDeSoporte;
    private ArrayList Controles;
    private Entidad_P root;
    private Persona persona;
            
    private EntityDB() {
        Tareas = new ArrayList();
        Riesgos = new ArrayList();
        Roles = new ArrayList();
    }
    
    public void setPersona(String rol, String login, String nombre, String password){
        persona = new Persona(rol,login,nombre,password);
    }
    
    public static EntityDB getInstance() {
        return EntityDBHolder.INSTANCE;
    }
    
    private static class EntityDBHolder {

        private static final EntityDB INSTANCE = new EntityDB();
    }
    
    public void agregarTarea(Tarea t){
        Tareas.add(t);
    }
    
    public void agregarRiesgo(Riesgo r){
        Riesgos.add(r);
    }
    
    public void agregarRol(Rol r){
        Roles.add(r);
    }
    
    public void agregarActivo(Activo a){
        Activos.add(a);
    }
    
    public void agregarPlanDeSoporte(PlanDeSoporte s){
        PlanesDeSoporte.add(s);
    }
    
    public void agregarControl(Control c){
        Controles.add(c);
    }

    public ArrayList getTareas() {
        return Tareas;
    }

    public ArrayList getRiesgos() {
        return Riesgos;
    }

    public ArrayList getRoles() {
        return Roles;
    }

    public Persona getPersona() {
        return persona;
    }
    
    public void agregaMision(Entidad_P e){
        this.root = e;
    }
    
    
    
    //TEMPORALES
    
    public Riesgo riesgoEjemplo(){
        Riesgo r = new Riesgo();
                    r.setActivo("Servidor");
                    r.setAmenaza("El itzco!");
                    r.setImpacto(5);
                    r.setOcurrencia(5);//Ese itzco está en todos lados
                    r.setProximoMonitoreo(new Date(1,2,3));
                    r.setResultado("Interrupcion");
                    r.setRiesgo(10);//Alto peligro
                    r.setTiempoDeMonitoreo(new Time(1,2,3));
                    r.setTratamiento("Aceptarlo");//No se puede hacer nada contra el itzco
                    return r;
    }
    
    public Control controlEjemplo(){
        Control c = new Control();
        c.setNombre("Antivirus ZAM");
        c.setProximoMonitoreo(new Date(1,2,3));
        c.setTiempoDeMonitoreo(new Time(1,2,3));
        ArrayList tar = new ArrayList();
        tar.add(tareaEjemplo());
        tar.add(tareaEjemplo());
        c.setTareasARealizar(tar);
        ArrayList ries = new ArrayList();
        ries.add("Riesgo 1");
        ries.add("Riesgo 2");
        c.setRiesgosAsociados(ries);
        return c;
    }
    
    public Tarea tareaEjemplo(){
        Tarea salida = new Tarea();
        salida.setNombre("Paso");
        salida.setDescripcion("Realizar el paso");
        return salida;
    }
    
    public Entidad_P politicaEjemplo(){
        Politica p = new Politica();
        p.setNombre("Politica General");
        p.setDescripcion("Esta es la descripcion de la política general");
        p.setProximoMonitoreo(new Date(1,2,3));
        p.setTiempoDeMonitoreo(new Time(1,2,3));
        ArrayList act = new ArrayList();
        act.add("Servidor");
        act.add("Activo 2");
        p.setActivosAsociados(act);
        ArrayList cont = new ArrayList();
        cont.add("Antivirus ZAM");
        cont.add("Control 2");
        p.setControlesAsociados(cont);
        p.setPadre(new Politica());
        p.setResponsable(rolEjemplo());
        ArrayList hija = new ArrayList();
        hija.add(procesoEjemplo());
        p.setHijas(hija);
        p.setEstado("Vigente");
        return p;
    }
    
    public Entidad_P procesoEjemplo(){
        Proceso p = new Proceso();
        p.setNombre("Sobre el cifrado con el algoritmo Sotelo");
        p.setDescripcion("Esta es la descripcion del proceso");
        p.setProximoMonitoreo(new Date(1,2,3));
        p.setTiempoDeMonitoreo(new Time(1,2,3));
        ArrayList act = new ArrayList();
        act.add("Servidor");
        act.add("Activo 2");
        p.setActivosAsociados(act);
        ArrayList cont = new ArrayList();
        cont.add("Antivirus ZAM");
        cont.add("Control 2");
        p.setControlesAsociados(cont);
        p.setPadre(new Politica());
        p.setResponsable(rolEjemplo());
        p.setEstado("Vigente");
        return p;
    }
    
    public Activo activoEjemplo(){
        Activo act = new Activo();
        act.setNombre("Servidor");
        act.setProximoMonitoreo(new Date(1,2,3));
        act.setTiempoDeMonitoreo(new Time(1,2,3));
        act.setCostoInterrupcion("50000");
        act.setCostoModificacion("Reputación");
        act.setCostoRevelacion("100000");
        ArrayList ries = new ArrayList();
        ries.add("El itzco!");
        ries.add("El joel!");//Que también es hacker
        act.setRiesgos(ries);
        return act;
    }
    
    public Rol rolEjemplo(){
        Rol r = new Rol();
        r.setNombre("Director de TI");
        ArrayList user = new ArrayList();
        user.add("itzcoatl90");
        user.add("neogiovas");
        user.add("DanielZam");
        user.add("Jortegam");
        user.add("msotelo");
        r.setUsuarios(user);
        return r;
    }
    
    public PlanDeSoporte planDeSoporteEjemplo(){
        PlanDeSoporte sop = new PlanDeSoporte();
        sop.setNombre("Plan de Contingencia");
        sop.setDescripcion("Es el plan de contingencia para los servicios digitales");
        sop.setProximoMonitoreo(new Date(1,2,3));
        sop.setTiempoDeMonitoreo(new Time(1,2,3));
        ArrayList tar = new ArrayList();
        tar.add(tareaEjemplo());
        tar.add(tareaEjemplo());
        sop.setTareasARealizar(tar);
        ArrayList pol = new ArrayList();
        pol.add("Politica General");
        pol.add("Sobre el cifrado con el algoritmo Sotelo");
        sop.setPoliticasQueSoporta(pol);
        return sop;
    }
    
}
