package Controladores;

import Modelos.EntityDB;
import Modelos.LectorEscritorDeArbol;
import Modelos.LectorEscritorDeEntidades;
import Modelos.LectorEscritorValuadorDeRol;

/**
 *
 * @author Itzcoatl90
 */
public class Escritura {
    LectorEscritorValuadorDeRol rol;
    LectorEscritorDeEntidades enti;
    LectorEscritorDeArbol arbol;
    public Escritura(){
        rol = new LectorEscritorValuadorDeRol();
    }
    public boolean autenticar(String login, String password){
        rol = new LectorEscritorValuadorDeRol();
        return rol.autenticar(login,password);
    }
    
    public void leerDatos(){
        enti = new LectorEscritorDeEntidades();
        arbol = new LectorEscritorDeArbol();
        rol.leerRoles();
        enti.leerEntidadesDirectas();
        enti.leerEntidadesIndirectas();
        arbol.leerArbol();
    }
}
