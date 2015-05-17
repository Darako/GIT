/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package game.level.object;

import game.level.LevelObject;
import org.newdawn.slick.Animation;
import org.newdawn.slick.Image;
import org.newdawn.slick.SlickException;

/**
 *
 * @author Darako
 */
public class Objective extends LevelObject
{
    protected Animation animation;
    
    Image [] sandia = 
    {
        new Image("data/CutePack/Frutas/Sandia/Sandia_Sandia01.png"),
        new Image("data/CutePack/Frutas/Sandia/Sandia_Sandia02.png"),
        new Image("data/CutePack/Frutas/Sandia/Sandia_Sandia03.png"),
        new Image("data/CutePack/Frutas/Sandia/Sandia_Sandia04.png"),
        new Image("data/CutePack/Frutas/Sandia/Sandia_Sandia05.png"),
    };
    
    Image [] uva = 
    {
        new Image("data/CutePack/Frutas/Uva/Uva_Uva01.png"),
        new Image("data/CutePack/Frutas/Uva/Uva_Uva02.png"),
        new Image("data/CutePack/Frutas/Uva/Uva_Uva03.png"),
        new Image("data/CutePack/Frutas/Uva/Uva_Uva04.png"),
        new Image("data/CutePack/Frutas/Uva/Uva_Uva05.png"),
    };
    
    Image [] manzana = 
    {
        new Image("data/CutePack/Frutas/Manzana/Manzana_Manzana01.png"),
        new Image("data/CutePack/Frutas/Manzana/Manzana_Manzana02.png"),
        new Image("data/CutePack/Frutas/Manzana/Manzana_Manzana03.png"),
        new Image("data/CutePack/Frutas/Manzana/Manzana_Manzana04.png"),
        new Image("data/CutePack/Frutas/Manzana/Manzana_Manzana05.png"),
    };
    
    Image [] pera = 
    {
        new Image("data/CutePack/Frutas/Pera/Pera_Pera01.png"),
        new Image("data/CutePack/Frutas/Pera/Pera_Pera02.png"),
        new Image("data/CutePack/Frutas/Pera/Pera_Pera03.png"),
        new Image("data/CutePack/Frutas/Pera/Pera_Pera04.png"),
        new Image("data/CutePack/Frutas/Pera/Pera_Pera05.png"),
    };
                                              
    
    public Objective(float x, float y, String fruit) throws SlickException
    {
        super(x,y);
        switch(fruit)
        {
            case "manzana":
            {
                animation = new Animation(manzana,new int[]{200,100,200,100,200});
                animation.setPingPong(true);
                break;
            }
            case "uva":
            {
                animation = new Animation(uva,new int[]{200,100,200,100,200});
                animation.setPingPong(true);
                break;
            }
            case "sandia":
            {
                animation = new Animation(sandia,new int[]{200,100,200,100,200});
                animation.setPingPong(true);
                break;
            }
            case "pera":
            {
                animation = new Animation(pera,new int[]{200,100,200,100,200});
                animation.setPingPong(true);
                break;
            }
        }
//        animation = new Animation(sandia,new int[]{200,100,200,100,200});
//        animation.setPingPong(true);
    }
    
    public void render(float offsetX, float offsetY)
    {
        animation.draw(x-offsetX, y-offsetY);
    }
}
