/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package graficos;

import java.awt.Color;
import java.awt.Graphics;
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
        this.start();
    }

    @Override
    public void run() {
        while (Limite()) {
            try {
                moverse();
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
        
        if (direccion == 1) {
            for (int i = 0; i < vehiculos.size(); i++) {
                if (puedeTransitar(vehiculos.get(i))) {
                    resVehiculo = true;
                    break;
                }
            }
            for (int i = 0; i < semaforos.size(); i++) {
                if (Semaforo(semaforos.get(i))) {
                    resSemaforo = true;
                    break;
                }
            }

        }
        if (direccion == 2) {
            for (int i = 0; i < vehiculos.size(); i++) {
                if (puedeTransitar(vehiculos.get(i))) {
                    resVehiculo = true;
                    break;
                }
            }
            for (int i = 0; i < semaforos.size(); i++) {
                if (Semaforo(semaforos.get(i))) {
                    resSemaforo = true;
                    break;
                }
            }
        }
        if (direccion == 3) {
            for (int i = 0; i < vehiculos.size(); i++) {
                if (puedeTransitar(vehiculos.get(i))) {
                    resVehiculo = true;
                    break;
                }
            }
            for (int i = 0; i < semaforos.size(); i++) {
                if (Semaforo(semaforos.get(i))) {
                    resSemaforo = true;
                    break;
                }
            }
        }
        if (direccion == 4) {
            for (int i = 0; i < vehiculos.size(); i++) {
                if (puedeTransitar(vehiculos.get(i))) {
                    resVehiculo = true;
                    break;
                }
            }
            for (int i = 0; i < semaforos.size(); i++) {
                if (Semaforo(semaforos.get(i))) {
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

    public void paint(Graphics g) {
        g.setColor(color.brighter());
        if (direccion == 1 || direccion == 3) {
            g.fillRect(ubicacion.x, ubicacion.y, 40, 22);
            g.setColor(Color.black);
            g.fillRect(ubicacion.x + 5, ubicacion.y + 2, 5, 18);
            g.fillRect(ubicacion.x + 14, ubicacion.y + 2, 10, 18);
            g.fillRect(ubicacion.x + 27, ubicacion.y + 2, 5, 18);
        } else {
            g.fillRect(ubicacion.x, ubicacion.y, 22, 40);
            g.setColor(Color.black);
            g.fillRect(ubicacion.x + 2, ubicacion.y + 5, 18, 5);
            g.fillRect(ubicacion.x + 2, ubicacion.y + 14, 18, 10);
            g.fillRect(ubicacion.x + 2, ubicacion.y + 27, 18, 5);
        }
    }

    public boolean CaminoRecorrido() {
        return caminoRecorrido;
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

    private boolean puedeTransitar(vehiculo c) {
        boolean res = false;//no colision
        vehiculo coche = c;
        //vehiculos.get(i).ubicacion.x == this.ubicacion.x + 42 && vehiculos.get(i).ubicacion.y == this.ubicacion.y
        switch (direccion) {
            case 1:
                switch (coche.direccion) {
                    case 1:
                        if (this.ubicacion.x + 42 == coche.ubicacion.x && this.ubicacion.y == coche.ubicacion.y) {
                            res = true;
                        }
                }
                break;
            case 2:
                switch (coche.direccion) {
                    case 2:
                        if (this.ubicacion.y == coche.ubicacion.y - 42 && this.ubicacion.x == coche.ubicacion.x) {
                            res = true;
                        }
                }
                break;
            case 3:
                switch (coche.direccion) {
                    case 3:
                        if (this.ubicacion.x == coche.ubicacion.x + 42 && this.ubicacion.y == coche.ubicacion.y) {
                            res = true;
                        }
                }
                break;
            case 4:
                switch (coche.direccion) {
                    case 4:
                        if (this.ubicacion.y == coche.ubicacion.y - 42 && this.ubicacion.x == coche.ubicacion.x) {
                            res = true;
                        }
                }
                break;
        }

        return res;
    }
    //semaforos.get(i).punto.x == this.ubicacion.x + 42 && semaforos.get(i).rojo.equals(rojo)
    //                    && semaforos.get(i).config == this.direccion
    private boolean Semaforo(semaforo semaforo) {
        boolean res=false;
        switch(this.direccion){
            case 1:
                if(this.ubicacion.x+42==semaforo.punto.x 
                        && semaforo.rojo.equals(rojo)&& semaforo.config == this.direccion){
                    res=true;
                }
                break;
            case 2:
                if(this.ubicacion.y+42==semaforo.punto.y  
                        && semaforo.rojo.equals(rojo) && semaforo.config == this.direccion){
                    res=true;
                }
                break;
            case 3:
                if(this.ubicacion.x==semaforo.punto.x+2 
                        && semaforo.rojo.equals(rojo)&& semaforo.config == this.direccion){
                    res=true;
                }
                break;
            case 4:
                if(this.ubicacion.y==semaforo.punto.y+2
                        && semaforo.rojo.equals(rojo)&& semaforo.config == this.direccion){
                    res=true;
                }
                break;
        }
        return res;
    }

    private boolean pertenescaRango(int p, int este) {
        boolean res=false;
        if(este >p+25 && este<p-25){
            res=true;
        }
        return res;
    }
}
