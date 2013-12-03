package Controladores;

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
    
    public Mediator(){
        escritura = new Escritura();
        login  = new Login();
        login.setMediator(this);
        login.show();
    }
    
    public void autenticar(String login, String password){
        if(escritura.autenticar(login,password)){
            menu = new Menu();
            this.login.setVisible(false);
            menu.show();
        } else {
            this.login.errorDeAuten();
        }
    }
    
}
