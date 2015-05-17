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
public class MouseAndKeyBoardPlayerController extends PlayerController
{
    public MouseAndKeyBoardPlayerController(Player player)
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
        if(i.isKeyDown(Input.KEY_A) || i.isKeyDown(Input.KEY_LEFT))
        {
            player.moveLeft(delta);
        }
        else if(i.isKeyDown(Input.KEY_D) || i.isKeyDown(Input.KEY_RIGHT))
        {
            player.moveRight(delta);

        }
        else
        {            
            player.setMoving(false);
            player.standing(delta);
        }
        if(i.isKeyDown(Input.KEY_SPACE))
        {
            player.jump();
        }
    }
}
