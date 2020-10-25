package com.tank;

import java.awt.*;

public class Bullet {
    private int x, y;
    private Dir dir;
    private int SPEED = 20;
    private int WIDTH = 8, HEIGHT = 8;
    private boolean live = true;
    private TankFrame tf;

    public Bullet(int x, int y, Dir dir, TankFrame tf) {
        this.x = x;
        this.y = y;
        this.dir = dir;
        this.tf = tf;
    }
    public void paint(Graphics g) {
        Color c = g.getColor();
        g.setColor(Color.RED);
        g.fillOval(x, y, WIDTH, HEIGHT);
        g.setColor(c);

        move();

        if (!live) {
            tf.bullets.remove(this);
        }
    }
    private void move() {
        switch (dir) {
            case LEFT:
                x -= SPEED;
                break;
            case RIGHT:
                x += SPEED;
                break;
            case UP:
                y -= SPEED;
                break;
            case DOWN:
                y += SPEED;
                break;
            default:
                break;
        }
        if(x < 0 || x > tf.GAME_WIDTH || y < 0 || y > tf.GAME_HEIGHT) {
            live = false;
        }
    }
}
