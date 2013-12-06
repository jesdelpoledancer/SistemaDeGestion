package Estructuras;

/**
 *
 * @author Itzcoatl90
 */
public class DatosConfidenciales {
    private String rol;//1
    private String nombre;//2
    private String login;//3
    private String password;//4

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
