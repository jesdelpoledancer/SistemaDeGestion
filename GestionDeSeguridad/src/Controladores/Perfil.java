package Controladores;

import Controladores.paneles.PerfilDeActivo;
import Controladores.paneles.PerfilDeControl;
import Controladores.paneles.PerfilDePlanDeSoporte;
import Controladores.paneles.PerfilDeRiesgo;
import Controladores.paneles.PerfilDeRol;
import Controladores.paneles.Politica;
import Estructuras.Activo;
import Estructuras.Control;
import Estructuras.PlanDeSoporte;
import Estructuras.Riesgo;
import Estructuras.Rol;
import Estructuras.Tarea;
import java.text.Format;
import java.text.SimpleDateFormat;
import java.util.ArrayList;

/**
 *
 * @author Itzcoatl90
 */
public class Perfil {
    
    public void change(PerfilDeActivo ACTIVO, Activo puntero, Rol r){
        Format formatter = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        ACTIVO.setNombre(puntero.getNombre());
        ACTIVO.setCostoModif(puntero.getCostoModificacion());
        ACTIVO.setCostoInt(puntero.getCostoInterrupcion());
        ACTIVO.setCostoRev(puntero.getCostoRevelacion());
        ACTIVO.setTiempoMon(formatter.format(puntero.getTiempoDeMonitoreo()));
        ACTIVO.setProximaMon(formatter.format(puntero.getProximoMonitoreo()));
        ACTIVO.setRiesgos(puntero.getRiesgos().toArray());
        ACTIVO.setNombreEnabled(Privilegios.getInstance().modificar(r, puntero, 3));
        ACTIVO.setCostoModifEnabled(Privilegios.getInstance().modificar(r, puntero, 4));
        ACTIVO.setCostoIntEnabled(Privilegios.getInstance().modificar(r, puntero, 5));
        ACTIVO.setCostoRevEnabled(Privilegios.getInstance().modificar(r, puntero, 6));
        ACTIVO.setTiempoMonEnabled(Privilegios.getInstance().modificar(r, puntero, 7));
        ACTIVO.setProximaMonEnabled(Privilegios.getInstance().modificar(r, puntero, 8));
        ACTIVO.setAgregarRiesgosEnabled(Privilegios.getInstance().modificar(r, puntero, 9));
        ACTIVO.setQuitarRiesgosEnabled(Privilegios.getInstance().modificar(r, puntero, 10));
    }
    
    public void change(PerfilDeControl CONTROL, Control puntero, Rol r){
        Format formatter = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        CONTROL.setNombre(puntero.getNombre());
        CONTROL.setTiempoMon(formatter.format(puntero.getTiempoDeMonitoreo()));
        CONTROL.setProximaMon(formatter.format(puntero.getProximoMonitoreo()));
        CONTROL.setRiesgos(puntero.getRiesgosAsociados().toArray());
        Object object[] = new Object[puntero.getTareasARealizar().size()*2];
        for (int i = 0; i < object.length; i++) {
            if(i%2==0){
                object[i] = ((Tarea)puntero.getTareasARealizar().get(i/2)).getNombre();
            } else {
                object[i] = "\t"+((Tarea)puntero.getTareasARealizar().get(i/2)).getDescripcion();
            }
        }
        CONTROL.setTareas(object);
        CONTROL.setNombreEnabled(Privilegios.getInstance().modificar(r, puntero, 3));
        CONTROL.setTiempoMonEnabled(Privilegios.getInstance().modificar(r, puntero, 5));
        CONTROL.setProximaMonEnabled(Privilegios.getInstance().modificar(r, puntero, 6));
        CONTROL.setAgregarRiesgoEnabled(Privilegios.getInstance().modificar(r, puntero, 4));
        CONTROL.setQuitarRiesgoEnabled(Privilegios.getInstance().modificar(r, puntero, 8));
        CONTROL.setAgregarTareaEnabled(Privilegios.getInstance().modificar(r, puntero, 7));
        CONTROL.setQuitarTareaEnabled(Privilegios.getInstance().modificar(r, puntero, 9));
    }
    
