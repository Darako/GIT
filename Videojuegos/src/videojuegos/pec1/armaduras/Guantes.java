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
public class Guantes extends Armadura{
    
    //CONSTRUCTOR   
    public Guantes(String nombre, int durabilidad, int pv, int pm, int defensa, int defensa_magica) {
        super(nombre, durabilidad, pv, pm, defensa, defensa_magica);
    }

    @Override
    public String toString() {
        return "\nNombre: "+super.getNombre()+"\nDefensa: "+super.getDefensa()+"\nDurabilidad: "+super.getDurabilidad();
    }
}
