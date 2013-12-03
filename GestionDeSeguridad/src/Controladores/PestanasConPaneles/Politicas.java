package Controladores.PestanasConPaneles;

import Controladores.Mediator;
import javax.swing.JPanel;

/**
 *
 * @author Itzcoatl90
 */
public class Politicas {
    private JPanel misionYPoliticas;
    private Mediator m;
    private boolean init = true;
    public Politicas(Mediator m){
        misionYPoliticas = new JPanel();
        misionYPoliticas.setSize(595,489);
        this.m = m;
    }
    
    public void init(){
        if(init){
            init =false;
            prepararMapa();
        }
    }
    
    private void changePanel(JPanel panel){
        m.changePanel(3, panel);
    }
    
    public void prepararMapa(){
        /*
         * Aquí ya sabes imprimir imagen y calcular perfil politicas
         */
        changePanel(misionYPoliticas);
    }
}
