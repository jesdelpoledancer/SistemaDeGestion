package Controladores.PestanasConPaneles;

import Controladores.Mediator;
import javax.swing.JPanel;

/**
 *
 * @author Itzcoatl90
 */
public class VisualizacionDB {
    JPanel mapalogico;
    Mediator m;
    public VisualizacionDB(Mediator m){
        mapalogico = new JPanel();
        mapalogico.setSize(520,450);
        this.m = m;
    }
    
    public JPanel prepararMapa(){
        /*
         * Aquí ya sabes
         */
        return mapalogico;
    }
    
}
