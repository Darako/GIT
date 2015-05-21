/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package game.level;

import game.physics.AABoundingRect;
import game.physics.BoundingShape;

/**
 *
 * @author Darako
 */
public abstract class LevelObject 
{
    protected float x;
    protected float y;
    protected BoundingShape boundingShape;
    
    protected float xVelocity = 0;
    protected float yVelocity = 0;
    protected float maximumFallSpeed = 1;
    
    protected boolean onGround = true;
    
    public LevelObject(float x, float y)
    {
        this.x = x;
        this.y = y;
        
        //default bounding shape is a 70x70 box
        boundingShape = new AABoundingRect(x+5,y+5,60,60);
    }
    
    public void applyGravity(float gravity)
    {
        //if we aren't already moving at maximum speed
        if(yVelocity < maximumFallSpeed)
        {
            //accelerate
            yVelocity += gravity;
            if(yVelocity > maximumFallSpeed)
            {
                yVelocity = maximumFallSpeed;
            }
        }        
    }
    
    public float getYVelocity() {
        return yVelocity;
    }
 
    public void setYVelocity(float f){
        yVelocity = f;
    }
 
    public float getXVelocity(){
        return xVelocity;
    }
 
    public void setXVelocity(float f){
        xVelocity = f;
    }
 
    public float getX(){
        return x;
    }
 
    public float getY(){
        return y;
    }
 
    public void setX(float f){
        x = f;
        updateBoundingShape();
    }
 
    public void setY(float f){
        y = f;
        updateBoundingShape();
    }
 
    public void updateBoundingShape(){
        boundingShape.updatePosition(x,y);
    }
 
    public boolean isOnGround(){
        return onGround;
    }
 
    public void setOnGround(boolean b){
        onGround = b;
    }
 
    public BoundingShape getBoundingShape(){
        return boundingShape;
    }
    
    public abstract void render(float offsetX, float offsetY);
    
}
