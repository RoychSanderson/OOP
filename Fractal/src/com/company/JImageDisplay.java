package com.company;

import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;


public class JImageDisplay extends JComponent {
    public JImageDisplay(int width, int height){
        picture = new BufferedImage(width, height, BufferedImage.TYPE_INT_RGB);
        super.setPreferredSize(new Dimension(width,height));
    }

    @Override
    protected void paintComponent(Graphics g){
    super.paintComponent(g);
    g.drawImage(picture, 0, 0, picture.getWidth(), picture.getHeight(), null);
    }

    public void clearImage() {
    for (int x = 0; x < picture.getHeight(); x++){
        for (int y = 0; y < picture.getWidth(); y++){
            picture.setRGB(x,y,0);
        }
    }
    }
    public BufferedImage getPicture(){
        return picture;
    }
    public void drawPixel(int x, int y, int rgbColor){
        picture.setRGB(x,y,rgbColor);
    }
    private final BufferedImage picture;
}
