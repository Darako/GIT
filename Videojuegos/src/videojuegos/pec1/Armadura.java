/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package videojuegos.pec1;

/**
 *
 * @author Jorge
 */
public class Armadura {
    
    //ATRIBUTOS
    private String nombre;
    private int defensa;    
    private int durabilidad;
    
    //CONSTRUCTOR
    public Armadura(String nombre, int defensa, int durabilidad) {
        this.nombre = nombre;
        this.defensa = defensa;
        this.durabilidad = durabilidad;
    }

    //GETTER & SETTER
    public int getDurabilidad() {
        return durabilidad;
    }

    public void setDurabilidad(int durabilidad) {
        this.durabilidad = durabilidad;
    }

    public int getDefensa() {
        return defensa;
    }

    public void setDefensa(int defensa) {
        this.defensa = defensa;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    
}
