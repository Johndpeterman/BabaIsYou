/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.kekeisyou.objects;

import com.mycompany.kekeisyou.Game;
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
 * @author John
 */
public class Wall extends GameObject {

    
    private float width = 32;
    private float height = 32;
    private boolean isBlock = false;
    
    Texture texture = Game.getInstance();
    
    public Wall(float x, float y, ObjectId id) {
        super(x, y, id);
    }
    
    public Wall(float x, float y, ObjectId id, boolean isBlock) {
        super(x, y, id);
        this.isBlock = isBlock;
    }

    
    public void tick(LinkedList<GameObject> object) {
        
    }

   
    public void render(Graphics g) {
        
        
        g.setColor(Color.WHITE);
        g.drawImage(texture.wall_sprite[0], (int)x, (int)y, null);
        
        /*
        Graphics2D g2d = (Graphics2D) g;
        g.setColor(Color.BLUE);
        g2d.draw(getBounds());
        g2d.draw(getBoundsTop());
        g2d.draw(getBoundsRight());
        g2d.draw(getBoundsLeft());
        
        */
    }
    
    public boolean isBlock() {
        return isBlock;
    }

    
     public Rectangle getBounds() { //bottom bound
        return new Rectangle((int) ((int)x + (width/2) - ((width/2)/2)), (int) ((int)y + (height/2)), (int)width/2, (int)height/2);
    }
    
    public Rectangle getBoundsTop() {
        return new Rectangle((int) ((int)x + (width/2) - ((width/2)/2)), (int)y, (int)width/2, (int)height/2);
    }
    
    public Rectangle getBoundsRight() {
        return new Rectangle((int) ((int)x + width-5), (int)y+5, (int)5, (int)height - 10);
    }
    
    public Rectangle getBoundsLeft() {
        return new Rectangle((int)x, (int)y + 5, (int)5, (int)height - 10);
    }    
}
