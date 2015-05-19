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
        if(Game.FRUITS_COLLECTED == level.getItemCount() && levelID != 6)
        {            
            Game.FRUITS_COLLECTED = 0;
            level.resetItemCount();
            sbg.enterState(levelID+1, new FadeOutTransition(Color.black), new FadeInTransition(Color.black));
        }
        else if(Game.FRUITS_COLLECTED == level.getItemCount() && levelID == 6)
        {
            System.exit(0);
        }
    }
 
    public void render(GameContainer container, StateBasedGame sbg, Graphics g) throws SlickException 
    { 
        //if we ever wanter to scale but nope
        g.scale(Game.SCALE, Game.SCALE);
        
        level.render();
        g.drawImage( new Image("data/CutePack/FruitsCount.png"), 0, (posY-1) * 70 + 5);
        switch(Game.FRUITS_COLLECTED)
        {
            case 0 : { g.drawImage(new Image("data/CutePack/Base pack/HUD/hud_0.png"), 215, (posY-1) *70 + 20); break; } 
            case 1 : { g.drawImage(new Image("data/CutePack/Base pack/HUD/hud_1.png"), 215, (posY-1) *70 + 20); break; }
            case 2 : { g.drawImage(new Image("data/CutePack/Base pack/HUD/hud_2.png"), 215, (posY-1) *70 + 20); break; }
            case 3 : { g.drawImage(new Image("data/CutePack/Base pack/HUD/hud_3.png"), 215, (posY-1) *70 + 20); break; }
            case 4 : { g.drawImage(new Image("data/CutePack/Base pack/HUD/hud_4.png"), 215, (posY-1) *70 + 20); break; }
            case 5 : { g.drawImage(new Image("data/CutePack/Base pack/HUD/hud_5.png"), 215, (posY-1) *70 + 20); break; }
            case 6 : { g.drawImage(new Image("data/CutePack/Base pack/HUD/hud_6.png"), 215, (posY-1) *70 + 20); break; }
            case 7 : { g.drawImage(new Image("data/CutePack/Base pack/HUD/hud_7.png"), 215, (posY-1) *70 + 20); break; }
            case 8 : { g.drawImage(new Image("data/CutePack/Base pack/HUD/hud_8.png"), 215, (posY-1) *70 + 20); break; }
            case 9 : { g.drawImage(new Image("data/CutePack/Base pack/HUD/hud_9.png"), 215, (posY-1) *70 + 20); break; }
        }
        
        switch(level.getItemCount())
        {
            case 0 : { g.drawImage(new Image("data/CutePack/Base pack/HUD/hud_0.png"), 295, (posY-1) *70 + 20); break; } 
            case 1 : { g.drawImage(new Image("data/CutePack/Base pack/HUD/hud_1.png"), 295, (posY-1) *70 + 20); break; }
            case 2 : { g.drawImage(new Image("data/CutePack/Base pack/HUD/hud_2.png"), 295, (posY-1) *70 + 20); break; }
            case 3 : { g.drawImage(new Image("data/CutePack/Base pack/HUD/hud_3.png"), 295, (posY-1) *70 + 20); break; }
            case 4 : { g.drawImage(new Image("data/CutePack/Base pack/HUD/hud_4.png"), 295, (posY-1) *70 + 20); break; }
            case 5 : { g.drawImage(new Image("data/CutePack/Base pack/HUD/hud_5.png"), 295, (posY-1) *70 + 20); break; }
            case 6 : { g.drawImage(new Image("data/CutePack/Base pack/HUD/hud_6.png"), 295, (posY-1) *70 + 20); break; }
            case 7 : { g.drawImage(new Image("data/CutePack/Base pack/HUD/hud_7.png"), 295, (posY-1) *70 + 20); break; }
            case 8 : { g.drawImage(new Image("data/CutePack/Base pack/HUD/hud_8.png"), 295, (posY-1) *70 + 20); break; }
            case 9 : { g.drawImage(new Image("data/CutePack/Base pack/HUD/hud_9.png"), 295, (posY-1) *70 + 20); break; }
        }
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
