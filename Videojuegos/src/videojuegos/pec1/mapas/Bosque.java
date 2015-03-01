/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package videojuegos.pec1.mapas;

import javax.swing.ImageIcon;

/**
 *
 * @author pedro
 */
public class Bosque extends Zona{

    public Bosque(String nombre, int lvl, ImageIcon imagen, int provabilidad) {
        super(nombre, lvl, imagen, provabilidad);
    }

    
    
    @Override
   public String toString(){
        return "Nombre: "+super.getNombre()+", Nivel: "+super.getLvl()+", Provabilidad de enemigos: "+super.getProvabilidad();
    } 
    
}
