/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package videojuegos.pec1.armas;


/**
 *
 * @author Guillermo
 */
public class Bastonaco {
    
    //ATRIBUTOS
    private String nombre;
    private int durabilidad;
    private int ataque;
    private int ataque_magico;

    //CONSTRUCTOR
    public Bastonaco(String nombre, int durabilidad, int ataque, int ataque_magico) {
        this.nombre = nombre;
        this.durabilidad = durabilidad;
        this.ataque = ataque;
        this.ataque_magico = ataque_magico;
    }
   
    //GETTER & SETTER
    public String getNombre() {
        return nombre;
    }
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getDurabilidad() {
        return durabilidad;
    }
    public void setDurabilidad(int durabilidad) {
        this.durabilidad = durabilidad;
    }
        
    public int getAtaque() {
        return ataque;
    }
    public void setAtaque(int ataque) {
        this.ataque = ataque;
    }
        
    public int getAtaque_magico() {
        return ataque_magico;
    }
    public void setAtaque_magico(int ataque_magico) {
        this.ataque_magico = ataque_magico;
    }

    //MÉTODOS
    @Override
    public String toString() {
        return "Bastonaco{" + "nombre=" + nombre + ", durabilidad=" + durabilidad + ", ataque=" + ataque + ", ataque_magico=" + ataque_magico + '}';
    }
    
}
