/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package videojuegos.pec1.armaduras;

/**
 *
 * @author Jorge
 */
public class Armadura {
    
    //ATRIBUTOS
    private int pv;
    private int pm;
    private int defensa;
    private int defensa_magica;
    private Botas botas;
    private Casco casco;
    private Guantes guantes;
    private Pechera pechera;

    //CONSTRUCTOR
    public Armadura(Botas botas, Casco casco, Guantes guantes, Pechera pechera) {
        this.pv = botas.getPv() + casco.getPv() + guantes.getPv() + pechera.getPv();
        this.pm = botas.getPm() + casco.getPm() + guantes.getPm() + pechera.getPm();
        this.defensa = botas.getDefensa() + casco.getDefensa() + guantes.getDefensa() + pechera.getDefensa();
        this.defensa_magica = botas.getDefensa_magica() + casco.getDefensa_magica() + guantes.getDefensa_magica() + pechera.getDefensa_magica();
        this.botas = botas;
        this.casco = casco;
        this.guantes = guantes;
        this.pechera = pechera;
            
    }
    
    //GETTER & SETTER

    public int getPv() {
        return pv;
    }
    public void setPv(int pv) {
        this.pv = pv;
    }       

    public int getPm() {
        return pm;
    }
    public void setPm(int pm) {
        this.pm = pm;
    }     

    public int getDefensa() {
        return defensa;
    }
    public void setDefensa(int defensa) {
        this.defensa = defensa;
    }
        
    public int getDefensa_magica() {
        return defensa_magica;
    }
    public void setDefensa_magica(int defensa_magica) {
        this.defensa_magica = defensa_magica;
    }

    public Botas getBotas() {
        return botas;
    }
    public void setBotas(Botas botas) {
        this.botas = botas;
    }

    public Casco getCasco() {
        return casco;
    }
    public void setCasco(Casco casco) {
        this.casco = casco;
    }

    public Guantes getGuantes() {
        return guantes;
    }
    public void setGuantes(Guantes guantes) {
        this.guantes = guantes;
    }

    public Pechera getPechera() {
        return pechera;
    }
    public void setPechera(Pechera pechera) {
        this.pechera = pechera;
    }

    
    //MÉTODOS

    @Override
    public String toString() {
        return "Armadura{" + "pv=" + pv + ", pm=" + pm + ", defensa=" + defensa + ", defensa_magica=" + defensa_magica + ", botas=" + botas + ", casco=" + casco + ", guantes=" + guantes + ", pechera=" + pechera + '}';
    }
    
    
    

}
