package Controladores.PestanasConPaneles;

import Controladores.Mediator;
import javax.swing.JPanel;

/**
 *
 * @author Itzcoatl90
 */
public class Organizacion implements Pestana {
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
    
    @Override
    public void init(){
        if(init){
            init =false;
            prepararPanel();
        }
    }
    
    @Override
    public void prepararPanel(){
        /*
         * Aquí ya sabes pintar imagen y medir los perfiles de roles
         */
        changePanel(organigrama);
    }

    @Override
    public void mostrarPerfil(Object obj) {
        m.mostrarPerfil(obj);
    }
    
}
