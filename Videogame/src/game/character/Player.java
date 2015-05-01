/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package game.character;

import game.enums.Facing;
import java.util.HashMap;
import org.newdawn.slick.Animation;
import org.newdawn.slick.Image;
import org.newdawn.slick.SlickException;

/**
 *
 * @author Darako
 */
public class Player extends Character 
{ 
    Image [] movRight = 
        {
            new Image("data/Personaje/Right/p1_walk01.png"), 
            new Image("data/Personaje/Right/p1_walk02.png"),
            new Image("data/Personaje/Right/p1_walk03.png"),
            new Image("data/Personaje/Right/p1_walk04.png"),
            new Image("data/Personaje/Right/p1_walk05.png"),
            new Image("data/Personaje/Right/p1_walk06.png"),
            new Image("data/Personaje/Right/p1_walk07.png"),
            new Image("data/Personaje/Right/p1_walk08.png"),
            new Image("data/Personaje/Right/p1_walk09.png"),
            new Image("data/Personaje/Right/p1_walk10.png"),
            new Image("data/Personaje/Right/p1_walk11.png")
        };
    
    public Player(float x, float y) throws SlickException
    {
        super(x,y);
        setSprite(new Image("data/Personaje/Right/p1_walk03.png"));
        setMovingAnimation(movRight, 100);
    }

    public void moveLeft(int delta) 
    {        
        x -= (0.25f * delta);
        facing = Facing.LEFT;
        lastTimeMoved = System.currentTimeMillis();
    }

    public void moveRight(int delta) 
    {        
        x += (0.25f * delta);
        facing = Facing.RIGHT;
        lastTimeMoved = System.currentTimeMillis();
    }  
}
