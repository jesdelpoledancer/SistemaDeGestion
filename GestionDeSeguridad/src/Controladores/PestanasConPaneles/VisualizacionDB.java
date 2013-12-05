package Controladores.PestanasConPaneles;

import Controladores.Mediator;
import Estructuras.Activo;
import Estructuras.Riesgo;
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
            JLabel truquitoMagico = new JLabel(new ImageIcon(db));
            
            truquitoMagico.addMouseListener(new java.awt.event.MouseListener() {

                @Override
                public void mouseClicked(MouseEvent me) {
                    Riesgo r = new Riesgo();
                    r.setActivo("Servidor");
                    r.setAmenaza("El itzco!");
                    r.setImpacto(5);
                    r.setOcurrencia(5);//Ese itzco está en todos lados
                    r.setProximoMonitoreo(new Date(1,2,3));
                    r.setResultado("Interrupcion");
                    r.setRiesgo(10);//Alto peligro
                    r.setTiempoDeMonitoreo(new Time(1,2,3));
                    r.setTratamiento("Aceptarlo");//No se puede hacer nada contra el itzco
                    m.mostrarPerfil(r);
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
            
            mapalogico.add(truquitoMagico);
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
