/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.kekeisyou;

import com.mycompany.kekeisyou.framework.GameObject;
import com.mycompany.kekeisyou.framework.KeyInput;
import com.mycompany.kekeisyou.framework.ObjectId;
import com.mycompany.kekeisyou.framework.Texture;
import com.mycompany.kekeisyou.objects.Flag;
import com.mycompany.kekeisyou.objects.Flag_text;
import com.mycompany.kekeisyou.objects.Wall_text;
import com.mycompany.kekeisyou.objects.Player;
import com.mycompany.kekeisyou.objects.Stop_text;

import com.mycompany.kekeisyou.objects.Wall;
import com.mycompany.kekeisyou.objects.Is_text;
import com.mycompany.kekeisyou.objects.Not_text;
import com.mycompany.kekeisyou.objects.Thankyou_object;
import com.mycompany.kekeisyou.objects.Victory_object;
import com.mycompany.kekeisyou.objects.Win_text;
import java.awt.Canvas;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.image.BufferStrategy;

/**
 *
 * @author John
 */

//this class is an adaptation of the game class, that represents the window that opens when the level is completed
//I didn't know how to add images or text into a window, so my workaround was basically creating a new "game" upon
//completing the level, and having the images and text be game objects that I can add in with the handler class, as seen in line 58
public class Victory extends Canvas implements Runnable{
    
    private boolean running = false;
    private Thread thread;
    
    public static int WIDTH, HEIGHT;
    
    
    Handler handler;
    static Texture texture;
    
    private void initialize() {
        
        WIDTH = getWidth();
        HEIGHT = getHeight();
        
        texture = new Texture();
        
        
        handler = new Handler();
        
        
        handler.addObject(new Victory_object(0, 0, handler, ObjectId.Victory_object));
        handler.addObject(new Thankyou_object(640 - (593/2), 0, handler, ObjectId.Thankyou_object));
        
        this.addKeyListener(new KeyInput(handler));
        
    }
    
    public synchronized void start() {
        
        if (running) {
            return;
        }
            running = true;
            thread = new Thread(this);
            thread.start();
        
        
    }
   
    
    public void run() {
        
        initialize();
        this.requestFocus();
        
        long lastTime = System.nanoTime();
        double amountOfTicks = 60.0;
        double ns = 1000000000 / amountOfTicks;
        double delta = 0;
        long timer = System.currentTimeMillis();
        int updates = 0;
        int frames = 0;
        while(running){
                long now = System.nanoTime();
                delta += (now - lastTime) / ns;
                lastTime = now;
                while(delta >= 1){
                        tick();
                        updates++;
                        delta--;
                }
                render();
                frames++;

                if(System.currentTimeMillis() - timer > 1000){
                        timer += 1000;
                        //System.out.println("FPS: " + frames + " TICKS: " + updates);
                        frames = 0;
                        updates = 0;
                }
        }
        
        
    }
    
    private void tick() {
        
        handler.tick();
    }
    
    private void render() {
        
        BufferStrategy bs = this.getBufferStrategy();
        if (bs == null) {
            this.createBufferStrategy(3);
            return;
        }
        
        Graphics g = bs.getDrawGraphics();
        /////
        //draw here
        g.setColor(Color.white);
        g.fillRect(0, 0, getWidth(), getHeight()); //background
        
        handler.render(g);
        
        g.dispose();
        bs.show();
        
    }
    
    
    public static Texture getInstance() {
        return texture;
    }
    
    
    
    
    
    
}
