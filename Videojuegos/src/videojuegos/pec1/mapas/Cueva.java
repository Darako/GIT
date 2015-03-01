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
public class Cueva extends Terreno{

    private MCueva c;

    public Cueva(String nombre, int lvl, ImageIcon imagen) {
        super(nombre, lvl, imagen);
        this.c=new MCueva();
    }
    
    
    public MCueva getContenido(){
        return c;
    }
    
    @Override
    public String toString(){
        return "Nombre: "+super.getNombre()+", Nivel: "+super.getLvl();
    }
    
}
