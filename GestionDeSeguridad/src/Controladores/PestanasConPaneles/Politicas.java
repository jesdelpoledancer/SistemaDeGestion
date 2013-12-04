package Controladores.PestanasConPaneles;

import Controladores.Mediator;
import javax.swing.JPanel;

/**
 *
 * @author Itzcoatl90
 */
public class Politicas implements Pestana {
    private JPanel misionYPoliticas;
    private Mediator m;
    private boolean init = true;
    public Politicas(Mediator m){
        misionYPoliticas = new JPanel();
        misionYPoliticas.setSize(595,489);
        this.m = m;
    }
    
    @Override
    public void init(){
        if(init){
            init =false;
            prepararPanel();
        }
    }
    
    private void changePanel(JPanel panel){
        m.changePanel(3, panel);
    }
    
    @Override
    public void prepararPanel(){
        /*
         * Aquí ya sabes imprimir imagen y calcular perfil politicas
         */
        changePanel(misionYPoliticas);
    }

    @Override
    public void mostrarPerfil(Object obj) {
        m.mostrarPerfil(obj);
    }
}
