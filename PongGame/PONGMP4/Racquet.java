package com.edu4java.minitennis8;

import java.awt.*;
import java.awt.event.KeyEvent;

public class Racquet {
    private int racketno;
    private int y;
    private int width;
    private int height;
    private int x = 0;
    private float xa = 0;
    public int score;
    private Game game;


    public int getScore() {
        return score;
    }

    public Racquet(Game game, int racketno) {
        this.game = game;
        this.racketno = racketno;
        if(racketno == 1){
            height = 10;
            y = 345;
            score = 0;
            width = 60;
        }
        else if(racketno == 2){
            height = 10;
            width = 60;
            y = 5;
            score = 0;
        }
    }

    public void changewidth(int add){
        if(x + add < game.getWidth()){
            width = add;
        }
        else{
            x -=(x + add- game.getWidth());
            width = add;
        }

    }

    public void reset(){
        xa = 0;
        changewidth(60);
        score= 0;
    }

    public void move() {
        if (x + xa > 0 && x + xa < game.getWidth() - width)
            x = (int)(x + xa);
    }

    public int getRacketNo(){
        return racketno;
    }

    public void paint(Graphics2D g) {
        g.setColor(Color.RED);
        g.fillRect(x, y, width, height);
    }

    public void keyReleased(KeyEvent e) {
        if ( e.getKeyCode() == KeyEvent.VK_D && racketno ==2|| e.getKeyCode() == KeyEvent.VK_A && racketno ==2)
            xa = 0;

        else if (e.getKeyCode() == KeyEvent.VK_RIGHT && racketno ==1 ||e.getKeyCode() == KeyEvent.VK_LEFT && racketno ==1)
            xa = 0;
    }

    public void keyPressed(KeyEvent e) {
        if (e.getKeyCode() == KeyEvent.VK_LEFT && racketno ==1 || e.getKeyCode() == KeyEvent.VK_A && racketno == 2)
            xa = -game.speed;

        if (e.getKeyCode() == KeyEvent.VK_RIGHT && racketno ==1 || e.getKeyCode() == KeyEvent.VK_D && racketno == 2) { xa = game.speed;}
    }

    public Rectangle getBounds() {
        return new Rectangle(x, y, width, height);
    }

    public int getTopy() {
        if(racketno == 1)
            return y - height;
        else{
            return y + height;
        }
    }
}
