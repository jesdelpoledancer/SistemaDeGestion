package Controladores.PestanasConPaneles;

import Controladores.Mediator;
import Modelos.EntityDB;
import java.awt.event.MouseEvent;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
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
        try {
            BufferedImage db = ImageIO.read(new File("DIAGRAMA DE POLITICAS.png"));
            JLabel truquitoMagico = new JLabel(new ImageIcon(db));
            misionYPoliticas.add(truquitoMagico);
            
             truquitoMagico.addMouseListener(new java.awt.event.MouseListener() {
                @Override
                public void mouseClicked(MouseEvent me) {
                    int x = me.getX();
                    int y = me.getY();
                    if(x > 199 && x < 290 && y > 73 && y < 134){
                        m.mostrarPerfil(EntityDB.getInstance().getRoot());
                    }
                    if(x > 15 && x < 106 && y > 151 && y < 212){
                        m.mostrarPerfil(EntityDB.getInstance().getRoot().getHijas()[0]);
                    }
                    if(x > 120 && x < 221 && y > 151 && y < 212){
                        m.mostrarPerfil(EntityDB.getInstance().getRoot().getHijas()[1]);
                    }
                    if(x > 67 && x < 159 && y > 229 && y < 292){
                        m.mostrarPerfil(((Estructuras.Politica)EntityDB.getInstance().getRoot().getHijas()[1]).getHijas()[0]);
                    }
                    if(x > 66 && x < 159 && y > 307 && y < 371){
                        m.mostrarPerfil(((Estructuras.Politica)((Estructuras.Politica)EntityDB.getInstance().getRoot().getHijas()[1]).getHijas()[0]).getHijas()[0]);
                    }
                }
                @Override
                public void mousePressed(MouseEvent me) {}
                @Override
                public void mouseReleased(MouseEvent me) {}
                @Override
                public void mouseEntered(MouseEvent me) {}
                @Override
                public void mouseExited(MouseEvent me) {}
            });
             
        } catch (IOException ex) {
            Logger.getLogger(VisualizacionDB.class.getName()).log(Level.SEVERE, null, ex);
        }
        changePanel(misionYPoliticas);
    }

    @Override
    public void mostrarPerfil(Object obj) {
        m.mostrarPerfil(obj);
    }
}
