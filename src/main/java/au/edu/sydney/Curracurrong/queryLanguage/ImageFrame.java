package au.edu.sydney.Curracurrong.queryLanguage;

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

import java.awt.image.*;
import javax.swing.*;

/**
 * 
 * @author Saeed Attar
 * University of Sydney
 */
public class ImageFrame {

    private BufferedImage image;

    /**
     * Constructor of class 
     * @param img input image in BufferedImage format
     */
    public ImageFrame(BufferedImage img) {
        image = img;
    }

    /**
     * Creates and show image frame
     * @param h height of frame
     * @param w width of frame
     */
    @SuppressWarnings("deprecation")
    public void show(int h, int w) {
        JFrame frame = new JFrame();
        frame.setSize(w+30, h+30);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);        
        ImagePanel panel = new ImagePanel(image);      
        frame.getContentPane().add(panel);         
        frame.show();
    }
}
