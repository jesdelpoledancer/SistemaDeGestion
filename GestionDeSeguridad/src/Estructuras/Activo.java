package Estructuras;

import java.util.ArrayList;
import java.util.Date;

/**
 *
 * @author Itzcoatl90
 */
public class Activo {
    private ArrayList riesgos;
    private String nombre;
    private double costo;
    private Date tiempoDeMonitoreo;
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

    public double getCosto() {
        return costo;
    }

    public void setCosto(double costo) {
        this.costo = costo;
    }

    public Date getTiempoDeMonitoreo() {
        return tiempoDeMonitoreo;
    }

    public void setTiempoDeMonitoreo(Date tiempoDeMonitoreo) {
        this.tiempoDeMonitoreo = tiempoDeMonitoreo;
    }
   
}
