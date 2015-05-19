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
import game.physics.Physics;
import java.awt.Font;
import java.io.InputStream;
import org.newdawn.slick.Color;
import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.Image;
import org.newdawn.slick.Input;
import org.newdawn.slick.Music;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.Sound;
import org.newdawn.slick.TrueTypeFont;
import org.newdawn.slick.state.BasicGameState;
import org.newdawn.slick.state.StateBasedGame;
import org.newdawn.slick.state.transition.FadeInTransition;
import org.newdawn.slick.state.transition.FadeOutTransition;
import org.newdawn.slick.util.ResourceLoader;



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
    //protected Image sprite;
    private Physics physics;
    private Music music;
    private static Sound mjump;
    private int levelID;
    private int posY;
    private TrueTypeFont font;
 
    public LevelState(String startingLevel, int levelID, int posY)
    {
        this.startingLevel = startingLevel;
        this.levelID = levelID;
        this.physics = new Physics();
        this.posY = posY;
    }
 
    public void init(GameContainer container, StateBasedGame sbg) throws SlickException 
    {       
        
        //sprite = new Image("data/CutePack/AllFruits.png");
        //at the start of the game we don't have a player yet
        player = new Player(70f,(float) (posY*70 - 70));        
        //once we initialize our level, we want to load the right level
        level = new Level(startingLevel, player);
        //and we create a controller, for now we use the MouseAndKeyBoardPlayerController
        playerController = new MouseAndKeyBoardPlayerController(player); 
        //adding physics
        physics = new Physics();
        //adding fonts
        try 
        {
            InputStream inputStream = ResourceLoader.getResourceAsStream("data/Fonts/DINL___.TTF");

            Font awtFont = Font.createFont(Font.TRUETYPE_FONT, inputStream);
            awtFont = awtFont.deriveFont(60f); // set font size
            font = new TrueTypeFont(awtFont, false);

        } catch (Exception e) {
            e.printStackTrace();
        }
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
        if(Game.FRUITS_COLLECTED == level.getItemCount() && levelID != 3)
        {            
            Game.FRUITS_COLLECTED = 0;
            level.resetItemCount();
            sbg.enterState(levelID+1, new FadeOutTransition(Color.black), new FadeInTransition(Color.black));
        }
        else if(Game.FRUITS_COLLECTED == level.getItemCount() && levelID == 3)
        {
            System.exit(0);
        }
    }
 
    public void render(GameContainer container, StateBasedGame sbg, Graphics g) throws SlickException 
    { 
        //if we ever wanter to scale but nope
        g.scale(Game.SCALE, Game.SCALE);
        
        level.render();
        g.setFont(font);
        g.setColor(Color.black);        
        g.drawString("FRUTAS: "+Game.FRUITS_COLLECTED+"/"+level.getItemCount(),0,845);
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
        return levelID;
    } 
}
