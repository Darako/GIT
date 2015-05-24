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
    protected HashMap<Facing,Image> sprites;
    protected HashMap<Facing,Animation> movingAnimations;
    protected HashMap<Facing,Animation> standingAnimations;
    protected HashMap<Facing,Animation> crouchingAnimations;
    protected Facing facing;
    protected boolean moving = false;
    protected boolean crouch = false;
    protected float accelerationSpeed = 1;
    protected float decelerationSpeed = 1;
    protected float maximumSpeed = 1;
    protected Image sprite;
    protected long lastTimeMoved;
    
    
    public Character(float x, float y) throws SlickException
    {
        super(x,y);
        setSprite(new Image("data/Mapuski/Stand/mapuski_stand_01.png"));
        facing = Facing.STAND;
    }
    
    protected void setStandingAnimation(Image[]images, int frameDuration)
    {
        standingAnimations = new HashMap<Facing,Animation>();
        standingAnimations.put(Facing.STAND, new Animation(images, frameDuration));
    }
    
    protected void setCrouchingAnimation(Image[]images, int frameDuration)
    {
        crouchingAnimations = new HashMap<Facing,Animation>();
        crouchingAnimations.put(Facing.CROUCH, new Animation(images, frameDuration));
    }
    
    protected void setMovingAnimation(Image[]images, int frameDuration)
    {
        movingAnimations = new HashMap<Facing,Animation>();
        movingAnimations.put(Facing.RIGHT, new Animation(images, frameDuration));
        
        Animation facingLeftAnimation = new Animation();
        for(Image i : images)
        {
            facingLeftAnimation.addFrame(i.getFlippedCopy(true, false), frameDuration);
        }
        movingAnimations.put(Facing.LEFT, facingLeftAnimation);         
    }

    protected void setSprite(Image i)
    {
        sprites = new HashMap<Facing,Image>();
        sprites.put(Facing.RIGHT, i);
        sprites.put(Facing.LEFT, i.getFlippedCopy(true, false));
    }

    public boolean isMoving()
    {
        return moving;
    }
    
    public void setMoving(boolean b)
    {
        moving = b;
    }
    
    public boolean isCrouch()
    {
        return crouch;
    }
    
    public void setCrouch(boolean b)
    {
        crouch = b;
    }

    public void jump()
    {
        if(onGround) yVelocity = -0.5f;
    }

    public void standing(int delta)
    {
        moving = false;
        facing = Facing.STAND;
    }
    
    public void crouching(int delta)
    {
        if(onGround) facing = Facing.CROUCH;
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
            xVelocity += decelerationSpeed * delta;
            if(xVelocity > 0)
            {
                xVelocity = 0;
            }
        }
    }
    
    public void moveLeft(int delta)
    {
        //if we aren't already moving at max speed
        if(xVelocity > -maximumSpeed)
        {
            xVelocity -= accelerationSpeed * delta;
            if(xVelocity < -maximumSpeed)
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
 
    public void render(float offsetX, float offsetY)
    {
        //draw a moving animation if we have one and we moved within the last 150 milis
        if(movingAnimations != null && moving)
        {
            movingAnimations.get(facing).draw(x-offsetX,y-offsetY);
        } 
//        else if(crouchingAnimations != null && crouch)
//        {
//            System.out.println("weee");
//            crouchingAnimations.get(facing).draw(x-offsetX,y-offsetY);
//        }
        else
        {
            standingAnimations.get(facing).draw(x-offsetX,y-offsetY);
        }
                 
    }
}


