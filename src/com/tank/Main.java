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
                tf.repaint();
            } catch (InterruptedException e) {
            }
        }
    }
}
