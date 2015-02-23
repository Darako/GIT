/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package videojuegos.pec1.enemigos;

import java.util.Random;

/**
 *
 * @author noesmoral
 */
public class Troll extends Enemigo{
    
    int especial;       //falla el ataque
    Random r = new Random();

    public Troll(String nombre, int danyo, int vida) {
        super(nombre, danyo, vida);
        this.especial=0;
    }
    
    //METODO 
    public int atacar(){
        int resultado=r.nextInt(11);
        if(resultado>=7) return especial;
        else return super.getDanyo();
    }
    
    @Override
    public String toString() {
        return "\nNombre: "+super.getNombre()+"\nDaño: "+super.getDanyo()+"\nVida: "+super.getVida()+"\nInformacion: Puede fallar";
    }
    
}
