/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package videojuegos.pec1.mapas;

import java.awt.GridLayout;
import java.util.Scanner;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.WindowConstants;

/**
 *
 * @author pedro
 */
public class PruebaMapa {

    
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {

      Mapa mapa=new Mapa();
      
      mapa.generacionMapa();
      
      JFrame v = new JFrame();
      v.setLayout (new GridLayout (10,10));
      
      JLabel label[][] = new JLabel[10][10];
      for (int r=0;r<10;r++)
            for (int p = 0; p < 10; p++) {
                label[r][p] = new JLabel();
            }
        
      for (int i = 0; i < 10; i++) {
            for (int j = 0; j < 10; j++) {
                ImageIcon a= mapa.getContenido(i, j).getImagen();
                label[i][j].setIcon(a);
            }
      }
      
      for (int z=0;z<10;z++)
            for (int u = 0; u < 10; u++) {
                v.add(label[z][u]);
            }
      
      v.pack();
      v.setVisible(true);
      v.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
    }
    
}
