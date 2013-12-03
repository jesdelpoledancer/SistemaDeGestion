package Estructuras;

import java.util.ArrayList;
import java.util.Date;

/**
 *
 * @author Itzcoatl90
 */
public class PlanDeSoporte {
    private String nombre;
    private String descripcion;
    private ArrayList PoliticasQueSoporta;
    private ArrayList TareasARealizar;
    private Date tiempoDeMonitoreo;

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

    public Date getTiempoDeMonitoreo() {
        return tiempoDeMonitoreo;
    }

    public void setTiempoDeMonitoreo(Date tiempoDeMonitoreo) {
        this.tiempoDeMonitoreo = tiempoDeMonitoreo;
    }
    
}
