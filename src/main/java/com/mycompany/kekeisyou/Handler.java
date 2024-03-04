/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.kekeisyou;

import com.mycompany.kekeisyou.framework.GameObject;
import com.mycompany.kekeisyou.framework.ObjectId;
import com.mycompany.kekeisyou.objects.Wall_text;
import com.mycompany.kekeisyou.objects.Wall;
import java.awt.Graphics;
import java.util.LinkedList;

/**
 *
 * @author John
 */
public class Handler {
    
    //a linked list of all objects present in the game
    //will be used to loop through and identify the desired object using its ID in the enum, and control its collision, etc
    public LinkedList<GameObject> object = new LinkedList<GameObject>(); 
    
    private GameObject tempObject;
    
    //a boolean value that is responsible for turning off and on wall collision
    //backs the main logic of level 1
    private boolean wall_collision = true;
    
    //boolean value that determines the status of the level being completed or not -- only has an enable method
    private boolean flag_win = false;
    
    //these following lock booleans are what back up all the logic behind the basis of the game
    //these enable me to push objects into statements, and have those statements evoke some change in the game
    //each of these lock values have their respective get, enable, and disable methods
    //if all locks are enabled, the statement is effectively "unlocked" and allows the statement that was formed in the game to be evoked
    //this enabling and disabling happens between the collision of objects
    private boolean lock1 = false;
    private boolean lock2 = false;
    private boolean lock3 = false;
    
    private boolean altlock1 = false;
    private boolean altlock2 = false;
    
    //these boolean values are for updating the sprite of the moveable character and the respective key is pressed
    private boolean rightSprite = true;
    private boolean leftSprite = false;
    private boolean upSprite = false;
    private boolean downSprite = false;
    
    public void tick() {
        for (int i = 0; i < object.size(); i++) {
            tempObject = object.get(i);
            tempObject.tick(object);
        }
    }
    
    public void render(Graphics g) {
        for (int i = 0; i < object.size(); i++) {
            tempObject = object.get(i);
            tempObject.render(g);
        }
    }
    
    //adding and removing game objects from linked list
    public void addObject(GameObject object) {
        this.object.add(object);
    }
    public void removeObject(GameObject object) {
        this.object.remove(object);
    }
    
    //turning off/on wall collision
    public boolean get_wall_collision() {
        return wall_collision;
    }
    public boolean disable_wall_collision() {
        return wall_collision = false;
    }
    public boolean enable_wall_collision() {
        return wall_collision = true;
    }
    
    //collision between wall_text and is_text
    public boolean get_lock1() {
        return lock1;
    }
    public boolean enable_lock1() {
        return lock1 = true;
    }
    public boolean disable_lock1() {
        return lock1 = false;
    }
    
    //collision between is_text and not_text
    public boolean get_lock2() {
        return lock2;
    }
    public boolean enable_lock2() {
        return lock2 = true;
    }
    public boolean disable_lock2() {
        return lock2 = false;
    }
    
    //collision between not_text and stop_text
    public boolean get_lock3() {
        return lock3;
    }
    public boolean enable_lock3() {
        return lock3 = true;
    }
    public boolean disable_lock3() {
        return lock3 = false;
    }
    
    //collision between flag_text and is_text
    public boolean get_altlock1() {
        return altlock1;
    }
    public boolean enable_altlock1() {
        return altlock1 = true;
    }
    public boolean disable_altlock1() {
        return altlock1 = false;
    }
    
    //collision between is_text and win_text
    public boolean get_altlock2() {
        return altlock2;
    }
    public boolean enable_altlock2() {
        return altlock2 = true;
    }
    public boolean disable_altlock2() {
        return altlock2 = false;
    }
    
    //player sprites for key input
    ////
    public boolean getRightSprite() {
        return rightSprite;
    }
    public boolean evokeRightSprite() {
        upSprite = false;
        downSprite = false;
        leftSprite = false;
        return rightSprite = true;
    }
    
    public boolean getLeftSprite() {
        return leftSprite;
    }
    public boolean evokeLeftSprite() {
        upSprite = false;
        downSprite = false;
        rightSprite = false;
        return leftSprite = true;
    }
    
    public boolean getUpSprite() {
        return upSprite;
    }
    public boolean evokeUpSprite() {
        leftSprite = false;
        downSprite = false;
        rightSprite = false;
        return upSprite = true;
    }
    
    public boolean getDownSprite() {
        return downSprite;
    }
    public boolean evokeDownSprite() {
        upSprite = false;
        leftSprite = false;
        rightSprite = false;
        return downSprite = true;
    }
    ////
    
    //win status
    public boolean get_win() {
        return flag_win;
    }
    public boolean enable_win() {
        return flag_win = true;
    }
    
    public void createLevel1() { //creating the first level with walls
        
        for (int x = 200; x < Game.WIDTH - 200; x += 32 ) { //bottom walls
            addObject(new Wall(x, 400, ObjectId.Wall));
        }
        
        for (int x = 200; x < Game.WIDTH - 200; x += 32 ) { //top walls
            addObject(new Wall(x, 176, ObjectId.Wall));
        }
        
        for (int y = 208; y < Game.HEIGHT - 200; y += 32 ) { //left walls
            addObject(new Wall(200, y, ObjectId.Wall));
        }
        
        for (int y = 208; y < Game.HEIGHT - 200; y += 32 ) { //right walls
            addObject(new Wall(584, y, ObjectId.Wall));
        }
    }
    
    public void createLevel2() {
        
        addObject(new Wall(400, 300, ObjectId.Wall));
    }
    
    
    
}
