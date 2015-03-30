package net.jsenko.pv260;

import java.awt.*;
import java.awt.event.KeyEvent;
import java.util.ArrayList;
import java.util.List;

import static net.jsenko.pv260.Direction.LEFT;
import static net.jsenko.pv260.Direction.RIGHT;

public class yourclass {

    private Core core;


    public yourclass() {
        List<Drawable> drawables = new ArrayList<Drawable>();

        drawables.add(new Background());

        drawables.add(new Bike(40, 40, RIGHT,
                KeyEvent.VK_UP,
                KeyEvent.VK_LEFT,
                KeyEvent.VK_RIGHT,
                KeyEvent.VK_DOWN,
                Color.GREEN));

        drawables.add(
                new Bike(600, 640, LEFT,
                        KeyEvent.VK_W,
                        KeyEvent.VK_A,
                        KeyEvent.VK_D,
                        KeyEvent.VK_S,
                        Color.RED));

        this.core = new Core(drawables);
    }



    public void run() {
        core.run();
    }

    public static void main(String[] args) {
        new yourclass().run();
    }
}
