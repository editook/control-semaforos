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
    Point punto;
    public Esquina(Point punto){
        this.punto=punto;
    }
    public void paint(Graphics g){
        Graphics2D gg=(Graphics2D)g;
        gg.setColor(Color.BLACK);
        gg.drawRect(punto.x,punto.y,80,80);
        
    }
}
