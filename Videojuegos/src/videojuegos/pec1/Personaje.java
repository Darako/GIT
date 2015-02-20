/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package videojuegos.pec1;

/**
 *
 * @author Guillermo
 */
public class Personaje {
    
    private Arma arma;
    private int pv;
    private String nombre;
    private int destreza;

    
    public Personaje(Arma arma, int pv, String nombre, int destreza) {
        this.arma = arma;
        this.pv = pv;
        this.nombre = nombre;
        this.destreza = destreza;
    } 
    
    
    public Arma getArma() {
        return arma;
    }
    public void setArma(Arma arma) {
        this.arma = arma;
    } 

    public int getPv() {
        return pv;
    }
    public void setPv(int pv) {
        this.pv = pv;
    }        

    public String getNombre() {
        return nombre;
    }
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }  

    public int getDestreza() {
        return destreza;
    }
    public void setDestreza(int destreza) {
        this.destreza = destreza;
    }

    public boolean estaDerrotado(){
        return this.pv <= 0;
    }

    public void combatir(){
    
}
    private void atacar(Personaje per1, Personaje per2){
        int cantidad = 0;
        if(per1.getArma().estaDisponible())
        {
            cantidad=+per1.getArma().getDanyo();
        }
        if(per1.getDestreza()>0)
        {
            cantidad=+per1.getDestreza();
        }
        per2.setPv(per2.getPv()-cantidad);
    }
    
    @Override
    public String toString() {
        return "Personaje{" + "arma=" + arma + ", pv=" + pv + ", nombre=" + nombre + ", destreza=" + destreza + '}';
    }
    
    
}
