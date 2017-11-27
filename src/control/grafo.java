/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package control;
import java.util.ArrayList;

/**
 *
 * @author ASUS
 */
public class grafo extends ArrayList<vertice> {

    public grafo() {
    }
    public void anadirNodo(vertice v) {
        this.add(v);
    }

    public int tamano() {
        return this.size();
    }
    public vertice getVertice(String nombre){
        vertice n=null;
        for (vertice aThi : this) {
            if (aThi.nombre.equals(nombre)) {
                n = aThi;
            }
        }
        return n;
    }
    public vertice getAdyacente(int pos){
        return this.get(pos);
    }
    public int posicion(vertice nodo) {
        return this.indexOf(nodo);
    }
}
