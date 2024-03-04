/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.kekeisyou.objects;

import com.mycompany.kekeisyou.Game;
import com.mycompany.kekeisyou.Handler;
import com.mycompany.kekeisyou.Victory;
import com.mycompany.kekeisyou.Victory_window;
import com.mycompany.kekeisyou.framework.GameObject;
import com.mycompany.kekeisyou.framework.ObjectId;
import com.mycompany.kekeisyou.framework.Texture;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Rectangle;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Set;

/**
 *
 * @author John Peterman
 */

//pretty much every other gameObject is a duplicate of one another besides the player class, with slight differences that I will document
public class Player extends GameObject{

    
    private float width = 32;
    private float height = 32;
    private Handler handler;
    boolean did_we_win = false; //this is in place to make sure the player doesn't "win" the game hundreds of times when
                                //colliding with the flag
    
    Texture texture = Game.getInstance(); //creating the instance of the texture class
    
    public Player(float x, float y, Handler handler, ObjectId id) {
        super(x, y, id);
        this.handler = handler;
    }
    
    public void tick(LinkedList<GameObject> object) {
        x += velX;
        y += velY;
        
        Collision(object); //collision constantly being ticked
        
    }
    
    private void Collision(LinkedList<GameObject> object) {
        
        //locking sequences that enable and disable wall collision
        ///////////////////
        if (handler.get_lock1() == true && handler.get_lock2() == true && handler.get_lock3() == true) {
            handler.disable_wall_collision();
        }
        
        if (handler.get_altlock1() == true && handler.get_altlock2() == true) {
            handler.enable_wall_collision();
        }
        ///////////////////
        //////////////////
        for (int i = 0; i < handler.object.size(); i++) {
            
            GameObject tempObject = handler.object.get(i);
            
         if (handler.get_wall_collision() == true) {
             
            if (tempObject.getId() == ObjectId.Wall) { //checking if the player is colliding with the wall

                //checks if the bounds of the player interesects with the bounds of the wall, and sets the player's velocity to 0
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
                
                if (getBoundsRight().intersects(tempObject.getBoundsLeft())) {
                     x = tempObject.getX() - width;
                    
                    velX = 0;
                    velY = 0;
                }
                
                if (getBoundsLeft().intersects(tempObject.getBoundsRight())) {
                     x = tempObject.getX() + width;
                    
                    velX = 0;
                    velY = 0;
                }
            }
         }
         
         //////////////////////////////
            ///experimentation--ignore
            if (tempObject.getId() == ObjectId.Wall_text) {
                
                for (int j = 0; j < handler.object.size(); j++) {
            
                    GameObject tempObject1 = handler.object.get(j);
                    
                    if (tempObject1.getId() == ObjectId.Wall) {
                        
                        if (tempObject.getBoundsRight().intersects(tempObject1.getBoundsLeft())) {
                            velX = 0;
                        }   
                    }
                }
            }
         //////////////////////////////   
            //////////////////////////////
            if (tempObject.getId() == ObjectId.Wall_text) { //the following if statements represent the collision between each object in the game and the player
                                                            //it simply sets the velocity of the object it's colliding with to the velocity of the player

                if (getBoundsTop().intersects(tempObject.getBounds())) {
                    tempObject.setVelY(velY);
                }
                else if (velY == 0 ){
                   tempObject.setVelY(0);
                }
                
                if (getBounds().intersects(tempObject.getBoundsTop())) {
                     tempObject.setVelY(velY);
                     
                }
                
                if (getBoundsRight().intersects(tempObject.getBoundsLeft())) {
                    
                    
                    tempObject.setVelX(velX);
                }
                else if (velX == 0 ){
                   tempObject.setVelX(0);
                }
                
                if (getBoundsLeft().intersects(tempObject.getBoundsRight())) {
                     tempObject.setVelX(velX);
                }  
             }
            /////////////////////////////

            
            ////////////////////////////////
            if (tempObject.getId() == ObjectId.Is_text) {
                
                if (getBoundsTop().intersects(tempObject.getBounds())) {
                    tempObject.setVelY(velY);
                }
                else if (velY == 0 ){
                   tempObject.setVelY(0);
                }
                
                if (getBounds().intersects(tempObject.getBoundsTop())) {
                     tempObject.setVelY(velY);
                }
                
                if (getBoundsRight().intersects(tempObject.getBoundsLeft())) {
                    tempObject.setVelX(velX);
                }
                else if (velX == 0 ){
                   tempObject.setVelX(0);
                }
                
                if (getBoundsLeft().intersects(tempObject.getBoundsRight())) {
                     tempObject.setVelX(velX);
                }    
            }
            
            
            /////////////////////////////////
            if (tempObject.getId() == ObjectId.Stop_text) {
                
                if (getBoundsTop().intersects(tempObject.getBounds())) {
                    tempObject.setVelY(velY);
                }
                else if (velY == 0 ){
                   tempObject.setVelY(0);
                }
                
                if (getBounds().intersects(tempObject.getBoundsTop())) {
                     tempObject.setVelY(velY);
                     
                }
                
                if (getBoundsRight().intersects(tempObject.getBoundsLeft())) {
                    tempObject.setVelX(velX);
                    
                }
                else if (velX == 0 ){
                   tempObject.setVelX(0);
                }
                
                if (getBoundsLeft().intersects(tempObject.getBoundsRight())) {
                     tempObject.setVelX(velX);
                }  
            }
            
            /////////////////////////////////
            if (tempObject.getId() == ObjectId.Not_text) {
                
                if (getBoundsTop().intersects(tempObject.getBounds())) {
                    tempObject.setVelY(velY);
                }
                else if (velY == 0 ){
                   tempObject.setVelY(0);
                }
                
                if (getBounds().intersects(tempObject.getBoundsTop())) {
                     tempObject.setVelY(velY);  
                }
                
                if (getBoundsRight().intersects(tempObject.getBoundsLeft())) {
                    tempObject.setVelX(velX);
                }
                else if (velX == 0 ){
                   tempObject.setVelX(0);
                }
                
                if (getBoundsLeft().intersects(tempObject.getBoundsRight())) {
                     tempObject.setVelX(velX);
                }
            }
            
            ////////////////////////////////////
            if (tempObject.getId() == ObjectId.Flag_text) {
                
                if (getBoundsTop().intersects(tempObject.getBounds())) {
                    tempObject.setVelY(velY);
                }
                else if (velY == 0 ){
                   tempObject.setVelY(0);
                }
                
                if (getBounds().intersects(tempObject.getBoundsTop())) {
                     tempObject.setVelY(velY);
                }
                
                if (getBoundsRight().intersects(tempObject.getBoundsLeft())) {
                    tempObject.setVelX(velX);
                }
                else if (velX == 0 ){
                   tempObject.setVelX(0);
                }
                
                if (getBoundsLeft().intersects(tempObject.getBoundsRight())) {
                     tempObject.setVelX(velX);
                }
            }
            
            ////////////////////////////////////
            if (tempObject.getId() == ObjectId.Win_text) {
                
                if (getBoundsTop().intersects(tempObject.getBounds())) {
                    tempObject.setVelY(velY);
                }
                else if (velY == 0 ){
                   tempObject.setVelY(0);
                }
                
                if (getBounds().intersects(tempObject.getBoundsTop())) {
                     tempObject.setVelY(velY); 
                }
                
                if (getBoundsRight().intersects(tempObject.getBoundsLeft())) {
                    tempObject.setVelX(velX);
                }
                else if (velX == 0 ){
                   tempObject.setVelX(0);
                }
                
                if (getBoundsLeft().intersects(tempObject.getBoundsRight())) {
                     tempObject.setVelX(velX);
                }
            }
            //////////////////////////////////
            
            
        if (handler.get_win() == true) { //the win status is enabled in the flag_text class, representing
                                             //when the flag is win statement has been completing
                                             //once it has, the player class will check if it's colliding with the flag and launch the victory window
                
            if (tempObject.getId() == ObjectId.Flag) { //checking if the player is colliding with the flag

                
                if (getBoundsTop().intersects(tempObject.getBounds()) && did_we_win == false) {
                    new Victory_window(1280, 720, "Congratulations!", new Victory());
                    velY = 0;
                    did_we_win = true;
                }
                
                
               
                if (getBounds().intersects(tempObject.getBoundsTop()) && did_we_win == false) {
                     new Victory_window(1280, 720, "Congratulations!", new Victory());
                     velY = 0;
                     did_we_win = true;
                }
                
                
                
                if (getBoundsRight().intersects(tempObject.getBoundsLeft()) && did_we_win == false) {
                    new Victory_window(1280, 720, "Congratulations!", new Victory());
                    velX = 0;
                    did_we_win = true;
                }
                
                
                if (getBoundsLeft().intersects(tempObject.getBoundsRight()) && did_we_win == false) {
                    new Victory_window(1280, 720, "Congratulations!", new Victory());
                    velX = 0;
                    did_we_win = true;
                }
            }  
        }
    }
}
    
    @Override
    public void render(Graphics g) { //renders the sprites for the player based on the sprite methods in the handler
        
        g.setColor(Color.WHITE);
        
        
        if (handler.getRightSprite() == true) {
            g.drawImage(texture.player_sprite[0], (int)x, (int)y, null);
        }
        
        if (handler.getLeftSprite() == true) {
            g.drawImage(texture.player_sprite[1], (int)x, (int)y, null);
        }
        
        if (handler.getUpSprite() == true) {
            g.drawImage(texture.player_sprite[2], (int)x, (int)y, null);
        }
        
        if (handler.getDownSprite() == true) {
            g.drawImage(texture.player_sprite[3], (int)x, (int)y, null);
        }
        
        //this draws the collision bounds for me to visualize
        /*
        Graphics2D g2d = (Graphics2D) g;
        g.setColor(Color.RED);
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
        //return new Rectangle((int)x, (int)y + 5, (int)5, (int)height - 10);
        return new Rectangle((int)x, (int)y+3, (int)5, (int)height - 7);
    }
}
