package Modelos;

import Estructuras.Activo;
import Estructuras.Control;
import Estructuras.PlanDeSoporte;
import Estructuras.Politica;
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
//import org.jespxml.JespXML;
//import org.jespxml.excepciones.TagHijoNotFoundException;
//import org.jespxml.modelo.Atributo;
//import org.jespxml.modelo.Comentario;
//import org.jespxml.modelo.Encoding;
//import org.jespxml.modelo.Tag;
//import org.xml.sax.SAXException;

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
//        EntityDB db=EntityDB.getInstance();
//        JespXML xml1= new JespXML(new File("DirEnt.sg"));
//        
//            Tag raiz;
//        try {
//            raiz = xml1.leerXML();
//             Tag tareas= raiz.getTagHijoByName("tareas");
//            Tag riesgos=raiz.getTagHijoByName("riesgos");
//            if(riesgos.isHijos()){
//            List<Tag> listaRiesgos=riesgos.getTagsHijos();
//            Riesgo riesgo;
//            for (Tag tag : listaRiesgos) {
//                riesgo=leerRiesgo(tag);
//               db.agregarRiesgo(riesgo);
//            }
//            }
//            if(tareas.isHijos()){
//            List<Tag> listaTareas=tareas.getTagsHijos();
//            Tarea tarea;
//            for (Tag tag : listaTareas) { 
//                tarea=leerTarea(tag);
//               db.agregarTarea(tarea);
//            }
//            }
//        } catch (ParserConfigurationException ex) {
//          
//        } catch (SAXException ex) {
//           
//        } catch (IOException ex) {
//            
//        } catch (TagHijoNotFoundException ex) {
//           
//        }
           
             
            
        
        
        
            
        
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
//          EntityDB db=EntityDB.getInstance();
//        JespXML xml1= new JespXML(new File("IndEnt.sg"));
//        try {
//            Tag raiz=xml1.leerXML();
//            Tag activos=raiz.getTagHijoByName("activos");
//            Tag planesdeSoporte=raiz.getTagHijoByName("planesdeSoporte");
//            Tag controles=raiz.getTagHijoByName("controles");
//            if(controles.isHijos()){
//                List<Tag> listacontroles=controles.getTagsHijos();
//                Control control;
//                 for (Tag tag : listacontroles) {
//                     control=leerControl(tag);  
//                  db.agregarControl(control);   
//                 }
//            }
//            if(activos.isHijos()){
//                List<Tag> listaactivos=activos.getTagsHijos();
//                Activo activo;
//                
//                 for (Tag tag : listaactivos) {
//                     activo=leerActivo(tag);
//                db.agregarActivo(activo);
//            }
//            }
//            if(planesdeSoporte.isHijos()){
//                List<Tag> listaplanes=planesdeSoporte.getTagsHijos();
//                PlanDeSoporte plan;
//                for (Tag tag : listaplanes) {
//                     plan=leerPlan(tag);
//                db.agregarPlanDeSoporte(plan);
//                }
//            }
//        } catch (ParserConfigurationException ex) {
//          
//        } catch (SAXException ex) {
//           
//        } catch (IOException ex) {
//            
//        } catch (TagHijoNotFoundException ex) {
//            
//        }
//        
    }
    
    public boolean escribirEntidadesDirectas(){
        /*
         * En este método escribes lo que puedas leer directamente a un archivo (DirEnt.sg)
         * regresa true si lo lograste hacer... regresa false si hubo cualquier error.
//         */
//        EntityDB db=EntityDB.getInstance();
//        Tag raiz= new Tag("entidades");
//        raiz.addAtributo(new Atributo("ultimaActualizacion",new Date().toLocaleString()));
//        raiz.addComentario(new Comentario("Este archivo contiene las entidades directas y sus atributos"));
//        raiz.addComentario(new Comentario("Riesgos y Tareas"));
//        Tag Tareas= new Tag("tareas");
//        if(db.getTareas()!=null){
//        Tareas=escribirTareas(db.getTareas());
//        }
//        raiz.addTagHijo(Tareas);
//        Tag Riesgos= new Tag("riesgos");
//        if(db.getRiesgos()!=null){
//          Riesgos=escribirRiesgos(db.getRiesgos());
//        }
//        raiz.addTagHijo(Riesgos);
//
//        JespXML xml= new JespXML(new File("DirEnt.sg"),Encoding.UTF_8);
//        try {
//            xml.escribirXML(raiz);
//        } catch (ParserConfigurationException ex) {
//            return false;
//        } catch (TransformerConfigurationException ex) {
//            return false;
//        } catch (FileNotFoundException ex) {
//            return false;
//        } catch (TransformerException ex) {
//            return false;
//        }
        return true;
    }
    
    public boolean escribirEntidadesIndirectas(){
        /*
         * En este método escribes lo que puedas leer directamente a un archivo (IndEnt.sg)
         * regresa true si lo lograste hacer... regresa false si hubo cualquier error.
         */
//        Tag raiz= new Tag("entidades-indirectas");
//        raiz.addAtributo(new Atributo("ultimaActualizacion",new Date().toLocaleString()));
//        raiz.addComentario(new Comentario("Este archivo contiene las entidades directas y sus atributos"));
//       raiz.addComentario(new Comentario("Riesgos y Tareas"));
//      EntityDB db=EntityDB.getInstance();
//         Tag activos= new Tag("activos");
//         if(db.getActivos()!=null){
//         activos=escribirActivos(db.getActivos());
//         }
//        raiz.addTagHijo(activos);
//        Tag plansoporte= new Tag("planesDeSoporte");
//        if(db.getPlanesDeSoporte()!=null){
//         plansoporte=escribirPlanesdeSoporte(db.getPlanesDeSoporte());
//        }
//        raiz.addTagHijo(plansoporte);
//        Tag controles= new Tag("controles");
//       if(db.getControles()!=null){
//       controles=escribirControles(db.getControles());
//       }
//          raiz.addTagHijo(controles);
//        JespXML xml= new JespXML(new File("IndEnt.sg"),Encoding.UTF_8);
//        try {
//            xml.escribirXML(raiz);
//        } catch (ParserConfigurationException ex) {
//            return false;
//        } catch (TransformerConfigurationException ex) {
//            return false;
//        } catch (FileNotFoundException ex) {
//            return false;
//        } catch (TransformerException ex) {
//            return false;
//        }
        return true;
    }
    
