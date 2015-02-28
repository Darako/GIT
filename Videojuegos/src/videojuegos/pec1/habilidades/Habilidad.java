/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package videojuegos.pec1.habilidades;

/**
 *
 * @author Jorge
 */
public class Habilidad {
    
    //ATRIBUTOS
    private String tipo_danyo;        
    private int efecto;    
    private String nombre;    
    private int experiencia;    
    private int coste;
    
    //CONSTRUCTOR
    public Habilidad(String nombre, String tipo_danyo, int efecto, int coste, int experiencia) {
        this.nombre = nombre;
        this.tipo_danyo = tipo_danyo;
        this.efecto = efecto;
        this.coste = coste;
        this.experiencia = experiencia;
    }  
    
    //GETTER & SETTER
    public int getCoste() {
        return coste;
    }
    public void setCoste(int coste) {
        this.coste = coste;
    }
    public int getExperiencia() {
        return experiencia;
    }
    public void setExperiencia(int experiencia) {
        this.experiencia = experiencia;
    }
    public String getNombre() {
        return nombre;
    }
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    public int getEfecto() {
        return efecto;
    }
    public void setEfecto(int efecto) {
        this.efecto = efecto;
    }
    public String getTipo_danyo() {
        return tipo_danyo;
    }    
    public void setTipo_danyo(String tipo_danyo) {
        this.tipo_danyo = tipo_danyo;
    }    
    
    //METODOS

    @Override
    public String toString() {
        return "Habilidad{" + "tipo_danyo=" + tipo_danyo + ", efecto=" + efecto + ", nombre=" + nombre + ", experiencia=" + experiencia + ", coste=" + coste + '}';
    }
    
}
