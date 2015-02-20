/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package videojuegos.pec1;

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
        
        Arco arco1 = new Arco("Tirachinas de Bart", 5, 10);
        Espada espada1 = new Espada("Palo de Selfie", 5, 20);
        Baston baston1 = new Baston("Palillo de los Oidos", 5, 15);
        
        Arma baul[] = new Arma[3];
        
        baul[0] = arco1;
        baul[1] = espada1;
        baul[2] = baston1;
        
        arco1.usar();
        espada1.usar();
        baston1.usar();
          
        for(int i=0;i<baul.length;i++)
        {
            System.out.println(baul[i].toString());
        }
       
        Personaje per1 = new Personaje(espada1, 50, "Juanito Calavera", 15);
        Personaje per2 = new Personaje(arco1, 50, "Valde Derramas", 15);
        per1.atacar(per2);
        System.out.println(per1.toString());
        System.out.println(per2.toString());
        
       
    }
    
}
