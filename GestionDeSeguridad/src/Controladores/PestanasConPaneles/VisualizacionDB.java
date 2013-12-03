package Controladores.PestanasConPaneles;

import Controladores.Mediator;
import javax.swing.JPanel;

/**
 *
 * @author Itzcoatl90
 */
public class VisualizacionDB {
    private JPanel mapalogico;
    private Mediator m;
    private boolean init = true;
    public VisualizacionDB(Mediator m){
        mapalogico = new JPanel();
        mapalogico.setSize(595,489);
        this.m = m;
    }
    private void changePanel(JPanel panel){
        m.changePanel(5, panel);
    }
    
    public void init(){
        if(init){
            init =false;
            prepararMapa();
        }
    }
    
    public void prepararMapa(){
        /*
         * Aquí ya sabes imprimir imagen y verse bonita nada mas
         */
        changePanel(mapalogico);
    }
    
}
