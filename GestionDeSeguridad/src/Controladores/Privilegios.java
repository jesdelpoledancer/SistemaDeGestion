package Controladores;

import Estructuras.Rol;

/**
 *
 * @author Itzcoatl90
 */
public class Privilegios {
    
    private Privilegios() {
    }
    
    public static Privilegios getInstance() {
        return PrivilegiosHolder.INSTANCE;
    }
    
    private static class PrivilegiosHolder {

        private static final Privilegios INSTANCE = new Privilegios();
    }
    
     public int ObjetoEstructura(Object obj){
         int objeto1=0;
        
        if(obj instanceof Estructuras.Activo == true)
            objeto1 =1;
        if(obj instanceof Estructuras.Control == true)
            objeto1 =2;
        if(obj instanceof Estructuras.Entidad_P == true)
            objeto1 =3;
        if(obj instanceof Estructuras.PlanDeSoporte == true)
            objeto1 =4;
        if(obj instanceof Estructuras.Riesgo == true)
            objeto1 =5;
        if(obj instanceof Estructuras.Rol == true)
            objeto1 = 6;
        
        return objeto1;
    }
    
        
    public boolean ver(Rol rol,Object obj){
       
       switch(ObjetoEstructura(obj))
            {
		case 1: 
                    return ((boolean[])rol.getPrivilegios().get(1))[0];
            
                case 2:
                    return ((boolean[])rol.getPrivilegios().get(2))[0];
                   
                case 3:
                    return ((boolean[])rol.getPrivilegios().get(3))[0];
                    
                case 4:
                    return ((boolean[])rol.getPrivilegios().get(4))[0];
                
                case 5:
                    return ((boolean[])rol.getPrivilegios().get(5))[0];
                    
                case 6:
                    return ((boolean[])rol.getPrivilegios().get(6))[0];
                
                default:
                    break;
       }
        
        
            
        return true;
    }
    
    public boolean crear(Rol rol, Object obj){
            switch(ObjetoEstructura(obj))
        {
		case 1: 
                    return ((boolean[])rol.getPrivilegios().get(1))[1];
            
                case 2:
                    return ((boolean[])rol.getPrivilegios().get(2))[1];
                   
                case 3:
                    return ((boolean[])rol.getPrivilegios().get(3))[1];
                    
                case 4:
                    return ((boolean[])rol.getPrivilegios().get(4))[1];
                
                case 5:
                    return ((boolean[])rol.getPrivilegios().get(5))[1];
                    
                case 6:
                    return ((boolean[])rol.getPrivilegios().get(6))[1];
                
                default:
                    break;
       }
        return true;
    }
    
    public boolean eliminar(Rol rol, Object obj){
           
        switch(ObjetoEstructura(obj))
            {
		case 1: 
                    return ((boolean[])rol.getPrivilegios().get(1))[2];
                
                case 2:
                    return ((boolean[])rol.getPrivilegios().get(2))[2];
                   
                case 3:
                    return ((boolean[])rol.getPrivilegios().get(3))[2];
                    
                case 4:
                    return ((boolean[])rol.getPrivilegios().get(4))[2];
                
                case 5:
                    return ((boolean[])rol.getPrivilegios().get(5))[2];
                    
                case 6:
                    return ((boolean[])rol.getPrivilegios().get(6))[2];
                
                default:
                    break;
       }
        return true;
    }
    
    public boolean modificar(Rol rol, Object obj, int numeroAtributo){
   
        switch(ObjetoEstructura(obj))
        {
		case 1: 
                    return ((boolean[])rol.getPrivilegios().get(1))[numeroAtributo];
            
                case 2:
                    return ((boolean[])rol.getPrivilegios().get(2))[numeroAtributo];
                   
                case 3:
                    return ((boolean[])rol.getPrivilegios().get(3))[numeroAtributo];
                    
                case 4:
                    return ((boolean[])rol.getPrivilegios().get(4))[numeroAtributo];
                
                case 5:
                    return ((boolean[])rol.getPrivilegios().get(5))[numeroAtributo];
                    
                case 6:
                    return ((boolean[])rol.getPrivilegios().get(6))[numeroAtributo];
                
                default:
                    break;
       }
                    
     return true;
    }
    
 
    
}
