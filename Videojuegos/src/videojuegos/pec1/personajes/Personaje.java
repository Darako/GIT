/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package videojuegos.pec1.personajes;

import videojuegos.pec1.habilidades.Habilidad;
import java.io.Serializable;
import videojuegos.pec1.armas.Arma;
import videojuegos.pec1.armaduras.Casco;
import videojuegos.pec1.armaduras.Guantes;
import videojuegos.pec1.armaduras.Pechera;
import videojuegos.pec1.armaduras.Botas;



/**
 *
 * @author Guillermo
 */
public class Personaje implements Serializable{
    
    //ATRIBUTOS
    private String nombre;
    private int pv;
    private int pm;
    private int pvMax;
    private int pmMax;
    private int ataqueFisico;
    private int ataqueMagico;
    private int defensaFisica;
    private int defensaMagica;
    private int nivel;
    private int exp;
    private Habilidad habilidad;
    private Arma arma;
    private Casco casco;
    private Pechera pechera;
    private Botas botas;
    private Guantes guantes;

    //CONSTRUCTOR

    public Personaje(String nombre, int pvMax, int pmMax, int ataqueFisico, int ataqueMagico, int defensaFisica, int defensaMagica) {
        this.nombre = nombre;
        this.pv = pvMax;
        this.pm = pmMax;
        this.pvMax = pvMax;
        this.pmMax = pmMax;
        this.ataqueFisico = ataqueFisico;
        this.ataqueMagico = ataqueMagico;
        this.defensaFisica = defensaFisica;
        this.defensaMagica = defensaMagica;
        this.nivel = 0;
        this.exp = 0;
    }
    
