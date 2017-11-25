/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package control;

import java.awt.Point;

/**
 *
 * @author ASUS
 */
public class Zona {
    public static grafo getMapa(){
        grafo gr = new grafo();

        vertice a=new vertice("a",new Point(50,50));
        vertice b=new vertice("b",new Point(250,50));
        vertice c=new vertice("c",new Point(450,50));
        vertice d=new vertice("d",new Point(650,50));
        
        vertice e=new vertice("e",new Point(50,250));
        vertice f=new vertice("f",new Point(250,250));
        vertice g=new vertice("g",new Point(450,250));
        vertice h=new vertice("h",new Point(650,250));
        
        vertice i=new vertice("i",new Point(50,450));
        vertice j=new vertice("j",new Point(250,450));
        vertice k=new vertice("k",new Point(450,450));
        vertice l=new vertice("l",new Point(650,450));
        
        vertice m=new vertice("m",new Point(50,650));
        vertice n=new vertice("n",new Point(250,650));
        vertice o=new vertice("o",new Point(450,650));
        vertice p=new vertice("p",new Point(650,650));
        //vertical
        vertice r=new vertice("r",new Point(50,250));
        vertice s=new vertice("s",new Point(50,450));
        vertice t=new vertice("t",new Point(50,650));
        
        vertice u=new vertice("u",new Point(250,250));
        vertice v=new vertice("v",new Point(250,450));
        vertice w=new vertice("w",new Point(250,650));
        
        vertice x=new vertice("x",new Point(450,250));
        vertice y=new vertice("y",new Point(450,450));
        vertice z=new vertice("z",new Point(450,650));
        
        vertice aa=new vertice("aa",new Point(650,250));
        vertice bb=new vertice("bb",new Point(650,450));
        vertice cc=new vertice("cc",new Point(650,650));
        //auxiliares
        vertice aux1=new vertice("aux1",new Point(50,-10));
        vertice aux2=new vertice("aux2",new Point(-10,50));
        vertice aux3=new vertice("aux3",new Point(730,50));
        vertice aux4=new vertice("aux4",new Point(650,-10));
        vertice aux5=new vertice("aux5",new Point(-10,650));//abajo
        vertice aux6=new vertice("aux6",new Point(250,-10));//arriba 2
        vertice aux7=new vertice("aux7",new Point(450,-10));//arriba 3
        vertice aux8=new vertice("aux8",new Point(-10,250));//iz 2
        vertice aux9=new vertice("aux9",new Point(-10,450));//iz 3
        vertice aux10=new vertice("aux10",new Point(730,250));//der 2
        vertice aux11=new vertice("aux11",new Point(730,450));//der 3
        vertice aux12=new vertice("aux12",new Point(730,650));//der 4
        
        a.relacion(b,"mayor rocha");
        b.relacion(c,"mayor rocha");
        c.relacion(d,"mayor rocha");
        
        e.relacion(f,"ecuador");
        f.relacion(g,"ecuador");
        g.relacion(h,"ecuador");
        
        i.relacion(j,"colombia");
        j.relacion(k,"colombia");
        k.relacion(l,"colombia");
        
        m.relacion(n,"heroinas");
        n.relacion(o,"heroinas");
        o.relacion(p,"heroinas");
        //vertical
        a.relacion(r,"marianoV");
        r.relacion(s,"marianoV");
        s.relacion(t,"marianoV");
        
        b.relacion(u,"españa");
        u.relacion(v,"españa");
        v.relacion(w,"españa");
        
        c.relacion(x,"25 mayo");
        x.relacion(y,"25 mayo");
        y.relacion(z,"25 mayo");
        
        d.relacion(aa,"san martin");
        aa.relacion(bb,"san martin");
        bb.relacion(cc,"san martin");
        //auxiliares
        a.relacion(aux1,"");
        a.relacion(aux2,"");
        d.relacion(aux3,"");
        d.relacion(aux4,"");
        t.relacion(aux5,"");
        b.relacion(aux6,"");
        c.relacion(aux7,"");
        r.relacion(aux8,"");
        s.relacion(aux9,"");
        x.relacion(aux10,"");
        y.relacion(aux11,"");
        z.relacion(aux12, "");
        gr.add(a);gr.add(b);gr.add(c);gr.add(d);gr.add(e);
        gr.add(f);gr.add(g);gr.add(h);gr.add(i);gr.add(j);
        gr.add(k);gr.add(l);gr.add(m);gr.add(n);gr.add(o);
        gr.add(p);gr.add(r);gr.add(s);gr.add(t);gr.add(u);
        gr.add(v);gr.add(w);gr.add(x);gr.add(y);gr.add(z);
        gr.add(aa);gr.add(bb);gr.add(cc);
        gr.add(aux1);gr.add(aux2);gr.add(aux3);gr.add(aux4);gr.add(aux5);
        gr.add(aux6);gr.add(aux7);gr.add(aux8);gr.add(aux9);gr.add(aux10);
        return gr;
    }
}
