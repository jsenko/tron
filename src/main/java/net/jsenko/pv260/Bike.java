package net.jsenko.pv260;

import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import java.util.Collections;

import net.jsenko.pv260.geometry.Path;
import net.jsenko.pv260.geometry.Point;
import static net.jsenko.pv260.Direction.DOWN;
import static net.jsenko.pv260.Direction.LEFT;
import static net.jsenko.pv260.Direction.RIGHT;
import static net.jsenko.pv260.Direction.UP;

public class Bike implements Drawable, KeyListener, MouseListener,
        MouseMotionListener, CollisionAware {

    boolean first = true;

    private ScreenManager sm;

    private Point position;

    Direction currentDirection1;

    int moveAmount = 5;

    private Path path;

    private int keyUp;
    private int keyLeft;
    private int keyRight;
    private int keyDown;
    private Color color;


    public Bike(int centrex1, int centrey1, Direction currentDirection1,
                int keyUp, int keyLeft, int keyRight, int keyDown, Color color) {
        this.path = new Path();
        this.keyUp = keyUp;
        this.keyLeft = keyLeft;
        this.keyRight = keyRight;
        this.keyDown = keyDown;
        this.position = new Point(centrex1, centrey1);
        this.color = color;
        this.currentDirection1 = currentDirection1;
    }

    public void init(ScreenManager sm) {
        this.sm = sm;
        Window w = sm.getFullScreenWindow();
        w.addKeyListener(this);
        w.addMouseListener(this);
        w.addMouseMotionListener(this);
    }


    public void draw(Graphics2D g) {


        if (!first) {
            path.addCopy(position);
        }
        first = false;


        switch (currentDirection1) {
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


    public void keyPressed(KeyEvent e) {
        if (e.getKeyCode() == keyUp) {
            if (currentDirection1 != DOWN) {
                currentDirection1 = UP;
            }
        } else if (e.getKeyCode() == keyDown) {
            if (currentDirection1 != UP) {
                currentDirection1 = DOWN;
            }
        } else if (e.getKeyCode() == keyRight) {
            if (currentDirection1 != LEFT) {
                currentDirection1 = RIGHT;
            }
        } else if (e.getKeyCode() == keyLeft) {
            if (currentDirection1 != RIGHT) {
                currentDirection1 = LEFT;
            }
        }
    }

    public void keyReleased(KeyEvent e) {

    }

    public void keyTyped(KeyEvent arg0) {

    }

    public void mouseClicked(MouseEvent e) {

    }

    public void mouseEntered(MouseEvent arg0) {
    }

    public void mouseExited(MouseEvent arg0) {
    }

    public void mousePressed(MouseEvent e) {
    }

    public void mouseReleased(MouseEvent e) {
    }

    public void mouseDragged(MouseEvent e) {

    }

    public void mouseMoved(MouseEvent e) {

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
