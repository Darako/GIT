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
     
    //ATRIBUTOS
    private int energia;

    //CONSTRUCTOR
    public Kender(int energia, Arma arma, int pv, String nombre, int destreza) {
        super(arma, pv, nombre, destreza);
        this.energia = energia;
    }

    //GETTER & SETTER
    public int getEnergia() {
        return energia;
    }
    public void setEnergia(int energia) {
        this.energia = energia;
    }

    @Override
    public String toString() {
        return "Kender{" + " energia=" + energia + '}';
    }

    
}
