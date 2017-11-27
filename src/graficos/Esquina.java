/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package graficos;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Point;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

/**
 *
 * @author ASUS
 */
public class Esquina {
    Point punto;String nombre;
    public Esquina(Point punto,String nombre){
        this.punto=punto;
        this.nombre=nombre;
    }
    public void paint(Graphics g){
        Graphics2D gg=(Graphics2D)g;
        gg.setColor(Color.red);
        gg.drawRect(punto.x+10,punto.y+10,60,60);
        //gg.setColor(Color.black);
        //gg.drawString(nombre,punto.x+30,punto.y+30);
        
    }
}
