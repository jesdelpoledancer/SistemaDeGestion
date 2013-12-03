package Estructuras;

/**
 *
 * @author Itzcoatl90
 */
public class DatosConfidenciales {
    private String rol;
    private String nombre;
    private String login;
    private String password;

    public DatosConfidenciales(String rol, String nombre, String login, String password) {
        this.rol = rol;
        this.nombre = nombre;
        this.login = login;
        this.password = password;
    }
    
    public String getRol(){
        return rol;
    }
    
}
