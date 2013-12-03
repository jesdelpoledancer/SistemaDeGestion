package Modelos;

import Estructuras.Activo;
import Estructuras.Control;
import Estructuras.Entidad_P;
import Estructuras.Persona;
import Estructuras.PlanDeSoporte;
import Estructuras.Riesgo;
import Estructuras.Rol;
import Estructuras.Tarea;
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
    
}
