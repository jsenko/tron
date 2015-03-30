package net.jsenko.pv260;

import java.awt.*;

public class Background implements Drawable {


    private ScreenManager sm;


    public void init(ScreenManager sm) {
        this.sm = sm;
    }


    public void draw(Graphics2D g) {
        g.setColor(Color.BLACK);
        g.fillRect(0, 0, sm.getWidth(), sm.getHeight());
    }

}
