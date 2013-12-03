package Controladores.PestanasConPaneles;

import Controladores.Mediator;
import javax.swing.JPanel;

/**
 *
 * @author Itzcoatl90
 */
public class Avisos {
    private Mediator m;
    private JPanel pizarra;
    private boolean init = true;
    public Avisos(Mediator m){
        pizarra = new JPanel();
        pizarra.setSize(595,489);
        this.m = m;
    }
    private void changePanel(JPanel panel){
        m.changePanel(6, panel);
    }
    
    public void init(){
        if(init){
            init =false;
            prepararAvisos();
        }
    }
    
    public void prepararAvisos(){
        changePanel(pizarra);
    }
    
}
