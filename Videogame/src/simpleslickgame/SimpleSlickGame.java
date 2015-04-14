/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package simpleslickgame;

import org.newdawn.slick.Animation;
import org.newdawn.slick.AppGameContainer;
import org.newdawn.slick.BasicGame;
import org.newdawn.slick.GameContainer;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.Image;
import org.newdawn.slick.Input;
import org.newdawn.slick.geom.*;
import org.newdawn.slick.tiled.TiledMap;

/**
 *
 * @author Jorge
 */
public class SimpleSlickGame extends BasicGame  
{   
    private TiledMap mapa;
    private Input entrada;
    private Animation spritePersonaje, spriteAnterior, right, left, jumpRight, jumpLeft, stay, crouchRight, crouchLeft;
    private float personajeX = 280f, personajeY = 560f;
    private float velocidadX = 0f, velocidadY = 0f;
    private Rectangle personajeRect;
    private Rectangle[][] terreno;
    private float aceleracion = 0.25f;
    private float gravedad = 0.50f;
    private float fuerzaSalto = 0.50f;
    private boolean jumping = false;  
    private boolean[][] bloques;   
    private boolean suelo = false;
    private static final int SIZE = 70;    
    
    public SimpleSlickGame(String gamename)
    {
        super(gamename);
    }
    
    @Override
    public void init(GameContainer gc) throws SlickException
    {
        mapa = new TiledMap("data/MapaPrueba02.tmx");
        Image [] movStay = 
        {
            new Image("data\\Personaje\\Front\\p1_front.png")
        };
        
        Image [] movCrouchRight = 
        {
            new Image("data\\Personaje\\Crouch\\p1_duck_R.png")
        };
        
        Image [] movCrouchLeft = 
        {
            new Image("data\\Personaje\\Crouch\\p1_duck_L.png")
        };
        
        Image [] movJumpRight = 
        {
            new Image("data\\Personaje\\Jump\\p1_jump_R.png")
        };
        
        Image [] movJumpLeft = 
        {
            new Image("data\\Personaje\\Jump\\p1_jump_L.png")
        };
        
        Image [] movRight = 
        {
            new Image("data\\Personaje\\Right\\p1_walk01.png"), 
            new Image("data\\Personaje\\Right\\p1_walk02.png"),
            new Image("data\\Personaje\\Right\\p1_walk03.png"),
            new Image("data\\Personaje\\Right\\p1_walk04.png"),
            new Image("data\\Personaje\\Right\\p1_walk05.png"),
            new Image("data\\Personaje\\Right\\p1_walk06.png"),
            new Image("data\\Personaje\\Right\\p1_walk07.png"),
            new Image("data\\Personaje\\Right\\p1_walk08.png"),
            new Image("data\\Personaje\\Right\\p1_walk09.png"),
            new Image("data\\Personaje\\Right\\p1_walk10.png"),
            new Image("data\\Personaje\\Right\\p1_walk11.png")
        };
       
        Image [] movLeft = 
        {
            new Image("data\\Personaje\\Left\\p1_walk01.png"), 
            new Image("data\\Personaje\\Left\\p1_walk02.png"),
            new Image("data\\Personaje\\Left\\p1_walk03.png"),
            new Image("data\\Personaje\\Left\\p1_walk04.png"),
            new Image("data\\Personaje\\Left\\p1_walk05.png"),
            new Image("data\\Personaje\\Left\\p1_walk06.png"),
            new Image("data\\Personaje\\Left\\p1_walk07.png"),
            new Image("data\\Personaje\\Left\\p1_walk08.png"),
            new Image("data\\Personaje\\Left\\p1_walk09.png"),
            new Image("data\\Personaje\\Left\\p1_walk10.png"),
            new Image("data\\Personaje\\Left\\p1_walk11.png")
        };     
        
        int [] movDuration = {100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100};
        int [] jumpDuration = {250};
       
        right = new Animation(movRight, movDuration, false);
        left = new Animation(movLeft, movDuration, false);
        jumpRight = new Animation(movJumpRight, jumpDuration, false);
        jumpLeft = new Animation(movJumpLeft, jumpDuration, false);
        crouchRight = new Animation(movCrouchRight, jumpDuration, false);
        crouchLeft = new Animation(movCrouchLeft, jumpDuration, false);
        stay = new Animation(movStay,jumpDuration,false);
        spritePersonaje = stay;
        
        // build a collision map based on tile properties in the TileD map
        bloques = new boolean[mapa.getWidth()][mapa.getHeight()];
        terreno = new Rectangle[mapa.getWidth()][mapa.getHeight()];
        
        personajeRect = new Rectangle(personajeX,personajeY,spritePersonaje.getWidth(),spritePersonaje.getHeight());
        
        for (int i=0;i<mapa.getWidth(); i++)
        {
            for (int j=0;j<mapa.getHeight(); j++)
            {
                int tileID = mapa.getTileId(i, j, 1);
                String value = mapa.getTileProperty(tileID, "suelo", "false"); 
                if (value.equals("true"))
                {
                    System.out.println("dentro en "+i+","+j+" con valor "+value);
                    bloques[i][j] = true;
                    Rectangle recAux = new Rectangle((float) i * SIZE, (float) j * SIZE, (float) SIZE, (float) SIZE);
                    terreno[i][j] = recAux;
                }                
                else
                {
                    bloques[i][j] = false;
                    terreno[i][j] = null;
                }
            }
        }     
    }
    
