package Modelos;

/**
 *
 * @author Itzcoatl90
 */
public class LectorEscritorValuadorDeRol {
    
    public boolean autenticar(String login, String password){
        /*
         * Este método revisa del archivo SAMY.sg si el login existe,
         * si el password (hasheado) está asociado con el login.
         * 
         * En SAMY.sg están los atributos de "DatosConfidenciales":
         * rol (string nombre), login, Nombre, password
         * 
         * Si el login existe y si password (después de hashearlo) es
         * el que está asociado con este regresa true
         * false en otro caso.
         * 
         * NOTA: en el archivo están los passwords HASHEADOS
         * 
         * Si miras que va a ser true, crea la "persona" de EntityDB
         * 
         * EntityDB es un Singleton y la forma de llamarlo es por su método "getInstance()"
         * en vez de crear uno nuevo.
         * 
         * ej.
         * 
         * EntityDB entidad = EntityDB.getInstance();
         * 
         */
        return true;
    }
    
    public void leerRoles(){
        /*
         * Leer de archivo ident.sg
         * los datos de la persona del login...
         * 
         * En este archivo se encuentran los logins y los atributos
         * DE LOS ROLES.
         * 
         * Se guardan todos los roles en EntityDB
         * 
         * EntityDB es un Singleton y la forma de llamarlo es por su método "getInstance()"
         * en vez de crear uno nuevo.
         * 
         * ej.
         * 
         * EntityDB entidad = EntityDB.getInstance();
         * 
         */
    }
    
}
