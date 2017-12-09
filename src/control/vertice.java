/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package control;
import java.awt.Point;
import java.util.ArrayList;

/**
 *
 * @author ASUS
 */
public class vertice {
    public String nombre;
    ArrayList<vertice>relacion;
    ArrayList<String>rutas;
    Point punto;
    public vertice(String nombre,Point punto){
        this.nombre=nombre;
        relacion=new ArrayList<>();
        rutas=new ArrayList<>();
        this.punto=punto;
    }
    public String getRelacion(){
        String salida="";
        for (int i = 0; i < relacion.size(); i++) {
            salida+=","+relacion.get(i).nombre;
        }
        return salida;
    }
    public void relacion(vertice v,String nombreCalle){
        relacion.add(v);
        rutas.add(nombreCalle);
    }
    public void quitar(int pos){
        relacion.remove(pos);
        rutas.remove(pos);
        System.err.println("se quito correctemente");
    }
    public ArrayList<String> getRutas(){
    return rutas;
    }
    public String getNombreRuta(int pos){
    return rutas.get(pos);
    }
    public ArrayList<vertice> Adyacente(){
        return relacion;
    }
    public Point getPunto(){
    return punto;
    }
}
