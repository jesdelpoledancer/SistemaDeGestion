package Controladores.PestanasConPaneles;

import Controladores.Mediator;
import Controladores.Privilegios;
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
        try {
            BufferedImage db = ImageIO.read(new File("ORGANIGRAMA.png"));
            JLabel truquitoMagico = new JLabel(new ImageIcon(db));
            organigrama.add(truquitoMagico);
            truquitoMagico.addMouseListener(new java.awt.event.MouseListener() {
                @Override
                public void mouseClicked(MouseEvent me) {
                    int x = me.getX();
                    int y = me.getY();
                    if(x > 170 && x < 308){
                        if(y > 335 && y < 362){
                            m.mostrarPerfil(EntityDB.getInstance().getRoles().get(1));
                        } else if(y > 183 && y < 208){
                            m.mostrarPerfil(EntityDB.getInstance().getRoles().get(2));
                        }
                    } else if(x > 20 && x < 122){
                        if(y > 184 && y < 210){
                            m.mostrarPerfil(EntityDB.getInstance().getRoles().get(0));
                        }
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
        changePanel(organigrama);
    }

    @Override
    public void mostrarPerfil(Object obj) {
        m.mostrarPerfil(obj);
    }
    
}
