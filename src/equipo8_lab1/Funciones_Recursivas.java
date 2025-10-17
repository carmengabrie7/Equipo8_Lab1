package equipo8_lab1;


public class Funciones_Recursivas {
 public static int contarNOLEIDOS(Email[] inbox, int pos){
     if (pos==inbox.length)//caso base
         return 0; 
     if (inbox[pos] != null && !inbox[pos].leido)
        return  1 + contarNOLEIDOS(inbox, pos +1); 
     //tipo de método - downk
 }

 public static int buscaPOREMISOR (Email[] inbox,int pos, String emisorBuscado){
     if (pos==inbox.length)
         return 0;
     if (inbox[pos] != null )
     
     
     return 0;
 }
 
 public static int mostrarTODO (){
     
     return 0;
 }
 
 public static int contarTOTAL (Email[]inbox){
     
         
     return 0;
 }
    
}
