/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package game.level;

import game.character.Character;
import java.util.ArrayList;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.tiled.TiledMap;

/**
 *
 * @author Darako
 */
public class Level 
{
 
    private TiledMap map;
 
    //a list of all characters present somewhere on this map
    private ArrayList<Character> characters;
 
    public Level(String level) throws SlickException
    {
        map = new TiledMap("data/MapaPrueba02.tmx");
        characters = new ArrayList<Character>();
    }
 
    public void addCharacter(Character c)
    {
        characters.add(c);
    }
    
    public void render()
    {
        //render the map first
        map.render(0, 0, 0, 0, 12, 12);
 
        //and then render the characters on top of the map
        for(Character c : characters)
        {
            c.render();
        }
    }
}
