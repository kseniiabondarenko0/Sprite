package SpriteSheet;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class ViewButton extends JButton {
     BufferedImage myImage;
    int drawX;
    int drawY;
    ViewButton() throws IOException {
        this.myImage = ImageIO.read(new File("src/main/java/SpriteSheet/SpriteSheet.png"));
        setBounds(0,0, myImage.getWidth()/4, myImage.getHeight()/4);
    }

    public void startAnimation(){
        Animate anim = new Animate(myImage, 32, 32, 16);
        anim.start();
    }

    void setNewCoorditanes(int x, int y){
        this.drawX=x;
        this.drawY=y;
        repaint();
    }
    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        g.drawImage(myImage, drawX, drawY, this);

    }

    public class Animate extends Thread{
        private final int spriteWidth;
        private final int spriteHeight;
        private final int numSprites;
        private final int[][] coordinates;
        private final BufferedImage spriteSheet;


        public Animate(BufferedImage spriteSheet, int spriteWidth, int spriteHeight, int numSprites) {
            this.spriteWidth = spriteWidth;
            this.spriteHeight = spriteHeight;
            this.numSprites = numSprites;
            this.coordinates = new int[numSprites][2];
            this.spriteSheet = spriteSheet;
        }

        @Override
        public void run() {
            System.out.println(spriteSheet.getHeight());


                int spriteIndex = 0;
                for (int y = 0; y > spriteSheet.getHeight() *(-1); y -= spriteSheet.getHeight()/4) {
                    for (int x = 0; x > spriteSheet.getWidth() * (-1); x -= spriteSheet.getWidth()/4) {
//
                        spriteIndex++;
                        setNewCoorditanes(x, y);
                        try {
                            sleep(1000/7);
                        } catch (InterruptedException e) {
                            throw new RuntimeException(e);
                        }
                    }
                }
            }

        public int[][] getCoordinates() {
            return coordinates;
        }


    }
}
