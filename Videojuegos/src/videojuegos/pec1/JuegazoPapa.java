/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package videojuegos.pec1;

import java.util.ArrayList;

/**
 *
 * @author Jorge
 */
public class JuegazoPapa {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        
        Arco arco1 = new Arco("Tirachinas de Bart", 10, 10);
        Espada espada1 = new Espada("Palo de Selfie", 10, 20);
        Baston baston1 = new Baston("Palillo de los Oidos", 10, 15);
        
        Personaje per1 = new Personaje(espada1, 100, "Personaje1", 15);
        Personaje per2 = new Personaje(arco1, 100, "Personaje2", 15);
        
        ArrayList<Personaje> luchadores = new ArrayList<Personaje>();
        luchadores.add(per1);
        luchadores.add(per2);
        
        
        System.out.println("¡¡COMBATE!!");
        per1.combatir(luchadores);        
        
        System.out.println("¡¡RESULTADO DEL COMBATE!!");
        System.out.println(luchadores.get(0).toString());
        System.out.println("\n"+luchadores.get(0).getArma().toString());
        System.out.println("\n"+luchadores.get(1).toString());
        System.out.println("\n"+luchadores.get(1).getArma().toString());
        
        
        
       
    }
    
}
