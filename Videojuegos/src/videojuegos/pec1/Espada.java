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
public class Espada extends Arma{
    
    //ATRIBUTOS
    private int resistencia;

    //CONSTRUCTOR
    public Espada(String nombre, int danyo, int resistencia) {
        super(nombre, danyo);
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
    
    @Override
    public String toString() {
        return "\nNombre: "+super.getNombre()+"\nDaño: "+super.getDanyo()+"\nResistencia: "+resistencia;
    }

    
    
}
