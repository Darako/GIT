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
    private static Sound fin;
    private int a=0;
    
    public ClosingMenu(int IDLevel)
    {
        this.IDLevel = IDLevel;
    }
    
    @Override
    public void init(GameContainer container, StateBasedGame game) throws SlickException 
    {
        this.game = game;
        fin=new Sound("data/sound/bird.ogg");
    }
 
    @Override
    public void render(GameContainer container, StateBasedGame game, Graphics g) throws SlickException 
    {   
        if(!fin.playing() && a==0){
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
            game.enterState(0, new FadeOutTransition(Color.black,10), new FadeInTransition(Color.black));
        }
        if(container.getInput().isKeyPressed(Input.KEY_ENTER))
        {            
            game.getCurrentState().leave(container, game);
            fin.stop();
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
    
    public void keyReleased(int key, char c) 
    {
        if(key == Input.KEY_ESCAPE)
        {
            fin.stop();
            System.exit(0);
        }
    }
}
