package Controladores;

import Estructuras.Rol;

/**
 *
 * @author Itzcoatl90
 */
public class Privilegios {
    
    private Privilegios() {
    }
    
    public static Privilegios getInstance() {
        return PrivilegiosHolder.INSTANCE;
    }
    
    private static class PrivilegiosHolder {

        private static final Privilegios INSTANCE = new Privilegios();
    }
    public String ObjetoEstructura(Object obj){
         String objeto1="";
        
        if(obj instanceof Estructuras.Activo == true)
            objeto1 ="Activo";
        if(obj instanceof Estructuras.Control == true)
            objeto1 ="Control";
        if(obj instanceof Estructuras.DatosConfidenciales == true)
            objeto1 ="DatoConf";
        if(obj instanceof Estructuras.DiccionarioDePrivilegios == true)
            objeto1 ="DiccPriv";
        if(obj instanceof Estructuras.Entidad_P == true)
            objeto1 ="Entidad";
        if(obj instanceof Estructuras.Persona == true)
            objeto1 ="Persona";
        if(obj instanceof Estructuras.PlanDeSoporte == true)
            objeto1 ="PlanSoporte";
        if(obj instanceof Estructuras.Politica == true)
            objeto1 ="Politica";
        if(obj instanceof Estructuras.Proceso == true)
            objeto1 ="Proceso";
        if(obj instanceof Estructuras.Riesgo == true)
            objeto1 ="Riesgo";
        
        return objeto1;
    }
    
    public boolean ver(Rol rol,Object obj){
       
        /*
         * Este método revisa si el rol puede mirar el TIPO de objeto
         * obj... Para esto, se debe checar que es obj (instanceOf), o
         * hacer un método por cada entidad diferente (riesgo, activo,
         * politica, control, plan de soporte).
         * 
         * Regresa true si puede hacerlo
         * Regresa false si no
         */
        //verificamos instancia
        
        
            
        return true;
    }
    
    public boolean crear(Rol rol, Object obj){
        /*
         * Este método revisa si el rol puede crear el TIPO de objeto
         * obj... Para esto, se debe checar que es obj (instanceOf), o
         * hacer un método por cada entidad diferente (riesgo, activo,
         * politica, control, plan de soporte).
         * 
         * Regresa true si puede hacerlo
         * Regresa false si no
         */
        return true;
    }
    
    public boolean eliminar(Rol rol, Object obj){
        /*
         * Este método revisa si el rol puede eliminar el TIPO de objeto
         * obj... Para esto, se debe checar que es obj (instanceOf), o
         * hacer un método por cada entidad diferente (riesgo, activo,
         * politica, control, plan de soporte).
         * 
         * Regresa true si puede hacerlo
         * Regresa false si no
         */
        return true;
    }
    
    public boolean modificar(Rol rol, Object obj, int numeroAtributo){
        /*
         * Este método revisa si el rol puede modificar el TIPO de objeto
         * obj (y el número de atributo numeroAtributo)... Para esto, se
         * debe checar que es obj (instanceOf), o
         * hacer un método por cada entidad diferente (riesgo, activo,
         * politica, control, plan de soporte).
         * 
         * Regresa true si puede hacerlo
         * Regresa false si no
         */
        return true;
    }
    
}
