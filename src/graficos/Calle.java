/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package graficos;
import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Point;

/**
 *
 * @author ASUS
 */
public class Calle {
    Point puntoIni,puntoDes;
    Color color;
    String calle;
    public Calle(Point puntoIni,Point puntoDes,String calle){
        this.puntoIni=puntoIni;
        this.puntoDes=puntoDes;
        this.color=new Color(242,242,242);
        this.calle=calle;
    }
    public void paint(Graphics g){
        Graphics2D gg=(Graphics2D)g;
        gg.setColor(color);
        gg.setStroke(new BasicStroke(60));
        gg.drawLine(puntoIni.x+40,puntoIni.y+40,puntoDes.x+40,puntoDes.y+40);
        gg.setColor(Color.BLACK);
        gg.drawString(calle,(((puntoIni.x)+puntoDes.x+40)/2),(((puntoIni.y+40)+puntoDes.y+40)/2));
    }
}
