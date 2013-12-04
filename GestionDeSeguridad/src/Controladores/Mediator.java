package Controladores;

import Controladores.PestanasConPaneles.Asociaciones;
import Controladores.PestanasConPaneles.Avisos;
import Controladores.PestanasConPaneles.Calendario;
import Controladores.PestanasConPaneles.Organizacion;
import Controladores.PestanasConPaneles.Politicas;
import Controladores.PestanasConPaneles.Salidas;
import Controladores.PestanasConPaneles.VisualizacionDB;
import Controladores.paneles.PerfilDeActivo;
import Controladores.paneles.PerfilDeControl;
import Controladores.paneles.PerfilDePlanDeSoporte;
import Controladores.paneles.PerfilDeRiesgo;
import Controladores.paneles.PerfilDeRol;
import Controladores.paneles.Politica;
import Vistas.Login;
import Vistas.Menu;
import javax.swing.JPanel;

/**
 *
 * @author Itzcoatl90
 */
public class Mediator {
    
    //Controladores hermanos
    Escritura Control_escritura;
    Perfil Control_perfil;
    Privilegios Control_privilegio;
    
    //Controladores del paquete PestanasConPaneles
    Asociaciones Controlador_asos;
    Calendario Controlador_calendario;
    Avisos Controlador_aviso;
    Organizacion Controlador_organizacion;
    Politicas Controlador_politicas;
    VisualizacionDB Controlador_recursos;
    Salidas Controlador_salida;
    
    //Vistas
    Vistas.Perfil Vista_perfil;
    Menu Vista_menu;
    Login Vista_login;
    
    //Perfiles
    PerfilDeActivo ACTIVO;
    PerfilDeControl CONTROL;
    PerfilDePlanDeSoporte SOPORTE;
    PerfilDeRiesgo RIESGO;
    PerfilDeRol ROL;
    Politica POLITICA;
    
    public Mediator(){
        Control_escritura = new Escritura();
        Vista_login  = new Login();
        Vista_login.setMediator(this);
        Vista_login.show();
    }
    
    public void autenticar(String login, String password){
        if(Control_escritura.autenticar(login,password)){
            
            //Controles hermanos
            Control_perfil = new Perfil();
            Control_privilegio = Privilegios.getInstance();
            
            //Controladores de pestañas
            Controlador_asos = new Asociaciones(this);
            Controlador_calendario = new Calendario(this);
            Controlador_aviso = new Avisos(this);
            Controlador_organizacion = new Organizacion(this);
            Controlador_politicas = new Politicas(this);
            Controlador_recursos = new VisualizacionDB(this);
            Controlador_salida = new Salidas(this);
            
            //Vistas
            Vista_perfil = new Vistas.Perfil();
            Vista_menu = new Menu();
            Vista_perfil.setMediator(this);
            Vista_menu.setMediator(this);
            
            //Procedimiento
            Control_escritura.leerDatos();
            Controlador_asos.init();
            Controlador_calendario.init();
            Controlador_aviso.init();
            Controlador_organizacion.init();
            Controlador_politicas.init();
            Controlador_recursos.init();
            Controlador_salida.init();
            
            //Cambio de panel
            this.Vista_login.setVisible(false);
            Vista_menu.setVisible(true);
        
        } else {
            this.Vista_login.errorDeAuten();
        }
    }
    
    public void changePanel(int indice, JPanel panel){
        Vista_menu.setCalendario(indice,panel);
    }
    
    public void mostrarPerfil(Object obj){
        if(obj instanceof Estructuras.Activo){
            Estructuras.Activo puntero = (Estructuras.Activo)obj;
        }
        if(obj instanceof Estructuras.Control){
            Estructuras.Control puntero = (Estructuras.Control)obj;
        }
        if(obj instanceof Estructuras.Entidad_P){
            Estructuras.Entidad_P puntero = (Estructuras.Entidad_P)obj;
        }
        if(obj instanceof Estructuras.PlanDeSoporte){
            Estructuras.PlanDeSoporte puntero = (Estructuras.PlanDeSoporte)obj;
        }
        if(obj instanceof Estructuras.Riesgo){
            Estructuras.Riesgo puntero = (Estructuras.Riesgo)obj;
        }
        if(obj instanceof Estructuras.Rol){
            Estructuras.Rol puntero = (Estructuras.Rol)obj;
        }
        Vista_perfil.setVisible(true);
    }
    
}
