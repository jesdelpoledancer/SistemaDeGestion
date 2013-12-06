package Estructuras;

import java.sql.Time;
import java.util.ArrayList;
import java.util.Date;

/**
 *
 * @author Itzcoatl90
 */
public class Control {
    private String nombre;//1
    private ArrayList riesgosAsociados;//2
    private Time tiempoDeMonitoreo;//3
    private Date proximoMonitoreo;//4
    private ArrayList tareasARealizar;//5

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

    public Date getProximoMonitoreo() {
        return proximoMonitoreo;
    }

    public void setProximoMonitoreo(Date proximoMonitoreo) {
        this.proximoMonitoreo = proximoMonitoreo;
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
