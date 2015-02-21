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
public class Shadow extends Enemigo{
    
    int especial;       //falla el ataque
    int especial1;      //ataque especial

    public Shadow(String nombre, int danyo, int vida) {
        super(nombre, danyo, vida);
        this.especial=0;
        this.especial1=danyo+5;
    }
    
    //METODOS GET
    public int getEspecial(){
        return especial;
    }
    
    public int getEspecial1(){
        return especial1;
    }
    
    @Override
    public String toString() {
        return "\nNombre: "+super.getNombre()+"\nDaño: "+super.getDanyo()+"\nVida: "+super.getVida()+"\nInformacion: Puede Fallar o realizar un ataque especial";
    }
}
