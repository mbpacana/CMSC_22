package com.edu4java.minitennis8;


import java.awt.*;;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import javax.swing.*;
import javax.swing.JPanel;
import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;
@SuppressWarnings("serial")
public class Game extends JPanel {
    Ball ball = new Ball(this);//creating a ball class to isolate all the code using ball
    //we pass 'this' so that we can use the methods in this class like getwidth na getheight
    float speed = 1;
    Boolean playstart = true;//show menu screen
    Boolean oneplayer = true;//know if one player or two

    Racquet racquet1 = new Racquet(this,1);//creating a racket class to isolate all the code using ball
    Racquet racquet2 = new Racquet(this,2);

    private BufferedImage image, image2;

    PowerUp pow = new PowerUp(this);
    public Game() {
        try {//loading images
            image = ImageIO.read(new File("C:/Users/User/Documents/Second Year First Sem/MP4 Pong/src/com/edu4java/minitennis8/res/Pong.png"));
            image2 = ImageIO.read(new File("C:/Users/User/Documents/Second Year First Sem/MP4 Pong/src/com/edu4java/minitennis8/res/back.png"));
        } catch (IOException ex) {
            System.out.println("File not found");
        }
        addKeyListener(new KeyListener() {//to know if there is user input
            @Override
            public void keyTyped(KeyEvent e) {
            }
            @Override
            public void keyReleased(KeyEvent e) {
                if (e.getKeyCode() == KeyEvent.VK_LEFT ||e.getKeyCode() == KeyEvent.VK_RIGHT)//to stop user
                    racquet1.keyReleased(e);
                if (e.getKeyCode() == KeyEvent.VK_A ||e.getKeyCode() == KeyEvent.VK_D)
                    racquet2.keyReleased(e);
            }
            @Override
            public void keyPressed(KeyEvent e) {//to move user
                if(playstart){// know whther user wants one player or two player
                    if( e.getKeyCode() == KeyEvent.VK_2){ oneplayer = false; playstart = false; }
                    else if(e.getKeyCode() == KeyEvent.VK_1){ oneplayer = true; playstart = false;}
                }
                else {//movement
                    if (e.getKeyCode() == KeyEvent.VK_LEFT || e.getKeyCode() == KeyEvent.VK_RIGHT)
                        racquet1.keyPressed(e);
                    if (e.getKeyCode() == KeyEvent.VK_A || e.getKeyCode() == KeyEvent.VK_D)
                        racquet2.keyPressed(e);
                }
            }
        });
        setFocusable(true);//so that we can see them
    }

    private boolean move() {//moving of objects during the actual game
        boolean replay = true;//replay of game and not game over
        if(!playstart) {//will move it is not in menu screen
            replay = ball.move();
            racquet1.move();
            pow.move();
            racquet2.move();
        }
        return replay;
    }

    @Override
    public void paint (Graphics g) {//actual "render in slick"
        super.paint(g);
        Graphics2D g2d = (Graphics2D) g;
        g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING,//make it a lot more smooth
                RenderingHints.VALUE_ANTIALIAS_ON);
        if (playstart){
            g2d.drawImage(image, 45, 10,200,100, this);//draws the image I loaded
            g2d.setColor(Color.RED);//here we show the score of the particular person
            g2d.setFont(new Font("Verdana", Font.BOLD, 25));//set font and font size
            g2d.drawString(" PING PONG LAND", 10, 150);//title
            g2d.setColor(Color.BLUE);//setting of color
            g2d.setFont(new Font("Verdana", Font.BOLD, 12));//settingo of font, and font size
            g2d.drawString(" Press 1 for Single Player", 50, 180);//string to be displayed
            g2d.drawString(" Press 2 for Double Player", 50, 200);//string to be displayed
        }
        else {
            g2d.drawImage(image2, 0, 0, 350,500, this);//image added as background
            pow.paint(g2d);
            ball.paint(g2d);//paints ball all time
            racquet1.paint(g2d);//paints racket all time
            if(!oneplayer) {//if not one player, then racket 2 will be printed
                racquet2.paint(g2d);
                g2d.setColor(Color.GRAY);//There we show the score of the particular person
                g2d.setFont(new Font("Verdana", Font.BOLD, 30));
                g2d.drawString(String.valueOf(racquet2.getScore()), 10, 30);
            }
            g2d.setColor(Color.GRAY);//here we show the score of the particular person
            g2d.setFont(new Font("Verdana", Font.BOLD, 30));
            g2d.drawString(String.valueOf(racquet1.getScore()), 10, 320);
        }
    }
    public boolean gameOver() {//once it is game obver
        Sound.BACK.stop();//background song will stop
        Sound.GAMEOVER.play();//game over song will play
        String winner = "";//winner to diplay text on the dialog box
        if(!oneplayer) {
            if (racquet1.getScore() > racquet2.getScore()) {
                winner = "Player 1 won\n";
            } else {
                winner = "Player 2 won\n";
            }
        }
        else{
            winner ="Game Over\n Your Score is: "+racquet1.getScore()+"\n";
        }
        int x = JOptionPane.showConfirmDialog(this, winner+"Play Again?",
                "Game Over", JOptionPane.YES_NO_OPTION);
        if(x == 0){
            return false;
        }
        else {
            System.exit(ABORT);
            return true;
        }
    }

    public static void main(String[] args) throws InterruptedException {
        boolean replay = true;
        JFrame frame;
        frame = new JFrame("Mini Tennis");
        Game game = new Game();
        frame.add(game);
        while (replay){
            Sound.BACK.loop();
            frame.setSize(300, 400);
            frame.setVisible(true);
            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

            while (replay) {
                replay = game.move();
                game.repaint();
                Thread.sleep(10);
            }
            replay = true;
            game.setDir(150,200);
        }
    }
    public void setDir(int x, int y){
        ball.setDir(x,y);
        racquet2.reset();
        racquet1.reset();
        if(racquet1.score >= 3 || racquet2.score >= 3) {
            playstart = true;
            oneplayer = true;
        }
    }
}
