package com.edu4java.minitennis8;
import java.awt.*;
import java.util.*;

public class Ball {
    private static final int DIAMETER = 30;// how big our ball will be
    float x = 100;//x and y coordnates
    float y = 100;
    float xa = 1;//direction of the ball in the x axis
    float ya = 1;// direction of the ball in the y axis
    private Game game;

    public Ball(Game game) {
        this.game = game;
    }

    void setDir(int x, int y){//to reset
        Random rand = new Random();
        game.speed = 1;
        this.x = x;
        this.y = y;
        xa = 1;
        ya = rand.nextInt(2)+1;
        if(ya == 1){
            ya = -1;
        }
        else{
            ya = 1;
        }
    }
    boolean move() {//logic when moving
        boolean changeDirection = true;//when it changes direction
        boolean replay = true;//code for replay
        if (x + xa < 0)
            xa = game.speed;//when it hits left wall
        else if (x + xa > game.getWidth() - DIAMETER)
            xa = -game.speed;//when it hits right wall
        else if (y + ya > game.getHeight() - DIAMETER) {
            if(game.racquet2.score == 2|| game.oneplayer) {
                game.playstart=true;
                replay = game.gameOver();
            }
            else{
                ya = -game.speed;
                game.racquet2.score += 1;
                if(!game.oneplayer ) {
                    setDir(150, 200);
                }
            }
        }
        else if( y + ya < 0){
            if(game.racquet1.score >= 2 && !game.oneplayer) {
                game.playstart=true;
                replay = game.gameOver();
            }
            else{
                ya= game.speed;
                game.racquet1.score+=1;
                if(!game.oneplayer) {
                    setDir(150, 200);
                }
            }
        }
        else if (collision()){//when there is a collision
            ya = -game.speed;
            if(game.racquet1.getBounds().intersects(getBounds()) == true) { // sees whether the ball and racket collided
                y = game.racquet1.getTopy() - DIAMETER;//reseting the ball position
                //game.racquet1.score+=1;//adding of score
            }
            else {// sees whether the ball and racket collided
                if(!game.oneplayer) {
                    y = game.racquet2.getTopy();//reseting the ball position
                    ya = game.speed;//changing the direction
                    //game.racquet2.score += 1;
                }
            }
                game.speed+= .25 ;//increasing game speed everytime
        } else
            changeDirection = false;

        if (changeDirection)
            Sound.BALL.play();
        x = x + xa;//the change in the signs of ya is reflected here
        y = y + ya;
        return replay;
    }

    private boolean collision() {//sees whether when to game over

        if (game.racquet1.getBounds().intersects(getBounds()) == true || game.racquet2.getBounds().intersects(getBounds()) == true){
            if(game.pow.ctr!=0){
                game.pow.ctr--;
            }
            if(game.racquet2.getBounds().intersects(getBounds()) == true && game.oneplayer) { return false; }
            else{ return true; }
        }
        else
            return false;
    }

    public void paint(Graphics2D g) {//draws the graphics
        g.setColor(Color.BLUE);
        g.fillOval((int)x, (int)y, DIAMETER, DIAMETER);//we need an oval filled representing a ball
    }

    public Rectangle getBounds() {
        return new Rectangle((int)x,(int)y, DIAMETER, DIAMETER);
    } //gets the area of our ball to compare whee
}
