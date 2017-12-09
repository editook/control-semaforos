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
    public  void quitarRelacion(String ini,String  fin){
        for (int i = 0; i <this.size(); i++) {
            if(ini.equals(this.get(i).nombre)){
                ArrayList<vertice>relaciones=this.get(i).Adyacente();
                for (int j = 0; j < relaciones.size(); j++) {
                        if(fin.equals(relaciones.get(j).nombre)){
                            //mostrar();
                            System.err.println("encontrado");
                            this.get(i).quitar(j);
                            j=i=this.size();
                            //mostrar();
                        }
                }
                i=this.size();
                System.err.println("sin relaciones");
            }
        }
        //System.err.println("creo que no hay");
    }
    public void mostrar(){
        for (int i = 0; i < this.size(); i++) {
            ArrayList<vertice> v=this.get(i).Adyacente();
            System.err.print("-"+this.getAdyacente(i).nombre+"->");
            for (int j = 0; j <v.size(); j++) {
                System.err.print(v.get(j).nombre+" ");
            }
            System.err.println("");
        }
        System.err.println("----------------");
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
    public ArrayList<vertice>getRelaciones(vertice v){
        for (int i = 0; i < this.size(); i++) {
            if(this.get(i).nombre.equals(v.nombre)){
            return this.get(i).Adyacente();
            }
        }
        return v.Adyacente();
    }
    public vertice getAdyacente(int pos){
        return this.get(pos);
    }
    public int posicion(vertice nodo) {
        return this.indexOf(nodo);
    }
}
