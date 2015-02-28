/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package videojuegos.pec1.armas;

/**
 *
 * @author Jorge
 */
public class Arco extends Arma{
    
    //ATRIBUTOS
    private int flechas;

    //CONSTRUCTOR
    public Arco(String nombre, int durabilidad, int ataqueFisico, int ataqueMagico, int flechas) {
        super(nombre, durabilidad, ataqueFisico, ataqueMagico);
        this.flechas = flechas;
    }  
    
    //GETTER & SETTER
    public int getFlechas() {
        return flechas;
    }
    public void setFlechas(int flechas) {
        this.flechas = flechas;
    }

    //METODOS
    @Override
    public void usar(){
        this.flechas--;
    }
    
    @Override
    public boolean estaDisponible(){
        int restante = this.flechas;
        return restante != 0;
    }

    @Override
    public String toString() {
        return "Arco{" + "flechas=" + flechas + '}';
    }
    
    
    
    
}
