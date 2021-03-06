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
import Estructuras.Rol;
import Estructuras.Tarea;
import Modelos.EntityDB;
import Vistas.Login;
import Vistas.Menu;
import java.text.Format;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.HashMap;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;
import org.pushingpixels.substance.api.SubstanceLookAndFeel;

/**
 *
 * @author Itzcoatl90
 */
public class Mediator {
    
    //Auxiliador para el invokeLater
    private Mediator apuntador;
    
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
    Vistas.Salvado Vista_Memento;
    
    //Perfiles
    PerfilDeActivo ACTIVO;
    PerfilDeControl CONTROL;
    PerfilDePlanDeSoporte SOPORTE;
    PerfilDeRiesgo RIESGO;
    PerfilDeRol ROL;
    Politica POLITICA;
    
    public Mediator(){
        apuntador = this;
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                SubstanceLookAndFeel.setSkin("org.pushingpixels.substance.api.skin.MagellanSkin");
                Control_escritura = new Escritura();
                Vista_login  = new Login();
                Vista_login.setMediator(apuntador);
                Vista_login.setVisible(true);
            }
          });
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
            Vista_Memento = new Vistas.Salvado();
            Vista_perfil.setMediator(this);
            Vista_menu.setMediator(this);
            Vista_Memento.setMediator(this);
            
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
    
    public void mostrarMemento(){
        Vista_Memento.setVisible(true);
    }
    
    public void mostrarPerfil(Object obj){
        Rol r = EntityDB.getInstance().getPersona().getRol();
        if(Control_privilegio.ver(r, obj)){
            if(obj instanceof Estructuras.Activo){
                ACTIVO = new PerfilDeActivo();
                ACTIVO.setMediator(this);
                Estructuras.Activo puntero = (Estructuras.Activo)obj;
                Control_perfil.change(ACTIVO, puntero, r);
                Vista_perfil.change(ACTIVO);
            }else
            if(obj instanceof Estructuras.Control){
                CONTROL = new PerfilDeControl();
                CONTROL.setMediator(this);
                Estructuras.Control puntero = (Estructuras.Control)obj;
                Control_perfil.change(CONTROL, puntero, r);
                Vista_perfil.change(CONTROL);
            }else
            if(obj instanceof Estructuras.Entidad_P){
                POLITICA = new Politica();
                POLITICA.setMediator(this);
                Estructuras.Entidad_P puntero = (Estructuras.Entidad_P)obj;
                Control_perfil.change(POLITICA, puntero, r);
                Vista_perfil.change(POLITICA);
            }else
            if(obj instanceof Estructuras.PlanDeSoporte){
                SOPORTE = new PerfilDePlanDeSoporte();
                SOPORTE.setMediator(this);
                Estructuras.PlanDeSoporte puntero = (Estructuras.PlanDeSoporte)obj;
                Control_perfil.change(SOPORTE, puntero, r);
                Vista_perfil.change(SOPORTE);
            }else
            if(obj instanceof Estructuras.Riesgo){
                RIESGO = new PerfilDeRiesgo();
                Estructuras.Riesgo puntero = (Estructuras.Riesgo)obj;
                Control_perfil.change(RIESGO, puntero, r);
                Vista_perfil.change(RIESGO);
            }else
            if(obj instanceof Estructuras.Rol){
                ROL = new PerfilDeRol();
                Estructuras.Rol puntero = (Estructuras.Rol)obj;
                Control_perfil.change(ROL, puntero, r);
                Vista_perfil.change(ROL);
            }
            Vista_perfil.setVisible(true);
        }
    }
    
}
