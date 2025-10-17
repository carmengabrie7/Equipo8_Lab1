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

public class JavaLook extends JFrame {
    private EmailAccount[] Cuentas = new EmailAccount[10];
    private EmailAccount CuentaActual = null;
    
    private CardLayout cartas = new CardLayout();
    private JPanel wasd = new JPanel(cartas);
    
    private JTextField TxtLoginCorreo;
    private JPasswordField TxtLoginContra;
    
    private JLabel LblUsuario;
    private JLabel LblReloj;
    private JTextArea AreaInbox;
}
