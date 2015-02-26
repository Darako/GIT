/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package videojuegos.pec1.mapas;

/**
 *
 * @author pedro
 */
public class PruebaMapa {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        
      Mapa mapa=new Mapa();
      
      mapa.generarMapa();
      mapa.mostrarMapa();
      System.out.println(mapa.mostrarContenido(1, 3));
    }
    
}
