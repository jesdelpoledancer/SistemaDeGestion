package Controladores;

import Modelos.EntityDB;
import Modelos.LectorEscritorDeArbol;
import Modelos.LectorEscritorDeEntidades;
import Modelos.LectorEscritorDeMementos;
import Modelos.LectorEscritorDePrivilegios;
import Modelos.LectorEscritorValuadorDeRol;
import Modelos.LogsRegister;
import Modelos.Reporter;

/**
 *
 * @author Itzcoatl90
 */
public class Escritura {
    LectorEscritorValuadorDeRol rol;
    LectorEscritorDeEntidades enti;
    LectorEscritorDeArbol arbol;
    LogsRegister logger;
    LectorEscritorDeMementos memento;
    LectorEscritorDePrivilegios privilegio;
    Reporter reportero;
    public Escritura(){
        rol = new LectorEscritorValuadorDeRol();
        logger = new LogsRegister();
    }
    public boolean autenticar(String login, String password){
        boolean logeo = rol.autenticar(login,password);
        logger.logLoggin(login, password, logeo);
        return logeo;
    }
    
    public void leerDatos(){
        enti = new LectorEscritorDeEntidades();
        arbol = new LectorEscritorDeArbol();
        memento = new LectorEscritorDeMementos();
        privilegio = new LectorEscritorDePrivilegios();
        reportero = new Reporter();
        rol.leerRoles();
        enti.leerEntidadesDirectas();
        enti.leerEntidadesIndirectas();
        arbol.leerArbol();
    }
}
