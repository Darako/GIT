/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package videojuegos.pec1;

import java.util.Random;

/**
 *
 * @author noesmoral
 */
public class Shadow extends Enemigo{
    
    int especial;       //falla el ataque
    int especial1;      //ataque especial
    Random r = new Random();

    public Shadow(String nombre, int danyo, int vida) {
        super(nombre, danyo, vida);
        this.especial=0;
        this.especial1=danyo+5;
    }
    
    //METODOS 
    public int atacar(){
        int resultado=r.nextInt(21);
        if(resultado>=15) return especial1;
        else if (resultado<=5) return especial;
        else return super.getDanyo();
    }
    
    @Override
    public String toString() {
        return "\nNombre: "+super.getNombre()+"\nDaño: "+super.getDanyo()+"\nVida: "+super.getVida()+"\nInformacion: Puede Fallar o realizar un ataque especial";
    }
}
