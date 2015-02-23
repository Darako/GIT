/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package videojuegos.pec1;

import java.util.ArrayList;
import videojuegos.pec1.armaduras.Armadura;
import videojuegos.pec1.armas.Arma;
import videojuegos.pec1.enemigos.Enemigo;
import videojuegos.pec1.personajes.Personaje;

/**
 *
 * @author Jorge
 */
public class Juego {
    
    
    
    //LISTAS
    public static ArrayList<Personaje> personajes = new ArrayList<Personaje>();
    public static ArrayList<Enemigo> enemigos = new ArrayList<Enemigo>();
    public static ArrayList<Arma> armas = new ArrayList<Arma>();
    public static ArrayList<Armadura> armaduras = new ArrayList<Armadura>();   
    
    //CONSTRUCTOR

    public Juego() {
        
    }
    
    //GETTER & SETTER
    public static ArrayList<Personaje> getPersonajes() {
        return personajes;
    }

    public static void setPersonas(ArrayList<Personaje> personajes) {
        Juego.personajes = personajes;
    }
    
    
    //METODOS
    public void nuevaPartida(){
        
    }
    
    public void reiniciar(){
        
    }
    
    public void iniciarJuego(){
        
    }
    
}
