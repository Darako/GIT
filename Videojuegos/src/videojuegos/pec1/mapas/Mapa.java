/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package videojuegos.pec1.mapas;

import java.util.Random;

/**
 *
 * @author pedro
 */
public class Mapa {
    
    public String map[][]=new String[10][10];
    Random r = new Random();
    
    public Mapa(){
        
    }
    
    public void generarMapa(){
        int resultado;
        for (int i = 0; i < 10; i++) {
            for (int j = 0; j < 10; j++) {
                resultado=r.nextInt((10-0)+1)+0;
                switch (resultado){
                    case 0:this.map[i][j]="P";
                            break;
                    case 1:this.map[i][j]="M";
                            break;
                    case 2:this.map[i][j]="E";
                            break;
                    default:this.map[i][j]="X";
                            break;
                }
            }
        }
        
    }
    
    public void mostrarMapa(){
        for (int i = 0; i < 10; i++) {
            for (int j = 0; j < 10; j++) {
                System.out.print(map[i][j]);
            }
            System.out.println("");
        }
    }
    
    public String mostrarContenido(int x,int y){
        return this.map[x][y];
    }
}
