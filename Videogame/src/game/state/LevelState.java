/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package game.state;

import game.Game;
import game.character.Player;
import game.controller.MouseAndKeyBoardPlayerController;
import game.controller.PlayerController;
import game.level.Level;
import game.level.object.Objective;
import game.physics.Physics;
import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.Input;
import org.newdawn.slick.Music;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.Sound;
import org.newdawn.slick.state.BasicGameState;
import org.newdawn.slick.state.StateBasedGame;


/**
 *
 * @author Darako
 */
public class LevelState extends BasicGameState
{
    private Level  level;
    private String startingLevel;
    private Player player;
    private PlayerController playerController;
    private Physics physics;
    private Music music;
    private static Sound mjump;
 
    public LevelState(String startingLevel)
    {
        this.startingLevel = startingLevel;
        this.physics = new Physics();
    }
 
    public void init(GameContainer container, StateBasedGame sbg) throws SlickException 
    {       
        //at the start of the game we don't have a player yet
        player = new Player(70f,839f);        
        //once we initialize our level, we want to load the right level
        level = new Level(startingLevel, player);
        //and we create a controller, for now we use the MouseAndKeyBoardPlayerController
        playerController = new MouseAndKeyBoardPlayerController(player);        
        //adding objetives
        //level.addLevelObject(new Objective(630,629));        
        //adding physics
        physics = new Physics();
//        music=new Music("src/sound/2.ogg");
//        mjump=new Sound("src/sound/jump_08.ogg");
    }
 
    public void update(GameContainer container, StateBasedGame sbg, int delta) throws SlickException 
    {
        playerController.handleInput(container.getInput(), delta);
        physics.handlePhysics(level,delta);
//        if(music.playing()==false){
//            music.play();
//        }
    }
 
    public void render(GameContainer container, StateBasedGame sbg, Graphics g) throws SlickException 
    { 
        //if we ever wanter to scale but nope
        g.scale(Game.SCALE, Game.SCALE);
        level.render();
    }
 
    //this method is overriden from basicgamestate and will trigger once you press any key on your keyboard
    public void keyPressed(int key, char code)
    {
        //if the key is escape, close our application
        if(key == Input.KEY_ESCAPE){
            System.exit(0);
        }
//        if(key == Input.KEY_SPACE) mjump.play();        
    }
    
    public int getID() 
    {
        //this is the id for changing states
        return 0;
    } 
}
