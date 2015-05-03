/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package game.physics;

import game.level.tile.Tile;
import java.util.ArrayList;

/**
 *
 * @author Darako
 */
public abstract class BoundingShape 
{
    public boolean checkCollision(BoundingShape bv)
    {
        if(bv instanceof AABoundingRect)
        {
            return checkCollision((AABoundingRect) bv);
        }        
        return false;
    }
    
    public abstract boolean checkCollision(AABoundingRect box);
    public abstract void updatePosition(float newX, float newY);
    public abstract void movePosition(float x, float y);
    public abstract ArrayList<Tile> getTilesOccupying(Tile[][] tiles);
    public abstract ArrayList<Tile> getGroundTiles(Tile[][] tiles);
    
}
