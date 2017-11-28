/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package control;

import java.awt.Point;
import java.util.HashMap;

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
        
        vertice bb=new vertice("bb",new Point(50,-10));//bb
        vertice aa=new vertice("aa",new Point(-10,50));//aa
        vertice ff=new vertice("ff",new Point(730,50));//ff
        vertice ee=new vertice("ee",new Point(650,-10));//ee
        
        vertice kk=new vertice("kk",new Point(-10,650));//kk
        vertice cc=new vertice("cc",new Point(250,-10));//cc
        vertice dd=new vertice("dd",new Point(450,-10));//dd
        vertice ii=new vertice("ii",new Point(-10,250));//ii
        vertice jj=new vertice("jj",new Point(-10,450));//jj
        vertice gg=new vertice("gg",new Point(730,250));//gg
        vertice hh=new vertice("hh",new Point(730,450));//hh
        vertice ll=new vertice("ll",new Point(730,650));//ll
        
        a.relacion(b,"mexico");
        a.relacion(e,"");
        aa.relacion(a,"mexico");
        bb.relacion(a,"");
        b.relacion(cc,"");
        b.relacion(c,"mexico");
        c.relacion(g,"");
        c.relacion(d,"mexico");
        dd.relacion(c,"");
        d.relacion(ee,"sanMartin");
        d.relacion(ff,"mexico");
        e.relacion(ii,"");
        e.relacion(i,"MaBatist");
        jj.relacion(i,"");
        i.relacion(m,"");
        i.relacion(j,"");
        kk.relacion(m,"heroinas");
        m.relacion(n,"heroinas");
        n.relacion(j,"");
        n.relacion(o,"heroinas");
        j.relacion(f,"");
        f.relacion(b,"españa");
        o.relacion(p,"heroinas");
        p.relacion(l,"sanMartin");
        p.relacion(ll,"heroinas");
        k.relacion(l,"colombia");
        k.relacion(o,"");
        l.relacion(hh,"");
        l.relacion(h,"sanMartin");
        j.relacion(k,"");
        g.relacion(f,"ecuador");
        g.relacion(k,"");
        h.relacion(g,"");
        h.relacion(d,"sanMartin");
        gg.relacion(h,"");
        gr.add(a);gr.add(b);gr.add(c);gr.add(d);gr.add(e);
        gr.add(f);gr.add(g);gr.add(h);gr.add(i);gr.add(j);
        gr.add(k);gr.add(l);gr.add(m);gr.add(n);gr.add(o);
        gr.add(p);
        gr.add(aa);gr.add(bb);gr.add(cc);
        gr.add(dd);gr.add(ee);gr.add(ff);gr.add(gg);gr.add(hh);
        gr.add(ii);gr.add(jj);gr.add(kk);gr.add(ll);
        return gr;
    }
    public static Point getPuntoDireccional(Point p){
        HashMap<String,Point>map=new HashMap<>();
        //map.put(key, p);
        return map.get(p);
    }
}
