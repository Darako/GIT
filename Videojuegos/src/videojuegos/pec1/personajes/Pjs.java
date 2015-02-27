/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package videojuegos.pec1.personajes;

import java.io.Serializable;
import videojuegos.pec1.armas.Arma;
import videojuegos.pec1.armaduras.Armadura;
import java.util.ArrayList;

/**
 *
 * @author Guillermo
 */
public class Pjs implements Serializable{
    
    //ATRIBUTOS
    private String nombre;
    private int pv;
    private int pm;
    private int ataque;
    private int ataque_magico;
    private int defensa;
    private int defensa_magica;
    private int nivel;
    private int exp;
    //private int exp_sig_nivel;
    //private Habilidad habilidad;
    private Arma arma;
    private Armadura armadura;

    //CONSTRUCTOR
    public Pjs(String nombre, int pv, int pm, int ataque, int ataque_magico, int defensa, int defensa_magica, int nivel, int exp/** int exp_sig_nivel, Habilidad habilidad, Arma arma, Armadura armadura**/) {
        this.nombre = nombre;
        this.pv = pv;
        this.pm = pm;
        this.ataque = ataque;
        this.ataque_magico = ataque_magico;
        this.defensa = defensa;
        this.defensa_magica = defensa_magica;
        this.nivel = nivel;
        this.exp = exp;
        //this.exp_sig_nivel = exp_sig_nivel;
        //this.habilidad = habilidad;
        //this.arma = arma;
        //this.armadura = armadura;
    }
    
    //GETTER & SETTER
    public String getNombre() {
        return nombre;
    }
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    
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

    public int getAtaque() {
        return ataque;
    }
    public void setAtaque(int ataque) {
        this.ataque = ataque;
    }      

    public int getAtaque_magico() {
        return ataque_magico;
    }
    public void setAtaque_magico(int ataque_magico) {
        this.ataque_magico = ataque_magico;
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

    public int getNivel() {
        return nivel;
    }
    public void setNivel(int nivel) {
        this.nivel = nivel;
    }

    public int getExp() {
        return exp;
    }
    public void setExp(int exp) {
        this.exp = exp;
    }       
    /**
    public int getExp_sig_nivel() {
        return exp_sig_nivel;
    }
    public void setExp_sig_nivel(int exp_sig_nivel) {
        this.exp_sig_nivel = exp_sig_nivel;
    }
    
    public Habilidad getHabilidad() {
        return habilidad;
    }
    public void setHabilidad(Habilidad habilidad) {
        this.habilidad = habilidad;
    }        
    **/
    public Arma getArma() {
        return arma;
    }
    public void setArma(Arma arma) {
        this.arma = arma;
    }

    public Armadura getArmadura() {
        return armadura;
    }
    public void setArmadura(Armadura armadura) {
        this.armadura = armadura;
    }

    //MÉTODOS

    @Override
    public String toString() {
        return "Pjs{" + "nombre=" + nombre + ", pv=" + pv + ", pm=" + pm + ", ataque=" + ataque + ", ataque_magico=" + ataque_magico + ", defensa=" + defensa + ", defensa_magica=" + defensa_magica + ", nivel=" + nivel + ", exp=" + exp + ", arma=" + arma + ", armadura=" + armadura + '}';
    }
    
    public void equiparArmadura(Armadura armadura){
        int pvEquipado = this.pv + armadura.getPv();
        int pmEquipado = this.pm + armadura.getPm();
        int defensaEquipado = this.defensa + armadura.getDefensa();
        int defensaMEquipado = this.defensa_magica + armadura.getDefensa_magica();
        
        this.setArmadura(armadura);
        this.setPv(pvEquipado);
        this.setPm(pmEquipado);
        this.setDefensa(defensaEquipado);
        this.setDefensa_magica(defensaMEquipado);
    }
    
}
