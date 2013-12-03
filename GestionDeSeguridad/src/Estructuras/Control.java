package Estructuras;

import java.util.ArrayList;
import java.util.Date;

/**
 *
 * @author Itzcoatl90
 */
public class Control {
    private ArrayList riesgosAsociados;
    private Date tiempoDeMonitoreo;
    private String nombre;
    private ArrayList tareasARealizar;

    public ArrayList getRiesgosAsociados() {
        return riesgosAsociados;
    }

    public void setRiesgosAsociados(ArrayList riesgosAsociados) {
        this.riesgosAsociados = riesgosAsociados;
    }

    public Date getTiempoDeMonitoreo() {
        return tiempoDeMonitoreo;
    }

    public void setTiempoDeMonitoreo(Date tiempoDeMonitoreo) {
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
