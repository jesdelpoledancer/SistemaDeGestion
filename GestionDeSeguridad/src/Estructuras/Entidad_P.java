package Estructuras;

import java.sql.Time;
import java.util.ArrayList;

/**
 *
 * @author Itzcoatl90
 */
public class Entidad_P {
    private String nombre;
    private String descripcion;
    private Time tiempoDeRevision;
    private ArrayList controlesAsociados;
    private ArrayList activosAsociados;
    private Politica padre;
    private Rol responsable;
    private String estado;
}
