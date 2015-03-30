package net.jsenko.pv260;

import java.awt.*;
import java.awt.event.KeyEvent;
import java.util.ArrayList;
import java.util.List;

import static net.jsenko.pv260.Direction.LEFT;
import static net.jsenko.pv260.Direction.RIGHT;

public class Main {

    private Core core;


    public void run() {
        // ====== Players (Bikes)
        Bike greenBike = new Bike(40, 40, RIGHT,
                KeyEvent.VK_UP,
                KeyEvent.VK_LEFT,
                KeyEvent.VK_RIGHT,
                KeyEvent.VK_DOWN, Color.GREEN);

        Bike redBike = new Bike(300, 340, LEFT,
                KeyEvent.VK_W,
                KeyEvent.VK_A,
                KeyEvent.VK_D,
                KeyEvent.VK_S, Color.RED);

        Bike blueBike = new Bike(600, 640, RIGHT,
                KeyEvent.VK_I,
                KeyEvent.VK_J,
                KeyEvent.VK_L,
                KeyEvent.VK_K, Color.BLUE);


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
        core.run();
    }

    public static void main(String[] args) {
        new Main().run();
    }
}
