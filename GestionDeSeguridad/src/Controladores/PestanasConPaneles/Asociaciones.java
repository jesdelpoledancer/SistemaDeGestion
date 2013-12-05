package Controladores.PestanasConPaneles;

import Controladores.Mediator;
import javax.swing.JPanel;

/**
 *
 * @author Itzcoatl90
 */
public class Asociaciones implements Pestana {
    private JPanel listasDeAsociaciones;
    private Mediator m;
    private boolean init = true;
    public Asociaciones(Mediator m){
        listasDeAsociaciones = new JPanel();
        listasDeAsociaciones.setSize(595,489);
        this.m = m;
    }
    
    private void changePanel(JPanel panel){
        m.changePanel(4, panel);
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
         * Este método prepara un panel con componentes de la GUI que puedan responder cada una de las señales
         * creo que funciona a la perfeccion la "List"... sino tal vez podría buscarse en internet que componente
         * se adapta...
         * voy a postear en facebook unas cosillas que pueden ser utiles para Sotelo y para tí...
         * 
         * ok va detallado
         * 
         * Tienes un panel al cual le puedes agregar otros componentes...
         * (que pueden ser listbox, textfields, buttons, etc...)
         * 
         * EntityDB es un Singleton y la forma de llamarlo es por su método "getInstance()"
         * en vez de crear uno nuevo.
         * 
         * ej.
         * 
         * EntityDB entidad = EntityDB.getInstance();
         * 
         * Este (EntityDB) tiene TODA la información de las entidades que existen dentro de nuestro sistema...
         * 
         * Puedes utilizar sus métodos para sacar las listas de riesgos por ejemplo...
         * 
         * Lo que queremos es tener un componente (que se adapte, que sea visual y obvio que lo conectes con add al panel)
         * con esas listas: activos, controles, entidades_P (politicas y procesos), planes de soporte, riesgo, rol.
         * 
         * Cada uno de estos tipos de entidades en su propia lista (o componente de GUI, visual)
         * 
         * Busca un componente cuyos elementos (dentro de) puedan tener un "evento" al hacerse click
         * 
         * Un evento en java es cualquier cosa que pueda ocurrir con un componente, como mousePressed, key released, etc...
         * 
         */
        changePanel(listasDeAsociaciones);
    }

    @Override
    public void mostrarPerfil(Object obj) {
        m.mostrarPerfil(obj);
    }
}
