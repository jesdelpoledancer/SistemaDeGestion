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
public class Salidas implements Pestana {
    private Mediator m;
    private Controladores.PestanasConPaneles.panelesDePestanas.PLANDOCHECKACT pizarra;
    private boolean init = true;
    public Salidas(Mediator m){
        pizarra = new Controladores.PestanasConPaneles.panelesDePestanas.PLANDOCHECKACT();
        this.m = m;
    }
    private void changePanel(JPanel panel){
        m.changePanel(7, panel);
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
            BufferedImage db = ImageIO.read(new File("PLAN.png"));
            JLabel plan = new JLabel(new ImageIcon(db));
            pizarra.addPLAN(plan);
        } catch (IOException ex) {
            Logger.getLogger(Salidas.class.getName()).log(Level.SEVERE, null, ex);
        }
        try {
            BufferedImage db = ImageIO.read(new File("DO.png"));
            JLabel doo = new JLabel(new ImageIcon(db));
            pizarra.addDO(doo);
        } catch (IOException ex) {
            Logger.getLogger(Salidas.class.getName()).log(Level.SEVERE, null, ex);
        }
        try {
            BufferedImage db = ImageIO.read(new File("CHECK.png"));
            JLabel check = new JLabel(new ImageIcon(db));
            check.addMouseListener(new java.awt.event.MouseListener() {
                @Override
                public void mouseClicked(MouseEvent me) {
                    int x = me.getX();
                    int y = me.getY();
                    if(x > 370 && x < 510){
                        if(y > 390 && y < 420){
                            m.mostrarMemento();
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
            pizarra.addCHECK(check);
        } catch (IOException ex) {
            Logger.getLogger(Salidas.class.getName()).log(Level.SEVERE, null, ex);
        }
        try {
            BufferedImage db = ImageIO.read(new File("ACT.png"));
            JLabel act = new JLabel(new ImageIcon(db));
            pizarra.addACT(act);
        } catch (IOException ex) {
            Logger.getLogger(Salidas.class.getName()).log(Level.SEVERE, null, ex);
        }
        pizarra.setBounds(0,0,595,489);
        changePanel(pizarra);
    }

    @Override
    public void mostrarPerfil(Object obj) {
        m.mostrarPerfil(obj);
    }
}
