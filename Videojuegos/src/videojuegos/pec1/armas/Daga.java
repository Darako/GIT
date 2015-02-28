/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package videojuegos.pec1.armas;

/**
 *
 * @author Guillermo
 */
public class Daga extends Arma{
    
    //ATRIBUTOS
    private int resistencia;

    //CONSTRUCTOR
    public Daga(int resistencia, String nombre, int durabilidad, int ataque, int ataque_magico) {
        super(nombre, durabilidad, ataque, ataque_magico);
        this.resistencia = resistencia;
    }   

    //GETTER & SETTER
    public int getResistencia() {
        return resistencia;
    }
    public void setResistencia(int resistencia) {
        this.resistencia = resistencia;
    }

    //METODOS
    public void usar(){
        this.resistencia--;
    }
    
    public boolean estaDisponible(){
        int restante = this.resistencia;
        return restante != 0;
    }

    @Override
    public String toString() {
        return "Daga{" + "resistencia=" + resistencia + '}';
    }

    
    
}
