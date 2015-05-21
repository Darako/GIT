/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package game.controller;

import game.character.Player;
import org.newdawn.slick.Input;

/**
 *
 * @author Darako
 */
public class XBoxController extends PlayerController
{
    public XBoxController(Player player)
    {
        super(player);
    }
    
    public void handleInput(Input i, int delta)
    {
        //handle any input from the keyboard
        handleKeyboardInput(i,delta);
    }
    
    private void handleKeyboardInput(Input i, int delta)
    {
        //we can both use the WASD or arrow keys to move around, obviously we can't move both
        if(i.isControllerLeft(0))
        {        
            //player.setCrouch(false);
            player.moveLeft(delta);
        }
        else if(i.isControllerRight(0))
        {       
            //player.setCrouch(false);
            player.moveRight(delta);
        }    
//        else if (i.isControllerDown(0))
//        {
//            //player.setMoving(false);
//            player.crouching(delta);
//        }
        else
        {            
            player.setMoving(false);
            player.standing(delta);
        }
        
        if(i.isButton1Pressed(0))
        {
            player.jump();
        }
        
    }
}
