package Controladores.PestanasConPaneles;

import Controladores.Mediator;
import javax.swing.JPanel;

/**
 *
 * @author Itzcoatl90
 */
public class Organizacion {
    private JPanel organigrama;
    private Mediator m;
    private boolean init = true;
    public Organizacion(Mediator m){
        organigrama = new JPanel();
        organigrama.setSize(595,489);
        this.m = m;
    }
    
    private void changePanel(JPanel panel){
        m.changePanel(2, panel);
    }
    
    public void init(){
        if(init){
            init =false;
            prepararMapa();
        }
    }
    
    public void prepararMapa(){
        /*
         * Aquí ya sabes pintar imagen y medir los perfiles de roles
         */
        changePanel(organigrama);
    }
    
}
