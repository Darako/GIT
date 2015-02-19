/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package videojuegos.pec1;

/**
 *
 * @author Guillermo
 */
public class Nigromante extends Personaje {
    
    private int poder;

    
    public Nigromante(int poder, Arma arma, int pv, String nombre, int destreza) {
        super(arma, pv, nombre, destreza);
        this.poder = poder;
        
    }

    
    public int getPoder() {
        return poder;
    }
    public void setPoder(int poder) {
        this.poder = poder;
    }

    @Override
    public String toString() {
        return "Nigromante{" + "poder=" + poder + '}';
    }

    
}
