/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package videojuegos.pec1;

import habilidades.Habilidad;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Scanner;
import videojuegos.pec1.armaduras.Armadura;
import videojuegos.pec1.armas.Arma;
import videojuegos.pec1.enemigos.Enemigo;
import videojuegos.pec1.personajes.Personaje;

/**
 *
 * @author Jorge
 */
public class Juego { 
    //LISTAS
    public static ArrayList<Personaje> personajes = new ArrayList<Personaje>();
    public static ArrayList<Arma> armas = new ArrayList<Arma>();
    public static ArrayList<Armadura> armaduras = new ArrayList<Armadura>();
    public static ArrayList<Enemigo> enemigos = new ArrayList<Enemigo>();
    public static ArrayList<Habilidad> habilidades = new ArrayList<Habilidad>();
       
    
    //CONSTRUCTOR
    public Juego() throws FileNotFoundException {
             
    }
    
    //GETTER & SETTER
    public  ArrayList<Personaje> getPersonajes() {
        return personajes;
    }
    public void setPersonas(ArrayList<Personaje> personajes) {
        Juego.personajes = personajes;
    }    
    public ArrayList<Arma> getArmas() {
        return armas;
    }
    public void setArmas(ArrayList<Arma> armas) {
        Juego.armas = armas;
    }    
    public  ArrayList<Personaje> getArmadura() {
        return personajes;
    }
    public void setArmadura(ArrayList<Armadura> armadura) {
        Juego.armaduras = armaduras;
    }    
    public ArrayList<Enemigo> getEnemigos() {
        return enemigos;
    }
    public void setEnemigos(ArrayList<Enemigo> enemigos) {
        Juego.enemigos = enemigos;
    }    
    public ArrayList<Habilidad> getHabilidades() {
        return habilidades;
    }
    public void setHabilidades(ArrayList<Habilidad> habilidades) {
        Juego.habilidades = habilidades;
    }
        
    //METODOS
    public void nuevaPartida(){
        
    }    
    public void reiniciar(){
        
    }    
    public void iniciarJuego(){
        
    }   
    public void iniciarDatos() throws FileNotFoundException{
        this.cargarPersonajes(personajes, "personajes");
        this.cargarArmas("armas");
        //this.armaduras = cargarDatos("armaduras");
        //this.enemigos = cargarDatos("enemigos");
        //this.habilidades = cargarDatos("habilidades");
    } 
        
    public void guardarObjeto(ArrayList datos, String nombre) {
        try{
            ObjectOutputStream ficheroSalida = new ObjectOutputStream(new FileOutputStream(nombre+".dat"));
            ficheroSalida.writeObject(datos);
            ficheroSalida.flush();
            ficheroSalida.close();
        }catch (IOException ioe) {
            System.out.println("Error IO: " + ioe.toString());
        } catch (Exception e) {
            System.out.println("Error: " + e.toString());
        }
    }
    
    public void cargarArmas(String nombre){
        try{
            ObjectInputStream ficheroEntrada = new ObjectInputStream(new FileInputStream(nombre+".dat"));
            armas = (ArrayList) ficheroEntrada.readObject();
            ficheroEntrada.close();            
        } catch (ClassNotFoundException cnfe) {
            System.out.println("Error de clase no encontrada:" + cnfe.toString());
        }catch (IOException ioe) {
            System.out.println("Error IO:" + ioe.toString());
        } catch (Exception e) {
            System.out.println("Error: " + e.toString());
        }
    }
    
    public void cargarPersonajes(ArrayList clase, String nombre){
        try{
            ObjectInputStream ficheroEntrada = new ObjectInputStream(new FileInputStream(nombre+".dat"));
            clase = (ArrayList) ficheroEntrada.readObject();
            ficheroEntrada.close();            
        } catch (ClassNotFoundException cnfe) {
            System.out.println("Error de clase no encontrada:" + cnfe.toString());
        }catch (IOException ioe) {
            System.out.println("Error IO:" + ioe.toString());
        } catch (Exception e) {
            System.out.println("Error: " + e.toString());
        }
    }
    
}
