package Controladores.PestanasConPaneles;

import Controladores.Mediator;
import javax.swing.JPanel;

/**
 *
 * @author Itzcoatl90
 */
public class Politicas {
    JPanel misionYPoliticas;
    Mediator m;
    public Politicas(Mediator m){
        misionYPoliticas = new JPanel();
        misionYPoliticas.setSize(520,450);
        this.m = m;
    }
    
    public JPanel prepararMapa(){
        /*
         * Aquí ya sabes
         */
        return misionYPoliticas;
    }
}
