package Controladores;

import Modelos.EntityDB;
import Modelos.LectorEscritorDeArbol;
import Modelos.LectorEscritorDeEntidades;
import Modelos.LectorEscritorValuadorDeRol;
import Modelos.LogsRegister;

/**
 *
 * @author Itzcoatl90
 */
public class Escritura {
    LectorEscritorValuadorDeRol rol;
    LectorEscritorDeEntidades enti;
    LectorEscritorDeArbol arbol;
    LogsRegister logger;
    public Escritura(){
        rol = new LectorEscritorValuadorDeRol();
        logger = new LogsRegister();
    }
    public boolean autenticar(String login, String password){
        rol = new LectorEscritorValuadorDeRol();
        boolean logeo = rol.autenticar(login,password);
        logger.logLoggin(login, password, logeo);
        return logeo;
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
