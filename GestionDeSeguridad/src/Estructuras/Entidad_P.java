package Estructuras;

import java.sql.Time;
import java.util.ArrayList;

/**
 *
 * @author Itzcoatl90
 */
public class Entidad_P {
    private String nombre;
    private String descripcion;
    private Time tiempoDeRevision;
    private ArrayList controlesAsociados;
    private ArrayList activosAsociados;
    private Politica padre;
    private Rol responsable;
    private String estado;

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public Time getTiempoDeRevision() {
        return tiempoDeRevision;
    }

    public void setTiempoDeRevision(Time tiempoDeRevision) {
        this.tiempoDeRevision = tiempoDeRevision;
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
