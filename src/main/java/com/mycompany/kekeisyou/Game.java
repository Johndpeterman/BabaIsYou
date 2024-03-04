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
import com.mycompany.kekeisyou.objects.Win_text;
import java.awt.Canvas;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.image.BufferStrategy;

/**
 *
 * @author John
 */
public class Game extends Canvas implements Runnable{
    
    
    private boolean running = false;
    private Thread thread;
    
    public static int WIDTH, HEIGHT;
    
    
    //object
    Handler handler;
    static Texture texture;
    
    private void initialize() {
        
        WIDTH = getWidth();
        HEIGHT = getHeight();
        
        texture = new Texture();
        
        handler = new Handler(); //creating a handler in order to add and remove objects in the initialization of the level
        
        //creating all the objects for the level
        handler.addObject(new Player(250, 250, handler, ObjectId.Player));
        handler.addObject(new Wall_text(300, 250, handler, ObjectId.Wall_text)); 
        handler.addObject(new Is_text(350, 250, handler, ObjectId.Is_text)); 
        handler.addObject(new Stop_text(400, 250, handler, ObjectId.Stop_text)); 
        handler.addObject(new Not_text(450, 250, handler, ObjectId.Not_text));
        
        handler.addObject(new Flag_text(350, 75, handler, ObjectId.Flag_text));
        handler.addObject(new Is_text(400, 75 + 32, handler, ObjectId.Is_text));
        handler.addObject(new Win_text(450, 75, handler, ObjectId.Win_text));
        handler.addObject(new Flag(550, 75, handler, ObjectId.Flag));
        
        //creating the walls for the level
        handler.createLevel1();
        
        //key listener for player input
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
        
        
        ////
        g.setColor(Color.black);
        g.fillRect(0, 0, getWidth(), getHeight()); //creating the black background for the window
        
        handler.render(g);
        
        ////
        g.dispose();
        bs.show();
        
    }
    
    
    public static Texture getInstance() { //creates an instance of the texture class to be applied to each object class
        return texture;
    }
    
    
    public static void main(String args[]) {
        new Window(800, 600, "Baba is You", new Game()); //launches game
    }
    
    
    
}
