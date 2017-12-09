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
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Point;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.Random;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;
import javax.swing.DefaultComboBoxModel;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
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
    static ArrayList<trabajando> bloqueos;
    static grafo g;
    ZonaVehicular zv;
    Random random = new Random();
    JPanel componentes;
    JLabel tiempo;
    JButton bloquear;
    JLabel titulo;
    Reloj r;
    String nombreCalleX;
    String verticalOrizontalX;
    boolean habilitarClick = false;
    JComboBox<String> selectorVO, selectorCalle;
    JLabel bloqueoVertical;
    int x = 0;
    int y = 100;
    int cantidadTrafico;
    static int estadoVisibleNodos;
    public panel(JFrame frame) {
        this.frame = frame;
        pane = this;
        cantidadTrafico=15;
        estadoVisibleNodos=0;
        componentes = new JPanel();
        componentes.setLocale(null);
        componentes.setBounds(1000, 0, 400, 750);
        componentes.setLayout(null);
        componentes.setBackground(Color.white);
        agregarComponentes();
        frame.getContentPane().add(componentes);
        pane.setLocale(null);
        pane.setLayout(null);
        pane.setBounds(200, -10, 800, 800);
        pane.setBackground(new Color(128, 128, 128));
        pane.addMouseListener(new java.awt.event.MouseAdapter() {
            @Override
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                if (habilitarClick) {
                    habilitarClick = false;
                    pane.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
                }
            }
        });
        pane.addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {
            @Override
            public void mouseMoved(java.awt.event.MouseEvent evt) {
                if (habilitarClick) {
                    bloqueoVertical.setLocation(evt.getPoint());
                } else {
                    //bloqueoVertical.setLocation(-1,-100);
                }

            }
        });
        listaEsquinas = new ArrayList<>();
        ListaCalles = new ArrayList<>();
        ListaVehiculos = new ArrayList<>();
        ListaSemaforo = new ArrayList<>();
        bloqueos = new ArrayList<>();
        cargarRegion();
        cargarSemaforos();
        r = new Reloj();
        zv = new ZonaVehicular();
        r.start();
        zv.start();

        //mostrarGrafo();
    }

    public void dibujar(JLabel ima, String tipo) {
        URL url;
        url = getClass().getResource("/graficos/images/" + tipo + ".png");
        ImageIcon imagen = new ImageIcon(url);
        Icon icono = new ImageIcon(imagen.getImage().getScaledInstance(ima.getWidth(), ima.getHeight(), Image.SCALE_DEFAULT));
        ima.setIcon(icono);
        ima.repaint();
    }

    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        //Graphics2D gg=(Graphics2D)g;
        for (int i = 0; i < listaEsquinas.size(); i++) {
            listaEsquinas.get(i).paint(g);
        }
        for (int i = 0; i < ListaCalles.size(); i++) {
            ListaCalles.get(i).paint(g);
        }
        for (int i = 0; i < ListaVehiculos.size(); i++) {
            ListaVehiculos.get(i).paint(g);
        }
        for (int i = 0; i < ListaSemaforo.size(); i++) {
            ListaSemaforo.get(i).paint(g);
        }
        for (int i = 0; i < bloqueos.size(); i++) {
            bloqueos.get(i).paint(g);
        }
        this.repaint();
    }

    private void cargarRegion() {
        g = Zona.getMapa();
        ArrayList<vertice> relaciones;
        ArrayList<String> nombreCalles;
        for (int i = 0; i < g.tamano(); i++) {
            //graficaEsquina(g.get(i));
            relaciones = g.get(i).Adyacente();
            nombreCalles = g.get(i).getRutas();
            for (int j = 0; j < relaciones.size(); j++) {
                graficarCalles(g.get(i), relaciones.get(j), nombreCalles.get(j));
            }
            
        }
    }

    private void graficaEsquina(vertice v) {
        listaEsquinas.add(new Esquina(v.getPunto(), v.nombre));
    }

    private void graficarCalles(vertice puntoI, vertice puntoF, String nombreC) {
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

    private void agregarComponentes() {
        titulo = new JLabel("Control de Semaforos");
        titulo.setFont(new java.awt.Font("Kristen ITC", 1, 24)); // NOI18N
        titulo.setBounds(50, 20, 300, 50);
        componentes.add(titulo);
        bloquear = new JButton("Bloquear Via");
        bloquear.setFont(new java.awt.Font("Kristen ITC", 1, 24));
        bloquear.setBackground(Color.cyan);
        bloquear.setBounds(30, 200, 300, 150);
        bloquear.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                bloqueoVertical = new JLabel();
                String VO = selectorVO.getSelectedItem().toString();
                String NombreCalle = selectorCalle.getSelectedItem().toString();
                System.out.println(VO + " " + NombreCalle);
                pane.setCursor(new java.awt.Cursor(java.awt.Cursor.CROSSHAIR_CURSOR));
                
                
                bloqueoVertical.setBounds(x, y, 120, 93);
                dibujar(bloqueoVertical, "trabajando");
                bloqueos.add(new trabajando(new Point(x, y)));
                pane.add(bloqueoVertical);
                bloqueaCamino(VO.toLowerCase(),NombreCalle.toLowerCase());
                habilitarClick = true;
                estadoVisibleNodos=0;
            }
        });
        componentes.add(bloquear);

        tiempo = new JLabel();
        tiempo.setFont(new java.awt.Font("Kristen ITC", 1, 26));
        tiempo.setBackground(Color.white);
        tiempo.setBounds(100, 50, 200, 200);
        componentes.add(tiempo);

        selectorVO = new JComboBox<>();
        selectorVO.setBounds(30, 350, 150, 50);
        selectorVO.setBackground(Color.green);
        selectorVO.setFont(new java.awt.Font("Kristen ITC", 1, 20));
        selectorVO.setModel(new javax.swing.DefaultComboBoxModel<>(new String[]{"A","B","C","D","E","F","G","H","I","J","K","L","M","O","P"}));
        selectorVO.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                estadoVisibleNodos=1;
            }
        });
            
        componentes.add(selectorVO);

        selectorCalle = new JComboBox<>();
        selectorCalle.setBounds(181, 350, 150, 50);
        selectorCalle.setBackground(Color.orange);
        selectorCalle.setFont(new Font("Kristen ITC", 1, 20));
        selectorCalle.setModel(new DefaultComboBoxModel<>(new String[]{"A","B","C","D","E","F","G","H","I","J","K","L","M","O","P"}));
        selectorCalle.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                estadoVisibleNodos=1;
            }
        });
        componentes.add(selectorCalle);
    }
    private void bloqueaCamino(String x, String y){
        g.mostrar();
        g.quitarRelacion(x, y);
        g.mostrar();
    }
    public static grafo getGrafo(){
        return g;
    }
    public class ZonaVehicular extends Thread {

        public int FlujoZona = 1500;
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
                    ListaVehiculos.get(i).stop();
                    ListaVehiculos.remove(i);
                }
            }
        }

        private void agregarVehiculos() {
            if (ListaVehiculos.size() < cantidadTrafico) {
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
                    puntoPosicionV = new Point(-44, getUno(465, 495));
                    movimiento = new Point(1, 0);
                    break;//colombia-->
                case 2:
                    puntoPosicionV = new Point(getUno(462, 492), -44);
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
                    puntoPosicionV = new Point(getUno(65, 95), -44);
                    movimiento = new Point(0, 1);
                    break; //marianoV
                case 6:
                    puntoPosicionV = new Point(getUno(265, 295), 720);
                    movimiento = new Point(0, -1);
                    break; //españa
                case 7:
                    puntoPosicionV = new Point(-44, getUno(65, 95));
                    movimiento = new Point(1, 0);
                    break; //mayor rocha
                default:
                    puntoPosicionV = new Point(-44, getUno(665, 695));
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

    public class Reloj extends Thread {

        int hora, min, segundo;
        String h, m, s;

        public Reloj() {
            hora = 0;
            min = 0;
            segundo = 0;
        }

        @Override
        public void run() {
            while (true) {
                cambiar();
                try {
                    Thread.sleep(10);
                } catch (InterruptedException ex) {

                }
                tiempo.setText(h + ":" + m + ":" + s);
            }
        }

        private void cambiar() {
            if (hora < 24) {
                if (min < 60) {
                    if (segundo < 60) {
                        segundo++;
                    } else {
                        segundo = 0;
                        min++;
                    }
                } else {
                    min = 0;
                    hora++;
                    segundo = 0;
                }
            } else {
                hora = 0;
                min = 0;
                segundo = 0;
            }
            h = "" + hora;
            m = "" + min;
            s = "" + segundo;
            if (hora <= 9) {
                h = "0" + hora;
            }
            if (min <= 9) {
                m = "0" + min;
            }
            if (segundo <= 9) {
                s = "0" + segundo;
            }
            //zona horaria para aumentar y decrementar vehiculos
            if(hora==3){
                cantidadTrafico=30;
            }
            else{
                cantidadTrafico=15;
            }
        }
    }
    
}
