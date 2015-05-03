/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package game.physics;

import game.character.Character;
import game.level.Level;
import game.level.LevelObject;
import game.level.tile.Tile;
import java.util.ArrayList;

/**
 *
 * @author Darako
 */
public class Physics 
{
    private final float gravity = 0.0015f;
    
    public void handlePhysics(Level level, int delta)
    {
        handleCharacters(level,delta);        
    }    
    
    private boolean checkCollision(LevelObject obj, Tile[][] mapTiles)
    {
        //get only the tiles that matter
        ArrayList<Tile> tiles = obj.getBoundingShape().getTilesOccupying(mapTiles);
        for(Tile t : tiles)
        {
            //if this tile has a bounding shape
            if(t.getBoundingShape() != null)
            {
                if(t.getBoundingShape().checkCollision(obj.getBoundingShape()))
                {
                    return true;
                }                    
            }
        }
        return false;        
    }
    
    private boolean isOnGround(LevelObject obj, Tile[][] mapTiles)
    {
        //we get the tiles that are directly "underneath" the characters, also known as gound tiles
        ArrayList<Tile> tiles = obj.getBoundingShape().getGroundTiles(mapTiles);
        //we lower the bounding objetct a bit so we can check if we are actually a bit above the ground
        obj.getBoundingShape().movePosition(0, 1);
        for(Tile t : tiles)
        {
            //not every tile has a bounding shape (like air tiles)
            if(t.getBoundingShape() != null)
            {
                //if the ground and the lowered object collide, then we are on the ground
                if(t.getBoundingShape().checkCollision(obj.getBoundingShape()))
                {
                    //dont forget the object back up even if we are on the ground!!
                    obj.getBoundingShape().movePosition(0, -1);
                    return true;
                }
            }
        }
        //and obviously move the object back up if we dont hit the ground
        obj.getBoundingShape().movePosition(0, -1);
        return false;
    }
    
    private void handleCharacters(Level level, int delta)
    {
        for(Character c : level.getCharacters())
        {
            //and now decelerate the character if he is not moving anymore
            if(!c.isMoving())
            {
                c.decelerate(delta);
            }
            handleGameObject(c,level,delta);
        }
    }
    
    private void handleGameObject(LevelObject obj, Level level, int delta)
    {        
        //first update the onGround of the object
        obj.setOnGround(isOnGround(obj, level.getTiles()));
        //now apply gravitational force if we are not on the ground or when we are about to jump
        if(!obj.isOnGround() || obj.getYVelocity() < 0) obj.applyGravity(gravity * delta);
        else obj.setYVelocity(0);
        
        //calculate how much we actually have to move
        float xMovement = obj.getXVelocity() * delta;
        float yMovement = obj.getYVelocity() * delta;
        //we have to calculate the step we have to take
        float stepY = 0;
        float stepX = 0;
        
        if(xMovement != 0)
        {
            stepY = Math.abs(yMovement)/Math.abs(xMovement);
            if(yMovement < 0) stepY = -stepY;    
            if(xMovement > 0) stepX = 1;
            else stepX = -1;
            if((stepY > 1 || stepY < -1) && stepY != 0)
            {
                stepX = Math.abs(stepX)/Math.abs(stepY);
                if(xMovement < 0) stepX = -stepX;
                if(yMovement < 0) stepY = -1;
                else stepY = 1;
            }
        }
        else if (yMovement != 0)
        {
            //if we only have vertical movement, we can just use a step of 1
            if(yMovement > 0) stepY = 1;
            else stepY = -1;
        }
        //and then do little steps until we are done moving
        while(xMovement != 0 || yMovement != 0)
        {
            //we first move in the x direction 
            if(xMovement != 0)
            {
                //when we do a step, we have to update the amount we have to move after this
                if((xMovement > 0 && xMovement < stepX) || (xMovement > stepX && xMovement < 0))
                {
                    stepX = xMovement;
                    xMovement = 0;
                }
                else xMovement -= stepX;
            
                //then we move the object one step
                obj.setX(obj.getX() + stepX);
                //if we collide with any of the bounding shapes of the tiles we have to revert to our original position
                if(checkCollision(obj,level.getTiles()))
                {
                    //undo our step, and set velocity and amount we still have to move to 0, because we can't move on that direction
                    obj.setX(obj.getX() - stepX);
                    obj.setXVelocity(0);
                    xMovement = 0;
                }
            }
            //same thing for the vertical, or y movement
            if(yMovement != 0)
            {
                if((yMovement > 0 && yMovement < stepY) || (yMovement > stepY && yMovement < 0))
                {
                    stepY = yMovement;
                    yMovement = 0;
                }
                else yMovement -= stepY;
                obj.setY(obj.getY() + stepY);
                if(checkCollision(obj, level.getTiles()))
                {
                    obj.setY(obj.getY() - stepY);
                    obj.setYVelocity(0);
                    yMovement = 0;
                    break;
                }
            }
        }        
    }
    
    
}