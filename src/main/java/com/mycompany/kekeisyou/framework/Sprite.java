/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.kekeisyou.framework;

import java.awt.image.BufferedImage;

/**
 *
 * @author John
 */
public class Sprite {
    
    private BufferedImage image;
    
    public Sprite(BufferedImage image) {
        this.image = image;
    }
    
    //initially was used to get the subimage of a spritesheet, but now just returns a single sprite of whatever bufferedImage it's given
    public BufferedImage getImage() {
        //BufferedImage img = image.getSubimage((col * width) - width, (row * height) - height, width, height);
        return image;
    }
    
}