//    private Riesgo leerRiesgo(Tag tag){
//        Riesgo riesgo=new Riesgo();
//        try {
//            riesgo.setActivo(tag.getTagHijoByName("activo").getContenido());
//        } catch (TagHijoNotFoundException ex) {
//            riesgo.setActivo(null);
//        }
//        try {
//            riesgo.setAmenaza(tag.getTagHijoByName("amenaza").getContenido());
//        } catch (TagHijoNotFoundException ex) {
//            riesgo.setAmenaza(null);
//        }
//        try {
//            riesgo.setImpacto(Integer.parseInt(tag.getTagHijoByName("impacto").getContenido()));
//        } catch (TagHijoNotFoundException ex) {
//            riesgo.setImpacto(0);
//        }
//        try {
//            riesgo.setOcurrencia(Integer.parseInt(tag.getTagHijoByName("ocurrencia").getContenido()));
//        } catch (TagHijoNotFoundException ex) {
//            riesgo.setOcurrencia(0);
//        }
//        try {
//           
//            riesgo.setProximoMonitoreo(new Date(Long.parseLong(tag.getTagHijoByName("proximoMonitoreo").getContenido())));
//            //riesgo.setProximoMonitoreo(new Date(tag.getTagHijoByName("proximoMonitoreo").getContenido()));
//        } catch (TagHijoNotFoundException ex) {
//            System.out.println("no encontro");
//            riesgo.setProximoMonitoreo(null);
//        }
//        try {
//            riesgo.setRiesgo(Integer.parseInt(tag.getTagHijoByName("riesgo").getContenido()));
//        } catch (TagHijoNotFoundException ex) {
//            riesgo.setRiesgo(0);
//        }
//        try {
//            riesgo.setTiempoDeMonitoreo(new Time(Long.parseLong(tag.getTagHijoByName("tiempoMonitoreo").getContenido())));
//        } catch (TagHijoNotFoundException ex) {
//            riesgo.setTiempoDeMonitoreo(null);
//        }
//        try {
//            riesgo.setTratamiento(tag.getTagHijoByName("tratamiento").getContenido());
//        } catch (TagHijoNotFoundException ex) {
//            riesgo.setTratamiento(null);
//        }
//        try { 
//            riesgo.setResultado(tag.getTagHijoByName("resultado").getContenido());
//        } catch (TagHijoNotFoundException ex) {
//            riesgo.setResultado(null);
//        }
//                return riesgo;
//    }
//    private Tarea leerTarea(Tag tag){
//        Tarea tarea=new Tarea();
//        try {
//            tarea.setNombre(tag.getTagHijoByName("nombre").getContenido());
//        } catch (TagHijoNotFoundException ex) {
//            tarea.setNombre(null);
//        }
//        try {
//            tarea.setDescripcion(tag.getTagHijoByName("descripcion").getContenido());
//        } catch (TagHijoNotFoundException ex) {
//            tarea.setDescripcion(null);
//        }
//    return tarea;
//    }
//    
//    private Control leerControl(Tag tag){
//        Control control= new Control();
//                         try{
//                         control.setNombre(tag.getTagHijoByName("nombre").getContenido());
//                         }catch(Exception e){
//                          control.setNombre("");   
//                         }
//                         try{
//                         control.setTiempoDeMonitoreo(new Time(Long.parseLong(tag.getTagHijoByName("tiempoMonitoreo").getContenido())));
//                         }catch(Exception e){
//                          control.setTiempoDeMonitoreo(null);   
//                         }
//                         try{
//                         control.setProximoMonitoreo(new Date((tag.getTagHijoByName("proximoMonitoreo").getContenido())));
//                         }catch(Exception e){
//                          control.setProximoMonitoreo(null);   
//                         }
//                         
//                         Tag tareas;
//                        try {
//                       tareas = tag.getTagHijoByName("tareas");
//                       List<Tag> listatareas=tareas.getTagsHijos();
//                       Tarea tarea;
//                       ArrayList listaTareas=new ArrayList();
//                       for (Tag tag1 : listatareas) {
//                              tarea=leerTarea(tag1);
//                              listaTareas.add(tarea);     
//                             }
//                         control.setTareasARealizar(listaTareas);
//                      } catch (TagHijoNotFoundException ex) {
//                      control.setTareasARealizar(null);
//                      }
//                         
//                         Tag riesgos;
//                        try {
//                       riesgos = tag.getTagHijoByName("riesgosAsociados");
//                       List<Tag> listariesgos=riesgos.getTagsHijos();
//                       ArrayList listaRiesgos=new ArrayList();
//                       for (Tag tag1 : listariesgos) {
//                       
//                       listaRiesgos.add(tag1.getContenido());
//                              }
//        control.setRiesgosAsociados(listaRiesgos);
//        } catch (TagHijoNotFoundException ex) {
//            control.setRiesgosAsociados(null);
//        }
//                             return control;
//    }
    
