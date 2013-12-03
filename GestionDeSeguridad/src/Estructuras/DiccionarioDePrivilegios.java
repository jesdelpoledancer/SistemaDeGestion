package Estructuras;

import java.util.HashMap;

/**
 *
 * @author Itzcoatl90
 */
public class DiccionarioDePrivilegios {
    private HashMap diccionario;
    private DiccionarioDePrivilegios() {
    }
    
    public static DiccionarioDePrivilegios getInstance() {
        return DiccionarioDePrivilegiosHolder.INSTANCE;
    }
    
    private static class DiccionarioDePrivilegiosHolder {

        private static final DiccionarioDePrivilegios INSTANCE = new DiccionarioDePrivilegios();
    }
}
