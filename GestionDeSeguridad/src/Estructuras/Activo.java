package Estructuras;

import java.sql.Time;
import java.util.ArrayList;

/**
 *
 * @author Itzcoatl90
 */
public class Activo {
    private ArrayList riesgos;
    private String nombre;
    private double costo;
    private Time tiempoDeMonitoreo;
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

    public Time getTiempoDeMonitoreo() {
        return tiempoDeMonitoreo;
    }

    public void setTiempoDeMonitoreo(Time tiempoDeMonitoreo) {
        this.tiempoDeMonitoreo = tiempoDeMonitoreo;
    }
   
}
