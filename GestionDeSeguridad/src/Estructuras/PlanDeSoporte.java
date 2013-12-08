package Estructuras;

import java.sql.Time;
import java.util.ArrayList;
import java.util.Date;

/**
 *
 * @author Itzcoatl90
 */
public class PlanDeSoporte {
    //0 para ver, 1 para agregar y 2 para eliminar
    private String nombre;//3
    private String descripcion;//4
    private ArrayList PoliticasQueSoporta;//5 (para agregar políticas) y 9 (para quitar políticas)
    private ArrayList TareasARealizar;//6 (para agregar tareas) y 10 (para quitar tareas)
    private Time tiempoDeMonitoreo;//7
    private Date proximoMonitoreo;//8

    public void agregarPolitica(Entidad_P in){
        /*
         agregar al ArrayList PoliticasQueSoporta la política in y todas sus hijas
         */
    }
    
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

    public ArrayList getPoliticasQueSoporta() {
        return PoliticasQueSoporta;
    }

    public void setPoliticasQueSoporta(ArrayList PoliticasQueSoporta) {
        this.PoliticasQueSoporta = PoliticasQueSoporta;
    }

    public ArrayList getTareasARealizar() {
        return TareasARealizar;
    }

    public void setTareasARealizar(ArrayList TareasARealizar) {
        this.TareasARealizar = TareasARealizar;
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
