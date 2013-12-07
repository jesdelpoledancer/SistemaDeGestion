package Estructuras;

/**
 *
 * @author Itzcoatl90
 */
public class Persona {
    private DatosConfidenciales info;//Este va a ser directamente sobre el private

    public Persona(String rol, String nombre, String login, String password) {
        info = new DatosConfidenciales(rol,nombre,login,password);
    }
    
    public Rol getRol(){
        /*
         * Datos confidenciales tiene "getRol()" que es un string...
         * 
         * Este método regresa el Rol (instancia ROL) del EntityDB (que es un singleton con toda la informacion
         * cuyo "nombre" es igual al string getRol del que se habló hace rato.
         * 
         * EntityDB es un Singleton y la forma de llamarlo es por su método "getInstance()"
         * en vez de crear uno nuevo.
         * 
         * ej.
         * 
         * EntityDB entidad = EntityDB.getInstance();
         * 
         */
        return null; 
    }
    
}
