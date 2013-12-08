package Estructuras;

import Controladores.Privilegios;
import Modelos.EntityDB;
import java.util.ArrayList;

/**
 *
 * @author Itzcoatl90
 */
public class Persona {
    private DatosConfidenciales info;

    public Persona(String rol, String nombre, String login, String password) {
        info = new DatosConfidenciales(rol,nombre,login,password);
    }
    
    public Rol getRol(){
        ArrayList p = EntityDB.getInstance().getRoles();
        for (int i = 0; i < p.size(); i++) {
            if(((Rol)p.get(i)).getNombre()==info.getRol()){
                return (Rol)p.get(i);
            }
        }
        return null;
    }

    public String getStringRol() {
        return info.getRol();
    }
    
    public void setStringRol(String nuevoRol){
        info.setRol(nuevoRol);
    }
    
}
