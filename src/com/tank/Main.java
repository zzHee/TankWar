package com.tank;

import sun.awt.WindowClosingListener;

import java.awt.*;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class Main {
    public static void main (String[] args) {
//        Frame f = new Frame();
//        f.setSize(800, 600);
//        f.setResizable(false);
//        f.setTitle("Tank War");
//        f.setVisible(true);
//
//        f.addWindowListener(new WindowAdapter() {
//            @Override
//            public void windowClosing(WindowEvent e) {
//                System.exit(0);
//            }
//        });
        TankFrame tf = new TankFrame();
        while (true) {
            try {
                Thread.sleep(50);
                //这支画笔只有系统自己拿得到，所以我们不能在paint方法的外部直接调用paint(),而使用repaint()代替
                tf.repaint();
            } catch (InterruptedException e) {
            }
        }
    }
}
