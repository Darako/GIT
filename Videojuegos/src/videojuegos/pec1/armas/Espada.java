/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package videojuegos.pec1.armas;

/**
 *
 * @author Jorge
 */
public class Espada extends Arma{
    
    //ATRIBUTOS
    private int stamina;

    //CONSTRUCTOR
    public Espada(String nombre, int durabilidad, int ataqueFisico, int ataqueMagico, int stamina) {
        super(nombre, durabilidad, ataqueFisico, ataqueMagico);
        this.stamina = this.stamina;
    }    

    //GETTER & SETTER
    public int getStamina() {
        return stamina;
    }
    public void setStamina(int stamina) {
        this.stamina = stamina;
    }

    //METODOS
    @Override
    public void usar(){
        this.stamina--;
    }
    
    @Override
    public boolean estaDisponible(){
        return this.stamina != 0;
    }

    @Override
    public String toString() {
        return "Espada{" + "stamina=" + stamina + '}';
    }
    
    

    
    
}
