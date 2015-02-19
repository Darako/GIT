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
public class Kender extends Personaje{
    
    private int poder;   
    private int energia;

    
    public Kender(int poder, int energia, Arma arma, int pv, String nombre, int destreza) {
        super(arma, pv, nombre, destreza);
        this.poder = poder;
        this.energia = energia;
    }

    
    public int getEnergia() {
        return energia;
    }
    public void setEnergia(int energia) {
        this.energia = energia;
    }

    public int getPoder() {
        return poder;
    }

    public void setPoder(int poder) {
        this.poder = poder;
    }

}
