/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package game.menu;

import org.newdawn.slick.Color;
import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.Image;
import org.newdawn.slick.Input;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.state.BasicGameState;
import org.newdawn.slick.state.StateBasedGame;

/**
 *
 * @author Darako
 */
public class Menu extends BasicGameState
{
 
    protected Image sprite;
    private StateBasedGame game;
    
    @Override
    public void init(GameContainer container, StateBasedGame game) throws SlickException 
    {
        sprite = new Image("data/Mapuski/Stand/mapuski_stand_01.png");
        this.game = game;
    }
 
    @Override
    public void render(GameContainer container, StateBasedGame game, Graphics g) throws SlickException 
    {
//        g.setColor(Color.white);
//        g.drawString("MAPUSKI", 50, 10);
//        g.drawImage(sprite,50, 20);
//        g.drawString("1. JUGAR", 50, 100);
          g.drawImage(new Image("data/Mapuski/mapuskibackground.png"),0,0);
    }
 
    @Override
    public void update(GameContainer container, StateBasedGame game, int delta) throws SlickException 
    {
 
    }
 
    @Override
    public int getID() 
    {
        return 0;
    } 
    
    public void keyReleased(int key, char c) 
    {
        switch(key) {
        case Input.KEY_ENTER:
            game.enterState(1);
            break;
        default:
            break;
        }
    }
}