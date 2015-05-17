/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package game.level.object;

import game.level.LevelObject;
import org.newdawn.slick.Animation;
import org.newdawn.slick.Image;
import org.newdawn.slick.SlickException;

/**
 *
 * @author Darako
 */
public class Objective extends LevelObject
{
    protected Animation animation;
    
    Image [] moneda = 
    {
        new Image("data/CutePack/Base pack/Items/coinGold.png"), 
        new Image("data/CutePack/Base pack/Items/coinSilver.png"), 
        new Image("data/CutePack/Base pack/Items/coinBronze.png"),
    };
                                              
    
    public Objective(float x, float y) throws SlickException
    {
        super(x,y);
        animation = new Animation(moneda,new int[]{125,125,125});
        animation.setPingPong(true);
    }
    
    public void render(float offsetX, float offsetY)
    {
        animation.draw(x-offsetX, y-offsetY);
    }
}
