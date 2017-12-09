/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package control;

import graficos.panel;
import java.awt.Point;
import java.util.HashMap;
import java.util.Random;

/**
 *
 * @author ASUS
 */
public class Zona {

    static Random random = new Random();

    public static grafo getMapa() {
        grafo gr = new grafo();

        vertice a = new vertice("a", new Point(50, 50));
        vertice b = new vertice("b", new Point(250, 50));
        vertice c = new vertice("c", new Point(450, 50));
        vertice d = new vertice("d", new Point(650, 50));

        vertice e = new vertice("e", new Point(50, 250));
        vertice f = new vertice("f", new Point(250, 250));
        vertice g = new vertice("g", new Point(450, 250));
        vertice h = new vertice("h", new Point(650, 250));

        vertice i = new vertice("i", new Point(50, 450));
        vertice j = new vertice("j", new Point(250, 450));
        vertice k = new vertice("k", new Point(450, 450));
        vertice l = new vertice("l", new Point(650, 450));

        vertice m = new vertice("m", new Point(50, 650));
        vertice n = new vertice("n", new Point(250, 650));
        vertice o = new vertice("o", new Point(450, 650));
        vertice p = new vertice("p", new Point(650, 650));

        vertice bb = new vertice("bb", new Point(50, -10));//bb
        vertice aa = new vertice("aa", new Point(-10, 50));//aa
        vertice ff = new vertice("ff", new Point(730, 50));//ff
        vertice ee = new vertice("ee", new Point(650, -10));//ee

        vertice kk = new vertice("kk", new Point(-10, 650));//kk
        vertice cc = new vertice("cc", new Point(250, -10));//cc
        vertice dd = new vertice("dd", new Point(450, -10));//dd
        vertice ii = new vertice("ii", new Point(-10, 250));//ii
        vertice jj = new vertice("jj", new Point(-10, 450));//jj
        vertice gg = new vertice("gg", new Point(730, 250));//gg
        vertice hh = new vertice("hh", new Point(730, 450));//hh
        vertice ll = new vertice("ll", new Point(730, 650));//ll

        a.relacion(b, "mexico");
        a.relacion(e, "");
        aa.relacion(a, "mexico");
        bb.relacion(a, "");
        b.relacion(cc, "");
        b.relacion(c, "mexico");
        c.relacion(g, "");
        c.relacion(d, "mexico");
        dd.relacion(c, "");
        d.relacion(ee, "sanMartin");
        d.relacion(ff, "mexico");
        e.relacion(ii, "");
        e.relacion(i, "MaBatist");
        jj.relacion(i, "");
        i.relacion(m, "");
        i.relacion(j, "");
        kk.relacion(m, "heroinas");
        m.relacion(n, "heroinas");
        n.relacion(j, "");
        n.relacion(o, "heroinas");
        j.relacion(f, "");
        f.relacion(b, "españa");
        o.relacion(p, "heroinas");
        p.relacion(l, "sanMartin");
        p.relacion(ll, "heroinas");
        k.relacion(l, "colombia");
        k.relacion(o, "");
        l.relacion(hh, "");
        l.relacion(h, "sanMartin");
        j.relacion(k, "");
        g.relacion(f, "ecuador");
        g.relacion(k, "");
        h.relacion(g, "");
        h.relacion(d, "sanMartin");
        gg.relacion(h, "");
        gr.add(a);
        gr.add(b);
        gr.add(c);
        gr.add(d);
        gr.add(e);
        gr.add(f);
        gr.add(g);
        gr.add(h);
        gr.add(i);
        gr.add(j);
        gr.add(k);
        gr.add(l);
        gr.add(m);
        gr.add(n);
        gr.add(o);
        gr.add(p);
        gr.add(aa);
        gr.add(bb);
        gr.add(cc);
        gr.add(dd);
        gr.add(ee);
        gr.add(ff);
        gr.add(gg);
        gr.add(hh);
        gr.add(ii);
        gr.add(jj);
        gr.add(kk);
        gr.add(ll);
        return gr;
    }

    public static Point getPuntoDirecciona(Point p, String nombreCalle) {
        grafo g=panel.getGrafo();
        Point pu = new Point();
        int aux=0;
        //getUno(462, 492)   2  x
        //getUno(663, 693)   3  x
        //getUno(65, 95),    5  x
        //getUno(265, 295)   6  x
        int rango=20;
        if(aux==0){
        if ((p.x > 462 - rango && p.x < 462 + rango) || (p.x > 492 - rango && p.x < 492 + rango)) {
            pu.x = getUno(462,492);
            pu.y = p.y;
            aux=1;
           
        } else {
            if ((p.x >663 - rango && p.x <= 663 + rango) || (p.x > 693 - rango && p.x < 693 + rango)) {
                pu.x = getUno(663, 693);
                pu.y = p.y;
                aux=1;
            } else {
                if ((p.x > 65 - rango && p.x <65 + rango) || (p.x >95 - rango && p.x < 95 + rango)) {
                    pu.x = getUno(65, 95);
                    pu.y = p.y;
                    aux=1;
                } else {

                    if ((p.x > 265 - rango && p.x < 265 + rango) || (p.x > 295 - rango && p.x < 295 + rango)) {
                        pu.x = getUno(265, 295);
                        pu.y = p.y;
                        aux=1;
                    }
                }
            }
        }
        }
        if(aux==0){
        
        if ((p.y > 465 - rango && p.y < 465 + rango) || (p.y >495 - rango && p.y <495 + rango)) {
            pu.y = 465;
            pu.x = p.x;
        } else {
            if ((p.y > 265 - 10 && p.y < 265 + rango) || (p.y > 295 - rango && p.y < 295 + rango)) {
                pu.y = 295;
                pu.x = p.x;
            } else {

                if ((p.y > 65 - rango && p.y < 65 + rango) || (p.y > 95 - rango && p.y < 95 + rango)) {
                    pu.y = 95;
                    pu.x = p.x;
                } else {

                    if ((p.y > 665 - rango && p.y < 665 + rango) || (p.y > 695 - rango && p.y < 695 + rango)) {
                        pu.y = 695;
                        pu.x = p.x;
                    }
                }
            }
        }
        }

        //getUno(465, 495)  1  y
        //getUno(265, 295)   4  y
        //getUno(65, 95)     7  y
        //getUno(665, 695)   8  y
        return pu;
    }

    private static int getUno(int a, int b) {

        int r = random.nextInt(3);
        if (r == 2) {
            return a;
        } else {
            return b;
        }
    }
}
