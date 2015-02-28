/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package videojuegos.pec1.personajes;

import videojuegos.pec1.habilidades.Habilidad;
import java.io.Serializable;
import videojuegos.pec1.armas.Arma;
import videojuegos.pec1.armaduras.Armadura;
import java.util.ArrayList;
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
    public Personaje(String nombre, int pv, int pm, int ataque, int ataque_magico, int defensa, int defensa_magica, int nivel, int exp/** int exp_sig_nivel, Habilidad habilidad, Arma arma, Armadura armadura**/) {
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
     * @return 
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
    
    public boolean estaDerrotado(){
        return this.pv <= 0;
    }
    
    public boolean estaExhausto()
    {
        return this.estaExhausto();
    }
    
    public void gastar(){}
    
    public void usarHabilidad(Habilidad habilidad, Personaje personaje){
        int danyo = habilidad.getEfecto();
        personaje.setPv(personaje.getPv()+danyo);
    }

    public void combatir(ArrayList<Personaje> luchadores){ 
        int i = 0;
        int herida = 0;
        while((!(luchadores.get(0).estaDerrotado())) || (!(luchadores.get(1).estaDerrotado())))
        {
            if(i==0)
            {   
                herida = luchadores.get(i).atacar(luchadores.get(i+1));
                if((luchadores.get(i).estaDerrotado()) || (luchadores.get(i+1).estaDerrotado()) || (herida==0)){
                    break;
                }
                luchadores.get(i+1).setPv((luchadores.get(i+1).getPv()) - herida);                
                System.out.println("Pegaron a "+luchadores.get(i+1).getNombre()+", "+herida+" de daño.\nVida: "+luchadores.get(i+1).getPv()+"\n");
                i++;
            }
            if(i==1)
            {
                herida = luchadores.get(i).atacar(luchadores.get(i-1));                
                if((luchadores.get(i).estaDerrotado()) || (luchadores.get(i-1).estaDerrotado())  || (herida==0) ){
                    break;
                }
                luchadores.get(i-1).setPv((luchadores.get(i-1).getPv()) - herida);                
                System.out.println("Pegaron a "+luchadores.get(i-1).getNombre()+", "+herida+" de daño.\nVida: "+luchadores.get(i-1).getPv()+"\n");
                i--;
            }            
        }
    }
    
    private int atacar(Personaje per){
        int cantidad = 0;
        if(this.getArma().estaDisponible())
        {
            cantidad = cantidad + this.getArma().getAtaque();
            this.getArma().usar();
        }
        if(!this.estaExhausto())
        {
            cantidad = cantidad + this.getDestreza();
            this.gastar();
        }
        return cantidad;
        
        
    }
     /** @param pieza    
    **/
    
    public void actualizarArmadura(Casco pieza){
        Casco piezaAux = this.getArmadura().getCasco();
        
        this.setPv(this.getPv() - piezaAux.getPv());
        this.setPm(this.getPm() - piezaAux.getPm());
        this.setDefensa(this.getDefensa() - piezaAux.getDefensa());
        this.setDefensa_magica(this.getDefensa_magica() - piezaAux.getDefensa_magica());
        this.getArmadura().setCasco(pieza);
        this.setPv(this.getPv() + piezaAux.getPv());
        this.setPm(this.getPm() + piezaAux.getPm());
        this.setDefensa(this.getDefensa() + piezaAux.getDefensa());
        this.setDefensa_magica(this.getDefensa_magica() + piezaAux.getDefensa_magica());
    }
    
    public void actualizarArmadura(Guantes pieza){
        Guantes piezaAux = this.getArmadura().getGuantes();
        
        this.setPv(this.getPv() - piezaAux.getPv());
        this.setPm(this.getPm() - piezaAux.getPm());
        this.setDefensa(this.getDefensa() - piezaAux.getDefensa());
        this.setDefensa_magica(this.getDefensa_magica() - piezaAux.getDefensa_magica());
        this.getArmadura().setGuantes(pieza);
        this.setPv(this.getPv() + piezaAux.getPv());
        this.setPm(this.getPm() + piezaAux.getPm());
        this.setDefensa(this.getDefensa() + piezaAux.getDefensa());
        this.setDefensa_magica(this.getDefensa_magica() + piezaAux.getDefensa_magica());
    }
    
    public void actualizarArmadura(Pechera pieza){
        Pechera piezaAux = this.getArmadura().getPechera();
        
        this.setPv(this.getPv() - piezaAux.getPv());
        this.setPm(this.getPm() - piezaAux.getPm());
        this.setDefensa(this.getDefensa() - piezaAux.getDefensa());
        this.setDefensa_magica(this.getDefensa_magica() - piezaAux.getDefensa_magica());
        this.getArmadura().setPechera(pieza);
        this.setPv(this.getPv() + piezaAux.getPv());
        this.setPm(this.getPm() + piezaAux.getPm());
        this.setDefensa(this.getDefensa() + piezaAux.getDefensa());
        this.setDefensa_magica(this.getDefensa_magica() + piezaAux.getDefensa_magica());
    }
    
    public void actualizarArmadura(Botas pieza){
        Botas piezaAux = this.getArmadura().getBotas();
        
        this.setPv(this.getPv() - piezaAux.getPv());
        this.setPm(this.getPm() - piezaAux.getPm());
        this.setDefensa(this.getDefensa() - piezaAux.getDefensa());
        this.setDefensa_magica(this.getDefensa_magica() - piezaAux.getDefensa_magica());
        this.getArmadura().setBotas(pieza);
        this.setPv(this.getPv() + piezaAux.getPv());
        this.setPm(this.getPm() + piezaAux.getPm());
        this.setDefensa(this.getDefensa() + piezaAux.getDefensa());
        this.setDefensa_magica(this.getDefensa_magica() + piezaAux.getDefensa_magica());
    }
    
   public void actualizarArma(Arma pieza){
        Arma piezaAux = this.getArma();
        
        this.setAtaque(this.getAtaque() - piezaAux.getAtaque());
        this.setAtaque_magico(this.getAtaque_magico() - piezaAux.getAtaque_magico());
        this.setArma(pieza);
        this.setAtaque(this.getAtaque() + piezaAux.getAtaque());
        this.setAtaque_magico(this.getAtaque_magico() + piezaAux.getAtaque_magico());        
   }
   
   
    @Override
    public String toString() {
        return "Pjs{" + "nombre=" + nombre + ", pv=" + pv + ", pm=" + pm + ", ataque=" + ataque + ", ataque_magico=" + ataque_magico + ", defensa=" + defensa + ", defensa_magica=" + defensa_magica + ", nivel=" + nivel + ", exp=" + exp + ", arma=" + arma + ", armadura=" + armadura + '}';
    }
}
