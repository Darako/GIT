/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package videojuegos.pec1.personajes;

import videojuegos.pec1.habilidades.Habilidad;
import videojuegos.pec1.armas.Arma;

/**
 *
 * @author Guillermo
 */
public class Nigromante extends Personaje {
    
    //ATRIBUTOS
    private int mana;

    //CONSTRUCTOR
    public Nigromante(String nombre, int pv, int pm, int ataque, int ataque_magico, int defensa, int defensa_magica, int nivel, int exp) {
        super(nombre, pv, pm, ataque, ataque_magico, defensa, defensa_magica, nivel, exp);
    }    

    //GETTER & SETTER
    public int getPoder() {
        return mana;
    }
    public void setPoder(int poder) {
        this.mana = mana;
    }
    
    //METODOS
    @Override
    public boolean estaExhausto()
    {
        return this.mana == 0;
    }
    
    @Override
    public void gastar(){
        this.mana--;
    }
    
    @Override
    public String toString() {
        return "DRUIDA\n"+super.toString()+"\nMana: "+this.mana;
    }

    
}
