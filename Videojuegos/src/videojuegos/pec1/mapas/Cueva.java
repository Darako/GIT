/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package videojuegos.pec1.mapas;

/**
 *
 * @author pedro
 */
import javax.swing.ImageIcon;

/**
 *
 * @author pedro
 */

public class Cueva extends Terreno{

    

    public Cueva(String nombre, int lvl, ImageIcon imagen) {
        super(nombre, lvl, imagen);

    }
    
    @Override
    public String toString(){
        return "Nombre: "+super.getNombre()+", Nivel: "+super.getLvl();
    }
    
}