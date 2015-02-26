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
public class Armadura {
    
    //ATRIBUTOS
    private String nombre;
    private int durabilidad;
    private int pv;
    private int pm;
    private int defensa;
    private int defensa_magica;

    //CONSTRUCTOR
    public Armadura(String nombre, int durabilidad, int pv, int pm, int defensa, int defensa_magica) {
        this.nombre = nombre;
        this.durabilidad = durabilidad;
        this.pv = pv;
        this.pm = pm;
        this.defensa = defensa;
        this.defensa_magica = defensa_magica;
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

    public int getPv() {
        return pv;
    }
    public void setPv(int pv) {
        this.pv = pv;
    }       

    public int getPm() {
        return pm;
    }
    public void setPm(int pm) {
        this.pm = pm;
    }     

    public int getDefensa() {
        return defensa;
    }
    public void setDefensa(int defensa) {
        this.defensa = defensa;
    }
        
    public int getDefensa_magica() {
        return defensa_magica;
    }
    public void setDefensa_magica(int defensa_magica) {
        this.defensa_magica = defensa_magica;
    }

}
