/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package game;

import game.state.LevelState;
import org.newdawn.slick.AppGameContainer;
import org.newdawn.slick.GameContainer;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.state.StateBasedGame;


/**
 *
 * @author Darako
 */
public class Game extends StateBasedGame
{
    //set the window width and then the height according to a aspect ratio
    public static final int     WINDOW_WIDTH  = 840;
    public static final int     WINDOW_HEIGTH = 560;
    public static final boolean FULLSCREEN = false;
 
    //set size of the tile
    private static final int SIZE = 70;
    
    //1280x720 is our base, we use 32x32 tiles but we want it to be 40x40 at 1280x720
    //so our base scale is not 1 but 1.25 actually
    public static final float  SCALE         = (float) (0.6122448979591837*((double)WINDOW_WIDTH/840));
    public static final String GAME_NAME     = "Mapuski";
    
    //Score
    public static int FRUITS_COLLECTED = 0;
 
    public Game() 
    {
        super(GAME_NAME);
    }
 
    public void initStatesList(GameContainer gc) throws SlickException 
    {
 
        //create a level state, this state will do the whole logic and rendering for individual levels
        addState(new LevelState("level_0"));
        this.enterState(0);
 
    }
 
    public static void main(String[] args) throws SlickException 
    {
         AppGameContainer app = new AppGameContainer(new Game());
 
         //set the size of the display to the width and height and fullscreen or not
         app.setDisplayMode(WINDOW_WIDTH, WINDOW_HEIGTH, FULLSCREEN);
         //this will attempt to create a framerate of approximately 60 frames per second
         app.setTargetFrameRate(60);
 
         app.start();
    }
}
