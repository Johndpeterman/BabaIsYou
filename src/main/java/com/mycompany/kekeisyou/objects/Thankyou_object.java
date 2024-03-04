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
public class Thankyou_object extends GameObject {
    //pink
    private float width = 128;
    private float height = 128;
    private Handler handler;
    
    Texture texture = Game.getInstance();
    
    
    public Thankyou_object(float x, float y, Handler handler, ObjectId id) {
        super(x, y, id);
        this.handler = handler;
    }

    
    public void tick(LinkedList<GameObject> object) {
    }
    
    public void render(Graphics g) {
        
        //rendering congrats image
        
        g.drawImage(texture.thankyou_sprite[0], (int)x, (int)y, null);
        
        
    }

    //abstract methods--ignore
    @Override
    public Rectangle getBounds() {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public Rectangle getBoundsRight() {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public Rectangle getBoundsLeft() {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public Rectangle getBoundsTop() {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    
    
    
    
    
}
