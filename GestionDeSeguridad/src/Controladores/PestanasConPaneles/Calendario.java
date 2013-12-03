package Controladores.PestanasConPaneles;

import Controladores.Mediator;
import javax.swing.JPanel;

/**
 *
 * @author Itzcoatl90
 */
public class Calendario {
    JPanel calendario;
    JPanel listaDePendientes;
    Mediator m;
    public Calendario(Mediator m){
        calendario = new JPanel();
        calendario.setSize(520,450);
        listaDePendientes = new JPanel();
        listaDePendientes.setSize(520,450);
        this.m = m;
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
         * Además... como tienes tu propio panel vas a tener que agregar los listeners de manera local...
         * 
         * dinámicamente checa como lo he hecho anteriormente...
         * 
         * 
         explicar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                explicarButton();
            }
         });
         * 
         * "explicar" es un boton. "actionPerformed" es un evento de un componente GUI (una señal),
         * por ejemplo que den doble click o pasen el mouse sobre el componente...
         * 
         * El "evento" puede ser de mouse (mouseClicked, mouseEntered,...), puede ser de teclas (keyPressed, keyRelease),...
         * 
         * Puedes buscar estas acciones en internet o, en otro proyecto, poner un panel o boton o un componente GUI y (en netbeans)
         * en la interfaz darle click derecho, "events" y allí te sale una lista...
         * 
         * Si lo haces con imagenes puedes (cuando da click el usuario) sacar la 'x' y la 'y' para saber donde está (creo que es
         * algo como con el evento mouseclicked sacar click.X y click.Y... No recuerdo pero no es dificil, lo he hecho).
         * 
         * Si resuelves el problema de otra manera (no imagenes y no paneles) y no sabes como podemos hacerle para los listeners
         * me avisas para ver que podemos hacer...
         * 
         * Los listeners responden a una señal, en mi ejemplo delega el evento "actionPerformed" de mi boton "explicar" al método
         * "explicarButton();" que implementa lo que se debe de hacer...
         * 
         * Tu tienes muchos días (ya sean páneles o imagenes), de modo que a lo mejor puedes ir creando (cuando creas el calendario)
         * un ArrayList con apuntadores a cada componente nuevo que creas para ponerle diferentes métodos de respuesta a las señales.
         * 
         * De manera Dinámica sería lo mejor, pero si se te dificulta mucho puedes hacerlo de manera estática. Se ve medio feo eso
         * pero tenemos la certeza de que hay máximo 31 días en un mes.
         * 
         * 
         */
        return calendario;
    }
    
    public void metodosDeRespuesta(){
        /*
         * Este método representa varios, en realidad son la respuesta a los eventos de allá arriba.
         * 
         * Lo que van a hacer es, de cada uno sacar el date (tal vez puede ser un solo método ahora que lo pienso
         * que lo que cambie sea el parámetro)... Gestiona tu como te acomodes...
         * 
         * Ahora sí, perdon... Del día en cuestión sacar el date y buscar en las listas de entidades o en una local que tengas
         * (a lo mejor cada componente si lo hiciste con paneles por ejemplo tiene su lista de pendientes)...
         * 
         * Lo que queremos es que en listaDePendientes se vean... jajaja .... la lista de pendientes de ese día.
         * 
         * toma en cuenta que también han de tener listeners estos... puesto que si le das click mandarás llamar a una
         * funcion que muestra perfiles. Esta lista (y sus listeners) los puedes crear onthefly (osease cada que se le da
         * click a un día).
         * 
         * IDEAS:
         * 
         * Puedes hacerlo con imágenes también, o puedes hacerlo con algun otro componente que sea de lista (creo que 
         * "list" te podría servir).
         * 
         * Al terminar todo este show cambia el panel desde el mediator...
         * 
         * 
         * NOTA: PARA CADA DÍA TENDRAS QUE ITERAR SOBRE LAS ENTIDADES... NO LAS AGREGUES SI NO TIENE PRIVILEGIOS!!!
         * 
         * Para saber si tiene o no privilegios, usa el singleton privilegios e invoca el método ver() con el rol (del
         * singleton persona y el objeto en cuestion como parámetro).
         * 
         * ej.
         * 
         * if(Privilegios.getInstance().ver(EntityDB.getInstance().getPersona().getRol(),objetoEnCuestion)){//Este objeto en cuestion es tuyo
         *    //Mostrar en lista
         * }
         * 
         */
        m.changeCalendarPanel(listaDePendientes);
    }
    
    public void mostrarPerfil(){
        /*
         * Manda llamar el mostrarPerfil del Mediator (mandale tu entidad hecho objeto).
         */
    }
    
}
