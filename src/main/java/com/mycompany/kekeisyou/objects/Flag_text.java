/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.kekeisyou.objects;

import com.mycompany.kekeisyou.Game;
import com.mycompany.kekeisyou.Handler;
import com.mycompany.kekeisyou.framework.GameObject;
import com.mycompany.kekeisyou.framework.ObjectId;
import com.mycompany.kekeisyou.framework.Texture;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Rectangle;
import java.util.LinkedList;

/**
 *
 * @author peterman_882876
 */
public class Flag_text extends GameObject {
   
    private float width = 32;
    private float height = 32;
    private Handler handler;
    
    Texture texture = Game.getInstance();
    
    
    public Flag_text(float x, float y, Handler handler, ObjectId id) {
        super(x, y, id);
        this.handler = handler;
    }

    
    public void tick(LinkedList<GameObject> object) {
        x += velX;
        y += velY;
        Collision(object);
        
    }
    
    
    private void Collision(LinkedList<GameObject> object) {
        
        for (int i = 0; i < handler.object.size(); i++) {
            
            GameObject tempObject = handler.object.get(i);
            
            if (tempObject.getId() == ObjectId.Wall) {
                
                if (getBoundsTop().intersects(tempObject.getBounds())) {
                    
                    y = tempObject.getY() + height;
                    velX = 0;
                    velY = 0;
                }
                
                
                if (getBounds().intersects(tempObject.getBoundsTop())) {
                    y = tempObject.getY() - height;
                    velX = 0;
                    velY = 0;
                }
                
                if (getBoundsLeft().intersects(tempObject.getBoundsRight())) {
                    
                    x = tempObject.getX() + width;
                    velX = 0;
                    velY = 0;
                } 
                
            }
            
            if (tempObject.getId() == ObjectId.Is_text) {
                
                if (getBoundsTop().intersects(tempObject.getBounds())) {
                    tempObject.setVelY(velY);
                }
                if (getBounds().intersects(tempObject.getBoundsTop())) {
                     tempObject.setVelY(velY);
                     
                }
                
                if (getBoundsRight().intersects(tempObject.getBoundsLeft())) {
                    
                    //this employs an alternate algorithem to the locking strategy, but achieves the same thing
                    //when the right bounds of the flag_text object collide with the left bounds of the is_text object,
                    //then another for loop will find the ID of the win_text object,
                    //in which the right bounds of the is_text will be checked for collision with the left bounds of the win_text,
                    //then the flag will be enabled for win
                    tempObject.setVelX(velX);
                    for (int j = 0; j < handler.object.size(); j++) {
                        
                         GameObject tempObject2 = handler.object.get(j);
                         
                         if (tempObject2.getId() == ObjectId.Win_text) {
                             
                             if (tempObject.getBoundsRight().intersects(tempObject2.getBoundsLeft())) {
                                 handler.enable_win();
                             }
                         }
                    }
                }
                
                if (getBoundsLeft().intersects(tempObject.getBoundsRight())) {
                     tempObject.setVelX(velX);
                }
            }
            
            if (tempObject.getId() == ObjectId.Win_text) {

                
                if (getBoundsTop().intersects(tempObject.getBounds())) {
                    tempObject.setVelY(velY);
                }
                
                if (getBounds().intersects(tempObject.getBoundsTop())) {
                     tempObject.setVelY(velY);
                     
                }
                
                if (getBoundsRight().intersects(tempObject.getBoundsLeft())) {
                    tempObject.setVelX(velX);
                }
               
                if (getBoundsLeft().intersects(tempObject.getBoundsRight())) {
                     tempObject.setVelX(velX);
                }  
            }    
        }
    }

   
    public void render(Graphics g) {
        
        
        g.setColor(Color.WHITE);
        g.drawImage(texture.flag_text_sprite[0], (int)x, (int)y, null);
        /*
        Graphics2D g2d = (Graphics2D) g;
        g.setColor(Color.PINK);
        g2d.draw(getBounds());
        g2d.draw(getBoundsTop());
        g2d.draw(getBoundsRight());
        g2d.draw(getBoundsLeft());
        */
        
    }

     public Rectangle getBounds() { //bottom bound
        return new Rectangle((int) ((int)x + (width/2) - ((width/2)/2)), (int) ((int)y + (height/2)), (int)width/2, (int)height/2);
    }
    
    public Rectangle getBoundsTop() {
        return new Rectangle((int) ((int)x + (width/2) - ((width/2)/2)), (int)y, (int)width/2, (int)height/2);
    }
    
    public Rectangle getBoundsRight() {
        return new Rectangle((int) ((int)x + width-5), (int)y+3, (int)5, (int)height - 7);
    }
    
    public Rectangle getBoundsLeft() {
        return new Rectangle((int)x, (int)y + 3, (int)5, (int)height - 7);
    }
    
    
    
    
    
}
