package equipo8_lab1;


public class Funciones_Recursivas {
 public static int contarNOLEIDOS(Email[] inbox, int pos){
     if (pos==inbox.length)//caso base
         return 0; 
     if (inbox[pos] != null && !inbox[pos].isLeido())//revisa si el correo existe y si esta leido
        return  contarNOLEIDOS(inbox, pos +1) + 1; 
     //tipo de método - down
     return contarNOLEIDOS(inbox,pos+1);
 }

 public static void buscaPOREMISOR (Email[] inbox,int pos, String emisorBuscado){
     if (pos==inbox.length)//caso base
     return;
     if (inbox[pos]!= null && inbox[pos].Emisor.equalsIgnoreCase(emisorBuscado))
         System.out.println(inbox[pos]);
     buscaPOREMISOR(inbox,pos +1, emisorBuscado);
 }
 
 public static void mostrarTODO (Email[] inbox,int pos){
     if (pos==inbox.length)//caso base
     return;
     if (inbox[pos]!=null) 
         System.out.println(inbox[pos]);
     mostrarTODO(inbox, pos +1);
 }
 
 public static void eliminarCORREOS (Email[] inbox,int pos){
     if (pos == inbox.length)//caso base
     return;
     if (inbox[pos]!=null && inbox[pos].isLeido())
         inbox[pos]=null; //borra los correos
     return;
 }
 
 public static int contarTOTAL (Email[]inbox,int pos){
     if (pos==inbox.length)//caso base
         return 0;
     if (inbox[pos] != null)
         return contarTOTAL (inbox, pos +1)+1;
         
     return contarTOTAL (inbox,pos +1);
 }
    
}
