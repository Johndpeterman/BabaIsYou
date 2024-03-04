/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.kekeisyou.framework;

import java.awt.Graphics;
import java.awt.Rectangle;
import java.util.LinkedList;

/**
 *
 * @author John
 */


//this class is the backing structure of the entire game, and is extended to every object I create in the game
public abstract class GameObject {
    
    //each object has an x, y coordinate, and x, y velocity
    protected float x;
    protected float y;
    protected float velX = 0;
    protected float velY = 0;
    
    protected ObjectId id; //as well as a unique id identifier located in an enum
   
    
    
    public GameObject(float x, float y, ObjectId id) {
        this.x = x;
        this.y = y;
        this.id = id;
    }
    
    //these methods are implemented in every extension of a gameobject, and represent the collision bounds of the object
    public abstract void tick(LinkedList<GameObject> object);
    public abstract void render(Graphics g);
    public abstract Rectangle getBounds();
    public abstract Rectangle getBoundsRight();
    public abstract Rectangle getBoundsLeft();
    public abstract Rectangle getBoundsTop();
    //
    
    //getters and setters
    public float getX() {
        return x;
    }
    
    public float getY() {
        return y;
    }
    
    public void setX(float x) {
        this.x = x;
    }
    
    public void setY(float y) {
        this.y = y;
    }
    
    public float getVelX() {
        return velX;
    }
    
    public float getVelY() {
        return velY;
    }
     
    public void setVelX(float velX) {
        this.velX = velX;
    }
    
    public void setVelY(float velY) {
        this.velY = velY;
    }
    
    public ObjectId getId() {
        return id;
    }
}
