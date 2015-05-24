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
public class AABoundingRect extends BoundingShape
{
    public float x;
    public float y;
    public float width;
    public float height;
    
    
    public AABoundingRect(float x, float y, float width, float height)
    {
        this.x = x;
        this.y = y;
        this.width = width;
        this.height = height;
    }
    
    public void updatePosition(float newX, float newY)
    {
        this.x = newX;
        this.y = newY;
    }
    
    public void movePosition(float x, float y)
    {
        this.x += x;
        this.y += y;
    }
    
    public boolean checkCollision(AABoundingRect rect)
    {
        return  !( rect.x > this.x+width 
                || rect.x+rect.width < this.x 
                || rect.y > this.y+height 
                || rect.y+rect.height < this.y);
    }
   
    public ArrayList<Tile> getTilesOccupying(Tile[][] tiles)
    {
        ArrayList<Tile> occupiedTiles = new ArrayList<Tile>();
        
        //we go from the left of the rect towards to right of the rect, 
        //making sure we round upwards to a multiple of 70 or we miss a few tiles
        //System.out.println("OCUPANDO: ("+(x+width+(70-width%70))/70+","+(y+height+(70-height%70))/70+")");        
        for(int i = (int) x; i < x+width+(70-width%70); i += 70)
        {
            for(int j = (int) y; j < y+height+(70-height%70); j += 70)
            {
              //if(j/70<14)
                occupiedTiles.add(tiles[i/70][j/70]);
                //System.out.print("("+i/70+","+j/70+") ");
            }
        }
        return occupiedTiles;
    }
    
    public ArrayList<Tile> getGroundTiles(Tile[][] tiles)
    {
        //System.out.println("Suelo:");
        ArrayList<Tile> tilesUnderneath = new ArrayList<Tile>();
        int j = (int) (y+height+1);
        
        for(int i = (int) x; i <= x+width+(70-width%70); i+= 70)
        {
            
            tilesUnderneath.add(tiles[i/70][j/70]);
            //System.out.println("("+i/70+","+j/70+")");
        }
        return tilesUnderneath;
    }
}
