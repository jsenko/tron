package net.jsenko.pv260;

import java.awt.*;
import java.util.Collections;

import net.jsenko.pv260.control.Control;
import net.jsenko.pv260.geometry.Path;
import net.jsenko.pv260.geometry.Point;

public class Bike implements Drawable, CollisionAware {

    private final int centrex1;
    private final int centrey1;
    private final Control control;
    boolean first = true;

    private ScreenManager sm;

    private Point position;

    int moveAmount = 5;

    private Path path;

    private Color color;

    Direction currentDirection;


    public Bike(int centrex1, int centrey1, Control control, Color color, Direction direction) {
        this.centrex1 = centrex1;
        this.centrey1 = centrey1;
        this.control = control;
        this.path = new Path();
        this.position = new Point(centrex1, centrey1);
        this.color = color;
        this.currentDirection = direction;
    }

    public void init(ScreenManager sm) {
        this.sm = sm;
    }


    public void draw(Graphics2D g) {


        if (!first) {
            path.addCopy(position);
        }
        first = false;

        if (control.newEvent()) {
            Direction newDirection = control.getDirection();
            if(currentDirection.getOpposite() != newDirection)
                currentDirection = newDirection;
            control.reset();
        }

        switch (currentDirection) {
            case UP:
                if (position.getY() > 0) {
                    position.setY(position.getY() - moveAmount);
                } else {
                    position.setY(sm.getHeight());
                }
                break;
            case RIGHT:
                if (position.getX() < sm.getWidth()) {
                    position.setX(position.getX() + moveAmount);
                } else {
                    position.setX(0);
                }
                break;
            case DOWN:
                if (position.getY() < sm.getHeight()) {
                    position.setY(position.getY() + moveAmount);
                } else {
                    position.setY(0);
                }
                break;
            case LEFT:
                if (position.getX() > 0) {
                    position.setX(position.getX() - moveAmount);
                } else {
                    position.setX(sm.getWidth());
                }
                break;
        }



        for (Point point : path) {
            g.setColor(color);
            g.fillRect(point.getX(), point.getY(), 10, 10);
        }
    }


    @Override
    public Iterable<Point> getHitboxPoints() {
        return path;
    }

    @Override
    public Iterable<Point> getCollidingPoints() {
        return Collections.singleton(position);
    }

    @Override
    public void hasCollision(Point point, CollisionAware other) {
        System.exit(0);
    }
}
