/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.kekeisyou;

import java.awt.Dimension;
import javax.swing.JFrame;

/**
 *
 * @author John
 */
public class Window {
    
    
    public Window(int w, int h, String title, Game game) {
        
         game.setPreferredSize(new Dimension(w, h));
         game.setMaximumSize(new Dimension(w, h));
         game.setMinimumSize(new Dimension(w, h));
        
        JFrame frame = new JFrame(title);
        frame.add(game);
        frame.pack();
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setResizable(false);
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
        
        
        game.start();
        
    }
    
    
    
}
