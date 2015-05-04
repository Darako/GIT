/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package game.character;

import game.enums.Facing;
import game.level.LevelObject;
import java.util.HashMap;
import org.newdawn.slick.Animation;
import org.newdawn.slick.Image;
import org.newdawn.slick.SlickException;

/**
 *
 * @author Darako
 */
public abstract class Character extends LevelObject 
{
 
    protected boolean moving = false;
    protected float accelerationSpeed = 1;
    protected float decelerationSpeed = 1;
    protected float maximumSpeed = 1;
    protected Image sprite;
    protected Facing facing;
    protected HashMap<Facing,Image> sprites;
    protected HashMap<Facing,Animation> movingAnimations;
    protected long lastTimeMoved;
    
    
    public Character(float x, float y) throws SlickException
    {
        super(x,y);
        //in case we forget to set the image, we don't want the game to crash, but it still has to be obvious that something was forgotten
        setSprite(new Image("data/Personaje/Front/p1_front.png"));
        //default direction will be right
        facing = Facing.RIGHT;
    }
    
    public boolean isMoving()
    {
        return moving;
    }
    
    public void setMoving(boolean b)
    {
        moving = b;
    }
    
    public void decelerate(int delta)
    {
        if(xVelocity > 0)
        {
            xVelocity -= decelerationSpeed * delta;
            if(xVelocity < 0)
            {
                xVelocity = 0;
            }
        }
        else if (xVelocity < 0)
        {
            xVelocity += decelerationSpeed + delta;
            if(xVelocity > 0)
            {
                xVelocity = 0;
            }
        }
    }
    
    public void jump()
    {
        if(onGround) yVelocity = -0.6f;
    }
    
    public void moveLeft(int delta)
    {
        //if we aren't already moving at max speed
        if(xVelocity > -maximumSpeed)
        {
            xVelocity -= accelerationSpeed * delta;
            if(xVelocity > -maximumSpeed)
            {
                xVelocity = -maximumSpeed;
            }
        }
        moving = true;
        facing = Facing.LEFT;
    }
    
    public void moveRight(int delta)
    {
        if(xVelocity < maximumSpeed)
        {
            xVelocity += accelerationSpeed * delta;
            if(xVelocity > maximumSpeed)
            {
                xVelocity = maximumSpeed;
            }
        }
        moving = true;
        facing = Facing.RIGHT;
    }
 
    public void render()
    {
        //draw a moving animation if we have one and we moved within the last 150 milis
        if(movingAnimations != null && moving)
        {
            movingAnimations.get(facing).draw(x,y);
        }
        else
        {
            sprites.get(facing).draw(x,y);
        }        
    }
    
    protected void setSprite(Image i)
    {
        sprites = new HashMap<Facing,Image>();
        sprites.put(Facing.RIGHT, i);
        sprites.put(Facing.LEFT, i.getFlippedCopy(true, false));
    }
    
    protected void setMovingAnimation(Image[]images, int frameDuration)
    {
        movingAnimations = new HashMap<Facing,Animation>();

        //we can just put the right facing in with the default images
        movingAnimations.put(Facing.RIGHT, new Animation(images, frameDuration));
        Animation facingLeftAnimation = new Animation();
        for(Image i : images)
        {
            facingLeftAnimation.addFrame(i.getFlippedCopy(true, false), frameDuration);
        }
        movingAnimations.put(Facing.LEFT, facingLeftAnimation);         
    }
        
}

