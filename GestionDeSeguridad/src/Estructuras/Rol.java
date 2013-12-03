package Estructuras;

import java.util.ArrayList;
import java.util.HashMap;

/**
 *
 * @author Itzcoatl90
 */
public class Rol {
    private String nombre;
    private DiccionarioDePrivilegios diccionario;
    private HashMap privilegios;
    private ArrayList usuarios;

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
