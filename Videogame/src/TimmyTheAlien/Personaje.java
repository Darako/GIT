/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package TimmyTheAlien;

import org.newdawn.slick.Animation;
import org.newdawn.slick.Image;
import org.newdawn.slick.Input;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.geom.Rectangle;

/**
 *
 * @author Jorge
 */
public class Personaje {
    
    private Input entrada;
    private Animation spritePersonaje, spriteAnterior, right, left, jumpRight, jumpLeft, stay, crouchRight, crouchLeft;
    private Rectangle personajeRect;
    
    private float personajeX, personajeY;
    private float velocidadX = 0f, velocidadY = 0f; 
    private float aceleracion = 0.25f;
    private float gravedad = 0.50f;
    private float fuerzaSalto = 0.50f;
    
    private boolean jumping = false;  
    
    Image [] movStay;
    Image [] movCrouchRight;
    Image [] movCrouchLeft;
    Image [] movJumpRight;
    Image [] movJumpLeft;
    Image [] movRight;
    Image [] movLeft;     

    int [] movDuration;
    int [] jumpDuration;

    public Personaje() throws SlickException 
    {
        this.movRight = new Image[]
                                {new Image("data\\Personaje\\Right\\p1_walk01.png"), 
                                new Image("data\\Personaje\\Right\\p1_walk02.png"), 
                                new Image("data\\Personaje\\Right\\p1_walk03.png"), 
                                new Image("data\\Personaje\\Right\\p1_walk04.png"), 
                                new Image("data\\Personaje\\Right\\p1_walk05.png"),             
                                new Image("data\\Personaje\\Right\\p1_walk06.png"), 
                                new Image("data\\Personaje\\Right\\p1_walk07.png"),             
                                new Image("data\\Personaje\\Right\\p1_walk08.png"),            
                                new Image("data\\Personaje\\Right\\p1_walk09.png"),
                                new Image("data\\Personaje\\Right\\p1_walk10.png"),
                                new Image("data\\Personaje\\Right\\p1_walk11.png")};
        
        this.movJumpLeft = new Image[]
                                {new Image("data\\Personaje\\Jump\\p1_jump_L.png")};
        
        this.movJumpRight = new Image[]
                                {new Image("data\\Personaje\\Jump\\p1_jump_R.png")};
        
        this.movCrouchLeft = new Image[]
                                {new Image("data\\Personaje\\Crouch\\p1_duck_L.png")};
        
        this.movLeft = new Image[]
                                {new Image("data\\Personaje\\Left\\p1_walk01.png"), 
                                new Image("data\\Personaje\\Left\\p1_walk02.png"), 
                                new Image("data\\Personaje\\Left\\p1_walk03.png"), 
                                new Image("data\\Personaje\\Left\\p1_walk04.png"), 
                                new Image("data\\Personaje\\Left\\p1_walk05.png"), 
                                new Image("data\\Personaje\\Left\\p1_walk06.png"), 
                                new Image("data\\Personaje\\Left\\p1_walk07.png"), 
                                new Image("data\\Personaje\\Left\\p1_walk08.png"), 
                                new Image("data\\Personaje\\Left\\p1_walk09.png"), 
                                new Image("data\\Personaje\\Left\\p1_walk10.png"), 
                                new Image("data\\Personaje\\Left\\p1_walk11.png")};
        
        this.movCrouchRight = new Image[]
                                {new Image("data\\Personaje\\Crouch\\p1_duck_R.png")};
        
        this.movStay = new Image[]
                                {new Image("data\\Personaje\\Front\\p1_front.png")};
        
        this.movDuration = new int[]
                                {100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100};
        
        this.jumpDuration = new int[]
                                {250};        
        
        this.spritePersonaje = stay;
        this.personajeRect = new Rectangle(personajeX,personajeY,spritePersonaje.getWidth(),spritePersonaje.getHeight());
    }
    
    private void movimiento(int delta)
    {
        //SI PULSAMOS BOTON ARRIBA
        if(entrada.isKeyDown(entrada.KEY_UP))
        {
            if(!enColision(personajeRect,"arriba"))
            {                
                if(spriteAnterior == left && !enColision(personajeRect,"izquierda"))
                {
                    spritePersonaje=jumpLeft;
                    spritePersonaje.update(delta);
                    personajeX -= aceleracion * delta;
                    personajeY -= fuerzaSalto * delta;
                    personajeRect.setY(personajeY);
                    personajeRect.setX(personajeX);
                    jumping = true;
                }
                else if(spriteAnterior == right && !enColision(personajeRect,"derecha"))
                {
                    spritePersonaje=jumpRight;
                    spritePersonaje.update(delta);
                    personajeX += aceleracion * delta;
                    personajeY -= fuerzaSalto * delta;
                    personajeRect.setY(personajeY);
                    personajeRect.setX(personajeX);
                    jumping = true;
                }
                else
                {
                    spritePersonaje=jumpRight;
                    spritePersonaje.update(delta);
                    personajeY -= fuerzaSalto * delta;
                    personajeRect.setY(personajeY);
                    jumping = true;
                }
            }
            else
            {
                jumping = true;
            }
        }     
        else if(jumping)
        {            
            if(enColision(personajeRect,"abajo"))
            {
                jumping = false;
            }
            else
            {
                spritePersonaje.update(delta);
                personajeY += gravedad * delta;
                personajeRect.setY(personajeY);
                spriteAnterior = spritePersonaje;
                if(spriteAnterior == left)
                {
                    personajeX -= aceleracion/2 * delta;
                    personajeRect.setX(personajeX);
                    /*if(!enColision(personajeRect,"izquierda"))
                    {
                        personajeX -= aceleracion * delta;
                        personajeRect.setX(personajeX);
                    }      */
                }
                else if(spriteAnterior == right)
                {
                    personajeX += aceleracion/2 * delta;
                    personajeRect.setX(personajeX);
                    /*if(!enColision(personajeRect,"derecha"))
                    {
                        personajeX += aceleracion * delta;
                        personajeRect.setX(personajeX);
                    }           */     
                }
            }                      
        }
        //SI PULSAMOS BOTON DERECHO
        else if(entrada.isKeyDown(entrada.KEY_RIGHT))
        {
            spritePersonaje = right;            
            spriteAnterior = spritePersonaje;
            spritePersonaje.update(delta);
            personajeX += aceleracion * delta;
            personajeRect.setX(personajeX);
            if(!enColision(personajeRect,"abajo"))
            {
                jumping = true;
            }
        }
        //SI PULSAMOS BOTON IZQUIERDO
        else if(entrada.isKeyDown(entrada.KEY_LEFT))
        {
            spritePersonaje = left;
            spriteAnterior = spritePersonaje;
            spritePersonaje.update(delta);
            personajeX -= aceleracion * delta;
            personajeRect.setX(personajeX);
            if(!enColision(personajeRect,"abajo"))
            {
                jumping = true;
            }
        }
        //SI PULSAMOS BOTON ABAJO
        else if(entrada.isKeyDown(entrada.KEY_DOWN))
        {
            if(spriteAnterior == left)
            {
                spritePersonaje=crouchLeft;
                spritePersonaje.update(delta);
            }
            else if(spriteAnterior == right || spriteAnterior == stay )
            {
                spritePersonaje=crouchRight;
                spritePersonaje.update(delta);
            }
        }        
        //SI ESTA QUIETO
        else
        {
           spritePersonaje = stay; 
        }     
    }
    
}
