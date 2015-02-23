/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package videojuegos.pec1.armaduras;

/**
 *
 * @author Jorge
 */
public class Botas extends Armadura{

    
    //CONSTRUCTOR
    public Botas(String nombre, int defensa, int durabilidad) {
        super(nombre, defensa, durabilidad);
    }
    
    
    
    @Override
    public String toString() {
        return "\nNombre: "+super.getNombre()+"\nDefensa: "+super.getDefensa()+"\nDurabilidad: "+super.getDurabilidad();
    }
    
}
