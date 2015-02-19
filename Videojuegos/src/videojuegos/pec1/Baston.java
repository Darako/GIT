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
public class Baston extends Arma{
    
    //ATRIBUTOS
    private int magia;

    //CONSTRUCTOR
    public Baston(String nombre, int danyo, int magia) {
        super(nombre, danyo);
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
    public void usar(){
        this.magia--;
    }

    @Override
    public String toString() {
        return "\nNombre: "+super.getNombre()+"\nDaño: "+super.getDanyo()+"\nMagia: "+magia;
    }

    
    
}
