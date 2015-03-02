/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package videojuegos.pec1.armaduras;

import java.io.Serializable;

/**
 *
 * @author Jorge
 */
public class Casco implements Serializable{
    
    //ATRIBUTOS
    String nombre;
    int durabilidad;
    int pv;
    int pm;
    int defensaFisica;
    int defensaMagica;

    //CONSTRUCTOR
    public Casco(String nombre, int durabilidad, int pv, int pm, int defensaFisica, int defensaMagica) {
        this.nombre = nombre;
        this.durabilidad = durabilidad;
        this.pv = pv;
        this.pm = pm;
        this.defensaFisica = defensaFisica;
        this.defensaMagica = defensaMagica;
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
    public int getDefensaFisica() {
        return defensaFisica;
    }
    public void setDefensaFisica(int defensaFisica) {
        this.defensaFisica = defensaFisica;
    }
    public int getDefensaMagica() {
        return defensaMagica;
    }
    public void setDefensaMagica(int defensaMagica) {
        this.defensaMagica = defensaMagica;
    }

    //MÉTODOS
    @Override
    public String toString() {
        return " - CASCO\nNombre: "+this.nombre+"\nDurabilidad: "+this.durabilidad+"\nPV: "+this.pv+"\nPM: "+this.pm+"\nDefensa Física: "+this.defensaFisica+"\nDefensa Mágica: "+this.defensaMagica+"\n";
    }
        
    
}
