/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package videojuegos.pec1.mapas;

import javax.swing.ImageIcon;

/**
 *
 * @author noesmoral
 */
public class MMazmorra {
    
    private int tam=5;
            
    public Terreno map[][]=new Terreno[tam][tam];
    
    
    ImageIcon c = new ImageIcon("src/Camino.jpg");
    ImageIcon n = new ImageIcon("src/NoCamino.jpg");
    
    Ncamino no=new Ncamino("piedra", 0, c);
    Camino si=new Camino("Camino1", 2, c, 25);

    public MMazmorra() {
        genMaz();
    }
    
    public void genMaz(){
        for (int i = 0; i < tam; i++) {
            for (int e = 0; e < tam; e++) {
                if(i==2 && e>4)
                    map[i][e]=si;
                else
                    map[i][e]=no;
            }
        }
    }
}
