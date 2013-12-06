package Estructuras;

import java.sql.Time;
import java.util.ArrayList;
import java.util.Date;

/**
 *
 * @author Itzcoatl90
 */
public abstract class Entidad_P {
    private String nombre;//1
    private String descripcion;//2
    private Time tiempoDeMonitoreo;//3
    private Date proximoMonitoreo;//4
    private ArrayList controlesAsociados;//5
    private ArrayList activosAsociados;//6
    private Politica padre;//7
    private Rol responsable;//8
    private String estado;//9

    public String getNombre() {
        return nombre;
    }
    
    public abstract Object[] getNombreHijas();

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

    public Rol getResponsable() {
        return responsable;
    }

    public void setResponsable(Rol responsable) {
        this.responsable = responsable;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }
    
}
