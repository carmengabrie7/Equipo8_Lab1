/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package equipo8_lab1;

/**
 *
 * @author andre
 */
public class EmailAccount {

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
    
    public boolean recibirEmmai(Email em){
        
        
    return false;
           
    }


}
