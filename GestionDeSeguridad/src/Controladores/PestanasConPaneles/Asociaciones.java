package Controladores.PestanasConPaneles;

import Controladores.Mediator;
import Controladores.Privilegios;
import Estructuras.Activo;
import Estructuras.Control;
import Estructuras.Entidad_P;
import Estructuras.PlanDeSoporte;
import Estructuras.Proceso;
import Estructuras.Riesgo;
import Estructuras.Rol;
import Modelos.EntityDB;
import java.util.ArrayList;
import java.util.Stack;
import javax.swing.JList;
import javax.swing.JPanel;

/**
 *
 * @author Itzcoatl90
 */
public class Asociaciones implements Pestana {
    private Controladores.paneles.Asociaciones listasDeAsociaciones;
    private Mediator m;
    private boolean init = true;
    public Asociaciones(Mediator m){
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
        listasDeAsociaciones = new Controladores.paneles.Asociaciones();
        listasDeAsociaciones.setMediator(m);
        listasDeAsociaciones.setBounds(0, 0, 700, 489);
        Object[] activos = new Object[EntityDB.getInstance().getActivos().size()];
        Object[] controles = new Object[EntityDB.getInstance().getControles().size()];
        Object[] planes = new Object[EntityDB.getInstance().getPlanesDeSoporte().size()];
        Object[] riesgos = new Object[EntityDB.getInstance().getRiesgos().size()];
        Object[] roles = new Object[EntityDB.getInstance().getRoles().size()];
        ArrayList politicas = new ArrayList();
        Stack s = new Stack();
        s.push(EntityDB.getInstance().getRoot());
        politicas.add(EntityDB.getInstance().getRoot().getNombre());
        while(s.size() != 0){
            Entidad_P p = (Entidad_P)s.pop();
            for (int j = 0; j < p.getHijas().length; j++) {
                s.push(p.getHijas()[j]);
                politicas.add(((Entidad_P)p.getHijas()[j]).getNombre());
            }
        }
        for (int i = 0; i < activos.length; i++) {
            activos[i] = ((Activo)EntityDB.getInstance().getActivos().get(i)).getNombre();
        }
        for (int i = 0; i < controles.length; i++) {
            controles[i] = ((Control)EntityDB.getInstance().getControles().get(i)).getNombre();
        }
        for (int i = 0; i < planes.length; i++) {
            planes[i] = ((PlanDeSoporte)EntityDB.getInstance().getPlanesDeSoporte().get(i)).getNombre();
        }
        for (int i = 0; i < riesgos.length; i++) {
            riesgos[i] = ((Riesgo)EntityDB.getInstance().getRiesgos().get(i)).getAmenaza();
        }
        for (int i = 0; i < roles.length; i++) {
            roles[i] = ((Rol)EntityDB.getInstance().getRoles().get(i)).getNombre();
        }
        listasDeAsociaciones.setActivos(activos);
        listasDeAsociaciones.setControles(controles);
        listasDeAsociaciones.setPlanesSoporte(planes);
        listasDeAsociaciones.setRiesgos(riesgos);
        listasDeAsociaciones.setRoles(roles);
        listasDeAsociaciones.setPANDP(politicas.toArray());
        listasDeAsociaciones.setEnabledAgregarActivos(Privilegios.getInstance().crear(EntityDB.getInstance().getPersona().getRol(), new Activo()));
        listasDeAsociaciones.setEnabledEliminarActivos(Privilegios.getInstance().eliminar(EntityDB.getInstance().getPersona().getRol(), new Activo()));
        listasDeAsociaciones.setEnabledAgregarControles(Privilegios.getInstance().crear(EntityDB.getInstance().getPersona().getRol(), new Control()));
        listasDeAsociaciones.setEnabledEliminarControles(Privilegios.getInstance().eliminar(EntityDB.getInstance().getPersona().getRol(), new Control()));
        listasDeAsociaciones.setEnabledAgregarPANDP(Privilegios.getInstance().crear(EntityDB.getInstance().getPersona().getRol(), new Proceso()));
        listasDeAsociaciones.setEnabledEliminarPANDP(Privilegios.getInstance().eliminar(EntityDB.getInstance().getPersona().getRol(), new Proceso()));
        listasDeAsociaciones.setEnabledAgregarRiesgo(Privilegios.getInstance().crear(EntityDB.getInstance().getPersona().getRol(), new Riesgo()));
        listasDeAsociaciones.setEnabledEliminarRiesgo(Privilegios.getInstance().eliminar(EntityDB.getInstance().getPersona().getRol(), new Riesgo()));
        listasDeAsociaciones.setEnabledAgregarRol(Privilegios.getInstance().crear(EntityDB.getInstance().getPersona().getRol(), new Rol()));
        listasDeAsociaciones.setEnabledEliminarRol(Privilegios.getInstance().eliminar(EntityDB.getInstance().getPersona().getRol(), new Rol()));
        listasDeAsociaciones.setEnabledAgregarSoporte(Privilegios.getInstance().crear(EntityDB.getInstance().getPersona().getRol(), new PlanDeSoporte()));
        listasDeAsociaciones.setEnabledEliminarSoporte(Privilegios.getInstance().eliminar(EntityDB.getInstance().getPersona().getRol(), new PlanDeSoporte()));
        changePanel(listasDeAsociaciones);
    }

    @Override
    public void mostrarPerfil(Object obj) {
        m.mostrarPerfil(obj);
    }
}