    public void change(PerfilDePlanDeSoporte SOPORTE, PlanDeSoporte puntero, Rol r){
        Format formatter = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        SOPORTE.setNombre(puntero.getNombre());
        SOPORTE.setDescripcion(puntero.getDescripcion());
        SOPORTE.setTiempoMon(formatter.format(puntero.getTiempoDeMonitoreo()));
        SOPORTE.setProximoMon(formatter.format(puntero.getProximoMonitoreo()));
        SOPORTE.setPoliticas(puntero.getPoliticasQueSoporta().toArray());
        Object object[] = new Object[puntero.getTareasARealizar().size()*2];
        for (int i = 0; i < object.length; i++) {
            if(i%2==0){
                object[i] = ((Tarea)puntero.getTareasARealizar().get(i/2)).getNombre();
            } else {
                object[i] = "\t"+((Tarea)puntero.getTareasARealizar().get(i/2)).getDescripcion();
            }
        }
        SOPORTE.setTareas(object);
        SOPORTE.setNombreEnabled(Privilegios.getInstance().modificar(r, puntero,3));
        SOPORTE.setDescripcionEnabled(Privilegios.getInstance().modificar(r, puntero,4));
        SOPORTE.setTiempoMonEnabled(Privilegios.getInstance().modificar(r, puntero,7));
        SOPORTE.setProximoMonEnabled(Privilegios.getInstance().modificar(r, puntero,8));
        SOPORTE.setAgregarTareaEnabled(Privilegios.getInstance().modificar(r, puntero, 6));
        SOPORTE.setAgregarPoliticasEnabled(Privilegios.getInstance().modificar(r, puntero, 5));
        SOPORTE.setQuitarTareaEnabled(Privilegios.getInstance().modificar(r, puntero, 10));
        SOPORTE.setQuitarPoliticasEnabled(Privilegios.getInstance().modificar(r, puntero, 9));
    }
    
    public void change(PerfilDeRiesgo RIESGO, Riesgo puntero, Rol r){
        Format formatter = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        System.out.println(puntero.getActivo());
        RIESGO.setActivo(puntero.getActivo());
        RIESGO.setAmenaza(puntero.getAmenaza());
        RIESGO.setImpacto(""+puntero.getImpacto());
        RIESGO.setOcurrencia(""+puntero.getOcurrencia());
        RIESGO.setResultado(puntero.getResultado());
        RIESGO.setTratamiento(puntero.getTratamiento());
        RIESGO.setTiempoMon(formatter.format(puntero.getTiempoDeMonitoreo()));
        RIESGO.setProximoMon(formatter.format(puntero.getProximoMonitoreo()));
        RIESGO.setRiesgo(""+puntero.getRiesgo());
        RIESGO.setActivoEnabled(Privilegios.getInstance().modificar(r, puntero, 11));
        RIESGO.setAmenazaEnabled(Privilegios.getInstance().modificar(r, puntero, 3));
        RIESGO.setImpactoEnabled(Privilegios.getInstance().modificar(r, puntero, 5));
        RIESGO.setOcurrenciaEnabled(Privilegios.getInstance().modificar(r, puntero, 4));
        RIESGO.setResultadoEnabled(Privilegios.getInstance().modificar(r, puntero, 8));
        RIESGO.setTratamientoEnabled(Privilegios.getInstance().modificar(r, puntero, 7));
        RIESGO.setTiempoMonEnabled(Privilegios.getInstance().modificar(r, puntero, 9));
        RIESGO.setProximoMonEnabled(Privilegios.getInstance().modificar(r, puntero, 10));
        RIESGO.setRiesgoEnabled(Privilegios.getInstance().modificar(r, puntero, 6));
    }
    
