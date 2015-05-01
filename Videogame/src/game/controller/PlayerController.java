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
public abstract class PlayerController 
{
    protected Player player;
    
    public PlayerController(Player player)
    {
        this.player = player;
    }
    
    public abstract void handleInput(Input i, int delta);
    
}
