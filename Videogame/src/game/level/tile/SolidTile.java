/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package game.level.tile;

import game.physics.AABoundingRect;

/**
 *
 * @author Darako
 */
public class SolidTile extends Tile 
{
    public SolidTile(int x, int y)
    {
        super(x,y);
        boundingShape = new AABoundingRect(x*70, y*70, 70, 70);
    }
}
