/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package game.physics;

import game.Game;
import game.character.Character;
import game.character.Player;
import game.level.Level;
import game.level.LevelObject;
import game.level.object.Objective;
import game.level.tile.Tile;
import java.util.ArrayList;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.Sound;

/**
 *
 * @author Darako
 */
public class Physics 
{
    private final float gravity = 0.0015f;
    private static Sound mcomer;
    public boolean sueloCierto=true;
    
    public void phsysics() throws SlickException{
        mcomer=new Sound("data/sound/comer.ogg");
    }
    
    
    public void handlePhysics(Level level, int delta)
    {
        handleCharacters(level,delta);          
    }    
    
    private boolean checkCollision(LevelObject obj, Tile[][] mapTiles)
    {
        ArrayList<Tile> tiles = obj.getBoundingShape().getTilesOccupying(mapTiles);
        for(Tile t : tiles)
        {
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
        ArrayList<Tile> tiles = obj.getBoundingShape().getGroundTiles(mapTiles);
        obj.getBoundingShape().movePosition(0, 1);
        for(Tile t : tiles)
        {
            if(t.getBoundingShape() != null)
            {
                if(t.getBoundingShape().checkCollision(obj.getBoundingShape()))
                {
                    obj.getBoundingShape().movePosition(0, -1);
                    sueloCierto=true;
                    return true;
                }
            }
        }
        obj.getBoundingShape().movePosition(0, -1);
        sueloCierto=false;
        return false;
    }
    
    private void handleCharacters(Level level, int delta)
    {
        for(Character c : level.getCharacters())
        {
            if(!c.isMoving())
            {
                c.decelerate(delta);
            }
            handleGameObject(c,level,delta);

            if(c instanceof Player)
            {
                ArrayList<LevelObject> removeQueue = new ArrayList<LevelObject>();

                for(LevelObject obj : level.getLevelObjects())
                {
                    if(obj instanceof Objective)
                    {
                        if(obj.getBoundingShape().checkCollision(c.getBoundingShape()))
                        {
                            Game.FRUITS_COLLECTED++;
                            mcomer.play(1f,0.5f);
                            removeQueue.add(obj);
                        }
                    }
                }
                level.removeObjects(removeQueue);
            }
        }
    }
    
    private void handleGameObject(LevelObject obj, Level level, int delta)
    {        
        obj.setOnGround(isOnGround(obj, level.getTiles()));
        if(!obj.isOnGround() || obj.getYVelocity() < 0) obj.applyGravity(gravity * delta);
        else obj.setYVelocity(0);
        
        float xMovement = obj.getXVelocity() * delta;
        float yMovement = obj.getYVelocity() * delta;
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
            if(yMovement > 0) stepY = 1;
            else stepY = -1;
        }
        while(xMovement != 0 || yMovement != 0)
        {
            if(xMovement != 0)
            {
                if((xMovement > 0 && xMovement < stepX) || (xMovement > stepX && xMovement < 0))
                {
                    stepX = xMovement;
                    xMovement = 0;
                }
                else xMovement -= stepX;
                
                obj.setX(obj.getX() + stepX);
                
                if(checkCollision(obj,level.getTiles()))
                {
                    obj.setX(obj.getX() - stepX);
                    obj.setXVelocity(0);
                    xMovement = 0;
                }
            }
            
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
    
    private void handleLevelObjects(Level level, int delta)
    {
        for(LevelObject obj: level.getLevelObjects())
        {
            handleGameObject(obj, level, delta);
        }
    }      
}