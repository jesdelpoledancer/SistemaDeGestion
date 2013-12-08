package Estructuras;

import java.util.ArrayList;
import java.util.HashMap;

/**
 *
 * @author Itzcoatl90
 */
public class Rol {
    //0 para ver, 1 para agregar y 2 para eliminar
    private String nombre;//3
    private DiccionarioDePrivilegios diccionario;//4
    private HashMap privilegios;//5 (para agregar privilegios) y 7 (para quitar privilegios)
    /*
     * Donde:
     * [1] Activo
     * [2] Control
     * [3] Politicas y procesos
     * [4] Plan de soporte
     * [5] Riesgo
     * [6] Rol
     */
    private ArrayList usuarios;//6 (para agregar usuarios) y 8 (para quitar usuarios)

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
