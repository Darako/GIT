/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package videojuegos.pec1.personajes;

import habilidades.Habilidad;
import videojuegos.pec1.armas.Arma;
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
    public Druida(String nombre, int pv, int destreza, Arma arma, Habilidad habilidades, int energia, int mana) {
        super(nombre, pv, destreza, arma, habilidades);
        this.energia = energia;
        this.mana = mana;
    }

    public Druida(String nombre, int pv, int destreza, int energia, int mana ) {
        super(nombre, pv, destreza);
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
    public boolean estaExhausto()
    {
        return (this.mana == 0) && (this.energia == 0);
    }
    
    @Override
    public void gastar(){
        Random i = new Random();
        int eleccion = i.nextInt((2-1)+1) + 1;
        if(eleccion==1){this.energia--;}else{this.mana--;}        
    }
    
    @Override
    public String toString() {
        return "DRUIDA\n"+super.toString()+"\nMana: "+this.mana+"\nEnergia: "+this.energia;
    }

}