    @Override
    public void update(GameContainer gc, int delta) throws SlickException{
        movimiento(delta);        
    }
    
    @Override
    public void render(GameContainer gc, Graphics g) throws SlickException{
        mapa.render(0,0);
        entrada = gc.getInput();
        spritePersonaje.draw((int)personajeX, (int)personajeY);
        g.drawRect(personajeRect.getX(),personajeRect.getY(), personajeRect.getWidth(), personajeRect.getHeight());
        for (int i=0;i<mapa.getWidth(); i++)
        {
            for (int j=0;j<mapa.getHeight(); j++)
            {
                if(terreno[i][j]!=null)
                {
                    g.drawRect(terreno[i][j].getX(),terreno[i][j].getY(), terreno[i][j].getWidth(), terreno[i][j].getHeight());
                }
            }
        }
        int x, y;
        x = (int) (personajeX/SIZE);
        y = (int) (personajeY/SIZE);
        suelo = bloques[x][y];
        g.drawString("Posicion del personaje: "+personajeX/SIZE+","+personajeY/SIZE+"\nPosicion del cubo de debajo: "+personajeX/SIZE+","+(personajeY+spritePersonaje.getHeight())/SIZE+"\n Suelo: "+suelo,70,70);
    }       
    
    //MAIN
    public static void main(String[] args) {
        try
        {
            AppGameContainer appgc = new AppGameContainer(new SimpleSlickGame("Juegazo Papitos"));
            appgc.setDisplayMode(840, 840, false);
            appgc.start();            
        }catch (SlickException ex) {}
    }        
    
