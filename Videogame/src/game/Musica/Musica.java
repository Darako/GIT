/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package game.Musica;

import org.newdawn.slick.Music;
import org.newdawn.slick.SlickException;

/**
 *
 * @author pedro
 */
public class Musica {
    
    private Music music;

    public Musica() throws SlickException {
        music=new Music("data/sound/2.ogg",true);
    }
    
    public boolean sondando(){
        if (music.playing()) return true;
        else return false;
    }
    
    public void repoducir(){
        music.play();
    }
    
    public void parada(){
        music.stop();
    }
    
    public void rest(){
        music.stop();
        music.play();        
    }
}
