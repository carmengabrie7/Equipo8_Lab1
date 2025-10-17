/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package equipo8_lab1;
import java.text.SimpleDateFormat;
import java.util.Calendar;
/**
 *
 * @author andre
 */
public class EmailAccount {
        Calendar hoy = Calendar.getInstance();

    String direccionEmail, password, nombreUsuario;

    
    Email[] inbox;

    public EmailAccount(String direccionEmail, String password, String nombreUsuario, Email[] inbox) {
        this.direccionEmail = direccionEmail;
        this.password = password;
        this.nombreUsuario = nombreUsuario;
        this.inbox = new Email[10];
    }

    public String getDireccionEmail() {
        return direccionEmail;
    }

    public String getPassword() {
        return password;
    }

    public String getNombreUsuario() {
        return nombreUsuario;
    }

    public boolean recibirEmai(Email em) {
        for (int i = 0; i < inbox.length; i++) {
            if (inbox[i] == null) {
                inbox[i] = em;
                return true;
            }
        }
        return false;
    }
    
    public void printInbox(){
        SimpleDateFormat FormatoFecha = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
        System.out.println("Fecha de hoy: "+FormatoFecha.format(hoy.getTime()));
        System.out.println("Posicion – Emisor – Asunto – [Leido / Sin Leer]");
        
        
        System.out.println("Correos Totales");
        System.out.println("Correos Sin Leer");
        
    }


}