//    private Activo leerActivo(Tag tag){
//        Activo activo=new Activo();
//                         try{
//                         activo.setNombre(tag.getTagHijoByName("nombre").getContenido());
//                         }catch(Exception e){
//                         activo.setNombre("");   
//                         }
//                         try{
//                         activo.setCostoModificacion(tag.getTagHijoByName("costoModificacion").getContenido());
//                         }catch(Exception e){
//                          activo.setCostoModificacion("");   
//                         }
//                         try{
//                         activo.setCostoInterrupcion(tag.getTagHijoByName("costoInterrupcion").getContenido());
//                         }catch(Exception e){
//                          activo.setCostoInterrupcion("");   
//                         }
//                         try{
//                         activo.setCostoRevelacion(tag.getTagHijoByName("costoRelevacion").getContenido());
//                         }catch(Exception e){
//                          activo.setCostoRevelacion("");   
//                         }
//                         try{
//                         activo.setTiempoDeMonitoreo(new Time(Long.parseLong(tag.getTagHijoByName("tiempoMonitoreo").getContenido())));
//                         }catch(Exception e){
//                          activo.setTiempoDeMonitoreo(null);   
//                         }
//                         try{
//                         activo.setProximoMonitoreo(new Date((tag.getTagHijoByName("proximoMonitoreo").getContenido())));
//                         }catch(Exception e){
//                          activo.setProximoMonitoreo(null);   
//                         }
//                         
//                         Tag riesgos;
//                        try {
//                         riesgos = tag.getTagHijoByName("riesgos");
//                         List<Tag> listariesgos=riesgos.getTagsHijos();
//                         ArrayList listaRiesgos=new ArrayList();
//                         Riesgo riesgo;
//                             for (Tag tag1 : listariesgos) {
//                             listaRiesgos.add(tag1.getContenido());
//                             }
//                         activo.setRiesgos(listaRiesgos);
//                        } catch (TagHijoNotFoundException ex) {
//                        activo.setRiesgos(null);
//                                                    }   
//                       return activo;   
//                
//                     }
//    
//    private PlanDeSoporte leerPlan(Tag tag){
//         PlanDeSoporte plan=new PlanDeSoporte();
//                     
//                         try{
//                         plan.setNombre(tag.getTagHijoByName("nombre").getContenido());
//                         }catch(Exception e){
//                          plan.setNombre("");   
//                         }
//                         try{
//                         plan.setDescripcion(tag.getTagHijoByName("descripcion").getContenido());
//                         }catch(Exception e){
//                          plan.setDescripcion("");   
//                         }
//                         try{
//                         plan.setTiempoDeMonitoreo(new Time(Long.parseLong(tag.getTagHijoByName("tiempoMonitoreo").getContenido())));
//                         }catch(Exception e){
//                          plan.setTiempoDeMonitoreo(null);   
//                         }
// 
//                        Tag politicas;
//                        try {
//                       politicas= tag.getTagHijoByName("politicasSoportadas");
//                       List<Tag> listapoliticas=politicas.getTagsHijos();
//                       Politica politica;
//                       ArrayList listaPoliticas=new ArrayList();
//                       for (Tag tag1 : listapoliticas) {
//                              listaPoliticas.add(tag1.getContenido());     
//                             }
//                         plan.setTareasARealizar(listaPoliticas);
//                      } catch (TagHijoNotFoundException ex) {
//                      plan.setTareasARealizar(null);
//                      }
//                  Tag tareas;
//                        try {
//                       tareas = tag.getTagHijoByName("tareas");
//                       List<Tag> listatareas=tareas.getTagsHijos();
//                       Tarea tarea;
//                       ArrayList listaTareas=new ArrayList();
//                       for (Tag tag1 : listatareas) {
//                              tarea=leerTarea(tag1);
//                              listaTareas.add(tarea);     
//                             }
//                         plan.setTareasARealizar(listaTareas);
//                      } catch (TagHijoNotFoundException ex) {
//                      plan.setTareasARealizar(null);
//                      }
//        
//       return plan;
//    }
//    
//    private Tag escribirTareas(ArrayList listaTareas){
//        Tag Tareas= new Tag("tareas");
//        Tag tarea,nombre,descripcion;
//        Tarea ta; 
//        int i=1;
//        for (Object e : listaTareas) {
//           ta=(Tarea)e;
//           tarea=new Tag("tarea"+i);
//           nombre=new Tag("nombre");
//           if(ta.getNombre()!=null){
//           nombre.addContenido(ta.getNombre());}
//                   
//           descripcion=new Tag("descripcion");
//           if(ta.getDescripcion()!=null){
//           descripcion.addContenido(ta.getDescripcion());}
//           tarea.addTagHijo(nombre);
//           tarea.addTagHijo(descripcion);
//           Tareas.addTagHijo(tarea);
//           i++;
//        }
//        return Tareas;
//    }
//    
//    private Tag escribirRiesgos(ArrayList listaRiesgos){
//         Tag Riesgos= new Tag("riesgos");
//        Riesgo ri;
//        Tag riesgo,amenaza,activo,ocurrencia,impacto,riesgoi;
//        Tag tratamiento,resultado,tMonitoreo,pMonitoreo;
//         int i=1;
//        for (Object e : listaRiesgos) {
//           ri=(Riesgo)e;
//           riesgo=new Tag("riesgo"+i);
//           amenaza=new Tag("amenaza");
//           if(ri.getAmenaza()!=null){
//           amenaza.addContenido(ri.getAmenaza());}
//           riesgo.addTagHijo(amenaza);
//           activo=new Tag("activo");
//           if(ri.getActivo()!=null){
//           
//           activo.addContenido(ri.getActivo());}
//           riesgo.addTagHijo(activo);
//           ocurrencia=new Tag("ocurrencia");
//           ocurrencia.addContenido(Integer.toString(ri.getOcurrencia()));
//           riesgo.addTagHijo(ocurrencia);
//           impacto=new Tag("impacto");
//           impacto.addContenido(Integer.toString(ri.getImpacto()));
//           riesgo.addTagHijo(impacto);
//           riesgoi=new Tag("riesgo");
//           riesgoi.addContenido(Integer.toString(ri.getRiesgo()));
//           riesgo.addTagHijo(riesgoi);
//           tratamiento=new Tag("tratamiento");
//           if(ri.getTratamiento()!=null){
//           tratamiento.addContenido(ri.getTratamiento());}
//           riesgo.addTagHijo(tratamiento);
//           resultado=new Tag("resultado");
//           if(ri.getResultado()!=null){
//           resultado.addContenido(ri.getResultado());}
//           riesgo.addTagHijo(resultado);
//           tMonitoreo=new Tag("tiempoMonitoreo");
//           if(ri.getTiempoDeMonitoreo()!=null){
//           tMonitoreo.addContenido(Long.toString(ri.getTiempoDeMonitoreo().getTime()));}
//           riesgo.addTagHijo(tMonitoreo);
//           pMonitoreo=new Tag("proximoMonitoreo");
//           if(ri.getProximoMonitoreo()!=null){
//           pMonitoreo.addContenido(Long.toString(ri.getProximoMonitoreo().getTime()));}
//           riesgo.addTagHijo(pMonitoreo);
//           Riesgos.addTagHijo(riesgo);
//           i++;
//        }
//        return Riesgos;
//    }
//    
//    private Tag escribirActivos(ArrayList listaActivos){
//        Tag activos= new Tag("activos");
//        Activo ac;
//        Tag activo,nombre,costoModificacion,costoInterrupcion,costoRelevacion,tiempoDeMonitoreo,proximoMonitoreo,riesgosdeActivos;
//         int i=1;
//         if(listaActivos!=null){
//        for (Object e : listaActivos) {
//           ac=(Activo)e;
//           activo=new Tag("activo"+i);
//           nombre=new Tag("nombre");
//           if(ac.getNombre()!=null){
//           nombre.addContenido(ac.getNombre());}
//           activo.addTagHijo(nombre);
//           costoModificacion=new Tag("costoModificacion");
//           if(ac.getCostoModificacion()!=null){
//           costoModificacion.addContenido(ac.getCostoModificacion());}
//           activo.addTagHijo(costoModificacion);
//           costoInterrupcion=new Tag("costoInterrupcion");
//           if(ac.getCostoInterrupcion()!=null){
//           costoInterrupcion.addContenido(ac.getCostoInterrupcion());}
//           activo.addTagHijo(costoInterrupcion);
//           costoRelevacion=new Tag("costoRelevacion");
//           if(ac.getCostoRevelacion()!=null){
//           costoRelevacion.addContenido(ac.getCostoRevelacion());}
//           activo.addTagHijo(costoRelevacion);
//           tiempoDeMonitoreo=new Tag("tiempoMonitoreo");
//           if(ac.getTiempoDeMonitoreo()!=null){
//           tiempoDeMonitoreo.addContenido(Long.toString(ac.getTiempoDeMonitoreo().getTime()));}
//           activo.addTagHijo(tiempoDeMonitoreo);
//           proximoMonitoreo=new Tag("proximoMonitoreo");
//           if(ac.getProximoMonitoreo()!=null){
//           proximoMonitoreo.addContenido(ac.getProximoMonitoreo().toString());}
//           activo.addTagHijo(proximoMonitoreo);
//           riesgosdeActivos=new Tag("riesgos");
//           if(ac.getRiesgos()!=null){
//               ArrayList riesgos=ac.getRiesgos();
//               String riesgo;
//               Tag ri;
//               int j=1;
//               for (Object e1 : riesgos) {
//                  ri=new Tag("riesgo"+j++);
//                  ri.addContenido((String)e1);
//                  riesgosdeActivos.addTagHijo(ri);
//               }
//           //riesgosdeActivos=escribirRiesgos(ac.getRiesgos());
//           }
//           activo.addTagHijo(riesgosdeActivos);
//           i++;
//           activos.addTagHijo(activo);
//        }
//         }
//       return activos;
//    }
//    
//    private Tag escribirPlanesdeSoporte(ArrayList listaplanes){
//    Tag plansoporte= new Tag("planesDeSoporte");
//        PlanDeSoporte plan;
//        Tag dato,tagplan;
//          int i=1;
//          if(listaplanes!=null){
//         for (Object e : listaplanes) {
//           plan=(PlanDeSoporte)e;
//           tagplan=new Tag("plan"+i);
//           dato=new Tag("nombre");
//           if(plan.getNombre()!=null){
//           dato.addContenido(plan.getNombre());}
//           tagplan.addTagHijo(dato);
//           dato=new Tag("descripcion");
//           if(plan.getDescripcion()!=null){
//           dato.addContenido(plan.getDescripcion());}
//           tagplan.addTagHijo(dato);
//           dato=new Tag("tiempoMonitoreo");
//           if(plan.getTiempoDeMonitoreo()!=null){
//           dato.addContenido(Long.toString(plan.getTiempoDeMonitoreo().getTime()));}
//           dato=new Tag("proximoMonitoreo");
//           if(plan.getTiempoDeMonitoreo()!=null){
//           dato.addContenido(plan.getProximoMonitoreo().toString());}
//           tagplan.addTagHijo(dato);
//           dato=new Tag("tareas");
//           if(plan.getTareasARealizar()!=null){
//           dato=escribirTareas(plan.getTareasARealizar());    
//           }
//           tagplan.addTagHijo(dato);
//         
//           dato=new Tag("politicasSoportadas");
//           if(plan.getPoliticasQueSoporta()!=null){
//               ArrayList politicas=plan.getPoliticasQueSoporta();
//               String politica;
//               Tag ri;
//               int j=1;
//               for (Object e1 : politicas) {
//                  ri=new Tag("politica"+j++);
//                  ri.addContenido((String)e1);
//                  dato.addTagHijo(ri);
//               }   
//           }
//            tagplan.addTagHijo(dato);
//            plansoporte.addTagHijo(tagplan);
//    }
//    
//          }
//
//return plansoporte;
//
//}
//    private Tag escribirControles(ArrayList listacontroles){
//         Tag controles= new Tag("controles");
//         Control control;
//         Tag tagcontrol,dato;
//          int i=1;
//          if(listacontroles!=null){
//         for (Object e : listacontroles) {
//             control=(Control)e;
//           tagcontrol=new Tag("control"+i);
//           dato=new Tag("nombre");
//           if(control.getNombre()!=null){
//           dato.addContenido(control.getNombre());}
//           tagcontrol.addTagHijo(dato);
//           dato=new Tag("tiempoMonitoreo");
//           if(control.getTiempoDeMonitoreo()!=null){
//           dato.addContenido(Long.toString(control.getTiempoDeMonitoreo().getTime()));}
//           tagcontrol.addTagHijo(dato);
//           
//           dato=new Tag("proximoMonitoreo");
//           if(control.getProximoMonitoreo()!=null){
//           dato.addContenido(control.getProximoMonitoreo().toString());}
//           tagcontrol.addTagHijo(dato);
//           dato=new Tag("tareas");
//           if(control.getTareasARealizar()!=null){
//           dato=escribirTareas(control.getTareasARealizar());
//           }
//           tagcontrol.addTagHijo(dato);
//           dato=new Tag("riesgosAociados");
//           if(control.getRiesgosAsociados()!=null){
//               ArrayList riesgos=control.getRiesgosAsociados();
//               String riesgo;
//               Tag ri;
//               int j=1;
//               for (Object e1 : riesgos) {
//                  ri=new Tag("riesgo"+j++);
//                  ri.addContenido((String)e1);
//                  dato.addTagHijo(ri);
//               }
//           //riesgosdeActivos=escribirRiesgos(ac.getRiesgos());
//           }
//            tagcontrol.addTagHijo(dato);
//            controles.addTagHijo(tagcontrol);
//           
//         }
//    }
//     return controles;     
//    }
   }