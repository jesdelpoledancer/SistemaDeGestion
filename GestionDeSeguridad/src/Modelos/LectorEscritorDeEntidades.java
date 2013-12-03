package Modelos;

/**
 *
 * @author Itzcoatl90
 */
public class LectorEscritorDeEntidades {
    
    public LectorEscritorDeEntidades(){
    }
    
    public void leerEntidadesDirectas(){
        /*
         * Lee desde archivo llamado "DirEnt.sg" las entidades:
         * -Riesgo
         * -Tarea
         * 
         * En este archivo solo están esas entidades, con todos
         * sus atributos.
         * 
         * TODAS las entidades ponerlas en su respectiva lista en "EntityDB"
         * 
         * EntityDB es un Singleton y la forma de llamarlo es por su método "getInstance()"
         * en vez de crear uno nuevo.
         * 
         * ej.
         * 
         * EntityDB entidad = EntityDB.getInstance();
         */
    }
    
    public void leerEntidadesIndirectas(){
        /*
         * Lee desde archivo llamado "IndEnt.sg" las entidades:
         * 
         * -Activo
         * -PlanDeSoporte
         * -Control
         * 
         * En este archivo solo están esas entidades, con todos
         * sus atributos, en los atributos que son otras entidades
         * (Riesgos y Tareas) solo hay una referencia a nombre y amenaza
         * de Tarea y Riesgo respectivamente. BUSCAR la tarea y/o riesgo en
         * el vector de EntityDB y agregarselos
         * 
         * TODAS las entidades ponerlas en su respectiva lista en "EntityDB"
         * 
         * EntityDB es un Singleton y la forma de llamarlo es por su método "getInstance()"
         * en vez de crear uno nuevo.
         * 
         * ej.
         * 
         * EntityDB entidad = EntityDB.getInstance();
         */
    }
    
}
