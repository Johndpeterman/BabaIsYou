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
public class Victory_window {
    
    public Victory_window(int w, int h, String title, Victory vict) {
        
         vict.setPreferredSize(new Dimension(w, h));
         vict.setMaximumSize(new Dimension(w, h));
         vict.setMinimumSize(new Dimension(w, h));
        
        JFrame frame = new JFrame(title);
        frame.add(vict);
        frame.pack();
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setResizable(false);
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
        
        
        vict.start();
        
    }
    
    
    
    
}
