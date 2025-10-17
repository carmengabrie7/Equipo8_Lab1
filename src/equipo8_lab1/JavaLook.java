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
import javax.swing.table.AbstractTableModel;
import java.awt.event.ActionEvent;
import java.text.SimpleDateFormat;
import java.util.Calendar;

public class JavaLook extends JFrame {
    private EmailAccount[] Cuentas = new EmailAccount[10];
    private EmailAccount Actual = null;
    
    private CardLayout cartas = new CardLayout();
    private JPanel wasd = new JPanel(cartas);
    
    private JTextField TxtLoginCorreo;
    private JPasswordField TxtLoginContra;
    
    private JLabel LblUsuario;
    private JLabel LblReloj;
    private JTextArea AreaInbox;

    public JavaLook() {
        super("Sistema de Email");
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setSize(800, 600);
        setLocationRelativeTo(null);
        
        JButton BtnLogin = new JButton("Iniciar sesion / Crear cuenta");
        BtnLogin.addActionListener(e -> LoginoCrear());
        
        AreaInbox.setEnabled(false);
        JScrollPane Scroll = new JScrollPane(AreaInbox);
        
        JButton BtnVerInbox = new JButton("Ver inbox");
        BtnVerInbox.addActionListener(e -> MostrarInbox());
        
        JButton BtnEnviar = new JButton("Enviar correo");
        
        JPanel Abajo = new JPanel();
        Abajo.add(BtnVerInbox);
        Abajo.add(BtnEnviar);
        
        add(BtnLogin, BorderLayout.NORTH);
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
    }
    
    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            new JavaLook().setVisible(true);
        });
    }
    
    
}
