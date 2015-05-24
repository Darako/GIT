/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package game.character;

import game.enums.Facing;
import game.physics.AABoundingRect;
import java.util.HashMap;
import org.newdawn.slick.Animation;
import org.newdawn.slick.Image;
import org.newdawn.slick.SlickException;

/**
 *
 * @author Darako
 */
public class Player extends Character 
{ 
    Image [] movRight = 
    {
        new Image("data/Mapuski/Walk/mapuski_walk_01.png"), 
        new Image("data/Mapuski/Walk/mapuski_walk_02.png"), 
        new Image("data/Mapuski/Walk/mapuski_walk_03.png"), 
        new Image("data/Mapuski/Walk/mapuski_walk_04.png"), 
        new Image("data/Mapuski/Walk/mapuski_walk_05.png")
    };
    
    Image [] stand =
    {
        new Image("data/Mapuski/Stand/mapuski_stand_01.png"), 
        new Image("data/Mapuski/Stand/mapuski_stand_02.png"), 
        new Image("data/Mapuski/Stand/mapuski_stand_03.png"), 
        new Image("data/Mapuski/Stand/mapuski_stand_04.png"), 
        new Image("data/Mapuski/Stand/mapuski_stand_05.png")          
    };
    
    Image [] crouched =
    {
        new Image("data/Mapuski/Crouch/mapuski_crouch_01.png"), 
        new Image("data/Mapuski/Crouch/mapuski_crouch_02.png"), 
        new Image("data/Mapuski/Crouch/mapuski_crouch_03.png"), 
        new Image("data/Mapuski/Crouch/mapuski_crouch_04.png"), 
        new Image("data/Mapuski/Crouch/mapuski_crouch_05.png"),          
        new Image("data/Mapuski/Crouch/mapuski_crouch_06.png")          
    };
    
    public Player(float x, float y) throws SlickException
    {
        super(x,y);
        setSprite(new Image("data/Mapuski/Stand/mapuski_stand_01.png"));
        setMovingAnimation(movRight, 100);
//        setCrouchingAnimation(crouched, 100);
        setStandingAnimation(stand, 100);
//        setStandingAnimation(crouched, 100);
        boundingShape = new AABoundingRect(x+5,y+2,60,66);
        accelerationSpeed = 0.005f;
        maximumSpeed = 0.25f;
        maximumFallSpeed = 0.5f;
        decelerationSpeed = 0.001f;
    }

    
    public void updateBoundingShape()
    {
        boundingShape.updatePosition(x+5, y+2);
    }
}
