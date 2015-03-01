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
public class Terreno {
    
    private String nombre;
    private int lvl;
    private ImageIcon imagen; 
    
    public Terreno(String nombre,int lvl, ImageIcon imagen){
        this.nombre=nombre;
        this.lvl=lvl;
        this.imagen=imagen;
    }
    
    public String getNombre(){
        return this.nombre;
    }
    
    public int getLvl(){
        return this.lvl;
    }
    
    public ImageIcon getImagen(){
        return this.imagen;
    }
    
}
