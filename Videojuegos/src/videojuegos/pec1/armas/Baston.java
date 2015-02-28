/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package videojuegos.pec1.armas;

/**
 *
 * @author Jorge
 */
public class Baston extends Arma{
    
    //ATRIBUTOS
    private int magia;

    //CONSTRUCTOR
    public Baston(String nombre, int durabilidad, int ataqueFisico, int ataqueMagico, int magia) {
        super(nombre, durabilidad, ataqueFisico, ataqueMagico);
        this.magia = magia;
    }    

    //GETTER & SETTER
    public int getMagia() {
        return magia;
    }
    public void setMagia(int magia) {
        this.magia = magia;
    }
    
    //METODOS
    @Override
    public void usar(){
        this.magia--;
    }

    @Override
    public boolean estaDisponible(){
        int restante = this.magia;
        return restante != 0;
    }

    @Override
    public String toString() {
        return "Baston{" + "magia=" + magia + '}';
    }
    
    

    
    
}
