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
    private ArrayList<Character> characters;
    private ArrayList<LevelObject> levelObjects;
    private Tile[][] tiles;
    private Player player;
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
            System.err.println("Map does not have the layer \"FruitLayer\"");
            System.exit(0);
        }
        
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
        map.render(-(offsetX%70), -(offsetY%70),  offsetX/70,  offsetY/70, 42, 14); 
        for(LevelObject obj : levelObjects)
        {
            obj.render(offsetX, offsetY);
        }
        for(Character c : characters)
        {
            c.render(offsetX,offsetY);
        }        
    }
    
    private void loadTileMap()
    {
        tiles = new Tile[map.getWidth()][map.getHeight()];
        
        int layerIndex = map.getLayerIndex("CollisionLayer");
        if(layerIndex == -1)
        {
            System.err.println("Map does not have the layer \"CollisionLayer\"");
            System.exit(0);
        }
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
        int halfWidth = (int) (Game.WINDOW_WIDTH/Game.SCALE/2);
        int maxX = (int) (map.getWidth()*70) - halfWidth;
        if(player.getX() < halfWidth)
        {
            offsetX=0;
        }
        else if(player.getX() > maxX)
        {
            offsetX = maxX - halfWidth;
        }
        else
        {
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
