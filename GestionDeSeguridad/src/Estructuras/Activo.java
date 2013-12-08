package Estructuras;

import java.sql.Time;
import java.util.ArrayList;
import java.util.Date;

/**
 *
 * @author Itzcoatl90
 */
public class Activo {
    //0 para ver, 1 para crear y 2 para eliminar
    private ArrayList riesgos;//9 (para agregar riesgo) y 10 (para quitar un riesgo)
    private String nombre;//3
    private String costoModificacion;//4
    private String costoInterrupcion;//5
    private String costoRevelacion;//6
    private Time tiempoDeMonitoreo;//7
    private Date proximoMonitoreo;//8
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
