package net.jsenko.pv260.control;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseWheelEvent;
import java.awt.event.MouseWheelListener;

import net.jsenko.pv260.Direction;
import static java.util.Objects.requireNonNull;
import static net.jsenko.pv260.Direction.*;

/**
 * Bike is controlled by mouse buttons (2 button mouse required)
 * and wheel. Buttons control left and right directions, wheel
 * is up and down.
 * @author Senko, Sumaj
 */
public class MouseControl implements Control, MouseListener, MouseWheelListener {

    private int down;

    private boolean newEvent = true;

    private Direction lastDirection;

    public MouseControl(Direction direction) {
        requireNonNull(direction);
        this.lastDirection = direction;
    }

    @Override
    public boolean newEvent() {
        return newEvent;
    }

    @Override
    public Direction getDirection() {
        return lastDirection;
    }

    @Override
    public void reset() {
        newEvent = false;
    }

    private void setLastDirection(Direction direction) {
        if (!newEvent) {
            lastDirection = direction;
            newEvent = true;
        }
    }

    @Override
    public void mouseClicked(MouseEvent e) {
        if (e.getButton() == MouseEvent.BUTTON1) {
            setLastDirection(LEFT);
        } else if (e.getButton() == MouseEvent.BUTTON3) {
            setLastDirection(RIGHT);
        }
    }

    @Override
    public void mousePressed(MouseEvent e) {

    }

    @Override
    public void mouseReleased(MouseEvent e) {

    }

    @Override
    public void mouseEntered(MouseEvent e) {

    }

    @Override
    public void mouseExited(MouseEvent e) {

    }

    /**
     * @param e
     */
    @Override
    public void mouseWheelMoved(MouseWheelEvent e) {

        int direction = e.getWheelRotation();

        if (direction < 0) {
            setLastDirection(UP);
        } else {
            setLastDirection(DOWN);
        }
    }
}