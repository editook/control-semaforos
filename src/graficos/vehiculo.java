/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package graficos;

import control.Zona;
import control.grafo;
import control.vertice;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Point;
import java.util.ArrayList;
import java.util.Random;

/**
 *
 * @author ASUS
 */
public class vehiculo extends Thread {

    private Point puntoMov;
    public Point ubicacion;
    private Color color;
    protected Random r = new Random();
    public int velocidad;//km
    private boolean caminoRecorrido = false;
    ArrayList<vehiculo> vehiculos;
    ArrayList<semaforo> semaforos;
    int direccion = 0;// 1 derecha rizontal 2 abajo vertical 3 izquierda orizontal 4 arriba vertical
    Color rojo = new Color(255, 32, 32);
    Color amarillo = new Color(255, 255, 0);
    grafo g;
    public vehiculo(Point puntoMov, Point p, int velocity) {
        this.puntoMov = puntoMov;
        ubicacion = p;
        color = new Color(r.nextInt(255), r.nextInt(255), r.nextInt(255));
        switch (velocity) {
            case 1:
                velocidad = 13;
                break;//alta
            case 2:
                velocidad = 20;
                break;//media
            default:
                velocidad = 25;//baja
        }
        if (puntoMov.x == 1) {
            direccion = 1;
        } else {
            if (puntoMov.x == -1) {
                direccion = 3;
            }
        }
        if (puntoMov.y == 1) {
            direccion = 2;
        } else {
            if (puntoMov.y == -1) {
                direccion = 4;
            }

        }
        g=Zona.getMapa();
        this.start();
    }

    @Override
    public void run() {
        while (Limite()) {
            try {
                moverse();
                cambiarDireccion();
                sleep(velocidad);
            } catch (InterruptedException ex) {
                System.err.println(ex);
            }

        }
        caminoRecorrido = true;
    }

    private void moverse() {
        vehiculos = panel.getListaVehiculos();
        semaforos = panel.getListaSemaforos();
        boolean resVehiculo = false;
        boolean resSemaforo = false;
        int colisiones=0;
        try {
            
            for (int i = 0; i < vehiculos.size(); i++) {
                colisiones=i;
            if (vehiculos.get(i).direccion == direccion) {
                if (colision(vehiculos.get(i))){
                    resVehiculo = true;
                    break;
                }
            }
        }
        } catch (Exception e) {
            System.out.println("jajajjaj"+vehiculos.get(colisiones).direccion);
        }
        
        
        for (int i = 0; i < semaforos.size(); i++) {
            if (semaforos.get(i).direccion==direccion) {
                if(ControlSemaforo(semaforos.get(i))){
                resSemaforo = true;
                break;
            }
        
        }
        }
        if (resVehiculo == false && resSemaforo == false) {
            ubicacion.x = ubicacion.x + (puntoMov.x);
            ubicacion.y = ubicacion.y + (puntoMov.y);
        }
    }

    public boolean CaminoRecorrido() {
        return caminoRecorrido;
    }

    public void paint(Graphics g) {
        Graphics2D gg=(Graphics2D)g;
        gg.setColor(color.brighter());
        if (direccion == 1 || direccion == 3) {
            gg.fillRect(ubicacion.x, ubicacion.y, 40, 22);
            gg.setColor(Color.black);
            gg.fillRect(ubicacion.x + 5, ubicacion.y + 2, 5, 18);
            gg.fillRect(ubicacion.x + 14, ubicacion.y + 2, 10, 18);
            gg.fillRect(ubicacion.x + 27, ubicacion.y + 2, 5, 18);
        } else {
            gg.fillRect(ubicacion.x, ubicacion.y, 22, 40);
            gg.setColor(Color.black);
            gg.fillRect(ubicacion.x + 2, ubicacion.y + 5, 18, 5);
            gg.fillRect(ubicacion.x + 2, ubicacion.y + 14, 18, 10);
            gg.fillRect(ubicacion.x + 2, ubicacion.y + 27, 18, 5);
        }
        //gg.setColor(Color.black);
        //gg.drawString(ubicacion.x+","+ubicacion.y,ubicacion.x,ubicacion.y);
    }
    private boolean colision(vehiculo c) {
        boolean res = false;
        switch (c.direccion) {
            case 1:
                if (ubicacion.x + 44 == c.ubicacion.x &&ubicacion.y == c.ubicacion.y) {
                    res = true;
                }
                break;
            case 2:
                if (ubicacion.y + 44 == c.ubicacion.y && ubicacion.x == c.ubicacion.x) {
                    res = true;
                }
                break;
            case 3:
                if (ubicacion.x == c.ubicacion.x+44 && ubicacion.y == c.ubicacion.y) {
                    res = true;
                }
                break;
            case 4:
                if (ubicacion.y == c.ubicacion.y+44 && ubicacion.x == c.ubicacion.x) {
                    res = true;
                }
                break;
        }

        return res;
    }
    private boolean Limite() {
        boolean res = true;
        switch (direccion) {
            case 1:
                if (ubicacion.x > 900) {
                    res = false;
                }
                break;//DI
            case 2:
                if (ubicacion.y > 800) {
                    res = false;
                }
                break;//ArAb
            case 3:
                if (ubicacion.x < -100) {
                    res = false;
                }
                break;//ID
            case 4:
                if (ubicacion.y < -100) {
                    res = false;
                }
                break;//AbAr
        }
        return res;
    }

    private boolean ControlSemaforo(semaforo s) {
        boolean res=false;
        switch(direccion){
            case 1:
                if(ubicacion.x+44==s.punto.x && (s.rojo.equals(rojo) ||s.amarillo.equals(amarillo))  && pertenece(ubicacion.y,s.punto.y)){
                    res=true;
                }
                break;
            case 2:
                if(ubicacion.y+44==s.punto.y && s.rojo.equals(rojo) && pertenece(ubicacion.x,s.punto.x)){
                    res=true;
                }
                break;
            case 3:
                if(ubicacion.x==s.punto.x+16 && s.rojo.equals(rojo) && pertenece(ubicacion.y,s.punto.y)){
                    res=true;
                }
                break;
            case 4:
                if(ubicacion.y==s.punto.y+16 && s.rojo.equals(rojo) && pertenece(ubicacion.x,s.punto.x)){
                    res=true;
                }
                break;
        }
        return res;
    }

    private boolean pertenece(int a, int b) {
    boolean res=false;
    if(a>b-20 && a<b+80){
        res=true;
    }
    return res;
    }

    private void cambiarDireccion() {
        
        if(estaEsquina()){
            
        }
    }
    private boolean estaEsquina(){
        boolean res=false;
        vertice ve;ArrayList<vertice>relacion;
        for(int i=0;i<g.size();i++){
            ve=g.getAdyacente(i);
            if(ve.getPunto().x==ubicacion.x && ve.getPunto().y>ubicacion.y-40 && ve.getPunto().y<ubicacion.y+40){
                cambiarDireccionAutomatico(ve.Adyacente());
            } 
        }
        return res;
    }

    private void cambiarDireccionAutomatico(ArrayList<vertice> Adyacente) {
        int randon=r.nextInt(Adyacente.size());
        
    }
    
}
