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
import org.newdawn.slick.Music;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.state.BasicGameState;
import org.newdawn.slick.state.StateBasedGame;

/**
 *
 * @author Darako
 */
public class Menu extends BasicGameState
{ 
    private StateBasedGame game;
    private Music music;
    
    @Override
    public void init(GameContainer container, StateBasedGame game) throws SlickException 
    {
        this.game = game;
        music=new Music("data/sound/menu.ogg");
    }
 
    @Override
    public void render(GameContainer container, StateBasedGame game, Graphics g) throws SlickException 
    {
        g.drawImage(new Image("data/Mapuski/mapuskibackground.png"),0,0);
    }
 
    @Override
    public void update(GameContainer container, StateBasedGame game, int delta) throws SlickException 
    {
        if(music.playing()==false){
            music.play();
        }
    }
 
    @Override
    public int getID() 
    {
        return 0;
    } 
    
    public void controllerButtonPressed(int controller, int button)
    {
        //Start
        if(button == 8)
        {
            inputEnded();
            music.stop();
            game.enterState(1);
        }
    }
    
    public void keyPressed(int key, char c) 
    {
        switch(key) {
        case Input.KEY_ENTER:
            music.stop();
            game.enterState(1);
            break;
        case Input.KEY_ESCAPE:
            System.exit(0);
            break;
        }
    }
}