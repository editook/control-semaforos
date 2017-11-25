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
import java.awt.Point;
import java.util.ArrayList;
import java.util.Random;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

/**
 *
 * @author ASUS
 */
public class panel extends JPanel {

    JFrame frame;
    JPanel pane;
    ArrayList<Esquina> listaEsquinas;//vertice entre P y J
    ArrayList<Calle> ListaCalles;//arista calama ejm
    static ArrayList<vehiculo> ListaVehiculos;
    static ArrayList<semaforo> ListaSemaforo;
    grafo g;
    ZonaVehicular zv;
    Random random = new Random();
    public panel(JFrame frame) {
        this.frame = frame;
        pane = this;
        pane.setBounds(200, -10, 800, 750);
        pane.setBackground(new Color(128, 128, 128));
        listaEsquinas = new ArrayList<>();
        ListaCalles = new ArrayList<>();
        ListaVehiculos = new ArrayList<>();
        ListaSemaforo = new ArrayList<>();
        
        cargarRegion();
        cargarSemaforos();
        zv = new ZonaVehicular();
        
        zv.start();
        
    }

    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        //Graphics2D gg=(Graphics2D)g;
        /*        for (int i = 0; i < listaEsquinas.size(); i++) {
        listaEsquinas.get(i).paint(g);
        }*/
        for (int i = 0; i < ListaCalles.size(); i++) {
            ListaCalles.get(i).paint(g);
        }
        for (int i = 0; i < ListaVehiculos.size(); i++) {
            ListaVehiculos.get(i).paint(g);
        }
        for (int i = 0; i < ListaSemaforo.size(); i++) {
            ListaSemaforo.get(i).paint(g);
        }
        this.repaint();
    }

    private void cargarRegion() {
        g = Zona.getMapa();
        ArrayList<vertice> relaciones;
        ArrayList<String> nombreCalles;
        for (int i = 0; i < g.tamano(); i++) {
            graficaEsquina(g.get(i));
            relaciones = g.get(i).Adyacente();
            nombreCalles = g.get(i).getRutas();
            for (int j = 0; j < relaciones.size(); j++) {
                graficarCalles(g.get(i).getPunto(), relaciones.get(j).getPunto(), nombreCalles.get(j));
            }
        }
    }

    private void graficaEsquina(vertice v) {
        listaEsquinas.add(new Esquina(v.getPunto()));
    }

    private void graficarCalles(Point puntoI, Point puntoF, String nombreC) {
        ListaCalles.add(new Calle(puntoI, puntoF, nombreC));
    }

    public static ArrayList<vehiculo> getListaVehiculos() {
        return ListaVehiculos;
    }

    public static ArrayList<semaforo> getListaSemaforos() {
        return ListaSemaforo;
    }

    private void cargarSemaforos() {
        ListaSemaforo.add(new semaforo(new Point(450, 460), 1));
        ListaSemaforo.add(new semaforo(new Point(460, 450), 2));

        ListaSemaforo.add(new semaforo(new Point(450, 660), 1));
        ListaSemaforo.add(new semaforo(new Point(460, 650), 2));

        ListaSemaforo.add(new semaforo(new Point(50, 660), 1));
        ListaSemaforo.add(new semaforo(new Point(60, 650), 2));

        ListaSemaforo.add(new semaforo(new Point(50, 460), 1));
        ListaSemaforo.add(new semaforo(new Point(60, 450), 2));

        ListaSemaforo.add(new semaforo(new Point(50, 60), 1));
        ListaSemaforo.add(new semaforo(new Point(60, 50), 2));

        ListaSemaforo.add(new semaforo(new Point(450, 60), 1));
        ListaSemaforo.add(new semaforo(new Point(460, 50), 2));
        //---------------------------------------------------
        ListaSemaforo.add(new semaforo(new Point(250, 60), 1));
        ListaSemaforo.add(new semaforo(new Point(260, 110), 4));
        ListaSemaforo.add(new semaforo(new Point(650, 60), 1));
        ListaSemaforo.add(new semaforo(new Point(660, 110), 4));
        //ListaSemaforo.add(new semaforo(new Point(312, 258), 3));//v
        //ListaSemaforo.add(new semaforo(new Point(258, 312), 4));//h

        ListaSemaforo.add(new semaforo(new Point(512, 258), 3));//v
        ListaSemaforo.add(new semaforo(new Point(458, 258), 2));//h

        ListaSemaforo.add(new semaforo(new Point(250, 460), 1));
        ListaSemaforo.add(new semaforo(new Point(260, 510), 4));

        ListaSemaforo.add(new semaforo(new Point(250, 658), 1));//v
        ListaSemaforo.add(new semaforo(new Point(258, 705), 4));//h

        //ListaSemaforo.add(new semaforo(new Point(110, 260), 3));
        //ListaSemaforo.add(new semaforo(new Point(60, 250), 2));

        ListaSemaforo.add(new semaforo(new Point(712, 260), 3));
        ListaSemaforo.add(new semaforo(new Point(658, 312), 4));

        ListaSemaforo.add(new semaforo(new Point(656, 460), 1));
        ListaSemaforo.add(new semaforo(new Point(658, 512), 4));

        ListaSemaforo.add(new semaforo(new Point(652, 658), 1));//v
        ListaSemaforo.add(new semaforo(new Point(658, 705), 4));//h
    }

    public class ZonaVehicular extends Thread {

        public int FlujoZona = 1000;
        int separadorTiempo;

        public ZonaVehicular() {
            separadorTiempo = random.nextInt(1000);
        }

        @Override
        public void run() {
            while (true) {
                try {
                    eliminaVehiculosRecorrido();
                    agregarVehiculos();
                    Thread.sleep(FlujoZona + random.nextInt(500));
                } catch (InterruptedException ex) {

                }
            }
        }

        private void eliminaVehiculosRecorrido() {
            for (int i = 0; i < ListaVehiculos.size(); i++) {
                if (ListaVehiculos.get(i).CaminoRecorrido()) {
                    ListaVehiculos.remove(i);
                }
            }
        }

        private void agregarVehiculos() {

            if (ListaVehiculos.size() < 30) {
                ListaVehiculos.add(getVehiculo());
            }

        }

        private vehiculo getVehiculo() {
            vehiculo nuevo;
            Point puntoPosicionV = null;
            Point movimiento = null;
            int direccion = random.nextInt(10);//1 ID-orizontal, 2ArAb-vertical,3 DI orzontal,4 AbAr vertical
            switch (direccion) {
                case 1:
                    puntoPosicionV = new Point(-20, getUno(465, 495));
                    movimiento = new Point(1, 0);
                    break;//colombia-->
                case 2:
                    puntoPosicionV = new Point(getUno(462, 492), -20);
                    movimiento = new Point(0, 1);
                    break;//25 de mayo
                case 3:
                    puntoPosicionV = new Point(getUno(663, 693), 720);
                    movimiento = new Point(0, -1);
                    break;//san martin
                case 4:
                    puntoPosicionV = new Point(820, getUno(265, 295));
                    movimiento = new Point(-1, 0);
                    break; //ecuador<--
                case 5:
                    puntoPosicionV = new Point(getUno(65, 95), -20);
                    movimiento = new Point(0, 1);
                    break; //marianoV
                case 6:
                    puntoPosicionV = new Point(getUno(265, 295), 720);
                    movimiento = new Point(0, -1);
                    break; //españa
                case 7:
                    puntoPosicionV = new Point(-20, getUno(65, 95));
                    movimiento = new Point(1, 0);
                    break; //mayor rocha
                default:
                    puntoPosicionV = new Point(-20, getUno(665, 695));
                    movimiento = new Point(1, 0);
                    break; //heroinas
            }
            nuevo = new vehiculo(movimiento, puntoPosicionV, random.nextInt(3));
            return nuevo;
        }

        private int getUno(int a, int b) {
            int r = random.nextInt(3);
            if (r == 2) {
                return a;
            } else {
                return b;
            }
        }
    }
}
