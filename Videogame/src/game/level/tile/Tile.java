/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package game.level.tile;

import game.physics.BoundingShape;

/**
 *
 * @author Darako
 */
public class Tile 
{
    protected int x;
    protected int y;
    protected BoundingShape boundingShape;
    
    public Tile(int x, int y)
    {
        this.x = x;
        this.y = y;
        this.boundingShape = null;
    }
    
    public int getX()
    {
        return x;
    }
    
    public int getY()
    {
        return y;
    }
    
    public BoundingShape getBoundingShape()
    {
        return boundingShape;
    }
}
