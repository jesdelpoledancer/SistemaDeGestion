package Estructuras;

import java.util.ArrayList;

/**
 *
 * @author Itzcoatl90
 */
public class Politica extends Entidad_P {
    private ArrayList hijas;//1

    public ArrayList getHijas() {
        return hijas;
    }

    public void setHijas(ArrayList hijas) {
        this.hijas = hijas;
    }

    @Override
    public Object[] getNombreHijas() {
        Object[] salida = new Object[hijas.size()];
        for (int i = 0; i < salida.length; i++) {
            salida[i] = ((Entidad_P)hijas.get(i)).getNombre();
        }
        return salida;
    }
    
}
