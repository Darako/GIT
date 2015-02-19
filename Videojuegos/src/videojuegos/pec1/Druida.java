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
public class Druida extends Personaje{
    
    private int energia;

    
    public Druida(int energia, Arma arma, int pv, String nombre, int destreza) {
        super(arma, pv, nombre, destreza);
        this.energia = energia;
    }

    
    public int getEnergia() {
        return energia;
    }

    public void setEnergia(int energia) {
        this.energia = energia;
    }

    
}