    public void change(PerfilDeRol ROL, Rol puntero, Rol r){
        Format formatter = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        ArrayList verList = new ArrayList();
        ArrayList crearList = new ArrayList();
        ArrayList eliminarList = new ArrayList();
        ArrayList modificarList = new ArrayList();
        ROL.setNombre(puntero.getNombre());
        ROL.setUsuarios(puntero.getUsuarios().toArray());
        if(((boolean[])puntero.getPrivilegios().get(1))[0]){verList.add("Activos");}
        if(((boolean[])puntero.getPrivilegios().get(2))[0]){verList.add("Controles");}
        if(((boolean[])puntero.getPrivilegios().get(3))[0]){verList.add("Politicas y procesos");}
        if(((boolean[])puntero.getPrivilegios().get(4))[0]){verList.add("Plan de soporte");}
        if(((boolean[])puntero.getPrivilegios().get(5))[0]){verList.add("Riesgos");}
        if(((boolean[])puntero.getPrivilegios().get(6))[0]){verList.add("Roles");}
        if(((boolean[])puntero.getPrivilegios().get(1))[1]){crearList.add("Activos");}
        if(((boolean[])puntero.getPrivilegios().get(2))[1]){crearList.add("Controles");}
        if(((boolean[])puntero.getPrivilegios().get(3))[1]){crearList.add("Politicas y procesos");}
        if(((boolean[])puntero.getPrivilegios().get(4))[1]){crearList.add("Plan de soporte");}
        if(((boolean[])puntero.getPrivilegios().get(5))[1]){crearList.add("Riesgos");}
        if(((boolean[])puntero.getPrivilegios().get(6))[1]){crearList.add("Roles");}
        if(((boolean[])puntero.getPrivilegios().get(1))[2]){eliminarList.add("Activos");}
        if(((boolean[])puntero.getPrivilegios().get(2))[2]){eliminarList.add("Controles");}
        if(((boolean[])puntero.getPrivilegios().get(3))[2]){eliminarList.add("Politicas y procesos");}
        if(((boolean[])puntero.getPrivilegios().get(4))[2]){eliminarList.add("Plan de soporte");}
        if(((boolean[])puntero.getPrivilegios().get(5))[2]){eliminarList.add("Riesgos");}
        if(((boolean[])puntero.getPrivilegios().get(6))[2]){eliminarList.add("Roles");}
        ROL.setVer(verList.toArray());
        ROL.setCrear(crearList.toArray());
        ROL.setEliminar(eliminarList.toArray());
        if(((boolean[])puntero.getPrivilegios().get(1))[3]){modificarList.add("Activos-Nombre");}
        if(((boolean[])puntero.getPrivilegios().get(1))[4]){modificarList.add("Activos-Costo de modificacion");}
        if(((boolean[])puntero.getPrivilegios().get(1))[5]){modificarList.add("Activos-Costo de interrupcion");}
        if(((boolean[])puntero.getPrivilegios().get(1))[6]){modificarList.add("Activos-Costo de revelacion");}
        if(((boolean[])puntero.getPrivilegios().get(1))[7]){modificarList.add("Activos-Tiempo de monitoreo");}
        if(((boolean[])puntero.getPrivilegios().get(1))[8]){modificarList.add("Activos-Proximo monitoreo");}
        if(((boolean[])puntero.getPrivilegios().get(1))[9]){modificarList.add("Activos-Ligar riesgo");}
        if(((boolean[])puntero.getPrivilegios().get(1))[10]){modificarList.add("Activos-Desligar riesgo");}
        if(((boolean[])puntero.getPrivilegios().get(2))[3]){modificarList.add("Controles-Nombre");}
        if(((boolean[])puntero.getPrivilegios().get(2))[4]){modificarList.add("Controles-Ligar Riesgos");}
        if(((boolean[])puntero.getPrivilegios().get(2))[5]){modificarList.add("Controles-Tiempo de monitoreo");}
        if(((boolean[])puntero.getPrivilegios().get(2))[6]){modificarList.add("Controles-Proximo monitoreo");}
        if(((boolean[])puntero.getPrivilegios().get(2))[7]){modificarList.add("Controles-Agregar tarea");}
        if(((boolean[])puntero.getPrivilegios().get(2))[8]){modificarList.add("Controles-Desligar un riesgo");}
        if(((boolean[])puntero.getPrivilegios().get(2))[9]){modificarList.add("Controles-Quitar tarea");}
        if(((boolean[])puntero.getPrivilegios().get(3))[3]){modificarList.add("Pol. y Pros.-Nombre");}
        if(((boolean[])puntero.getPrivilegios().get(3))[4]){modificarList.add("Pol. y Pros.-Descripcion");}
        if(((boolean[])puntero.getPrivilegios().get(3))[5]){modificarList.add("Pol. y Pros.-Tiempo de monitoreo");}
        if(((boolean[])puntero.getPrivilegios().get(3))[6]){modificarList.add("Pol. y Pros.-Proximo monitoreo");}
        if(((boolean[])puntero.getPrivilegios().get(3))[7]){modificarList.add("Pol. y Pros.-Ligar un control");}
        if(((boolean[])puntero.getPrivilegios().get(3))[8]){modificarList.add("Pol. y Pros.-Ligar un activo");}
        if(((boolean[])puntero.getPrivilegios().get(3))[9]){modificarList.add("Pol. y Pros.-Padre");}
        if(((boolean[])puntero.getPrivilegios().get(3))[10]){modificarList.add("Pol. y Pros.-Responsable");}
        if(((boolean[])puntero.getPrivilegios().get(3))[11]){modificarList.add("Pol. y Pros.-Estado");}
        if(((boolean[])puntero.getPrivilegios().get(3))[12]){modificarList.add("Pol. y Pros.-Agregar hija");}
        if(((boolean[])puntero.getPrivilegios().get(3))[13]){modificarList.add("Pol. y Pros.-Quitar hija");}
        if(((boolean[])puntero.getPrivilegios().get(3))[14]){modificarList.add("Pol. y Pros.-Desligar un control");}
        if(((boolean[])puntero.getPrivilegios().get(3))[15]){modificarList.add("Pol. y Pros.-Desligar un activo");}
        if(((boolean[])puntero.getPrivilegios().get(4))[3]){modificarList.add("P. Soporte-Nombre");}
        if(((boolean[])puntero.getPrivilegios().get(4))[4]){modificarList.add("P. Soporte-Descripcion");}
        if(((boolean[])puntero.getPrivilegios().get(4))[5]){modificarList.add("P. Soporte-Agregar politicas que soporta");}
        if(((boolean[])puntero.getPrivilegios().get(4))[6]){modificarList.add("P. Soporte-Agregar tareas a realizar");}
        if(((boolean[])puntero.getPrivilegios().get(4))[7]){modificarList.add("P. Soporte-Tiempo de monitoreo");}
        if(((boolean[])puntero.getPrivilegios().get(4))[8]){modificarList.add("P. Soporte-Proximo monitoreo");}
        if(((boolean[])puntero.getPrivilegios().get(4))[9]){modificarList.add("P. Soporte-Quitar politica que soporta");}
        if(((boolean[])puntero.getPrivilegios().get(4))[10]){modificarList.add("P. Soporte-Quitar tareas a realizar");}
        if(((boolean[])puntero.getPrivilegios().get(5))[3]){modificarList.add("Riesgos-Nombre");}
        if(((boolean[])puntero.getPrivilegios().get(5))[4]){modificarList.add("Riesgos-Ocurrencia");}
        if(((boolean[])puntero.getPrivilegios().get(5))[5]){modificarList.add("Riesgos-Impacto");}
        if(((boolean[])puntero.getPrivilegios().get(5))[6]){modificarList.add("Riesgos-Riesgo");}
        if(((boolean[])puntero.getPrivilegios().get(5))[7]){modificarList.add("Riesgos-Tratamiento");}
        if(((boolean[])puntero.getPrivilegios().get(5))[8]){modificarList.add("Riesgos-Resultado");}
        if(((boolean[])puntero.getPrivilegios().get(5))[9]){modificarList.add("Riesgos-Tiempo de monitoreo");}
        if(((boolean[])puntero.getPrivilegios().get(5))[10]){modificarList.add("Riesgos-Proximo monitoreo");}
        if(((boolean[])puntero.getPrivilegios().get(5))[11]){modificarList.add("Riesgos-Activo que ataca");}
        if(((boolean[])puntero.getPrivilegios().get(6))[3]){modificarList.add("Roles-Nombre");}
        if(((boolean[])puntero.getPrivilegios().get(6))[5]){modificarList.add("Roles-Agregar privilegio");}
        if(((boolean[])puntero.getPrivilegios().get(6))[6]){modificarList.add("Roles-Agregar usuario");}
        if(((boolean[])puntero.getPrivilegios().get(6))[7]){modificarList.add("Roles-Quitar privilegios");}
        if(((boolean[])puntero.getPrivilegios().get(6))[8]){modificarList.add("Roles-Quitar usuarios");}
        ROL.setModificar(modificarList.toArray());
        ROL.setNombreEnabled(Privilegios.getInstance().modificar(r, puntero, 3));
        ROL.setAgregarPrivilegiosEnabled(Privilegios.getInstance().modificar(r, puntero, 5));
        ROL.setEliminarPrivilegiosEnabled(Privilegios.getInstance().modificar(r, puntero, 7));
        ROL.setAgregarUsuariosEnabled(Privilegios.getInstance().modificar(r, puntero, 6));
        ROL.setEliminarUsuariosEnabled(Privilegios.getInstance().modificar(r, puntero, 8));
    }
    
