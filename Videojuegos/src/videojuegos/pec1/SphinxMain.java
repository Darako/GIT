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
import videojuegos.pec1.armas.Armaca;
import videojuegos.pec1.armas.Bastonaco;
import videojuegos.pec1.armas.Dagon;
import videojuegos.pec1.armas.Espadaca;
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
        
        Bastonaco baston0 = new Bastonaco("Bastón del Génesis", 100, 0, 0);
        Dagon daga0 = new Dagon ("Daga del Génesis", 100, 0, 0);
        Espadaca espada0 = new Espadaca ("Espada del Génesis", 100, 0, 0);
        Bastonaco baston1 = new Bastonaco ("Bastón Adleta", 100, 10, 10);
        Dagon daga1 = new Dagon ("Daga Adleta", 100, 10, 10);
        Espadaca espada1 = new Espadaca ("Espada Adleta", 100, 10, 10);
        Bastonaco baston2 = new Bastonaco("Bastón del quinto elemento", 100, 20, 20);
        Dagon daga2 = new Dagon ("Daga del quinto elemento", 100, 20, 20);
        Espadaca espada2 = new Espadaca ("Espada del quinto elemento", 100, 20, 20);
        Armaca arma0 = new Armaca(baston0);
        Armaca arma1 = new Armaca(daga0);
        Armaca arma2 = new Armaca(espada0);
        Armaca arma3 = new Armaca(baston1);
        Armaca arma4 = new Armaca(daga1);
        Armaca arma5 = new Armaca(espada1);
        Armaca arma6 = new Armaca(baston2);
        Armaca arma7 = new Armaca(daga2);
        Armaca arma8 = new Armaca(espada2);
        //Armadura armadura3 = new Armadura(casco2);
        //System.out.println(armadura0.toString());
        //System.out.println(armadura1.toString());
        
        System.out.println("POLLAS COMO PANES");
        Pjs nuevo = new Pjs("Rober Moraletti", 500, 100, 20, 10, 20, 15, 1, 0/** int exp_sig_nivel, Habilidad habilidad, arco1, armadura**/);
        nuevo.setArmadura(armadura0);
        //nuevo.setArmaca(arma1); //marca el tipo de arma, hay que mirarlo
        System.out.println(nuevo.toString());
        //nuevo.equiparArmadura(armadura1);
        //System.out.println(nuevo.toString());
        //nuevo.equiparArmadura(armadura2);
        //System.out.println(nuevo.toString());
        //nuevo.equiparArmadura(armadura0);
        //System.out.println(nuevo.toString());
        //nuevo.equiparCasco(armadura3);
        //System.out.println(nuevo.toString());
        nuevo.actualizarArmadura(casco2);
        //nuevo.actualizarArma(daga1);
        System.out.println(nuevo.toString());
        nuevo.actualizarArmadura(botas1);
        System.out.println(nuevo.toString());
    }
    
}
