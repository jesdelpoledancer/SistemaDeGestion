package Estructuras;

/**
 *
 * @author Itzcoatl90
 */
public class Persona {
    private DatosConfidenciales info;

    public Persona(Rol rol, String nombre, String login, String password) {
        info = new DatosConfidenciales(rol,nombre,login,password);
    }
    
}
