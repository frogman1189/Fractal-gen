/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fractals;

import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.Graphics;
import java.util.Random;

/**
 *
 * @author zdv5950
 */
public class Box implements DrawFractal{

    public Box() {
        
    }
    public void draw(Graphics g, int depth, int x, int y, Color color) {
        System.out.println("Drawing a fractal at depth: " + depth);
        if(depth > 0) {
            g.setColor(color);
            //int width = depth * 10;
            //int width = (int)Math.pow(2, depth);
            int width = (int) Math.abs(0.01 * (5 * depth * depth - 2) * ( 2 * depth * depth - 3));
            //int width = depth * x * y / 5000;
            g.drawRect(x - width/2, y- width/2, width, width);
            if(depth > 1) {
                Random rand = new Random((long)Math.pow(depth, 30));
                color = new Color(rand.nextInt(256), rand.nextInt(256), rand.nextInt(256), rand.nextInt(100));
                color = new Color(color.getRed() + 20, color.getGreen() + 30, color.getBlue() + 10, 128);
                draw(g, depth - 1, x + width/2, y + width/2, color);
                draw(g, depth - 1, x - width/2, y + width/2, color);
                draw(g, depth - 1, x + width/2, y - width/2, color);
                draw(g, depth - 1, x - width/2, y - width/2, color);
                
                draw(g, depth - 1, x - width / 3, y - width, color);
                draw(g, depth - 1, x - width / 3, y + width, color);
                draw(g, depth - 1, x + width, y - width / 3, color);
                draw(g, depth - 1, x - width, y - width / 3, color);
            } 
        }
        
    }
    
}
