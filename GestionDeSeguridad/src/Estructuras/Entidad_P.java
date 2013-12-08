package Estructuras;

import java.sql.Time;
import java.util.ArrayList;
import java.util.Date;

/**
 *
 * @author Itzcoatl90
 */
public abstract class Entidad_P {
    //0 para ver, 1 para crear y 2 para eliminar
    private String nombre;//3
    private String descripcion;//4
    private Time tiempoDeMonitoreo;//5
    private Date proximoMonitoreo;//6
    private ArrayList controlesAsociados;//7 (para agregar) y 14 (para quitar)
    private ArrayList activosAsociados;//8 (para agregar) y 15 (para quitar)
    private Politica padre;//9
    private String responsable;//10
    private String estado;//11
    //HIJAS (tanto para proceso como política) 12 (para agregar políticas) y 13 (para quitar políticas)

    public String getNombre() {
        return nombre;
    }
    
    public abstract Object[] getNombreHijas();
    public abstract Object[] getHijas();

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public Time getTiempoDeMonitoreo() {
        return tiempoDeMonitoreo;
    }

    public void setTiempoDeMonitoreo(Time tiempoDeMonitoreo) {
        this.tiempoDeMonitoreo = tiempoDeMonitoreo;
    }

    public Date getProximoMonitoreo() {
        return proximoMonitoreo;
    }

    public void setProximoMonitoreo(Date proximoMonitoreo) {
        this.proximoMonitoreo = proximoMonitoreo;
    }

    

    public ArrayList getControlesAsociados() {
        return controlesAsociados;
    }

    public void setControlesAsociados(ArrayList controlesAsociados) {
        this.controlesAsociados = controlesAsociados;
    }

    public ArrayList getActivosAsociados() {
        return activosAsociados;
    }

    public void setActivosAsociados(ArrayList activosAsociados) {
        this.activosAsociados = activosAsociados;
    }

    public Politica getPadre() {
        return padre;
    }

    public void setPadre(Politica padre) {
        this.padre = padre;
    }

    public String getResponsable() {
        return responsable;
    }

    public void setResponsable(String responsable) {
        this.responsable = responsable;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }
    
}
