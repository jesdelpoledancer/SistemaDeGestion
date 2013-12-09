package Controladores.PestanasConPaneles;

import Controladores.Mediator;
import Estructuras.Activo;
import Estructuras.Riesgo;
import Modelos.EntityDB;
import java.awt.event.MouseEvent;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.sql.Date;
import java.sql.Time;
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
        try {
            BufferedImage db = ImageIO.read(new File("VisualDB.jpg"));
            JLabel mapIm = new JLabel(new ImageIcon(db));
            mapalogico.add(mapIm);
        } catch (IOException ex) {
            Logger.getLogger(VisualizacionDB.class.getName()).log(Level.SEVERE, null, ex);
        }
        changePanel(mapalogico);
    }

    @Override
    public void mostrarPerfil(Object obj) {
        m.mostrarPerfil(obj);
    }
    
}
