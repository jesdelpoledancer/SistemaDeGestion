package Estructuras;

import java.sql.Time;
import java.util.ArrayList;

/**
 *
 * @author Itzcoatl90
 */
public class Control {
    private ArrayList riesgosAsociados;
    private Time tiempoDeMonitoreo;
    private String nombre;
    private ArrayList tareasARealizar;

    public ArrayList getRiesgosAsociados() {
        return riesgosAsociados;
    }

    public void setRiesgosAsociados(ArrayList riesgosAsociados) {
        this.riesgosAsociados = riesgosAsociados;
    }

    public Time getTiempoDeMonitoreo() {
        return tiempoDeMonitoreo;
    }

    public void setTiempoDeMonitoreo(Time tiempoDeMonitoreo) {
        this.tiempoDeMonitoreo = tiempoDeMonitoreo;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public ArrayList getTareasARealizar() {
        return tareasARealizar;
    }

    public void setTareasARealizar(ArrayList tareasARealizar) {
        this.tareasARealizar = tareasARealizar;
    }
    
}
