package au.edu.sydney.Curracurrong.queryLanguage;

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

import javax.swing.*;
import java.awt.image.*;
import java.awt.*;


/**
 * Creates panel contains image which gets in its constructor
 * @author Saeed Attar
 * University of Sydney
 */
public class ImagePanel extends JPanel {
	
    private static final long serialVersionUID = 1L;
    private BufferedImage backgroundImage;

    /**
     * Constructor
     * @param img input image in BufferedImage format
     */
    public ImagePanel(BufferedImage img) {
            super();

            this.setBackground(Color.white);
            setLayout(new BorderLayout());
            setLayout(new BorderLayout());

            ImageIcon icon = new ImageIcon(img);
            JLabel label = new JLabel();
            label.setIcon(icon);
            this.add(label);


            JScrollPane scrollPane = new JScrollPane(label);
            setPreferredSize(new Dimension(450, 500));
            this.add(scrollPane, BorderLayout.CENTER);


    }

    @Override
    public void paintComponent(Graphics g) {
            super.paintComponents(g);
            g.drawImage(this.backgroundImage, 0, 0, null);
    }
}
