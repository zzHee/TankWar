package com.tank;

import java.awt.*;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.util.ArrayList;
import java.util.List;

public class TankFrame extends Frame{
    static final int GAME_WIDTH = 800, GAME_HEIGHT = 600;

    Tank myTank = new Tank(200, 200, Dir.DOWN, Group.GOOD, this);
    Tank myTank1 = new Tank(200, 200, Dir.DOWN, Group.GOOD, this);

    List<Bullet> bullets = new ArrayList<>();
    List<Tank> tanks = new ArrayList<>();
    Explode e = new Explode(100, 100, 100, 100);

    public TankFrame(){
        setSize(GAME_WIDTH, GAME_HEIGHT);
        setResizable(false);
        setTitle("Tank War");
        setVisible(true);

        addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                System.exit(0);
            }
        });

        addKeyListener(new MyKeyListener());
    }
    Image offScreenImage = null;

    @Override
    public void update(Graphics g) {
        if (offScreenImage == null) {
            offScreenImage = this.createImage(GAME_WIDTH, GAME_HEIGHT);
        }
        Graphics gOffScreen = offScreenImage.getGraphics();
        Color c = gOffScreen.getColor();
        gOffScreen.setColor(Color.BLACK);
        gOffScreen.fillRect(0, 0, GAME_WIDTH, GAME_HEIGHT);
        gOffScreen.setColor(c);
        paint(gOffScreen);
        g.drawImage(offScreenImage, 0, 0, null);
    }

    @Override
    //每次窗口重新绘制，系统会自动调用paint方法，需要给他一支画笔Graphics
    public void paint(Graphics g) {
//        System.out.println("paint");
        Color c = g.getColor();
        g.setColor(Color.WHITE);
        g.drawString("子弹的数量" + bullets.size(), 10, 60);
        g.drawString("敌人坦克的数量" + tanks.size(), 10, 80);
        g.setColor(c);

        myTank.paint(g);
        myTank1.paint(g);
        e.paint(g);
        //用iterator遍历的时候删除回有cModificationException
        for (int i = 0; i < tanks.size(); i++) {
            tanks.get(i).paint(g);
        }
        for (int i = 0; i < bullets.size(); i++) {
            bullets.get(i).paint(g);
        }
        for (int i = 0; i < bullets.size(); i++) {
            for (int j = 0; j < tanks.size(); j++) {
                bullets.get(i).collideWith(tanks.get(j));
            }
        }
    }

    class MyKeyListener extends KeyAdapter {

        boolean bl = false;
        boolean br = false;
        boolean bu = false;
        boolean bd = false;
        private void setMainTankDir() {
            myTank.setOnMoving(true);
            if(!bl && !br && !bu && !bd) myTank.setOnMoving(false);
            if (bl) {
                myTank.setDir(Dir.LEFT);
            } else if (br) {
                myTank.setDir(Dir.RIGHT);
            } else if (bu) {
                myTank.setDir(Dir.UP);
            } else if (bd) {
                myTank.setDir(Dir.DOWN);
            }
        }
        @Override
        //这里是系统发现按键事件KeyEvent之后自动调用keyPressed方法，并把KeyEvent事件传入
        public void keyPressed(KeyEvent e) {
            int key = e.getKeyCode();
            switch (key) {
                case KeyEvent.VK_LEFT:
                    bl = true;
                    break;
                case KeyEvent.VK_RIGHT:
                    br = true;
                    break;
                case KeyEvent.VK_UP:
                    bu = true;
                    break;
                case KeyEvent.VK_DOWN:
                    bd = true;
                    break;
                default:
                    break;
            }
            setMainTankDir();
        }

        @Override
        public void keyReleased(KeyEvent e) {
            int key = e.getKeyCode();
            switch (key) {
                case KeyEvent.VK_LEFT:
                    bl = false;
                    break;
                case KeyEvent.VK_RIGHT:
                    br = false;
                    break;
                case KeyEvent.VK_UP:
                    bu = false;
                    break;
                case KeyEvent.VK_DOWN:
                    bd = false;
                    break;
                case KeyEvent.VK_CONTROL:
                    myTank.fire();
                default:
                    break;
            }
            setMainTankDir();
        }
    }
}
