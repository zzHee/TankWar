package com.tank;

public class Main {
    public static void main (String[] args) {
        TankFrame tf = new TankFrame();
        for (int i = 0; i < 5; i++) {
            tf.tanks.add(new Tank(50 + i*80,200, Dir.DOWN, Group.BAD, tf));
        }
        while (true) {
            try {
                Thread.sleep(50);
                //这支画笔只有系统自己拿得到，所以我们不能在paint方法的外部直接调用paint(),而使用repaint()代替
                tf.repaint();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
