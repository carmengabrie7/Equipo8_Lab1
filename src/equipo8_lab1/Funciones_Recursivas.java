package equipo8_lab1;


public class Funciones_Recursivas {
 public static int contarNOLEIDOS(Email[] inbox, int pos){
     if (pos==inbox.length)//caso base
         return 0; 
     if (inbox[pos] != null && !inbox[pos].isLeido())
        return  contarNOLEIDOS(inbox, pos +1) + 1; 
     //tipo de método - down
 }

 public static void buscaPOREMISOR (Email[] inbox,int pos, String emisorBuscado){
     
     
     return;
 }
 
 public static void mostrarTODO (){
     
     return;
 }
 
 public static void eliminarLEIDOS(){
     
     return;
 }
 
 public static int contarTOTAL (Email[]inbox,int pos){
     if (pos==inbox.length)
         return 0;
     if (inbox[pos] != null)
         return contarTOTAL (inbox, pos +1)+1;
         
     return contarTOTAL (inbox,pos +1);
 }
    
}
