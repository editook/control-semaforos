/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package interfaz;

import graficos.panel;
import java.awt.Color;
import javax.swing.JFrame;
import javax.swing.WindowConstants;

/**
 *
 * @author ASUS
 */
public class jframe {
    JFrame frame;
    public jframe(){
    frame=new JFrame();//crea un formulario JFrame
    frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);//cierre de sesion
    frame.getContentPane().setLayout(null);//setea para nueva configuracion
    frame.setExtendedState(JFrame.MAXIMIZED_BOTH);//tamaño maximo
    frame.setResizable(true);//
    frame.setLocationRelativeTo(null);
    frame.getContentPane().add(new panel(frame));//carga una clase que extiende de JPanel
    frame.setVisible(true);//muestra
    }
}
