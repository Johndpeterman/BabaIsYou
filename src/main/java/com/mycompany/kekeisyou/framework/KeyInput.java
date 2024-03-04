/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.kekeisyou.framework;

import com.mycompany.kekeisyou.Game;
import com.mycompany.kekeisyou.Handler;
import com.mycompany.kekeisyou.Window;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author John Peterman
 */
public class KeyInput extends KeyAdapter{
    
    
    Handler handler;
    public KeyInput(Handler handler) {
        this.handler = handler;
    }
    
    /**
     *
     * @param e
     */
    @Override
    public void keyPressed(KeyEvent e) {
        
        int key = e.getKeyCode();
        
        //this loops through the linked list of game objects, and sets a tempObject as the object at i
        //finding the objectid of this tempObject can select the object as the one to manipulate
        for (int i = 0; i < handler.object.size(); i++) {
            
            GameObject tempObject = handler.object.get(i);
            
            //normal baba is you movement
            /*
            if (tempObject.getId() == ObjectId.Player) {
                
                //baba movement
                int currentX = (int) tempObject.getX();
                if(key == KeyEvent.VK_RIGHT) 
                    tempObject.setX(currentX += 32);
                
                if(key == KeyEvent.VK_LEFT) 
                    tempObject.setX(currentX -= 32);
                
                int currentY = (int) tempObject.getY();
                if(key == KeyEvent.VK_UP) 
                    tempObject.setY(currentY -= 32);
                
                if(key == KeyEvent.VK_DOWN) 
                    tempObject.setY(currentY += 32);
            }
            */
            
            //smooth movement
            if (tempObject.getId() == ObjectId.Player) { //checking if the temporary object is the player
                
                
                if(key == KeyEvent.VK_RIGHT) {
                    tempObject.setVelX(5);
                    handler.evokeRightSprite(); //sets the current player sprite to the current key pressed
                }
                
                if(key == KeyEvent.VK_LEFT) {
                    tempObject.setVelX(-5);
                    handler.evokeLeftSprite();
                }
                
                
                if(key == KeyEvent.VK_UP) {
                    tempObject.setVelY(-5);
                    handler.evokeUpSprite();
                }
                
                if(key == KeyEvent.VK_DOWN) {
                    tempObject.setVelY(5);
                    handler.evokeDownSprite();
                }
            }
            
        }
        
        
        
        if(key == KeyEvent.VK_ESCAPE) {
            System.exit(0);
        }
        
        
        
        
        
    }
    
    
    public void keyReleased(KeyEvent e) {
        
        int key = e.getKeyCode();
        
        for (int i = 0; i < handler.object.size(); i++) {
            
            GameObject tempObject = handler.object.get(i);
            
            if (tempObject.getId() == ObjectId.Player) { //checking if the temporary object is the player
                
                
                
                if(key == KeyEvent.VK_RIGHT) //stops the player on release of key
                    tempObject.setVelX(0);
                
                if(key == KeyEvent.VK_LEFT) 
                    tempObject.setVelX(0);
                
                
                if(key == KeyEvent.VK_UP) 
                    tempObject.setVelY(0);
                
                if(key == KeyEvent.VK_DOWN) 
                    tempObject.setVelY(0);

                    
                
                
            }
            
            
        }
        
        
    }
    
}
