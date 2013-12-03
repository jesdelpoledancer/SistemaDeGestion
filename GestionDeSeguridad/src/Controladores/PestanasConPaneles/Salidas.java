package Controladores.PestanasConPaneles;

import Controladores.Mediator;
import javax.swing.JPanel;

/**
 *
 * @author Itzcoatl90
 */
public class Salidas {
    private Mediator m;
    private JPanel pizarra;
    private boolean init = true;
    public Salidas(Mediator m){
        pizarra = new JPanel();
        pizarra.setSize(595,489);
        this.m = m;
    }
    private void changePanel(JPanel panel){
        m.changePanel(7, panel);
    }
    
    public void init(){
        if(init){
            init =false;
            prepararPanel();
        }
    }
    public void prepararPanel(){
        changePanel(pizarra);
    }
}