    //GETTER & SETTER
    public String getNombre() {
        return nombre;
    }
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }    
    public int getPvMax() {
        return pvMax;
    }
    public void setPvMax(int pvMax) {
        this.pvMax = pvMax;
    }       
    public int getPmMax() {
        return pmMax;
    }
    public void setPmMax(int pmMax) {
        this.pmMax = pmMax;
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
    public int getAtaqueFisico() {
        return ataqueFisico;
    }
    public void setAtaqueFisico(int ataqueFisico) {
        this.ataqueFisico = ataqueFisico;
    } 
    public int getAtaqueMagico() {
        return ataqueMagico;
    }
    public void setAtaqueMagico(int ataqueMagico) {
        this.ataqueMagico = ataqueMagico;
    }
    public int getDefensaFisica() {
        return defensaFisica;
    }
    public void setDefensaFisica(int defensaFisica) {
        this.defensaFisica = defensaFisica;
    }
    public int getDefensaMagica() {
        return defensaMagica;
    }
    public void setDefensaMagica(int defensaMagica) {
        this.defensaMagica = defensaMagica;
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
    public Habilidad getHabilidad() {
        return habilidad;
    }
    public void setHabilidad(Habilidad habilidad) {
        this.habilidad = habilidad;
    }
    public Arma getArma() {
        return arma;
    }
    public void setArma(Arma arma) {
        this.arma = arma;
    }
    public Casco getCasco() {
        return casco;
    }
    public void setCasco(Casco casco) {
        this.casco = casco;
    }
    public Pechera getPechera() {
        return pechera;
    }
    public void setPechera(Pechera pechera) {
        this.pechera = pechera;
    }
    public Botas getBotas() {
        return botas;
    }
    public void setBotas(Botas botas) {
        this.botas = botas;
    }
    public Guantes getGuantes() {
        return guantes;
    }
    public void setGuantes(Guantes guantes) {
        this.guantes = guantes;
    }
        
    //MÉTODOS    
    public boolean estaDerrotado(){
        return this.pvMax <= 0;
    }
    
    public boolean estaExhausto()
    {
        return this.estaExhausto();
    }
    
    public void gastar(){} 
    
    public void combatir(String accion, Personaje personaje){ 
        switch(accion){
            case "Atacar":  {
                                this.atacar(personaje);
                                break;
                            }
            case "Habilidades": {
                                    this.usarHabilidad(habilidad, personaje);
                                    break;
                                }
            case "Huir":{
                            this.huir();
                            break;
                        }
        }
        
    }
    
    private void atacar(Personaje personaje){
        personaje.setPv(personaje.getPv() - this.ataqueFisico);
    }
    
    public void usarHabilidad(Habilidad habilidad, Personaje personaje){
        int danyo = habilidad.getEfecto();
        personaje.setPvMax(personaje.getPvMax()+danyo);
    }
    
    private void huir() {
        
    }
        
    public void actualizarArmadura(Casco pieza){
        if(this.casco != null){
            Casco piezaAux = this.getCasco();        
            this.setPvMax(this.getPvMax() - piezaAux.getPv());
            this.setPmMax(this.getPmMax() - piezaAux.getPm());
            this.setPv(this.getPv() - piezaAux.getPv());
            this.setPm(this.getPm() - piezaAux.getPm());
            this.setDefensaFisica(this.getDefensaFisica() - piezaAux.getDefensaFisica());
            this.setDefensaMagica(this.getDefensaMagica() - piezaAux.getDefensaMagica());
            this.setCasco(pieza);
            this.setPvMax(this.getPvMax() + pieza.getPv());
            this.setPmMax(this.getPmMax() + pieza.getPm());
            this.setDefensaFisica(this.getDefensaFisica() + pieza.getDefensaFisica());
            this.setDefensaMagica(this.getDefensaMagica() + pieza.getDefensaMagica());
        }else{
            this.setCasco(pieza);
            this.setPvMax(this.getPvMax() + pieza.getPv());
            this.setPmMax(this.getPmMax() + pieza.getPm());
            this.setDefensaFisica(this.getDefensaFisica() + pieza.getDefensaFisica());
            this.setDefensaMagica(this.getDefensaMagica() + pieza.getDefensaMagica());
        }
    }
    
    public void actualizarArmadura(Guantes pieza){
        if(this.guantes != null){
            Guantes piezaAux = this.getGuantes();        
            this.setPvMax(this.getPvMax() - piezaAux.getPv());
            this.setPmMax(this.getPmMax() - piezaAux.getPm());
            this.setPv(this.getPv() - piezaAux.getPv());
            this.setPm(this.getPm() - piezaAux.getPm());
            this.setDefensaFisica(this.getDefensaFisica() - piezaAux.getDefensaFisica());
            this.setDefensaMagica(this.getDefensaMagica() - piezaAux.getDefensaMagica());
            this.setGuantes(pieza);
            this.setPvMax(this.getPvMax() + pieza.getPv());
            this.setPmMax(this.getPmMax() + pieza.getPm());
            this.setDefensaFisica(this.getDefensaFisica() + pieza.getDefensaFisica());
            this.setDefensaMagica(this.getDefensaMagica() + pieza.getDefensaMagica());
        }else{
            this.setGuantes(pieza);
            this.setPvMax(this.getPvMax() + pieza.getPv());
            this.setPmMax(this.getPmMax() + pieza.getPm());
            this.setDefensaFisica(this.getDefensaFisica() + pieza.getDefensaFisica());
            this.setDefensaMagica(this.getDefensaMagica() + pieza.getDefensaMagica());
        }
    }
    
    public void actualizarArmadura(Pechera pieza){
        if(this.pechera != null){
            Pechera piezaAux = this.getPechera();        
            this.setPvMax(this.getPvMax() - piezaAux.getPv());
            this.setPmMax(this.getPmMax() - piezaAux.getPm());
            this.setPv(this.getPv() - piezaAux.getPv());
            this.setPm(this.getPm() - piezaAux.getPm());
            this.setDefensaFisica(this.getDefensaFisica() - piezaAux.getDefensaFisica());
            this.setDefensaMagica(this.getDefensaMagica() - piezaAux.getDefensaMagica());
            this.setPechera(pieza);
            this.setPvMax(this.getPvMax() + piezaAux.getPv());
            this.setPmMax(this.getPmMax() + piezaAux.getPm());
            this.setDefensaFisica(this.getDefensaFisica() + pieza.getDefensaFisica());
            this.setDefensaMagica(this.getDefensaMagica() + pieza.getDefensaMagica());
        }else{
            this.setPechera(pieza);
            this.setPvMax(this.getPvMax() + pieza.getPv());
            this.setPmMax(this.getPmMax() + pieza.getPm());
            this.setDefensaFisica(this.getDefensaFisica() + pieza.getDefensaFisica());
            this.setDefensaMagica(this.getDefensaMagica() + pieza.getDefensaMagica());    
        }
    }
    
    public void actualizarArmadura(Botas pieza){
        if(this.botas != null){
            Botas piezaAux = this.getBotas();        
            this.setPvMax(this.getPvMax() - piezaAux.getPv());
            this.setPmMax(this.getPmMax() - piezaAux.getPm());
            this.setPv(this.getPv() - piezaAux.getPv());
            this.setPm(this.getPm() - piezaAux.getPm());
            this.setDefensaFisica(this.getDefensaFisica() - piezaAux.getDefensaFisica());
            this.setDefensaMagica(this.getDefensaMagica() - piezaAux.getDefensaMagica());
            this.setBotas(pieza);
            this.setPvMax(this.getPvMax() + piezaAux.getPv());
            this.setPmMax(this.getPmMax() + piezaAux.getPm());
            this.setDefensaFisica(this.getDefensaFisica() + pieza.getDefensaFisica());
            this.setDefensaMagica(this.getDefensaMagica() + pieza.getDefensaMagica());
        }else{
            this.setBotas(pieza);
            this.setPvMax(this.getPvMax() + pieza.getPv());
            this.setPmMax(this.getPmMax() + pieza.getPm());
            this.setDefensaFisica(this.getDefensaFisica() + pieza.getDefensaFisica());
            this.setDefensaMagica(this.getDefensaMagica() + pieza.getDefensaMagica());    
        }
    }
    
    public void actualizarArma(Arma pieza){
        if(this.arma != null){
            Arma piezaAux = this.getArma();        
            this.setAtaqueFisico(this.getAtaqueFisico() - piezaAux.getAtaqueFisico());
            this.setAtaqueMagico(this.getAtaqueMagico() - piezaAux.getAtaqueMagico());
            this.setArma(pieza);
            this.setAtaqueFisico(this.getAtaqueFisico() + pieza.getAtaqueFisico());
            this.setAtaqueMagico(this.getAtaqueMagico() + pieza.getAtaqueMagico()); 
        }else{
            this.setArma(pieza);
            this.setAtaqueFisico(this.getAtaqueFisico() + pieza.getAtaqueFisico());
            this.setAtaqueMagico(this.getAtaqueMagico() + pieza.getAtaqueMagico());    
        }
    }
   
   
    @Override
    public String toString() {
        return "Nombre: "+this.nombre+"\nNivel: "+this.nivel+"\nExperiencia: "+this.exp
              +"\nPV: "+this.pv+"/"+this.pvMax+"\nPM: "+this.pm+"/"+this.pmMax
              +"\nAtaque Físico: "+this.ataqueFisico+"\nAtaque Mágico: "+this.ataqueMagico+"\nDefensa Física: "+this.defensaFisica+"\nDefensa Mágica: "+this.defensaMagica;
    }
}
