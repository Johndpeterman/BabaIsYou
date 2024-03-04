/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.kekeisyou.framework;

import com.mycompany.kekeisyou.BufferedImageLoader;
import java.awt.image.BufferedImage;

/**
 *
 * @author John
 */
public class Texture {
    
    //a sprite and buffered image is created for every texture in the game
    Sprite babaRight;
    Sprite babaLeft;
    Sprite babaDown;
    Sprite babaUp;
    
    Sprite wall;
    Sprite wall_text;
    Sprite is_text;
    Sprite stop_text;
    Sprite not_text;
    Sprite flag_text;
    Sprite win_text;
    Sprite flag;
    Sprite victory;
    Sprite thankyou;
    
    
    private BufferedImage babaSprite = null;
    private BufferedImage wallSprite = null;
    private BufferedImage wall_textSprite = null;
    private BufferedImage is_textSprite = null;
    private BufferedImage stop_textSprite = null;
    private BufferedImage not_textSprite = null;
    private BufferedImage flag_textSprite = null;
    private BufferedImage win_textSprite = null;
    private BufferedImage flagSprite = null;
    private BufferedImage victorySprite = null;
    private BufferedImage thankyouSprite = null;
    
    
    //these arrays of object sprites are necessary when one object has multiple sprites, like the player
    public BufferedImage[] player_sprite = new BufferedImage[4];
    public BufferedImage[] wall_sprite = new BufferedImage[1];
    public BufferedImage[] wall_text_sprite = new BufferedImage[1];
    public BufferedImage[] is_text_sprite = new BufferedImage[1];
    public BufferedImage[] stop_text_sprite = new BufferedImage[1];
    public BufferedImage[] not_text_sprite = new BufferedImage[1];
    public BufferedImage[] flag_text_sprite = new BufferedImage[1];
    public BufferedImage[] win_text_sprite = new BufferedImage[1];
    public BufferedImage[] flag_sprite = new BufferedImage[1];
    public BufferedImage[] victory_sprite = new BufferedImage[1];
    public BufferedImage[] thankyou_sprite = new BufferedImage[1];
    
    
    public Texture() {
        
        BufferedImageLoader loader = new BufferedImageLoader(); //class for loading the images from the files
        
        try{
            babaSprite = loader.loadBaba(); //the buffered image is loaded by the image loader, and then created as a new sprite to be put into it's respective array
        } catch(Exception e) {              //this is repeated for every single sprite (super annoying, and why using a sprite sheet is alot better)
            e.printStackTrace();
        }
        babaRight = new Sprite(babaSprite);
       
        try{
            babaSprite = loader.loadBabaLeft();
        } catch(Exception e) {
            e.printStackTrace();
        }
        babaLeft = new Sprite(babaSprite);
        
        try{
            babaSprite = loader.loadBabaUp();
        } catch(Exception e) {
            e.printStackTrace();
        }
        babaUp = new Sprite(babaSprite);
        
        try{
            babaSprite = loader.loadBabaDown();
        } catch(Exception e) {
            e.printStackTrace();
        }
        babaDown = new Sprite(babaSprite);
        
        
        
        
        try{
             wallSprite = loader.loadWall();  
        } catch(Exception e) {
            e.printStackTrace();
        }
        wall = new Sprite(wallSprite);
        
        try{
             wall_textSprite = loader.loadWallText();  
        } catch(Exception e) {
            e.printStackTrace();
        }
        wall_text = new Sprite(wall_textSprite);
        
        try{
             is_textSprite = loader.loadIsText();  
        } catch(Exception e) {
            e.printStackTrace();
        }
        is_text = new Sprite(is_textSprite);
        
        try{
             stop_textSprite = loader.loadStopText();  
        } catch(Exception e) {
            e.printStackTrace();
        }
        stop_text = new Sprite(stop_textSprite);
        
        try{
             not_textSprite = loader.loadNotText();  
        } catch(Exception e) {
            e.printStackTrace();
        }
        not_text = new Sprite(not_textSprite);
        
        try{
             flag_textSprite = loader.loadFlagText();  
        } catch(Exception e) {
            e.printStackTrace();
        }
        flag_text = new Sprite(flag_textSprite);
        
        try{
             win_textSprite = loader.loadWinText();  
        } catch(Exception e) {
            e.printStackTrace();
        }
        win_text = new Sprite(win_textSprite);
        
        try{
            flagSprite = loader.loadFlag();  
        } catch(Exception e) {
            e.printStackTrace();
        }
        flag = new Sprite(flagSprite);
        
        try{
            victorySprite = loader.loadVictory();  
        } catch(Exception e) {
            e.printStackTrace();
        }
        victory = new Sprite(victorySprite);
        
        try{
            thankyouSprite = loader.loadThankyou();  
        } catch(Exception e) {
            e.printStackTrace();
        }
        thankyou = new Sprite(thankyouSprite);
        
        getTextures();
        
    }
    
    
    private void getTextures() {
        
        player_sprite[0] = babaRight.getImage();
        player_sprite[1] = babaLeft.getImage();
        player_sprite[2] = babaUp.getImage();
        player_sprite[3] = babaDown.getImage();
        
        
        
        
        wall_sprite[0] = wall.getImage();
        wall_text_sprite[0] = wall_text.getImage();
        is_text_sprite[0] = is_text.getImage();
        stop_text_sprite[0] = stop_text.getImage();
        not_text_sprite[0] = not_text.getImage();
        flag_text_sprite[0] = flag_text.getImage();
        win_text_sprite[0] = win_text.getImage();
        flag_sprite[0] = flag.getImage();
        victory_sprite[0] = victory.getImage();
        thankyou_sprite[0] = thankyou.getImage();
        
    }
    
}
