/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package videojuegos.pec1;

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
        
        /*
        Arco arco1 = new Arco("Arco1", 10, 5);
        Espada espada1 = new Espada("Espada1", 10, 5);
        Baston baston1 = new Baston("Baston1", 10, 5);
        
        Kender personaje1 = new Kender("Personaje1", 100, 10, arco1, 10);
        Nigromante personaje2 = new Nigromante("Personaje2", 100, 10, baston1, 3);
        Druida personaje3 = new Druida("Personaje3", 100, 10, espada1, 3, 3);
        
        ArrayList<Personaje> roster = new ArrayList<Personaje>();
        roster.add(personaje1);
        roster.add(personaje2);
        roster.add(personaje3);        
        
        ArrayList<Arma> baul = new ArrayList<Arma>();
        baul.add(arco1);
        baul.add(espada1);
        baul.add(baston1);
        */
        Juego juego = new Juego();
        //juego.guardarObjeto(baul, "armas");
        //juego.guardarObjeto(roster,"personajes");
        juego.iniciarDatos();
        
        ArrayList<Personaje> roster = new ArrayList<Personaje>();
        roster=juego.getPersonajes();
        
        
        //System.out.println(juego.getArmas().get(0).getNombre());
        //System.out.println(roster.get(7).getArma().getNombre());
        for(int i=0;i<roster.size();i++){
            System.out.println(roster.get(i).getNombre());
            if(roster.get(i).getArma().getNombre() != null)
            {
                System.out.println(roster.get(i).getArma().getNombre());
            }
            
        }//System.out.println(baul.get(0).getNombre());System.out.println(roster.get(i).getArma().getNombre());
        
        /*
        System.out.println("¡¡COMBATE!!");
        personaje1.combatir(luchadores);        
        
        System.out.println("¡¡RESULTADO DEL COMBATE!!");
        System.out.println("Personaje 1:");
        System.out.println(personaje1.toString());
        System.out.println(personaje1.getArma().toString());
        System.out.println("\nPersonaje 2:");
        System.out.println(personaje2.toString());
        System.out.println(personaje2.getArma().toString());
        System.out.println("\nPersonaje 3:");
        System.out.println(personaje3.toString());
        System.out.println(personaje3.getArma().toString());
        
        Troll troll=new Troll("Escojondrio", 5, 35);
        Treant treant=new Treant("tronco", 10, 50);
        Shadow shadow=new Shadow("Transparente", 15, 75);
        Kraken kraken=new Kraken("Tentacruel", 20, 130);
        
        ArrayList<Enemigo> enemigo = new ArrayList<Enemigo>();
        enemigo.add(troll);
        enemigo.add(treant);
        enemigo.add(treant);
        enemigo.add(kraken);
        
        System.out.print(troll.toString());
        System.out.print(treant.toString());
        System.out.print(shadow.toString());
        System.out.print(kraken.toString());
        
        Kraken kraken=new Kraken("Tentacruel", 20, 130);
        
        for (int i = 0; i < 30; i++) {
            System.out.println(kraken.atacar());
        }
        */
        
        
       
    }
    
}
