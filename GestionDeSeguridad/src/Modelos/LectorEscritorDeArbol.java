package Modelos;

/**
 *
 * @author Itzcoatl90
 */
public class LectorEscritorDeArbol {
    public void leerArbol(){
        /*
         * Este Método lee desde el archivo arbolP.sg
         * TODO el arbol de procesos y los va anidando conforme
         * su jerarquia.
         * 
         * En el archivo arbolP.sg está toda la jerarquía de los
         * procesos y sus atributos, EXCEPTO los atributos que son
         * otras entidades, de estos solo están sus referencias (nombres)
         * 
         * Cuando este método es llamado YA EXISTEN TODAS LAS ENTIDADES
         * en EntityDB, de modo que buscar en EntityDB la entidad correspondiente
         * y agregárselas...
         * 
         * Ej. en arbol solo tienes algo como:
         *      Proceso: Proceso1
         *      Controles: {control1, control2, control3}
         * 
         * los controles ya existen, de modo que busca en entityDB y agregaselos al vector
         * 
         * EntityDB es un Singleton y la forma de llamarlo es por su método "getInstance()"
         * en vez de crear uno nuevo.
         * 
         * ej.
         * 
         * EntityDB entidad = EntityDB.getInstance();
         * 
         * NOTA: La primer y más alta Entidad_P que existe SE LLAMA MISION y no tiene padre.
         * 
         */
    }
    public boolean escribirArbol(){
        /*
         * En este método escribes lo que puedas leer directamente a un archivo (arbolP.sg)
         * regresa true si lo lograste hacer... regresa false si hubo cualquier error.
         */
        return true;
    }
}
