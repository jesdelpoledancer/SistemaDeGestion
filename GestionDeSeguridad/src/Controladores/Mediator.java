package Controladores;

import Controladores.PestanasConPaneles.Calendario;
import Vistas.Login;
import Vistas.Menu;

/**
 *
 * @author Itzcoatl90
 */
public class Mediator {
    Login login;
    Menu menu;
    Escritura escritura;
    Calendario calendario;
    
    public Mediator(){
        escritura = new Escritura();
        login  = new Login();
        login.setMediator(this);
        login.show();
    }
    
    public void autenticar(String login, String password){
        if(escritura.autenticar(login,password)){
            menu = new Menu();
            calendario = new Calendario();
            this.login.setVisible(false);
            escritura.leerDatos();
            menu.setCalendario(calendario.prepararCalendario());
            menu.show();
        } else {
            this.login.errorDeAuten();
        }
    }
    
}
