/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package game.state;

import game.Game;
import game.Musica.Musica;
import game.Musica.Musica1;
import game.character.Player;
import game.controller.MouseAndKeyBoardPlayerController;
import game.controller.PlayerController;
import game.controller.XBoxController;
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
    private Physics physics;
    private Musica cancion1;
    private Musica1 cancion2;
    private static Sound mjump;
    private int levelID;
    private float posX;
    private int posY;
    private TrueTypeFont font;
 
    public LevelState(String startingLevel, int levelID, int posY)
    {
        this.startingLevel = startingLevel;
        this.levelID = levelID;
        this.physics = new Physics();
        this.posX = 70f;
        this.posY = (posY*70 - 70);
    }
 
    public void init(GameContainer container, StateBasedGame sbg) throws SlickException 
    {   
        player = new Player(posX,(float) posY);
        level = new Level(startingLevel, player);
        playerController = new MouseAndKeyBoardPlayerController(player); 
//        playerController = new XBoxController(player); 
        physics = new Physics();
        physics.phsysics();
        try 
        {
            InputStream inputStream = ResourceLoader.getResourceAsStream("data/Fonts/DINL___.TTF");

            Font awtFont = Font.createFont(Font.TRUETYPE_FONT, inputStream);
            awtFont = awtFont.deriveFont(60f); // set font size
            font = new TrueTypeFont(awtFont, false);
        } catch (Exception e) {
            e.printStackTrace();
        }
        cancion1=new Musica();
        cancion2=new Musica1();
        mjump=new Sound("data/sound/jump_08.ogg");
    }
 
    public void update(GameContainer container, StateBasedGame sbg, int delta) throws SlickException 
    {
        playerController.handleInput(container.getInput(), delta);
        physics.handlePhysics(level,delta);
        if (getID()%2==0 && Game.ULTIMO_NIVEL!=getID()){
                if (!cancion1.sondando())cancion1.repoducir();
            }
        else if (Game.ULTIMO_NIVEL!=getID()){
                if (!cancion2.sondando())cancion2.repoducir();
            }
        else{
            cancion1.parada();
            cancion2.parada();
        }
        //R1
        if(container.getInput().isButtonPressed(5, 0))
        {     
            if (getID()%2==0){
                cancion1.rest();
            }else {
                cancion2.rest();
            }
            inputEnded();
            sbg.getCurrentState().leave(container, sbg);
            player.setX(posX);player.setY(posY);
            level.resetFrutas();
            sbg.enterState(levelID, new FadeOutTransition(Color.black,10), new FadeInTransition(Color.black,10));
        }
        if(container.getInput().isKeyDown(Input.KEY_R))
        {     
            if (getID()%2==0){
                cancion1.rest();
            }else {
                cancion2.rest();
            }
            inputEnded();
            sbg.getCurrentState().leave(container, sbg);
            player.setX(posX);player.setY(posY);
            level.resetFrutas();
            sbg.enterState(levelID, new FadeOutTransition(Color.black,10), new FadeInTransition(Color.black,10));
        }
        //Select
        if(container.getInput().isButtonPressed(6, 0))
        {
            if (getID()%2==0){
                cancion1.parada();
            }else {
                cancion2.parada();
            }
            inputEnded();
            leave(container, sbg);            
            player.setX(posX);player.setY(posY);
            level.resetFrutas();
            sbg.enterState(Game.ULTIMO_NIVEL, new FadeOutTransition(Color.black,10), new FadeInTransition(Color.black));
        }
        if(container.getInput().isKeyDown(Input.KEY_ESCAPE))
        {
            if (getID()%2==0){
                cancion1.parada();
            }else {
                cancion2.parada();
            }
            inputEnded();
            leave(container, sbg);            
            player.setX(posX);player.setY(posY);
            level.resetFrutas();
            sbg.enterState(Game.ULTIMO_NIVEL, new FadeOutTransition(Color.black,10), new FadeInTransition(Color.black));
        }
        if(Game.FRUITS_COLLECTED == level.getItemCount() && levelID != Game.ULTIMO_NIVEL-1)
        {      
            if (getID()%2==0){
                cancion1.parada();
            }else {
                cancion2.parada();
            }
            Game.FRUITS_COLLECTED = 0;
            level.resetItemCount();            
            leave(container, sbg);
            player.setX(posX);player.setY(posY);
            level.resetFrutas();            
            sbg.enterState(levelID+1, new FadeOutTransition(Color.black,10), new FadeInTransition(Color.black));
        } 
        else if(Game.FRUITS_COLLECTED == level.getItemCount() && levelID == Game.ULTIMO_NIVEL-1)
        {
            if (getID()%2==0){
                cancion1.parada();
            }else {
                cancion2.parada();
            }
            leave(container, sbg);
            player.setX(posX);player.setY(posY);
            level.resetFrutas();
            sbg.enterState(Game.ULTIMO_NIVEL, new FadeOutTransition(Color.black,10), new FadeInTransition(Color.black));
        }
    }
 
    public void render(GameContainer container, StateBasedGame sbg, Graphics g) throws SlickException 
    { 
        g.scale(Game.SCALE, Game.SCALE);        
        level.render();
        g.setFont(font);
        g.setColor(Color.black);
        g.drawString("NIVEL: "+levelID, 0,0);
        g.drawString("FRUTAS: "+Game.FRUITS_COLLECTED+"/"+level.getItemCount(),0,700);
    }
    
    public void controllerButtonPressed(int controller, int button)
    {        
        if(button == 1 && physics.sueloCierto == true) mjump.play();
    }
    
    public void keyPressed(int key, char code)
    {     
        if(key == Input.KEY_SPACE && physics.sueloCierto==true) mjump.play();
    }
    
    public int getID() 
    {
        return levelID;
    } 
}
