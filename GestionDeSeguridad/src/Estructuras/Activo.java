package Estructuras;

import java.sql.Time;
import java.util.ArrayList;
import java.util.Date;

/**
 *
 * @author Itzcoatl90
 */
public class Activo {
    private ArrayList riesgos;
    private String nombre;
    private String costoModificacion;
    private String costoInterrupcion;
    private String costoRevelacion;
    private Time tiempoDeMonitoreo;
    private Date proximoMonitoreo;
    public ArrayList getRiesgos() {
        return riesgos;
    }

    public void setRiesgos(ArrayList riesgos) {
        this.riesgos = riesgos;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getCostoModificacion() {
        return costoModificacion;
    }

    public void setCostoModificacion(String costoModificacion) {
        this.costoModificacion = costoModificacion;
    }

    public String getCostoInterrupcion() {
        return costoInterrupcion;
    }

    public void setCostoInterrupcion(String costoInterrupcion) {
        this.costoInterrupcion = costoInterrupcion;
    }

    public String getCostoRevelacion() {
        return costoRevelacion;
    }

    public void setCostoRevelacion(String costoRevelacion) {
        this.costoRevelacion = costoRevelacion;
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
   
}
