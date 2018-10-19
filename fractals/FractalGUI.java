/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fractals;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Point;
import java.awt.Toolkit;
import java.util.Random;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JSlider;
import javax.swing.JSpinner;
import javax.swing.SpinnerNumberModel;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

/**
 *
 * @author zdv5950
 */
public class FractalGUI extends JPanel implements ChangeListener{
    public final int WIDTH = 600;
    public final int HEIGHT = 600;
    private DrawFractal fractal;
    private JSpinner spinner;
    private int depth;
    private DrawPanel draw;
    public FractalGUI() {
        super(new BorderLayout());
        super.setPreferredSize(new Dimension(WIDTH, HEIGHT));
        setBackground(Color.white);
        draw = new DrawPanel();
        add(draw, BorderLayout.CENTER);
        
        JPanel slidePanel = new JPanel();
        spinner = new JSpinner(new SpinnerNumberModel(1, 1, 10, 1));
        spinner.addChangeListener(this);
        
        slidePanel.add(spinner);
        
        add(slidePanel, BorderLayout.SOUTH);
        
        
        depth = 1;
    }
    /**
     * @param args the command line arguments
     */
    private class DrawPanel extends JPanel {
        public DrawPanel() {
            super();
            fractal = new Box();
        }
        @Override
        public void paintComponent(Graphics g) {
            super.paintComponent(g);
            Random rand = new Random((long)Math.pow(depth, 30));
            Color color = new Color(rand.nextInt(256), rand.nextInt(256), rand.nextInt(256), 128);
        
            fractal.draw(g, depth, getWidth()/2, getHeight()/2, color);
        }
        
    }
    
    
    public static void main(String[] args) {
        FractalGUI gui = new FractalGUI();
        JFrame frame = new JFrame("Fractal"); //create frame to hold our JPanel subclass	
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	frame.getContentPane().add(gui);  //add instance of MyGUI to the frame
        frame.pack(); //resize frame to fit our Jpanel
        Dimension d = Toolkit.getDefaultToolkit().getScreenSize();
        frame.setLocation(new Point((d.width / 2) - (frame.getWidth() / 2), (d.height / 2) - (frame.getHeight() / 2)));
	//show the frame	
        frame.setVisible(true);
    }

    @Override
    public void stateChanged(ChangeEvent e) {
        depth = (int) spinner.getValue();
        repaint();
    }
    
}
