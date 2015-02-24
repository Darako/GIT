/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package videojuegos.pec1;

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
    //public static ArrayList<Armadura> armaduras = new ArrayList<Armadura>();
    //public static ArrayList<Enemigo> enemigos = new ArrayList<Enemigo>();
       
    
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
    
    
    //METODOS
    public void nuevaPartida(){
        
    }    
    public void reiniciar(){
        
    }    
    public void iniciarJuego(){
        
    }   
    public void iniciarDatos() throws FileNotFoundException{
        this.cargarPersonajes("personajes");
        this.cargarArmas("armas");
        //this.armaduras = cargarDatos(personajes);
        //this.enemigos = cargarDatos(personajes);
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
    
    public void cargarPersonajes(String nombre){
        try{
            ObjectInputStream ficheroEntrada = new ObjectInputStream(new FileInputStream(nombre+".dat"));
            personajes = (ArrayList) ficheroEntrada.readObject();
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
