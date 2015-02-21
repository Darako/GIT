/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package videojuegos.pec1;

import java.util.Random;

/**
 *
 * @author Guillermo
 */
public class Druida extends Personaje{
    
    //ATRIBUTOS
    private int energia;
    private int mana;
    
    //CONSTRUCTOR
    public Druida(String nombre, int pv, int destreza, Arma arma, int energia, int mana) {
        super(nombre, pv, destreza, arma);
        this.energia = energia;
        this.mana = mana;
    }

    //GETTER & SETTER
    public int getEnergia() {
        return energia;
    }
    public void setEnergia(int energia) {
        this.energia = energia;
    }    
    public int getMana(){
        return mana;
    }   
    public void setMana(int mana){
        this.mana = mana;
    }

    //METODOS
    @Override
    public void gastar(){
        Random i = new Random();
        int eleccion = i.nextInt((2-1)+1) + 1;
        if(eleccion==1){this.energia--;}else{this.mana--;}        
    }
    
    @Override
    public String toString() {
        return "Druida{" + "energia=" + energia + ", mana=" + mana + '}';
    }

}
