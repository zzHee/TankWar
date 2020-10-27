package com.tank;

import java.awt.*;

public class Explode {
    private int WIDTH = RescourceMgr.explodes[0].getWidth();
    private int HEIGHT = RescourceMgr.explodes[0].getHeight();
    private int x, y;

    private int step = 0;
    public Explode(int WIDTH, int HEIGHT, int x, int y) {
        this.WIDTH = WIDTH;
        this.HEIGHT = HEIGHT;
        this.x = x;
        this.y = y;
    }

    public void paint(Graphics g) {
        g.drawImage(RescourceMgr.explodes[step++], x, y, null);
        if (step >= RescourceMgr.explodes.length) {
            step = 0;
        }
    }
}
