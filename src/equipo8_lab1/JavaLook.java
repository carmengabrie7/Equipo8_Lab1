/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to  edit this template
 */
package equipo8_lab1;

/**
 *
 * @author Hp
 */

import javax.swing.*;
import java.awt.*;

import java.text.SimpleDateFormat;
import java.util.Calendar;

public class JavaLook extends JFrame {
    private final EmailAccount[] Cuentas = new EmailAccount[10];
    private EmailAccount Actual = null;
    
    private final CardLayout cartas = new CardLayout();
    private final JPanel wasd = new JPanel(cartas);
    
    private final JTextArea AreaInbox = new JTextArea();
    
    private final JLabel LblUsuarioActual;    

    public JavaLook() {
        super("Sistema de Email");
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setSize(800, 600);
        setLocationRelativeTo(null);
        
        LblUsuarioActual = new JLabel("Ningun usuario conectado");
        LblUsuarioActual.setFont(new Font("Arial", Font.BOLD, 12));
        LblUsuarioActual.setForeground(Color.BLUE);
        
        JButton BtnLogin = new JButton("Iniciar sesion / Crear cuenta");
        BtnLogin.addActionListener(e -> LoginoCrear());
        
        JPanel Topbar = new JPanel(new BorderLayout());
        
        JPanel izquierda = new JPanel(new FlowLayout(FlowLayout.LEFT, 10, 6));
        izquierda.add(BtnLogin);
        
        Topbar.add(izquierda, BorderLayout.WEST);
        Topbar.add(LblUsuarioActual, BorderLayout.CENTER);
        
        AreaInbox.setEnabled(true);
        AreaInbox.setEditable(false);
        AreaInbox.setFont(new Font("Arial", Font.BOLD, 16));
        JScrollPane Scroll = new JScrollPane(AreaInbox);
        
        JButton BtnVerInbox = new JButton("Ver inbox");
        BtnVerInbox.addActionListener(e -> MostrarInbox());
        
        JButton BtnEnviar = new JButton("Enviar correo");
        BtnEnviar.addActionListener(e -> EnviarCorreo());
        
        JPanel Abajo = new JPanel();
        Abajo.add(BtnVerInbox);
        Abajo.add(BtnEnviar);
        
        add(Topbar, BorderLayout.NORTH);
        add(Scroll, BorderLayout.CENTER);
        add(Abajo, BorderLayout.SOUTH);
        
        setVisible(true);
    }
    
    private void LoginoCrear() {
        String Correo = JOptionPane.showInputDialog(this, "Correo: ");
        if (Correo == null) {
            return;
        }
        
        String Contrasena = JOptionPane.showInputDialog(this, "Contraseña: ");
        if (Contrasena == null) {
            return;
        }
        
        EmailAccount CuentaActual = BuscarCuenta(Correo);
        if (CuentaActual != null) {
            if (CuentaActual.getPassword().equals(Contrasena)) {
                Actual = CuentaActual;
                
                LblUsuarioActual.setText("Usuario conetado: " + Actual.getNombreUsuario() + " (" + Actual.getDireccionEmail() + ")");
                
                JOptionPane.showMessageDialog(this, "Bienvenido, " + CuentaActual.getNombreUsuario());
            } else {
                JOptionPane.showMessageDialog(this, "Contraseña incorrecta");
            }
        } else {
            String Nombre = JOptionPane.showInputDialog(this, "Nuevo usuario, ingrese su nombre: ");
            if (Nombre == null) {
                return;
            }
            
            EmailAccount Nuevo = new EmailAccount(Correo, Contrasena, Nombre);
            GuardarCuenta(Nuevo);
            Actual = Nuevo;
            
            JOptionPane.showMessageDialog(this, "Cuenta creada e iniciada sesion como " + Nombre);
        }
    }
    
    private void MostrarInbox() {
        if (Actual == null) {
            JOptionPane.showMessageDialog(this, "Inicia sesion primero");
            return;
        }
        
        Email[] inbox = Actual.getInbox();
        
        StringBuilder sb = new StringBuilder();
        sb.append("==== INBOX de ").append(Actual.getNombreUsuario()).append("====\n");
        sb.append("Fecha: ").append(FechaActual()).append("\n\n");
        
        for (int i = 0; i < inbox.length; i++) {
            if (inbox[i] != null) {
                sb.append(i).append(" - ").append(inbox[i].getEmisor()).append(" - ").append(inbox[i].getAsunto()).append(" - ").append(inbox[i].isLeido() ? "LEIDO" : "SIN LEER").append("\n");
            }
        }
        AreaInbox.setText(sb.toString());
    }
    
    private void EnviarCorreo() {
        if (Actual == null) {
            JOptionPane.showMessageDialog(this, "Inicia sesion primero");
            return;
        }
        
        String Destinatario = JOptionPane.showInputDialog(this, "Destinatario (correo): ");
        if (Destinatario == null) {
            return;
        }
        
        EmailAccount Receptor = BuscarCuenta(Destinatario);
        if (Receptor == null) {
            JOptionPane.showMessageDialog(this, "Destinatario no encontrado");
            return;
        }
        
        String Asunto = JOptionPane.showInputDialog(this, "Asunto:");
        if (Asunto == null) {
            return;
        }
        
        String Contenido = JOptionPane.showInputDialog(this, "Contenido del mensaje:");
        if (Contenido == null) {
            return;
        }
        Email Nuevo = new Email(Actual.getDireccionEmail(), Asunto, Contenido);
        if (Receptor.recibirEmail(Nuevo)) {
            JOptionPane.showMessageDialog(this, "Correo enviado con exito!");
        } else {
            JOptionPane.showMessageDialog(this, "Inbox del destinatario esta lleno.");
        }
    }
    
    /*
        UTILIDADES
    */
    private EmailAccount BuscarCuenta(String correo) {
        for (EmailAccount corr : Cuentas) {
            if (corr != null && corr.getDireccionEmail().equalsIgnoreCase(correo)) {
                return corr;
            }
        }
        return null;
    }
    
    private String FechaActual() {
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
        return sdf.format(Calendar.getInstance().getTime());
    }
    
    private void GuardarCuenta(EmailAccount nueva) {
        for (int i = 0; i < Cuentas.length; i++) {
            if (Cuentas[i] == null) {
                Cuentas[i] = nueva;
                return;
            }
        }
    }
    
    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            new JavaLook().setVisible(true);
        });
    }
}
