/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package videojuegos.pec1;

import videojuegos.pec1.habilidades.Habilidad;
import java.io.FileNotFoundException;
import videojuegos.pec1.personajes.Personaje;
import videojuegos.pec1.personajes.Kender;
import videojuegos.pec1.personajes.Druida;
import videojuegos.pec1.personajes.Nigromante;
import videojuegos.pec1.armas.Arco;
import videojuegos.pec1.armas.Baston;
import videojuegos.pec1.armas.Espada;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import videojuegos.pec1.armas.Arma;

/**
 *
 * @author Jorge
 */
public class JuegazoPapa {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws FileNotFoundException {
        Juego juego = new Juego();
        juego.iniciarDatos();
        
        HashMap<String, Personaje> personajes = new HashMap<>();
        personajes = juego.getPersonajes();
        //Kender personaje1 = new Kender("Pruebo", 100, 10, 5, 5, 5, 5, 5);
        //personajes.put("Pruebo", personaje1);
        System.out.println(personajes.get("Prueba 1").getArma().toString());
        //juego.guardarDatos(personajes, "personajes");
        
        
       
    }
    
}