    public void change(Politica POLITICA, Estructuras.Entidad_P puntero, Rol r){
        Format formatter = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        POLITICA.setNombre(puntero.getNombre());
        POLITICA.setDescripcion(puntero.getDescripcion());
        POLITICA.setEstado(puntero.getEstado());
        POLITICA.setTiempoMon(formatter.format(puntero.getTiempoDeMonitoreo()));
        POLITICA.setProximoMon(formatter.format(puntero.getProximoMonitoreo()));
        POLITICA.setResponsable(puntero.getResponsable());
        if(puntero.getNombre()!="Mision de seguridad"){
            POLITICA.setPadre(puntero.getPadre().getNombre());
        }else{
            POLITICA.setPadre("-");
        }
        POLITICA.setControles(puntero.getControlesAsociados().toArray());
        POLITICA.setActivos(puntero.getActivosAsociados().toArray());
        POLITICA.setHijas(puntero.getNombreHijas());
        POLITICA.setNombreEnable(Privilegios.getInstance().modificar(r, puntero, 3));
        POLITICA.setDescripcionEnable(Privilegios.getInstance().modificar(r, puntero, 4));
        POLITICA.setEstadoEnable(Privilegios.getInstance().modificar(r, puntero, 11));
        POLITICA.setTiempoMonEnable(Privilegios.getInstance().modificar(r, puntero, 5));
        POLITICA.setProximoMonEnable(Privilegios.getInstance().modificar(r, puntero, 6));
        POLITICA.setResponsableEnable(Privilegios.getInstance().modificar(r, puntero, 10));
        POLITICA.setPadreEnable(Privilegios.getInstance().modificar(r, puntero, 9));
        POLITICA.setAgregarActivosEnable(Privilegios.getInstance().modificar(r, puntero, 8));
        POLITICA.setQuitarActivosEnable(Privilegios.getInstance().modificar(r, puntero, 15));
        POLITICA.setAgregarControlesEnable(Privilegios.getInstance().modificar(r, puntero, 7));
        POLITICA.setQuitarControlesEnable(Privilegios.getInstance().modificar(r, puntero, 14));
        POLITICA.setAgregarHijasEnable(Privilegios.getInstance().modificar(r, puntero, 12));
        POLITICA.setQuitarHijasEnable(Privilegios.getInstance().modificar(r, puntero, 13));
    }
    
}
