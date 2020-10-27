package com.tank;

import java.awt.*;
import java.util.Random;

public class Tank {
    private int x, y;
    private int WIDTH, HEIGHT;
    private Dir dir = Dir.UP;
    private int SPEED = 10;
    private boolean onMoving = false;
    private TankFrame tf;
    private boolean living = true;
    private Random random = new Random();
    private Group group;

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public int getWIDTH() {
        return WIDTH;
    }

    public int getHEIGHT() {
        return HEIGHT;
    }

    public Group getGroup() {
        return group;
    }

    public void setOnMoving(boolean onMoving) {
        this.onMoving = onMoving;
    }

    public void setDir(Dir dir) {
        this.dir = dir;
    }

    public void setSPEED(int SPEED) {
        this.SPEED = SPEED;
    }

    public Tank(int x, int y, Dir dir, Group group, TankFrame tf) {
        this.x = x;
        this.y = y;
        this.WIDTH = RescourceMgr.tankD.getWidth();
        this.HEIGHT = RescourceMgr.tankD.getHeight();
        this.dir = dir;
        this.group = group;
        this.tf = tf;
    }

    public void paint(Graphics g) {
        //窗口左上角为原点，横轴为x (width)，纵轴为y (height)。
//        Color c = g.getColor();
//        g.setColor(Color.BLUE);
//        g.fillRect(x, y, WIDTH, HEIGHT);
//        g.setColor(c);
        if(!living) {
            tf.tanks.remove(this);
        }
        switch (dir) {
            case LEFT:
                g.drawImage(RescourceMgr.tankL, x, y, null);
                break;
            case RIGHT:
                g.drawImage(RescourceMgr.tankR, x, y, null);
                break;
            case UP:
                g.drawImage(RescourceMgr.tankU, x, y, null);
                break;
            case DOWN:
                g.drawImage(RescourceMgr.tankD, x, y, null);
                break;
            default:
                break;
        }
        if (this.group == Group.BAD) {
//            System.out.println(random.nextInt(10));
            if (random.nextInt(20) > 18) {
                this.fire();
            }
        }
        if (onMoving) {

            move();
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
    }
    public void fire() {
        int bX = this.x + WIDTH/2;
        int bY = this.y + HEIGHT/2;
        if (group.equals(Group.GOOD)) {
            tf.bullets.add(new Bullet(bX, bY, dir, Group.GOOD, tf));
        }else{
            tf.bullets.add(new Bullet(bX, bY, dir, Group.BAD, tf));
        }
    }

    public void die() {
        living = false;
    }
}
