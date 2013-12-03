package Controladores;

import Controladores.PestanasConPaneles.Asociaciones;
import Controladores.PestanasConPaneles.Calendario;
import Vistas.Login;
import Vistas.Menu;
import javax.swing.JPanel;

/**
 *
 * @author Itzcoatl90
 */
public class Mediator {
    Login login;
    Menu menu;
    Escritura escritura;
    Calendario calendario;
    Vistas.Perfil perfil;
    Asociaciones asos;
    
    public Mediator(){
        escritura = new Escritura();
        login  = new Login();
        perfil = new Vistas.Perfil();
        login.setMediator(this);
        login.show();
    }
    
    public void autenticar(String login, String password){
        if(escritura.autenticar(login,password)){
            menu = new Menu();
            menu.setMediator(this);
            calendario = new Calendario(this);
            this.login.setVisible(false);
            escritura.leerDatos();
            menu.setCalendario(calendario.prepararCalendario());
            menu.show();
        } else {
            this.login.errorDeAuten();
        }
    }
    
    public void changePanel(JPanel panel){
        menu.setCalendario(panel);
    }
    
    public void mostrarPerfil(Object obj){
        /*
         * Itzco, tu sabes tu chamba... este método es para todos tus compañeritos (riesgo, control, rol, Activo, etc etc).
         * Mostrar en perfil...
         * * TIENES QUE CHECAR PRIVILEGIOS POR SI LA PETICION NO ES DEL CALENDARIO
         */
        perfil.show();
    }
    
    public void cambiaPestana(int pestana){
        switch(pestana){
            case 1:aAsociaciones();
            break;
            case 2:aAvisos();
            break;
            case 3:aCalendario();
            break;
            case 4:aOrganizacion();
            break;
            case 5:aPoliticas();
            break;
            case 6:aVisualizacionDB();
            break;
            case 7:aSalidas();
            break;
        }
    }
    
    private void aAsociaciones(){
        if(asos== null){
            asos = new Asociaciones(this);
        }
        menu.setCalendario(asos.prepararListas());
    }
    private void aAvisos(){
    }
    private void aCalendario(){
    }
    private void aOrganizacion(){
    }
    private void aPoliticas(){
    }
    private void aVisualizacionDB(){
    }
    private void aSalidas(){
    }
    
}
