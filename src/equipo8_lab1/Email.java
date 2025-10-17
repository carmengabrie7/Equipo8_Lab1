/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package equipo8_lab1;

import java.util.Calendar;
import java.text.SimpleDateFormat;
/**
 *
 * @author Hp
 */
public class Email {
    
    public static String Emisor;
    public static String Asunto;
    public static String Contenido;
    public static boolean Leido;
    public Calendar FechaEnvio;

    public Email(String Emisor, String Asunto, String Contenido) {
        this.Emisor = Emisor;
        this.Asunto = Asunto;
        this.Contenido = Contenido;
        this.Leido = false;
        this.FechaEnvio = Calendar.getInstance();
    }

    public String getEmisor() {
        return Emisor;
    }

    public String getAsunto() {
        return Asunto;
    }

    public String getContenido() {
        return Contenido;
    }

    public boolean isLeido() {
        return Leido;
    }

    public Calendar getFechaEnvio() {
        return FechaEnvio;
    }
    
    public String Print() {
        SimpleDateFormat FormatoFecha = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
        String Fecha = FormatoFecha.format(FechaEnvio.getTime());
        String Estado = Leido ? "LEIDO" : "SIN LEER";
        
        return "DE" + Emisor + "\n" + "ASUNTO:" + Asunto + "\n" + "CONTENIDO: " + Contenido + "\n" + "FECHA: " + Fecha + "\n" + "ESTADO: " + Estado;
        
    }
    
}
