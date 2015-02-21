/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package videojuegos.pec1;

/**
 *
 * @author noesmoral
 */
public class Kraken extends Enemigo{
    
    //enemigo final BOSS
    int especial;       //falla el ataque
    int especial1;      //atque especial que hace mas daño que el basico
    int especial2;      //ataque que mata directamente

    //CONSTRUCTOR
    public Kraken(String nombre, int danyo, int vida) {
        super(nombre, danyo, vida);
        this.especial=0;
        this.especial1=danyo+15;
        this.especial2=9999;
    }
    
    //METODOS GET
    public int getEspecial(){
        return especial;
    }
    
    public int getEspecial1(){
        return especial1;
    }
    
    public int getEspecial2(){
        return especial2;
    }
    
    @Override
    public String toString() {
        return "\nNombre: "+super.getNombre()+"\nDaño: "+super.getDanyo()+"\nVida: "+super.getVida()+"\nInformacion: Puede fallar hacer un atque especial o matar de un golpe";
    }
}
