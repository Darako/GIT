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
    
    //ATRIBUTOS
    private int ma;

    //CONSTRUCTOR
    public Nigromante(int ma, Arma arma, int pv, String nombre, int destreza) {
        super(arma, pv, nombre, destreza);
        this.mana = ma;
        
    }

    //GETTER & SETTER
    public int getPoder() {
        return mana;
    }
    public void setPoder(int poder) {
        this.mana = mana;
    }

    @Override
    public String toString() {
        return "Nigromante{" + "mana=" + mana + '}';
    }

    
}
