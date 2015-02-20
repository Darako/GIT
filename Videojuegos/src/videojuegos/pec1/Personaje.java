/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package videojuegos.pec1;

import java.util.ArrayList;

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

    public void combatir(ArrayList<Personaje> luchadores){ 
        int i = 0;
        while((luchadores.get(0).getPv() > 0) && (luchadores.get(1).getPv() > 0))
        {
            if(i==0)
            {
                luchadores.get(i).atacar(luchadores.get(i+1));
                if(luchadores.get(i+1).getPv()==0){
                    break;
                }
                i++;
            }
            if(i==1)
            {
                luchadores.get(i).atacar(luchadores.get(i-1));
                if(luchadores.get(i-1).getPv()==0){
                    break;
                }
                i--;
            }
        }
    }
    
    private void atacar(Personaje per){
        int cantidad = 0;
        if(this.getArma().estaDisponible()==true)
        {
            cantidad = cantidad + this.getArma().getDanyo();
            this.getArma().usar();
        }
        if(this.getDestreza()>0)
        {
            cantidad = cantidad + this.getDestreza();
        }
        per.setPv(per.getPv()-cantidad);
        System.out.println("Pegaron a: "+per.getNombre()+"\nVida: "+per.getPv()+"\n");
    }
    
    @Override
    public String toString() {
        return "\nPersonaje\nNombre: "+this.getNombre()+"\nPV: "+this.getPv()+"\nDestreza: "+this.getDestreza()+"\nArma: "+this.getArma().getNombre();
    }
    
    
}
