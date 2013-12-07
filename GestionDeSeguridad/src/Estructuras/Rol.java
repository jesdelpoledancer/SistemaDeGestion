package Estructuras;

import java.util.ArrayList;
import java.util.HashMap;

/**
 *
 * @author Itzcoatl90
 */
public class Rol {
    private String nombre;//1
    private DiccionarioDePrivilegios diccionario;//2
    private HashMap privilegios;//3 (para agregar privilegios) y 5 (para quitar privilegios)
    private ArrayList usuarios;//4 (para agregar usuarios) y 6 (para quitar usuarios)

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public DiccionarioDePrivilegios getDiccionario() {
        return diccionario;
    }

    public void setDiccionario(DiccionarioDePrivilegios diccionario) {
        this.diccionario = diccionario;
    }

    public HashMap getPrivilegios() {
        return privilegios;
    }

    public void setPrivilegios(HashMap privilegios) {
        this.privilegios = privilegios;
    }

    public ArrayList getUsuarios() {
        return usuarios;
    }

    public void setUsuarios(ArrayList usuarios) {
        this.usuarios = usuarios;
    }
    
}
