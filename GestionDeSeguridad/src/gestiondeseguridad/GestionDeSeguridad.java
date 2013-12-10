package gestiondeseguridad;

import Controladores.Mediator;
import Estructuras.Riesgo;
import Estructuras.Tarea;
import Modelos.EntityDB;
import Modelos.LectorEscritorDeEntidades;
import java.sql.Time;
import java.util.ArrayList;
import java.util.Date;
import javax.swing.JFrame;

/**
 *
 * @author Itzcoatl90
 */
public class GestionDeSeguridad {

    public static void main(String[] args) {
        JFrame.setDefaultLookAndFeelDecorated(true);
        Mediator m = new Mediator();
    }
    
    public static void imprimirPruebasDeQueTodosUsamosGitHub(){
        System.out.println("Hola mundo! Ahora a disfrutar de este espacio virtual.");
        System.out.println("Probando GIT, linea agregada por Mario Sotelo.");
        System.out.println("Prueba Daniel Zam");
        System.out.println("Gio prueba ");
        System.out.println("ya esta prueba Joel ");
    }
    
    public static void pruebasLectura(){
        /*
         * Pruebas Lectura y escritura
         * Escritura
        */
//        EntityDB db=EntityDB.getInstance();
//        Tarea t = new Tarea();
//        t.setNombre("Tarea1");
//        t.setDescripcion("Descripcion 1");
//        db.agregarTarea(t);
//        t = new Tarea();
//        t.setNombre("Tarea2");
//        t.setDescripcion("Descripcion 2");
//        db.agregarTarea(t);
//        t = new Tarea();
//        t.setNombre("Tarea3");
//        t.setDescripcion("Descripcion 3");
//        db.agregarTarea(t);
//        t = new Tarea();
//        t.setNombre("Tarea4");
//        t.setDescripcion("Descripcion 4");
//        db.agregarTarea(t);
//        Riesgo r=new Riesgo();
//        r.setActivo("Ac1");
//        r.setAmenaza("Am1");
//        r.setImpacto(1);
//        r.setOcurrencia(1);
//        r.setProximoMonitoreo(new Date());
//        r.setResultado("r1");
//        r.setTiempoDeMonitoreo(new Time(1));
//        r.setTratamiento("tr1");
//        db.agregarRiesgo(r);
//         r=new Riesgo();
//        r.setActivo("Ac2");
//        r.setAmenaza("Am2");
//        r.setImpacto(2);
//        r.setOcurrencia(2);
//        r.setProximoMonitoreo(new Date());
//        r.setResultado("r2");
//        r.setTiempoDeMonitoreo(new Time(2));
//        r.setTratamiento("tr2");
//        db.agregarRiesgo(r);
//        LectorEscritorDeEntidades l= new LectorEscritorDeEntidades();
//        System.out.println(l.escribirEntidadesDirectas());
        /*
         * Pruebas Lectura y escritura
         * Lectura
        */
        
        
        LectorEscritorDeEntidades l= new LectorEscritorDeEntidades();
       l.leerEntidadesDirectas();
       EntityDB db=EntityDB.getInstance();
       ArrayList lista=db.getRiesgos();
        for (Object e : lista) {
         Riesgo r=(Riesgo)e;
                System.out.println("Activo:"+r.getActivo()+" Tiempo Monitoreo:"+r.getTiempoDeMonitoreo());   
        }
      ArrayList tt=db.getTareas();
            for (Object e : tt) {
                Tarea r=(Tarea)e;
                System.out.println("Tarea:"+r.getNombre()+" Descripcion: "+r.getDescripcion());
            }
    }
}
