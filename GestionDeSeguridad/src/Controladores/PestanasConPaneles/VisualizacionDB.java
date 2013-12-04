package Controladores.PestanasConPaneles;

import Controladores.Mediator;
import javax.swing.JPanel;

/**
 *
 * @author Itzcoatl90
 */
public class VisualizacionDB implements Pestana{
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
         * Aquí ya sabes imprimir imagen y verse bonita nada mas
         */
        changePanel(mapalogico);
    }

    @Override
    public void mostrarPerfil(Object obj) {
        m.mostrarPerfil(obj);
    }
    
}
