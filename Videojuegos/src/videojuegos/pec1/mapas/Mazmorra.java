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
public class Mazmorra extends Terreno{
    
    private MMazmorra m; 

    
    public Mazmorra(String nombre, int lvl, ImageIcon imagen) {
        super(nombre, lvl, imagen);
        this.m=new MMazmorra();
    }
    
   
    
    public MMazmorra getContenido(){
        return m;
    }
    

    @Override
    public String toString(){
        return "Nombre: "+super.getNombre()+", Nivel: "+super.getLvl();
    }
    
}
