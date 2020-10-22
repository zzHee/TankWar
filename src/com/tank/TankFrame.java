package com.tank;

import java.awt.*;
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
    }

    @Override
    //每次窗口重新绘制，系统会自动调用paint方法，需要给他一支画笔Graphics
    public void paint(Graphics g) {
        System.out.println("paint");
        //窗口左上角为原点，横轴为x (width)，纵轴为y (height)。
        g.fillRect(x, y, 50, 100);
        x += 50;
        y += 50;
    }
}
