package Estructuras;

/**
 *
 * @author Itzcoatl90
 */
public class Persona {
    private DatosConfidenciales info;

    public Persona(String rol, String nombre, String login, String password) {
        info = new DatosConfidenciales(rol,nombre,login,password);
    }
    
}
