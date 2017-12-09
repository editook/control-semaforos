/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package graficos;

import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Point;
import java.awt.image.BufferedImage;
import java.io.File;
import javax.imageio.ImageIO;

/**
 *
 * @author ASUS
 */
public class trabajando {
    Point punto;
    BufferedImage imagen=null;
    public trabajando(Point punto){
        this.punto=punto;
        try{
         //imagen=ImageIO.read(new File("C:\\Users\\ASUS\\Documents\\NetBeansProjects\\Control_semaforos\\src\\graficos\\images\\trabajando.png"));
        imagen = ImageIO.read(getClass().getResource("/images/trabajando.png"));
       
        }
        catch(Exception e){
        }
       }
    public void paint(Graphics g){
        Graphics2D gg=(Graphics2D)g;
        gg.drawImage(imagen,punto.x-200,punto.y-100, null);
        
    }
}
