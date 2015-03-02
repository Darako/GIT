/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package videojuegos.pec1.personajes;

import videojuegos.pec1.habilidades.Habilidad;
import videojuegos.pec1.armas.Arma;

/**
 *
 * @author Guillermo
 */
public class Kender extends Personaje{
     
    //ATRIBUTOS
    private int energia;

    //CONSTRUCTOR
    public Kender(String nombre, int pvMax, int pmMax, int ataqueFisico, int ataqueMagico, int defensaFisica, int defensaMagica, int energia) {
        super(nombre, pvMax, pmMax, ataqueFisico, ataqueMagico, defensaFisica, defensaMagica);
        this.energia = energia;
    }       

    //GETTER & SETTER
    public int getEnergia() {
        return energia;
    }
    public void setEnergia(int energia) {
        this.energia = energia;
    }
    
    //METODOS
    @Override
    public boolean estaExhausto()
    {
        return this.energia == 0;
    }    
    
    @Override
    public void gastar(){
        this.energia--;
    }
    
    @Override
    public String toString() {
        StringBuilder equipo = new StringBuilder();
        if(this.getArma()!=null){equipo.append(this.getArma().toString());}
        if(this.getCasco()!=null){equipo.append(this.getCasco().toString());}
        if(this.getPechera()!=null){equipo.append(this.getPechera().toString());}
        if(this.getBotas()!=null){equipo.append(this.getBotas().toString());}
        if(this.getGuantes()!=null){equipo.append(this.getGuantes().toString());}
        return "KENDER\n"+super.toString()+"\nEnergia: "+this.energia+"\n\nEQUIPO:\n"+equipo;
    }

    
}
