/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package graficos;
import control.vertice;
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
    vertice puntoIni,puntoDes;
    Color color;
    String calle;
    public Calle(vertice puntoIni,vertice puntoDes,String calle){
        this.puntoIni=puntoIni;
        this.puntoDes=puntoDes;
        this.color=new Color(242,242,242);
        this.calle=calle;
    }
    public void paint(Graphics g){
        Graphics2D gg=(Graphics2D)g;
        gg.setColor(color);
        gg.setStroke(new BasicStroke(60));
        gg.drawLine(puntoIni.getPunto().x+40,puntoIni.getPunto().y+40,puntoDes.getPunto().x+40,puntoDes.getPunto().y+40);
        gg.setColor(Color.BLUE);
        //----------------------------------------------------------------------------------------------------------
        if(panel.estadoVisibleNodos!=0){
        if(esquina(puntoIni)){
        gg.fillOval(puntoIni.getPunto().x+30,puntoIni.getPunto().y+30, 20, 20);
        gg.setColor(Color.WHITE);
        gg.drawString(puntoIni.nombre,(puntoIni.getPunto().x+35),(puntoIni.getPunto().y+42));
        }
        gg.setColor(Color.BLUE);
        if(esquina(puntoDes)){
        gg.fillOval(puntoDes.getPunto().x+30,puntoDes.getPunto().y+30, 20, 20);
        gg.setColor(Color.WHITE);
        gg.drawString(puntoDes.nombre,(puntoDes.getPunto().x+35),(puntoDes.getPunto().y+42));
        }
        }
        gg.setColor(Color.BLACK);
        gg.drawString(calle,(((puntoIni.getPunto().x)+puntoDes.getPunto().x+40)/2),(((puntoIni.getPunto().y+40)+puntoDes.getPunto().y+40)/2));
    }
    private boolean esquina(vertice v) {
        boolean res = true;
        if (v.nombre.equals("aa") || v.nombre.equals("bb") || v.nombre.equals("cc") || v.nombre.equals("dd")
                || v.nombre.equals("ee") || v.nombre.equals("ff") || v.nombre.equals("gg") || v.nombre.equals("hh")
                || v.nombre.equals("ii") || v.nombre.equals("jj") || v.nombre.equals("kk") || v.nombre.equals("ll")) {
            res = false;
        }
        return res;
    }
}
