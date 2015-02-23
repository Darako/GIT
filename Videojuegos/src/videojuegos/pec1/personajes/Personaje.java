/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package videojuegos.pec1.personajes;

import videojuegos.pec1.armas.Arma;
import java.util.ArrayList;

/**
 *
 * @author Guillermo
 */
public class Personaje {
    
    //ATRIBUTOS
    private Arma arma;
    private int pv;
    private String nombre;
    private int destreza;

    //CONSTRUCOR
    public Personaje(String nombre, int pv, int destreza, Arma arma) {
        this.nombre = nombre;        
        this.pv = pv;        
        this.destreza = destreza;
        this.arma = arma;
    } 
    
    //GETTER & SETTER
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

    //METODOS
    public boolean estaDerrotado(){
        return this.pv <= 0;
    }
    
    public boolean estaExhausto()
    {
        return this.estaExhausto();
    }
    
    public void gastar(){}

    public void combatir(ArrayList<Personaje> luchadores){ 
        int i = 0;
        int herida = 0;
        while((!(luchadores.get(0).estaDerrotado())) || (!(luchadores.get(1).estaDerrotado())))
        {
            if(i==0)
            {   
                herida = luchadores.get(i).atacar(luchadores.get(i+1));
                if((luchadores.get(i).estaDerrotado()) || (luchadores.get(i+1).estaDerrotado()) || (herida==0)){
                    break;
                }
                luchadores.get(i+1).setPv((luchadores.get(i+1).getPv()) - herida);                
                System.out.println("Pegaron a "+luchadores.get(i+1).getNombre()+", "+herida+" de daño.\nVida: "+luchadores.get(i+1).getPv()+"\n");
                i++;
            }
            if(i==1)
            {
                herida = luchadores.get(i).atacar(luchadores.get(i-1));                
                if((luchadores.get(i).estaDerrotado()) || (luchadores.get(i-1).estaDerrotado())  || (herida==0) ){
                    break;
                }
                luchadores.get(i-1).setPv((luchadores.get(i-1).getPv()) - herida);                
                System.out.println("Pegaron a "+luchadores.get(i-1).getNombre()+", "+herida+" de daño.\nVida: "+luchadores.get(i-1).getPv()+"\n");
                i--;
            }            
        }
    }
    
    private int atacar(Personaje per){
        int cantidad = 0;
        if(this.getArma().estaDisponible())
        {
            cantidad = cantidad + this.getArma().getDanyo();
            this.getArma().usar();
        }
        if(!this.estaExhausto())
        {
            cantidad = cantidad + this.getDestreza();
            this.gastar();
        }
        return cantidad;
        
        
    }
    
    @Override
    public String toString() {
        return "Nombre: "+this.getNombre()+"\nPV: "+this.getPv()+"\nDestreza: "+this.getDestreza()+"\nArma: "+this.getArma().getNombre();
    }
    
    
}