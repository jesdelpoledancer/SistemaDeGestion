package Controladores.PestanasConPaneles;

import javax.swing.JPanel;

/**
 *
 * @author Itzcoatl90
 */
public class Calendario {
    JPanel calendario;
    public Calendario(){
        calendario = new JPanel();
        calendario.setSize(520,450);
    }
    
    public JPanel prepararCalendario(){
        /*
         * En este método se busca en todas las entidades de EntityDB
         * los "tiempoDeMonitoreo". Se pone un señalizador en cada dia de la semana.
         * 
         * Puedes representar el calendario con imagenes o con panelsitos...
         * Si te sale otra idea de como representarlo está bien...
         * 
         * Tienes todo el panel para ti solo... Solo no cambies el tamaño del panel (520*450)
         * y si lo cambias me avisas para yo cambiar tu host de calendario.
         * 
         * EntityDB es un Singleton y la forma de llamarlo es por su método "getInstance()"
         * en vez de crear uno nuevo.
         * 
         * ej.
         * 
         * EntityDB entidad = EntityDB.getInstance();
         * 
         */
        return calendario;
    }
    
}
