package com.tank;

import java.awt.*;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class TankFrame extends Frame{

    Tank myTank = new Tank(200, 200, Dir.DOWN);
    Bullet b = new Bullet(200,200,Dir.DOWN);

    public TankFrame(){
        setSize(800, 600);
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

    @Override
    //每次窗口重新绘制，系统会自动调用paint方法，需要给他一支画笔Graphics
    public void paint(Graphics g) {
//        System.out.println("paint");
        myTank.paint(g);
        b.paint(g);
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
                default:
                    break;
            }
            setMainTankDir();
        }
    }
}
