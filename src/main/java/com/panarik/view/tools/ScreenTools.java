package com.panarik.view.tools;

import java.awt.*;

public class ScreenTools {

    public static Dimension getScreenSize() {
        return Toolkit.getDefaultToolkit().getScreenSize();
    }

    public Dimension getScreenCenter() {
        Dimension screenDimension = Toolkit.getDefaultToolkit().getScreenSize();
        screenDimension.setSize(screenDimension.height / 2, screenDimension.width / 2);
        return screenDimension;
    }

    public Point getWindowCenter(int windowWidth, int windowHeight) {
        Point center = new Point();
        center.x = getScreenSize().width / 2 - windowWidth / 2;
        center.y = getScreenSize().height / 2 - windowHeight / 2;
        return center;
    }

}
