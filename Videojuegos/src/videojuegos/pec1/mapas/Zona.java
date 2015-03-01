/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package videojuegos.pec1.mapas;

import javax.swing.ImageIcon;

/**
 *
 * @author noesmoral
 */
public class Zona extends Terreno{
    
    private int provabilidad;

    public Zona(String nombre, int lvl, ImageIcon imagen, int provabilidad) {
        super(nombre, lvl, imagen);
        this.provabilidad=provabilidad;
    }

    
    
    public int getProvabilidad(){
        return this.provabilidad;
    }
    
    
    
    
}
