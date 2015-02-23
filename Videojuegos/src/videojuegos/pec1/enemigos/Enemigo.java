/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package videojuegos.pec1.enemigos;

/**
 *
 * @author noesmoral
 */
public class Enemigo {
         
    private String nombre;  
    private int danyo;
    private int vida;
    
    //CONSTRUCTOR
    public Enemigo(String nombre,int danyo,int vida){
        this.nombre=nombre;
        this.danyo=danyo;
        this.vida=vida;        
    }
    
    //METODOS GET/SET
    public String getNombre(){
        return nombre;
    }
    
    public void setNombre(String nombre){
        this.nombre=nombre;
    }
    
    public int getVida(){
        return vida;
    }
    
    public void setVida(int vida){
        this.vida=vida;
    }
    
    public int getDanyo(){
        return danyo;
    }
    
    public void setDanyo(int danyo){
        this.danyo=danyo;
    }
    
    @Override
    public String toString() {
        return "\nNombre: "+nombre+"\nDaño: "+danyo+"\nVida: "+vida;
    }  
}
