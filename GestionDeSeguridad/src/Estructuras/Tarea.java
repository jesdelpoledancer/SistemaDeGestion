package Estructuras;

/**
 *
 * @author Itzcoatl90
 */
public class Tarea {
    private String nombre;//1
    private String descripcion;//2

    public Tarea(){
    }
    
    public Tarea(String nombre){
    }
    
    public Tarea(String nombre,String descripcion){
        this.nombre = nombre;
        this.descripcion = descripcion;
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
    
}
