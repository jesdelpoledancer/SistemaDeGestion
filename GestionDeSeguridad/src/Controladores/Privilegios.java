package Controladores;

import Estructuras.Rol;

/**
 *
 * @author Itzcoatl90
 */
public class Privilegios {
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
