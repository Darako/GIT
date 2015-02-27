/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package videojuegos.pec1;

import videojuegos.pec1.armaduras.Armadura;
import videojuegos.pec1.armaduras.Botas;
import videojuegos.pec1.armaduras.Casco;
import videojuegos.pec1.armaduras.Guantes;
import videojuegos.pec1.armaduras.Pechera;
import videojuegos.pec1.armas.Arma;
import videojuegos.pec1.armas.Arco;
import videojuegos.pec1.personajes.Pjs;
/**
 *
 * @author Guillermo
 */
public class SphinxMain {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        Botas botas1 = new Botas("Botas del quinto elemento", 100, 10, 5, 25, 10);
        Casco casco1 = new Casco("Casco del quinto elemento", 100, 10, 5, 25, 10);
        Guantes guantes1 = new Guantes("Guantes del quinto elemento", 100, 10, 5, 25, 10);
        Pechera pechera1 = new Pechera("Pechera del quinto elemento", 100, 10, 5, 25, 10);
        Armadura armadura = new Armadura(botas1, casco1, guantes1, pechera1);
        System.out.println(armadura.toString());
        Arco arco1 = new Arco("Arco del cerdo", 10, 1000);
        System.out.println("POLLAS COMO PANES");
        Pjs nuevo = new Pjs("Rober Moraletti", 500, 100, 20, 10, 20, 15, 1, 0/** int exp_sig_nivel, Habilidad habilidad, arco1, armadura**/);
        nuevo.setArmadura(armadura);
        nuevo.setArma(arco1);
        nuevo.equiparArmadura(armadura);
        System.out.println(nuevo.toString());
    }
    
}
