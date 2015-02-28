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
public class Armaca {
    
    //ATRIBUTOS
    private Bastonaco bastonaco;
    private Dagon dagon;
    private Espadaca espadaca;

    //CONSTRUCTORES
    public Armaca(Bastonaco bastonaco) {
        this.bastonaco = bastonaco;
    }

    public Armaca(Dagon dagon) {
        this.dagon = dagon;
    }

    public Armaca(Espadaca espadaca) {
        this.espadaca = espadaca;
    }

    //GETTER & SETTER
    public Bastonaco getBastonaco() {
        return bastonaco;
    }
    public void setBastonaco(Bastonaco bastonaco) {
        this.bastonaco = bastonaco;
    }   

    public Dagon getDagon() {
        return dagon;
    }
    public void setDagon(Dagon dagon) {
        this.dagon = dagon;
    }   

    public Espadaca getEspadaca() {
        return espadaca;
    }
    public void setEspadaca(Espadaca espadaca) {
        this.espadaca = espadaca;
    }

    //MÉTODOS   
    @Override
    public String toString() {
        return "Armaca{" + "bastonaco=" + bastonaco + ", dagon=" + dagon + ", espadaca=" + espadaca + '}';
    }
    
}
