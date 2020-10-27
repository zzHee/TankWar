package com.tank;

import java.awt.*;

public class Bullet {
    private int x, y;
    private Dir dir;
    private int SPEED = 20;
    private int WIDTH, HEIGHT;
    private boolean living = true;
    private TankFrame tf;
    private Group group;

    public Bullet(int x, int y, Dir dir, Group group, TankFrame tf) {
        WIDTH = RescourceMgr.bulletD.getWidth();
        HEIGHT = RescourceMgr.bulletD.getHeight();
        this.x = x - WIDTH/2;
        this.y = y - HEIGHT/2;
        this.dir = dir;
        this.group = group;
        this.tf = tf;
    }
    public void paint(Graphics g) {
//        Color c = g.getColor();
//        g.setColor(Color.RED);
//        g.fillOval(x, y, WIDTH, HEIGHT);
//        g.setColor(c);
//        g.drawImage(RescourceMgr.bulletD, x, y, null);
        switch (dir) {
            case LEFT:
                g.drawImage(RescourceMgr.bulletL, x, y, null);
                break;
            case RIGHT:
                g.drawImage(RescourceMgr.bulletR, x, y, null);
                break;
            case UP:
                g.drawImage(RescourceMgr.bulletU, x, y, null);
                break;
            case DOWN:
                g.drawImage(RescourceMgr.bulletD, x, y, null);
                break;
            default:
                break;
        }
        move();

        if (!living) {
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
            living = false;
        }
    }

    public void collideWith(Tank tank) {
        // 用一个rect来记录子弹的位置
        Rectangle rect1 = new Rectangle(this.x, this.y, WIDTH, HEIGHT);
        Rectangle rect2 = new Rectangle(tank.getX(), tank.getY(), tank.getWIDTH(), tank.getHEIGHT());
        if (rect1.intersects(rect2)) {
            if (this.group != tank.getGroup()){
                tank.die();
                this.die();
            }
        }
    }

    private void die() {
        living = false;
    }

}
