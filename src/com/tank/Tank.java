package com.tank;

import java.awt.*;

public class Tank {
    private int x, y;
    private Dir dir = Dir.UP;
    private int SPEED = 10;
    private boolean onMoving = false;

    public void setOnMoving(boolean onMoving) {
        this.onMoving = onMoving;
    }

    public void setDir(Dir dir) {
        this.dir = dir;
    }

    public void setSPEED(int SPEED) {
        this.SPEED = SPEED;
    }

    public Tank(int x, int y, Dir dir) {
        this.x = x;
        this.y = y;
        this.dir = dir;
    }
    public void paint(Graphics g) {
        //窗口左上角为原点，横轴为x (width)，纵轴为y (height)。
        g.fillRect(x, y, 50, 100);
        if(onMoving){
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
}
