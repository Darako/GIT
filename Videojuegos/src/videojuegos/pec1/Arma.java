/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package videojuegos.pec1;

/**
 *
 * @author Jorge
 */
public class Arma {
    //ATRIBUTOS
    private String nombre;        
    private int danyo;
    
    //CONSTRUCTOR
    public Arma(String nombre, int danyo) {
        this.nombre = nombre;
        this.danyo = danyo;
    }   

    //GETTER & SETTER
    public int getDanyo() {
        return danyo;
    }
    public void setDanyo(int danyo) {
        this.danyo = danyo;
    }
    public String getNombre() {
        return nombre;
    }
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    //METODOS
    public boolean estaDisponible(){
        return this.estaDisponible();
    }
    
    public void usar(){
        this.usar();
    }    
    
    @Override
    public String toString() {
        return "\nArma: "+nombre+"\nDaño: "+danyo;
    }    
    
}
