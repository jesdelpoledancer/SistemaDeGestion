package Modelos;

import Estructuras.Riesgo;
import Estructuras.Tarea;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.Time;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.TransformerConfigurationException;
import javax.xml.transform.TransformerException;
import org.jespxml.JespXML;
import org.jespxml.excepciones.TagHijoNotFoundException;
import org.jespxml.modelo.Atributo;
import org.jespxml.modelo.Comentario;
import org.jespxml.modelo.Encoding;
import org.jespxml.modelo.Tag;
import org.xml.sax.SAXException;

/**
 *
 * @author Itzcoatl90
 */
public class LectorEscritorDeEntidades {
    
    public void leerEntidadesDirectas(){
        /*
         * Lee desde archivo llamado "DirEnt.sg" las entidades:
         * -Riesgo
         * -Tarea
         * 
         * En este archivo solo están esas entidades, con todos
         * sus atributos.
         * 
         * TODAS las entidades ponerlas en su respectiva lista en "EntityDB"
         * 
         * EntityDB es un Singleton y la forma de llamarlo es por su método "getInstance()"
         * en vez de crear uno nuevo.
         * 
         * ej.
         * 
         * EntityDB entidad = EntityDB.getInstance();
         */
        EntityDB db=EntityDB.getInstance();
        JespXML xml1= new JespXML(new File("DirEnt.sg"));
        try {
            Tag raiz=xml1.leerXML();
            Tag tareas= raiz.getTagHijoByName("tareas");
            Tag riesgos=raiz.getTagHijoByName("riesgos");
            List<Tag> listaRiesgos=riesgos.getTagsHijos();
            Riesgo riesgo;
            for (Tag tag : listaRiesgos) {
                riesgo=new Riesgo();
                riesgo.setActivo(tag.getTagHijoByName("activo").getContenido());
                riesgo.setAmenaza(tag.getTagHijoByName("amenaza").getContenido());
                riesgo.setImpacto(Integer.parseInt(tag.getTagHijoByName("impacto").getContenido()));
                riesgo.setOcurrencia(Integer.parseInt(tag.getTagHijoByName("ocurrencia").getContenido()));
                riesgo.setProximoMonitoreo(new Date(tag.getTagHijoByName("proximoMonitoreo").getContenido()));
                riesgo.setRiesgo(Integer.parseInt(tag.getTagHijoByName("riesgo").getContenido()));
                riesgo.setTiempoDeMonitoreo(new Time(Long.parseLong(tag.getTagHijoByName("tiempoMonitoreo").getContenido())));
                riesgo.setTratamiento(tag.getTagHijoByName("tratamiento").getContenido());
                riesgo.setResultado(tag.getTagHijoByName("resultado").getContenido());
               db.agregarRiesgo(riesgo);
            }  
            List<Tag> listaTareas=tareas.getTagsHijos();
            Tarea tarea;
            for (Tag tag : listaTareas) {
                tarea=new Tarea();
                 tarea.setNombre(tag.getTagHijoByName("nombre").getContenido());
                tarea.setDescripcion(tag.getTagHijoByName("descripcion").getContenido());
               db.agregarTarea(tarea);
            }
        } catch (ParserConfigurationException ex) {
          Logger.getLogger(LectorEscritorDeEntidades.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SAXException ex) {
            Logger.getLogger(LectorEscritorDeEntidades.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(LectorEscritorDeEntidades.class.getName()).log(Level.SEVERE, null, ex);
        } catch (TagHijoNotFoundException ex) {
            Logger.getLogger(LectorEscritorDeEntidades.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        
        
        
    }
    
    public void leerEntidadesIndirectas(){
        /*
         * Lee desde archivo llamado "IndEnt.sg" las entidades:
         * 
         * -Activo
         * -PlanDeSoporte
         * -Control
         * 
         * En este archivo solo están esas entidades, con todos
         * sus atributos, en los atributos que son otras entidades
         * (Riesgos y Tareas) solo hay una referencia a nombre y amenaza
         * de Tarea y Riesgo respectivamente. BUSCAR la tarea y/o riesgo en
         * el vector de EntityDB y agregarselos
         * 
         * TODAS las entidades ponerlas en su respectiva lista en "EntityDB"
         * 
         * EntityDB es un Singleton y la forma de llamarlo es por su método "getInstance()"
         * en vez de crear uno nuevo.
         * 
         * ej.
         * 
         * EntityDB entidad = EntityDB.getInstance();
         */
          
        
    }
    
    public boolean escribirEntidadesDirectas(){
        /*
         * En este método escribes lo que puedas leer directamente a un archivo (DirEnt.sg)
         * regresa true si lo lograste hacer... regresa false si hubo cualquier error.
         */
        EntityDB db=EntityDB.getInstance();
        Tag raiz= new Tag("entidades");
        raiz.addAtributo(new Atributo("ultimaActualizacion",new Date().toLocaleString()));
        raiz.addComentario(new Comentario("Este archivo contiene las entidades directas y sus atributos"));
        raiz.addComentario(new Comentario("Riesgos y Tareas"));
        Tag Tareas= new Tag("tareas");
        ArrayList listaTareas=db.getTareas();
        Tarea ta;
        Tag tarea,nombre,descripcion;
         int i=1;
        for (Object e : listaTareas) {
           ta=(Tarea)e;
           tarea=new Tag("tarea"+i);
           nombre=new Tag("nombre");
           nombre.addContenido(ta.getNombre());
                   
           descripcion=new Tag("descripcion");
           descripcion.addContenido(ta.getDescripcion());
           tarea.addTagHijo(nombre);
           tarea.addTagHijo(descripcion);
           Tareas.addTagHijo(tarea);
           i++;
        }
        raiz.addTagHijo(Tareas);
        Tag Riesgos= new Tag("riesgos");
        ArrayList listaRiesgos=db.getRiesgos();
        Riesgo ri;
        Tag riesgo,amenaza,activo,ocurrencia,impacto,riesgoi;
        Tag tratamiento,resultado,tMonitoreo,pMonitoreo;
        i=1;
        for (Object e : listaRiesgos) {
           ri=(Riesgo)e;
           riesgo=new Tag("riesgo"+i);
           amenaza=new Tag("amenaza");
           amenaza.addContenido(ri.getAmenaza());
           riesgo.addTagHijo(amenaza);
           activo=new Tag("activo");
           activo.addContenido(ri.getActivo());
           riesgo.addTagHijo(activo);
           ocurrencia=new Tag("ocurrencia");
           ocurrencia.addContenido(Integer.toString(ri.getOcurrencia()));
           riesgo.addTagHijo(ocurrencia);
           impacto=new Tag("impacto");
           impacto.addContenido(Integer.toString(ri.getImpacto()));
           riesgo.addTagHijo(impacto);
           riesgoi=new Tag("riesgo");
           riesgoi.addContenido(Integer.toString(ri.getRiesgo()));
           riesgo.addTagHijo(riesgoi);
           tratamiento=new Tag("tratamiento");
           tratamiento.addContenido(ri.getTratamiento());
           riesgo.addTagHijo(tratamiento);
           resultado=new Tag("resultado");
           resultado.addContenido(ri.getResultado());
           riesgo.addTagHijo(resultado);
           tMonitoreo=new Tag("tiempoMonitoreo");
           tMonitoreo.addContenido(Long.toString(ri.getTiempoDeMonitoreo().getTime()));
           riesgo.addTagHijo(tMonitoreo);
           pMonitoreo=new Tag("proximoMonitoreo");
           pMonitoreo.addContenido(ri.getProximoMonitoreo().toString());
           riesgo.addTagHijo(pMonitoreo);
           Riesgos.addTagHijo(riesgo);
           i++;
        }
        raiz.addTagHijo(Riesgos);

        JespXML xml= new JespXML(new File("DirEnt.sg"),Encoding.UTF_8);
        try {
            xml.escribirXML(raiz);
        } catch (ParserConfigurationException ex) {
            Logger.getLogger(LectorEscritorDeEntidades.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        } catch (TransformerConfigurationException ex) {
            Logger.getLogger(LectorEscritorDeEntidades.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        } catch (FileNotFoundException ex) {
            Logger.getLogger(LectorEscritorDeEntidades.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        } catch (TransformerException ex) {
            Logger.getLogger(LectorEscritorDeEntidades.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        }
        return true;
    }
    
    public boolean escribirEntidadesIndirectas(){
        /*
         * En este método escribes lo que puedas leer directamente a un archivo (IndEnt.sg)
         * regresa true si lo lograste hacer... regresa false si hubo cualquier error.
         */
        return true;
    }
    
}