    //LOGICA DE MOVIMIENTO
    private void movimiento(int delta)
    {
        //SI PULSAMOS BOTON ARRIBA
        if(entrada.isKeyDown(entrada.KEY_UP))
        {
            if(!enColision(personajeRect,"arriba"))
            {                
                if(spriteAnterior == left && !enColision(personajeRect,"izquierda"))
                {
                    spritePersonaje=jumpLeft;
                    spritePersonaje.update(delta);
                    personajeX -= aceleracion * delta;
                    personajeY -= fuerzaSalto * delta;
                    personajeRect.setY(personajeY);
                    personajeRect.setX(personajeX);
                    jumping = true;
                }
                else if(spriteAnterior == right && !enColision(personajeRect,"derecha"))
                {
                    spritePersonaje=jumpRight;
                    spritePersonaje.update(delta);
                    personajeX += aceleracion * delta;
                    personajeY -= fuerzaSalto * delta;
                    personajeRect.setY(personajeY);
                    personajeRect.setX(personajeX);
                    jumping = true;
                }
                else
                {
                    spritePersonaje=jumpRight;
                    spritePersonaje.update(delta);
                    personajeY -= fuerzaSalto * delta;
                    personajeRect.setY(personajeY);
                    jumping = true;
                }
            }
            else
            {
                jumping = true;
            }
        }     
        else if(jumping)
        {            
            if(enColision(personajeRect,"abajo"))
            {
                jumping = false;
            }
            else
            {
                spritePersonaje.update(delta);
                personajeY += gravedad * delta;
                personajeRect.setY(personajeY);
                spriteAnterior = spritePersonaje;
                if(spriteAnterior == left)
                {
                    personajeX -= aceleracion * delta;
                    personajeRect.setX(personajeX);
                    /*if(!enColision(personajeRect,"izquierda"))
                    {
                        personajeX -= aceleracion * delta;
                        personajeRect.setX(personajeX);
                    }      */
                }
                else if(spriteAnterior == right)
                {
                    personajeX += aceleracion * delta;
                    personajeRect.setX(personajeX);
                    /*if(!enColision(personajeRect,"derecha"))
                    {
                        personajeX += aceleracion * delta;
                        personajeRect.setX(personajeX);
                    }           */     
                }
            }                      
        }
        //SI PULSAMOS BOTON DERECHO
        else if(entrada.isKeyDown(entrada.KEY_RIGHT))
        {
            spritePersonaje = right;            
            spriteAnterior = spritePersonaje;
            spritePersonaje.update(delta);
            personajeX += aceleracion * delta;
            personajeRect.setX(personajeX);
            if(!enColision(personajeRect,"abajo"))
            {
                jumping = true;
            }
        }
        //SI PULSAMOS BOTON IZQUIERDO
        else if(entrada.isKeyDown(entrada.KEY_LEFT))
        {
            spritePersonaje = left;
            spriteAnterior = spritePersonaje;
            spritePersonaje.update(delta);
            personajeX -= aceleracion * delta;
            personajeRect.setX(personajeX);
            if(!enColision(personajeRect,"abajo"))
            {
                jumping = true;
            }
        }
        //SI PULSAMOS BOTON ABAJO
        else if(entrada.isKeyDown(entrada.KEY_DOWN))
        {
            if(spriteAnterior == left)
            {
                spritePersonaje=crouchLeft;
                spritePersonaje.update(delta);
            }
            else if(spriteAnterior == right || spriteAnterior == stay )
            {
                spritePersonaje=crouchRight;
                spritePersonaje.update(delta);
            }
        }        
        //SI ESTA QUIETO
        else
        {
           spritePersonaje = stay; 
        }     
    }
    
    //METODOS AUXILIARES    
    private boolean esBloque(int x, int y)
    {        
        return bloques[x][y];
    }
    
    private boolean enColision(Rectangle personaje, String posicion)
    {
        switch(posicion)
        {
            case "arriba":
            {
                int xBlock = (int) personaje.getCenterX() / SIZE;
                int yBlock = (int) personaje.getMaxY() / SIZE - 1;
                if(esBloque(xBlock, yBlock))
                {
                    return personaje.intersects(terreno[xBlock][yBlock]);
                }
                else
                {
                    return false;
                }
            }
            case "abajo":
            {
                int xBlock = 0;
                int yBlock = 0;
                if(spritePersonaje == right)
                {
                    xBlock = (int) personaje.getMinX() / SIZE;
                    yBlock = (int) (personaje.getMinY())/ SIZE + 1;
                }
                else if(spritePersonaje == left)
                {
                    xBlock = (int) personaje.getMaxX() / SIZE;
                    yBlock = (int) (personaje.getMinY())/ SIZE + 1; 
                }
                else
                {
                    xBlock = (int) personaje.getCenterX() / SIZE;
                    yBlock = (int) (personaje.getMinY())/ SIZE + 1;
                }                
                //System.out.println("debajo tengo x,y:"+xBlock+","+yBlock);
                if(esBloque(xBlock, yBlock))
                {
                    return personaje.intersects(terreno[xBlock][yBlock]);
                }
                else
                {
                    return false;
                }
            }
            case "derecha":
            {
                int xBlock = (int) personaje.getMaxX() / SIZE + 1;
                int yBlock = (int) personaje.getCenterY()  / SIZE;
                if(esBloque(xBlock, yBlock))
                {
                    return personaje.intersects(terreno[xBlock][yBlock]);
                }
                else
                {
                    return false;
                }
            }
            case "izquierda":
            {
                int xBlock = (int) personaje.getMinX() / SIZE - 1;
                int yBlock = (int) personaje.getCenterY()  / SIZE;
                if(esBloque(xBlock, yBlock))
                {
                    return personaje.intersects(terreno[xBlock][yBlock]);
                }
                else
                {
                    return false;
                }
            }
            default: { return false; }
        }         
    }
}
