package Estructuras;

import java.sql.Time;
import java.util.ArrayList;
import java.util.Date;

/**
 *
 * @author Itzcoatl90
 */
public class Control {
    //0 para ver, 1 para crear y 2 para eliminar
    private String nombre;//3
    private ArrayList riesgosAsociados;//4 (para agregar un riesgo a la lista) 8 (para quitar un riesgo)
    private Time tiempoDeMonitoreo;//5
    private Date proximoMonitoreo;//6
    private ArrayList tareasARealizar;//7 (para agregar una tarea) y 9 (para quitar una tarea)
    private int costoDeAdquisicion;
    private String tipoDeControl;//Preventivo, Operativo, Detectivo, Reactivo, Garantía

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

    public int getCostoDeAdquisicion() {
        return costoDeAdquisicion;
    }

    public void setCostoDeAdquisicion(int costoDeAdquisicion) {
        this.costoDeAdquisicion = costoDeAdquisicion;
    }
    
}
