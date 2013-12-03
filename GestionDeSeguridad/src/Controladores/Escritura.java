package Controladores;

import Modelos.LectorEscritorValuadorDeRol;

/**
 *
 * @author Itzcoatl90
 */
public class Escritura {
    LectorEscritorValuadorDeRol rol;
    public Escritura(){
        rol = new LectorEscritorValuadorDeRol();
    }
    public boolean autenticar(String login, String password){
        return rol.autenticar(login,password);
    }
}
