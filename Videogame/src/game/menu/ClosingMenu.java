/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package game.menu;

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
public class ClosingMenu extends BasicGameState
{
    private StateBasedGame game;
    private int IDLevel;
    
    public ClosingMenu(int IDLevel)
    {
        this.IDLevel = IDLevel;
    }
    
    @Override
    public void init(GameContainer container, StateBasedGame game) throws SlickException 
    {
        this.game = game;
    }
 
    @Override
    public void render(GameContainer container, StateBasedGame game, Graphics g) throws SlickException 
    {
        g.drawImage(new Image("data/Mapuski/mapuskibackgroundout.png"),0,0);
    }
 
    @Override
    public void update(GameContainer container, StateBasedGame game, int delta) throws SlickException 
    {
 
    }
 
    @Override
    public int getID() 
    {
        return IDLevel;
    } 
    
    public void keyReleased(int key, char c) 
    {
        switch(key) {
        case Input.KEY_ENTER:
            System.exit(0);
            break;
        case Input.KEY_ESCAPE:
            System.exit(0);
            break;
        }
    }
}
