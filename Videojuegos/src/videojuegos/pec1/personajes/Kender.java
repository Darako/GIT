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
public class Kender extends Personaje{
     
    //ATRIBUTOS
    private int energia;

    //CONSTRUCTOR
    public Kender(String nombre, int pv, int destreza, Arma arma, Habilidad habilidades, int energia) {
        super(nombre, pv, destreza, arma, habilidades);
        this.energia = energia;
    }

    public Kender(String nombre, int pv, int destreza, int energia) {
        super(nombre, pv, destreza);
        this.energia = energia;
    }

    //GETTER & SETTER
    public int getEnergia() {
        return energia;
    }
    public void setEnergia(int energia) {
        this.energia = energia;
    }
    
    //METODOS
    @Override
    public boolean estaExhausto()
    {
        return this.energia == 0;
    }    
    
    @Override
    public void gastar(){
        this.energia--;
    }
    
    @Override
    public String toString() {
        return "KENDER\n"+super.toString()+"\nEnergia: "+this.energia;
    }

    
}
