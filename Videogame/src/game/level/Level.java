/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package game.level;

import game.Game;
import game.character.Character;
import game.character.Player;
import game.level.object.Objective;
import game.level.tile.AirTile;
import game.level.tile.SolidTile;
import game.level.tile.Tile;
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
    //a list of the objects in this map (excluding characters)
    private ArrayList<LevelObject> levelObjects;
    //a list of our tiles
    private Tile[][] tiles;
    //Our player
    private Player player;
    //Item count
    private int itemCount;
    private int posY;
 
    public Level(String level, Player player) throws SlickException
    {
        map = new TiledMap("data/Niveles/"+level+".tmx");
        characters = new ArrayList<Character>();
        levelObjects = new ArrayList<LevelObject>();
        this.player = player;
        addCharacter(player);
        loadTileMap();
        itemCount = 0;
        posY = 0;
        cargaObjetos();
    }
    
    public float getPosY()
    {
        return (float) posY;
    }
    
    public void resetFrutas() throws SlickException
    {
        removeObjects(levelObjects);
        resetItemCount();
        Game.FRUITS_COLLECTED=0;
        cargaObjetos();
    }
    
    private void cargaObjetos() throws SlickException
    {
        int layerIndex = map.getLayerIndex("FruitLayer");
        if(layerIndex == -1)
        {
            //TODO we can clean this up later with an exception if we want, but because we
            //make the maps ourselfs this will suffice for now
            System.err.println("Map does not have the layer \"FruitLayer\"");
            System.exit(0);
        }
        
        //loop through the whole map
        for(int x = 0; x < map.getWidth(); x++)
        {
            for(int y = 0; y < map.getHeight(); y++)
            {
                int tileID = map.getTileId(x, y, layerIndex);
                Tile tile = null;
                switch(map.getTileProperty(tileID, "tileType", "none"))
                {
                    case "manzana":
                    {
                        addLevelObject(new Objective(x*70,y*70,"manzana"));itemCount++;break;
                    }
                    case "sandia":
                    {
                        addLevelObject(new Objective(x*70,y*70,"sandia"));itemCount++;break;
                    }
                    case "uva":
                    {
                        addLevelObject(new Objective(x*70,y*70,"uva"));itemCount++;break;
                    }
                    case "pera":
                    {
                        addLevelObject(new Objective(x*70,y*70,"pera"));itemCount++;break;
                    }
                    default:
                        break;
                }
            }
        }
        posY = map.getHeight() -1;
    }
     
    public void render()
    {
        int offsetX = getXOffset();
        int offsetY = getYOffset();
        
        //render the map first
        map.render(-(offsetX%70), -(offsetY%70),  offsetX/70,  offsetY/70, 42, 14);
 
        for(LevelObject obj : levelObjects)
        {
            obj.render(offsetX, offsetY);
        }
        
        //and then render the characters on top of the map
        for(Character c : characters)
        {
            c.render(offsetX,offsetY);
        }
        
    }
    
    private void loadTileMap()
    {
        //create an array to hold all the tiles in the map
        tiles = new Tile[map.getWidth()][map.getHeight()];
        
        int layerIndex = map.getLayerIndex("CollisionLayer");
        if(layerIndex == -1)
        {
            //TODO we can clean this up later with an exception if we want, but because we
            //make the maps ourselfs this will suffice for now
            System.err.println("Map does not have the layer \"CollisionLayer\"");
            System.exit(0);
        }
        
        //loop through the whole map
        //System.out.println("Ancho: "+map.getWidth()+" Alto: "+map.getHeight());
        for(int x = 0; x < map.getWidth(); x++)
        {
            for(int y = 0; y < map.getHeight(); y++)
            {
                int tileID = map.getTileId(x, y, layerIndex);
                Tile tile = null;
                switch(map.getTileProperty(tileID, "tileType", "solid"))
                {
                    case "air":
                        tile = new AirTile(x,y); break;
                    default:
                        tile = new SolidTile(x,y); break;
                }
                tiles[x][y] = tile;
            }
        }
    }
    
    public ArrayList<LevelObject> getLevelObjects()
    {
        return levelObjects;
    }
    
    public void addLevelObject(LevelObject obj)
    {
        levelObjects.add(obj);
    }
    
    public ArrayList<Character> getCharacters()
    {
        return characters;
    }
    
    public void addCharacter(Character c)
    {
        characters.add(c);
    }
    
    public Tile[][] getTiles()
    {
        return tiles;
    }
    
    public int getXOffset()
    {
        int offsetX = 0;
        
        //the first thing we are to need is the half-width of the screen, 
        //to calculate if the player is in the middle of the screen
        int halfWidth = (int) (Game.WINDOW_WIDTH/Game.SCALE/2);
        
        //next up is the maximum offset, this is the most right side of the map
        //mis half of the the screen
        int maxX = (int) (map.getWidth()*70) - halfWidth;
        
        //now we hace 3 cases here
        if(player.getX() < halfWidth)
        {
            //the player is between the most lef side of the map, whis is zero and half a screen
            //wich is 0+halfSceen
            offsetX=0;
        }
        else if(player.getX() > maxX)
        {
            //the player is between the maximum point of scrolling and the maximum width of the map
            //the reason why we substract half the screen again is because we need to set our offset to the
            //top left position of our screen
            offsetX = maxX - halfWidth;
        }
        else
        {
            //the player is in between the 2 spots, so we set the offset
            //to the player, minus the halfWidth of ths screen
            offsetX = (int) (player.getX() - halfWidth);
        }
        return offsetX;
    }
    
    public int getYOffset()
    {
        int offsetY = 0;
        int halfHeight = (int) (Game.WINDOW_HEIGTH/Game.SCALE/2);
        int maxY = (int) (map.getHeight()*70) - halfHeight;
        
        if(player.getY()<halfHeight)
        {
            offsetY = 0;
        }
        else if(player.getY() > maxY)
        {
            offsetY = maxY - halfHeight;
        }
        else
        {
            offsetY = (int) (player.getY() - halfHeight);
        }
        return offsetY;
    }
    
    public void removeObject(LevelObject obj)
    {
        levelObjects.remove(obj);
    }
    
    public void removeObjects(ArrayList<LevelObject> objects) 
    {
        levelObjects.removeAll(objects);
    }
    
    public int getItemCount()
    {
        return itemCount;
    }
    
    public void resetItemCount()
    {
        itemCount = 0;
    }
        
}
