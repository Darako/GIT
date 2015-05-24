/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package game.menu;

import game.Game;
import org.newdawn.slick.Color;
import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.Image;
import org.newdawn.slick.Input;
import org.newdawn.slick.Music;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.Sound;
import org.newdawn.slick.state.BasicGameState;
import org.newdawn.slick.state.StateBasedGame;
import org.newdawn.slick.state.transition.FadeInTransition;
import org.newdawn.slick.state.transition.FadeOutTransition;

/**
 *
 * @author Darako
 */
public class ClosingMenu extends BasicGameState
{
    private StateBasedGame game;
    private int IDLevel;
    private static Music fin;
    private int a=0;
    
    public ClosingMenu(int IDLevel)
    {
        this.IDLevel = IDLevel;
    }
    
    @Override
    public void init(GameContainer container, StateBasedGame game) throws SlickException 
    {
        this.game = game;
        fin=new Music("data/sound/bird.ogg",true);
    }
 
    @Override
    public void render(GameContainer container, StateBasedGame game, Graphics g) throws SlickException 
    {   
        if(!fin.playing() && a<=1){
            fin.play();
            a++;
        }
        g.drawImage(new Image("data/Mapuski/mapuskibackgroundout.png"),0,0);
    }
 
    @Override
    public void update(GameContainer container, StateBasedGame game, int delta) throws SlickException 
    {
        //R1
        if(container.getInput().isButtonPressed(5, 0))
        {   
            inputEnded();
            game.getCurrentState().leave(container, game);
            fin.stop();
            a=0;
            game.enterState(0, new FadeOutTransition(Color.black,10), new FadeInTransition(Color.black));
        }
        if(container.getInput().isKeyDown(Input.KEY_ENTER))
        {      
            inputEnded();            
            game.getCurrentState().leave(container, game);
            fin.stop();
            a=0;
            game.enterState(0, new FadeOutTransition(Color.black,10), new FadeInTransition(Color.black));
        }
    }
 
    @Override
    public int getID() 
    {
        return IDLevel;
    } 
    
    public void controllerButtonPressed(int controller, int button)
    {
        if(button == 7)
        {
            fin.stop();
            System.exit(0);
        }
    }
    
    public void keyPressed(int key, char c) 
    {
        if(key == Input.KEY_ESCAPE)
        {
            fin.stop();
            System.exit(0);
        }
    }
}
