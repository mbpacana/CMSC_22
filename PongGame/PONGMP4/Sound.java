package com.edu4java.minitennis8;
import java.awt.*;
import java.util.*;
class PowerUp {
    private static final int DIAMETER = 50;// how big our ball will be
    private int x;//x and y coordnates
    private int y;
    private Game game;
    public boolean power = false;
    public int ctr = 0;
    private Random rand = new Random();

    PowerUp(Game game) {
        this.game = game;
        x = 50;
        y = 50;
    }

    void move() {//logic of PowerUp whether it exists
        if (!power) {
            if(ctr == 1){
                game.racquet1.changewidth(60);
                game.racquet2.changewidth(60);
            }
            if(ctr==0) {
                int show = rand.nextInt(2) + 1;
                if (show == 1) {
                    x = rand.nextInt(game.getWidth() - DIAMETER);
                    y = rand.nextInt(game.getHeight() - DIAMETER);
                    power = true;
                }
            }
        } else {
            if (game.ball.getBounds().intersects(getBounds())) {

                power = false;
                ctr = 5;
                x = -DIAMETER;
                y= -DIAMETER;
                if (game.ball.ya < 0 || game.oneplayer) {
                    game.racquet1.changewidth(90);
                } else {
                    game.racquet2.changewidth(90);
                }
            }

        }
    }

    private Rectangle getBounds() {
        return new Rectangle(x, y, DIAMETER, DIAMETER);
    }

    public void paint(Graphics2D g) {
        g.setColor(Color.WHITE);
        g.fillOval(x, y, DIAMETER, DIAMETER);//we need an oval filled representing a ball
    }
}
