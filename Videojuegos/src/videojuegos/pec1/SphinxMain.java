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
        Botas botas0 = new Botas("Botas del Génesis", 100, 0, 0, 0, 0);
        Casco casco0 = new Casco("Casco del Génesis", 100, 0, 0, 0, 0);
        Guantes guantes0 = new Guantes("Guantes del Génesis", 100, 0, 0, 0, 0);
        Pechera pechera0 = new Pechera("Pechera del Génesis", 100, 0, 0, 0, 0);
        Botas botas1 = new Botas("Botas del quinto elemento", 100, 20, 20, 20, 20);
        Casco casco1 = new Casco("Casco del quinto elemento", 100, 20, 20, 20, 20);
        Guantes guantes1 = new Guantes("Guantes del quinto elemento", 100, 20, 20, 20, 20);
        Pechera pechera1 = new Pechera("Pechera del quinto elemento", 100, 20, 20, 20, 20);
        Botas botas2 = new Botas("Botas Adleta", 100, 10, 10, 10, 10);
        Casco casco2 = new Casco("Casco Adleta", 100, 10, 10, 10, 10);
        Guantes guantes2 = new Guantes("Guantes Adleta", 100, 10, 10, 10, 10);
        Pechera pechera2 = new Pechera("Pechera Adleta", 100, 10, 10, 10, 10);
        Armadura armadura0 = new Armadura(botas0, casco0, guantes0, pechera0);
        Armadura armadura1 = new Armadura(botas1, casco1, guantes1, pechera1);
        Armadura armadura2 = new Armadura(botas2, casco2, guantes2, pechera2);
        System.out.println(armadura0.toString());
        System.out.println(armadura1.toString());
        Arco arco1 = new Arco("Arco del cerdo", 10, 1000);
        System.out.println("POLLAS COMO PANES");
        Pjs nuevo = new Pjs("Rober Moraletti", 500, 100, 20, 10, 20, 15, 1, 0/** int exp_sig_nivel, Habilidad habilidad, arco1, armadura**/);
        nuevo.setArmadura(armadura0);
        nuevo.setArma(arco1);
        System.out.println(nuevo.toString());
        nuevo.equiparArmadura(armadura1);
        System.out.println(nuevo.toString());
        nuevo.equiparArmadura(armadura2);
        System.out.println(nuevo.toString());
        nuevo.equiparArmadura(armadura0);
        System.out.println(nuevo.toString());
    }
    
}
