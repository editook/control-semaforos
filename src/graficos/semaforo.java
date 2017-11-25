/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package graficos;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Point;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author ASUS
 */
public class semaforo extends Thread{
    Point punto;
    Color rojoActivo,rojoInactivo,amarilloActivo,amarilloInactivo,verdeActivo,verdeInactivo;
    Color rojo,amarillo,verde;
    int config;//1 derecha rizontal 2 abajo vertical 3 izquierda orizontal 4 arriba vertical
    public semaforo(Point punto,int config){
        this.punto=punto;
        this.config=config;
        rojoActivo=new Color(255, 32, 32);
        rojoInactivo=new Color(128,0, 0);
        amarilloActivo=new Color(255, 255, 0);
        amarilloInactivo=new Color(138,159,0);
        verdeActivo=new Color(0, 255, 0);
        verdeInactivo=new Color(0,64,0);
        this.start();
    }
    @Override
    public void run() {
        while(true){
            try {
                if(config==1){
                rojo=rojoInactivo;
                amarillo=amarilloInactivo;
                verde=verdeActivo;
                Thread.sleep(8000);
                rojo=rojoInactivo;
                amarillo=amarilloActivo;
                verde=verdeInactivo;
                Thread.sleep(700);
                rojo=rojoActivo;
                amarillo=amarilloInactivo;
                verde=verdeInactivo;
                Thread.sleep(8000);
                }
                else{
                rojo=rojoActivo;
                amarillo=amarilloInactivo;
                verde=verdeInactivo;
                Thread.sleep(8000);
                rojo=rojoInactivo;
                amarillo=amarilloInactivo;
                verde=verdeActivo;
                Thread.sleep(8000);
                rojo=rojoInactivo;
                amarillo=amarilloActivo;
                verde=verdeInactivo;
                Thread.sleep(700);
                
                }
                
            } catch (InterruptedException ex) {
                Logger.getLogger(semaforo.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }
    public void paint(Graphics g) {
        if(config==1){
        g.setColor(rojo.darker());
        g.fillOval(punto.x,punto.y+5,15,15);
        g.setColor(amarillo.darker());
        g.fillOval(punto.x,punto.y+25,15,15);
        g.setColor(verde.darker());
        g.fillOval(punto.x,punto.y+45,15,15);
        }
        else{
        g.setColor(rojo.darker());
        g.fillOval(punto.x+5,punto.y,15,15);
        g.setColor(amarillo.darker());
        g.fillOval(punto.x+25,punto.y,15,15);
        g.setColor(verde.darker());
        g.fillOval(punto.x+45,punto.y,15,15);
        }
        
    }
}
