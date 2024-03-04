/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.kekeisyou;

import java.awt.image.BufferedImage;
import java.io.FileInputStream;
import java.io.IOException;
import javax.imageio.ImageIO;

/**
 *
 * @author John
 */
public class BufferedImageLoader {
    
    private BufferedImage baba;
    private BufferedImage babaLeft;
    private BufferedImage babaUp;
    private BufferedImage babaDown;
    
    
    
    private BufferedImage wall;
    private BufferedImage wall_text;
    private BufferedImage is_text;
    private BufferedImage stop_text;
    private BufferedImage not_text;
    private BufferedImage flag_text;
    private BufferedImage win_text;
    private BufferedImage flag;
    private BufferedImage babaisyou;
    private BufferedImage thankyou;
    
    ///these methods will read the files present in the res folder and
    ///return them for the bufferedImages listed above
    ////these will be used to load the image into a sprite class
    
    ////baba sprites
    public BufferedImage loadBaba() {
        
        try {
            //baba = ImageIO.read(getClass().getResource(path));
            baba = ImageIO.read(new FileInputStream("res/baba.png"));
        } catch(IOException e) {
            e.printStackTrace();
        }
        
        return baba;
    }
    
    public BufferedImage loadBabaLeft() {
        
        try {
            babaLeft = ImageIO.read(new FileInputStream("res/baba_left.png"));
        } catch(IOException e) {
            e.printStackTrace();
        }
        
        return babaLeft;
    }
    
    public BufferedImage loadBabaUp() {
        
        try {
            babaUp = ImageIO.read(new FileInputStream("res/baba_up.png"));
        } catch(IOException e) {
            e.printStackTrace();
        }
        
        return babaUp;
    }
    
    public BufferedImage loadBabaDown() {
        
        try {
            babaDown = ImageIO.read(new FileInputStream("res/baba_down.png"));
        } catch(IOException e) {
            e.printStackTrace();
        }
        
        return babaDown;
    }
    ////
    
    public BufferedImage loadWall() {
        
        try {
            wall = ImageIO.read(new FileInputStream("res/wall.png"));
        } catch(IOException e) {
            e.printStackTrace();
        }
        
        return wall; 
    }
    
    public BufferedImage loadWallText() {
        
        try {
            wall_text = ImageIO.read(new FileInputStream("res/wall_text.png"));
        } catch(IOException e) {
            e.printStackTrace();
        }
        
        return wall_text;
    }
    
    public BufferedImage loadIsText() {
        
        try {
            is_text = ImageIO.read(new FileInputStream("res/is_text.png"));
        } catch(IOException e) {
            e.printStackTrace();
        }
        
        return is_text;
    }
    
    public BufferedImage loadStopText() {
        
        try {
            stop_text = ImageIO.read(new FileInputStream("res/stop_text.png"));
        } catch(IOException e) {
            e.printStackTrace();
        }
        
        return stop_text;
    }
    
    public BufferedImage loadNotText() {
        
        try {
            not_text = ImageIO.read(new FileInputStream("res/not_text.png"));
        } catch(IOException e) {
            e.printStackTrace();
        }
        
        return not_text;
    }
    
    public BufferedImage loadFlagText() {
        
        try {
            flag_text = ImageIO.read(new FileInputStream("res/flag_text.png"));
        } catch(IOException e) {
            e.printStackTrace();
        }
        
        return flag_text;
    }
    
    public BufferedImage loadWinText() {
        
        try {
            win_text = ImageIO.read(new FileInputStream("res/win_text.png"));
        } catch(IOException e) {
            e.printStackTrace();
        }
        
        return win_text;
    }
    
    public BufferedImage loadFlag() {
        
        try {
            flag = ImageIO.read(new FileInputStream("res/flag.png"));
        } catch(IOException e) {
            e.printStackTrace();
        }
        
        return flag;
    }
    
    public BufferedImage loadVictory() {
        
        try {
            babaisyou = ImageIO.read(new FileInputStream("res/babaisyou.jpg"));
        } catch(IOException e) {
            e.printStackTrace();
        }
        
        return babaisyou;
    }
    
    public BufferedImage loadThankyou() {
        
        try {
            thankyou = ImageIO.read(new FileInputStream("res/thanksforplaying.png"));
        } catch(IOException e) {
            e.printStackTrace();
        }
        
        return thankyou;
    }
}
