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
import java.util.HashMap;
import java.util.Stack;

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
        Activos = new ArrayList();
        PlanesDeSoporte = new ArrayList();
        Controles = new ArrayList();
    }
    
    public void setPersona(String rol, String login, String nombre, String password){
        persona = new Persona(rol,login,nombre,password);
    }
    
    public static EntityDB getInstance() {
        return EntityDBHolder.INSTANCE;
    }
    
    public Riesgo encuentraRiesgo(String nombre){
        for (int i = 0; i < Riesgos.size(); i++) {
            Riesgo r = (Riesgo)Riesgos.get(i);
            if(r.getAmenaza().equals(nombre)){
                return r;
            }
        }
        return null;
    }
    
    public Rol encuentraRoles(String nombre){
        for (int i = 0; i < Roles.size(); i++) {
            Rol r = (Rol)Roles.get(i);
            if(r.getNombre().equals(nombre)){
                return r;
            }
        }
        return null;
    }
    
    public Activo encuentraActivos(String nombre){
        for (int i = 0; i < Activos.size(); i++) {
            Activo a = (Activo)Activos.get(i);
            if(a.getNombre().equals(nombre)){
                return a;
            }
        }
        return null;
    }
    
    public PlanDeSoporte encuentraPlanDeSoporte(String nombre){
        for (int i = 0; i < PlanesDeSoporte.size(); i++) {
            PlanDeSoporte a = (PlanDeSoporte)PlanesDeSoporte.get(i);
            if(a.getNombre().equals(nombre)){
                return a;
            }
        }
        return null;
    }
    
    public Control encuentraControl(String nombre){
        for (int i = 0; i < Controles.size(); i++) {
            Control a = (Control)Controles.get(i);
            if(a.getNombre().equals(nombre)){
                return a;
            }
        }
        return null;
    }
    
    public Entidad_P encuentraPolitica(String nombre){
        Stack s = new Stack();
        s.push(EntityDB.getInstance().getRoot());
        while(s.size() != 0){
            Entidad_P p = (Entidad_P)s.pop();
            if(p.getNombre().equals(nombre)){
                return p;
            }
            for (int j = 0; j < p.getHijas().length; j++) {
                s.push(p.getHijas()[j]);
            }
        }
        return null;
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

    public Entidad_P getRoot() {
        return root;
    }

    public void setRoot(Entidad_P root) {
        this.root = root;
    }

    public ArrayList getActivos() {
        return Activos;
    }

    public ArrayList getPlanesDeSoporte() {
        return PlanesDeSoporte;
    }

    public ArrayList getControles() {
        return Controles;
    }
    
}
