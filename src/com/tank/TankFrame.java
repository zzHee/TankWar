package com.tank;

import java.awt.*;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class TankFrame extends Frame{
    private int x = 200, y = 200;
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
        System.out.println("paint");
        //窗口左上角为原点，横轴为x (width)，纵轴为y (height)。
        g.fillRect(x, y, 50, 100);
    }

    class MyKeyListener extends KeyAdapter {
        @Override
        public void keyPressed(KeyEvent e) {
            System.out.println("keypressed");
            x += 30;
            //这支画笔只有系统自己拿得到，所以我们不能直接调用paint(),而使用repaint()代替
//            repaint();
        }

        @Override
        public void keyReleased(KeyEvent e) {
            System.out.println("keyreleased");
        }
    }
}
