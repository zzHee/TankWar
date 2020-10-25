package com.tank;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.IOException;

public class RescourceMgr {
    public static BufferedImage tankL, tankU, tankR, tankD;

    static {
        try {
            tankL = ImageIO.read(RescourceMgr.class.getClassLoader().getResourceAsStream(("images/tankL.gif")));
            tankU = ImageIO.read(RescourceMgr.class.getClassLoader().getResourceAsStream(("images/tankU.gif")));
            tankR = ImageIO.read(RescourceMgr.class.getClassLoader().getResourceAsStream(("images/tankR.gif")));
            tankD = ImageIO.read(RescourceMgr.class.getClassLoader().getResourceAsStream(("images/tankD.gif")));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
