package Controladores.PestanasConPaneles;

import Controladores.Mediator;
import javax.swing.JPanel;

/**
 *
 * @author Itzcoatl90
 */
public class Organizacion {
    JPanel organigrama;
    Mediator m;
    public Organizacion(Mediator m){
        organigrama = new JPanel();
        organigrama.setSize(580,450);
        this.m = m;
    }
    
    public JPanel prepararMapa(){
        /*
         * Aquí ya sabes
         */
        return organigrama;
    }
    
}
