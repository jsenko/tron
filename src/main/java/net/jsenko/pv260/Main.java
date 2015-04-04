package net.jsenko.pv260;

import java.awt.*;
import java.awt.event.KeyEvent;
import java.util.ArrayList;
import java.util.List;

import net.jsenko.pv260.control.KeyboardControl;
import net.jsenko.pv260.control.KeyboardControl.KeyboardSettings;
import net.jsenko.pv260.control.MouseControl;
import static net.jsenko.pv260.Direction.LEFT;
import static net.jsenko.pv260.Direction.RIGHT;

public class Main {

    private Core core;


    public void run() {
        KeyboardSettings settingsKeys = new KeyboardSettings(
                KeyEvent.VK_UP,
                KeyEvent.VK_LEFT,
                KeyEvent.VK_RIGHT,
                KeyEvent.VK_DOWN);

        KeyboardSettings settingsWSAD = new KeyboardSettings(
                KeyEvent.VK_W,
                KeyEvent.VK_A,
                KeyEvent.VK_D,
                KeyEvent.VK_S);

        KeyboardSettings settingsIJKL = new KeyboardSettings(
                KeyEvent.VK_I,
                KeyEvent.VK_J,
                KeyEvent.VK_L,
                KeyEvent.VK_K);

        KeyboardControl c1 = new KeyboardControl(settingsKeys);
        KeyboardControl c2 = new KeyboardControl(settingsWSAD);
        KeyboardControl c3 = new KeyboardControl(settingsIJKL);

        MouseControl m1 = new MouseControl(RIGHT);

        // ====== Players (Bikes)
        Bike greenBike = new Bike(40, 40, c1, Color.GREEN, RIGHT);

        Bike redBike = new Bike(300, 340, c2, Color.RED, LEFT);

        Bike blueBike = new Bike(600, 640, m1, Color.BLUE, RIGHT);


        List<Drawable> drawables = new ArrayList<Drawable>();
        drawables.add(new Background());
        drawables.add(greenBike);
        drawables.add(redBike);
        drawables.add(blueBike);

        List<CollisionAware> collisionAwares = new ArrayList<CollisionAware>();
        collisionAwares.add(greenBike);
        collisionAwares.add(redBike);
        collisionAwares.add(blueBike);
        CollisionManager cm = new CollisionManager(collisionAwares);

        this.core = new Core(drawables, cm);

        core.registerKeyListener(c1);
        core.registerKeyListener(c2);
        core.registerKeyListener(c3);

        core.registerMouseListener(m1);
        core.registerMouseWheelListener(m1);
        core.run();
    }

    public static void main(String[] args) {
        new Main().run();
    }
}
