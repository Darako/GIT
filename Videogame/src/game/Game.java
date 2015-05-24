/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package game;

import game.menu.ClosingMenu;
import game.menu.Menu;
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
//    public static final int     WINDOW_WIDTH  = 840;
//    public static final int     WINDOW_HEIGTH = 560;
    public static final int     WINDOW_WIDTH  = 1366;
    public static final int     WINDOW_HEIGTH = 768;
    
    public static final boolean FULLSCREEN = true;
 
    //set size of the tile
    private static final int SIZE = 70;
    
    //1280x720 is our base, we use 32x32 tiles but we want it to be 40x40 at 1280x720
    //so our base scale is not 1 but 1.25 actually
    public static final float  SCALE         = (float) (0.6122448979591837*((double)WINDOW_WIDTH/840));
    public static final String GAME_NAME     = "Mapuski";
    
    //Score
    public static int FRUITS_COLLECTED;
    public static int ULTIMO_NIVEL;
 
    public Game() 
    {
        super(GAME_NAME);
    }
 
    public void initStatesList(GameContainer gc) throws SlickException 
    {
 
        //create a level state, this state will do the whole logic and rendering for individual levels      
        ULTIMO_NIVEL = 0;
        addState(new Menu());ULTIMO_NIVEL++;
        addState(new LevelState("Nivel_0",1,13));ULTIMO_NIVEL++;
        addState(new LevelState("Nivel_1",2,41));ULTIMO_NIVEL++;
        addState(new LevelState("Nivel_2",3,23));ULTIMO_NIVEL++;                
        addState(new LevelState("Nivel_3",4,14));ULTIMO_NIVEL++;                
        addState(new LevelState("Nivel_4",5,13));ULTIMO_NIVEL++;                
        addState(new LevelState("Nivel_5",6,13));ULTIMO_NIVEL++;                
        addState(new LevelState("Nivel_6",7,13));ULTIMO_NIVEL++;                
        addState(new LevelState("Nivel_7",8,13));ULTIMO_NIVEL++;                
        addState(new LevelState("Nivel_8",9,13));ULTIMO_NIVEL++;      
        addState(new LevelState("Nivel_9",10,13));ULTIMO_NIVEL++;   
        addState(new LevelState("Nivel_10",11,13));ULTIMO_NIVEL++; 
        addState(new LevelState("Nivel_11",12,13));ULTIMO_NIVEL++; 
        addState(new LevelState("Nivel_12",13,13));ULTIMO_NIVEL++;  
        addState(new ClosingMenu(ULTIMO_NIVEL));
        this.enterState(0);

    }
 
    public static void main(String[] args) throws SlickException 
    {
         AppGameContainer app = new AppGameContainer(new Game());
 
         //set the size of the display to the width and height and fullscreen or not
         app.setShowFPS(false);
         app.setDisplayMode(WINDOW_WIDTH, WINDOW_HEIGTH, FULLSCREEN);
         //this will attempt to create a framerate of approximately 60 frames per second
         app.setTargetFrameRate(60);
 
         app.start();
    }
}
