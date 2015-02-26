/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package videojuegos.pec1;

import habilidades.Habilidad;
import java.io.FileNotFoundException;
import videojuegos.pec1.personajes.Personaje;
import videojuegos.pec1.personajes.Kender;
import videojuegos.pec1.personajes.Druida;
import videojuegos.pec1.personajes.Nigromante;
import videojuegos.pec1.armas.Arco;
import videojuegos.pec1.armas.Baston;
import videojuegos.pec1.armas.Espada;
import java.util.ArrayList;
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
        // TODO code application logic here
        //Juego juego = new Juego();
        
        //juego.iniciarDatos();
        
        ArrayList<Arma> armas = new ArrayList<Arma>();
        Baston arma1 = new Baston("Baston1",100,1);
        Arco arma2 = new Arco("Arco1",100,1);
        armas.add(arma1);
        armas.add(arma2);
                
        //roster=juego.getPersonajes();
        
        ArrayList<Habilidad> habilidades = new ArrayList<Habilidad>();
        Habilidad magia1 = new Habilidad("FireBall","Magia",-3,2,0);
        Habilidad magia2 = new Habilidad("Heal","Magia",3,2,0);
        habilidades.add(magia2);
        habilidades.add(magia1);
        
        ArrayList<Personaje> roster = new ArrayList<Personaje>();
        Druida personaje1 = new Druida("Jugon1",100,10,arma1, magia1,10, 10);
        Druida personaje2 = new Druida("Jugon2",100,10,arma2, magia2,10, 10);
        
        personaje1.usarHabilidad(magia1, personaje2);
        System.out.println(personaje2.toString());
        /*for(int i=0;i<roster.size();i++){
            System.out.println(roster.get(i).getNombre());
            if(roster.get(i).getArma().getNombre() != null)
            {
                System.out.println(roster.get(i).getArma().getNombre());
            }            
        }*/
        
        
       
    }
    
}
