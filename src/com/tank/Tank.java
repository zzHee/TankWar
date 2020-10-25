package com.tank;

import java.awt.*;

public class Tank {
    private int x, y;
    private int WIDTH, HEIGHT;
    private Dir dir = Dir.UP;
    private int SPEED = 10;
    private boolean onMoving = false;
    private TankFrame tf;


    public void setOnMoving(boolean onMoving) {
        this.onMoving = onMoving;
    }

    public void setDir(Dir dir) {
        this.dir = dir;
    }

    public void setSPEED(int SPEED) {
        this.SPEED = SPEED;
    }

    public Tank(int x, int y, int WIDTH, int HEIGHT, Dir dir, TankFrame tf) {
        this.x = x;
        this.y = y;
        this.WIDTH = WIDTH;
        this.HEIGHT = HEIGHT;
        this.dir = dir;
        this.tf = tf;
    }

    public void paint(Graphics g) {
        //窗口左上角为原点，横轴为x (width)，纵轴为y (height)。
//        Color c = g.getColor();
//        g.setColor(Color.BLUE);
//        g.fillRect(x, y, WIDTH, HEIGHT);

        g.drawImage(RescourceMgr.tankL, x, y, null);
        if(onMoving){
            move();
        }
        g.setColor(c);
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
    public Bullet fire() {
        return new Bullet(x + WIDTH/2 - 4, y + HEIGHT/2 - 4, dir, tf);
    }
}
