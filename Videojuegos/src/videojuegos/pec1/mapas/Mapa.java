/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package videojuegos.pec1.mapas;

import java.util.Random;
import javax.swing.ImageIcon;

/**
 *
 * @author pedro
 */
public class Mapa extends Thread{
    
    private int tam=10;
            
    public Terreno map[][]=new Terreno[tam][tam];
    
    
    ImageIcon p = new ImageIcon("src/Pueblo.jpg");
    ImageIcon c = new ImageIcon("src/Cueva.jpg");
    ImageIcon m = new ImageIcon("src/Mazmora.jpg");
    ImageIcon mo = new ImageIcon("src/Montaña.jpg");
    ImageIcon ni = new ImageIcon("src/Nieve.jpg");
    ImageIcon ll = new ImageIcon("src/Llano.jpg");
    ImageIcon bo = new ImageIcon("src/Bosque.jpg");
    
    Pueblo pueblo=new Pueblo("Marchamalo", 1, p);
    Cueva cueva=new Cueva("Cueva1", 1, c);
    Mazmorra mazmorra=new Mazmorra("Mazmorra1", 1, m);
    Montaña montaña=new Montaña("Montaña1", 2, mo, 15);
    Llano llano=new Llano("Llano1", 1, ll, 5);
    Bosque bosque=new Bosque("Bosque1", 1, bo, 10);
    Nieve nieve=new Nieve("Nieve1", 3, ni, 20);
    
    public Mapa(){ 
        this.map[1][1]=pueblo;
        this.map[3][6]=cueva;
        this.map[9][2]=mazmorra;
    }
    
    public void generarMapa(){
        genera(1,1,llano);
        genera(7,2,bosque);
        genera(7,7,nieve);
        genera(2,7,montaña);
    }
    
    public void genera(int x, int y, Terreno ind){
        int aux=0;
        
        if(map[x][y].equals(null))
                map[x][y]=ind;  
            
        for (int e = 0; e < 3; e++) { 
            aux++;
            for (int w = 0; w < aux; w++) {
                x++;
                if(x>=0 && y>=0 && x<tam && y<tam){
                    if(map[x][y]==null)
                        map[x][y]=ind;
                }
            }
            for (int r = 0; r < aux; r++) {
                y++;
                if(x>=0 && y>=0 && x<tam && y<tam){
                    if(map[x][y]==null)
                        map[x][y]=ind;
                }
            }
            aux++;
            for (int t = 0; t < aux; t++) {
                x--;
                if(x>=0 && y>=0 && x<tam && y<tam){
                    if(map[x][y]==null)
                        map[x][y]=ind;
                }
            }
            for (int u = 0; u < aux; u++) {
                y--;
                if(x>=0 && y>=0 && x<tam && y<tam){
                    if(map[x][y]==null)
                        map[x][y]=ind;
                }
            }
        }   
    }
    
    
    
    public void mostrarMapa(){
        for (int i = 0; i < tam; i++) {
            for (int j = 0; j < tam; j++) {
                Terreno a=map[i][j];
                System.out.println(a.getNombre());
            }
        }
    }   
}