package Estructuras;

/**
 *
 * @author Itzcoatl90
 */
public class DatosConfidenciales {
    private Rol rol;
    private String nombre;
    private String login;
    private String password;

    public DatosConfidenciales(Rol rol, String nombre, String login, String password) {
        this.rol = rol;
        this.nombre = nombre;
        this.login = login;
        this.password = password;
    }
    
}
