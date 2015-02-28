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
    public Nigromante(String nombre, int pv, int destreza, Arma arma, Habilidad habilidades, int mana) {
        super(nombre, pv, destreza, arma, habilidades);
        this.mana = mana;        
    }

    public Nigromante(String nombre, int pv, int destreza,int mana) {
        super(nombre, pv, destreza);
        this.mana = mana;
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
