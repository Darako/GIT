/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package videojuegos.pec1.armas;

import java.io.Serializable;

/**
 *
 * @author Jorge
 */
public class Arma implements Serializable{
    //ATRIBUTOS
    private String nombre;
    private int durabilidad;   
    private int ataqueFisico;
    private int ataqueMagico;
    //private boolean enUso; 

    //CONSTRUCTOR
    
    public Arma(String nombre, int durabilidad, int ataque, int ataqueMagico) {
        this.nombre = nombre;
        this.durabilidad = durabilidad;
        this.ataqueFisico = ataqueFisico;
        this.ataqueMagico = ataqueMagico;
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
    public int getAtaqueFisico() {
        return ataqueFisico;
    }
    public void setAtaqueFisico(int ataqueFisico) {
        this.ataqueFisico = ataqueFisico;
    }    
    public int getAtaqueMagico() {
        return ataqueMagico;
    }
    public void setAtaqueMagico(int ataqueMagico) {
        this.ataqueMagico = ataqueMagico;
    }
    
    
    //METODOS
    public boolean estaDisponible(){
        return this.estaDisponible();
    }
    
    public void usar(){
        this.usar();
    }    

    @Override
    public String toString() {
        return "Arma{" + "nombre=" + nombre + ", durabilidad=" + durabilidad + ", ataque=" + ataqueFisico + ", ataqueMagico=" + ataqueMagico + '}';
    }
    
    
}    
    

