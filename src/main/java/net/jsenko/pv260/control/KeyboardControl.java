package net.jsenko.pv260.control;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import net.jsenko.pv260.Direction;
import static java.util.Objects.requireNonNull;
import static net.jsenko.pv260.Direction.DOWN;
import static net.jsenko.pv260.Direction.LEFT;
import static net.jsenko.pv260.Direction.RIGHT;
import static net.jsenko.pv260.Direction.UP;

/**
 * @author Jakub Senko
 */
public class KeyboardControl implements Control, KeyListener {


    private final KeyboardSettings settings;

    private boolean newEvent = false;

    private Direction lastDirection;

    public KeyboardControl(KeyboardSettings settings) {
        requireNonNull(settings);
        this.settings = settings;
    }

    @Override
    public boolean newEvent() {
        return newEvent;
    }

    @Override
    public Direction getDirection() {
        if(!newEvent)
            throw new IllegalStateException("No direction available yet.");
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
    public void keyPressed(KeyEvent e) {
        if (e.getKeyCode() == settings.getKeyUp()) {
            setLastDirection(UP);
        } else if (e.getKeyCode() == settings.getKeyDown()) {
            setLastDirection(DOWN);
        } else if (e.getKeyCode() == settings.getKeyRight()) {
            setLastDirection(RIGHT);
        } else if (e.getKeyCode() == settings.getKeyLeft()) {
            setLastDirection(LEFT);
        }
    }

    @Override
    public void keyReleased(KeyEvent e) {

    }

    @Override
    public void keyTyped(KeyEvent e) {

    }

    /**
     * TBD
     */
    public static class KeyboardSettings {

        private int keyUp;
        private int keyLeft;
        private int keyRight;
        private int keyDown;

        public KeyboardSettings(int keyUp, int keyLeft, int keyRight, int keyDown) {
            this.keyUp = keyUp;
            this.keyLeft = keyLeft;
            this.keyRight = keyRight;
            this.keyDown = keyDown;
        }

        public int getKeyUp() {
            return keyUp;
        }

        public int getKeyLeft() {
            return keyLeft;
        }

        public int getKeyRight() {
            return keyRight;
        }

        public int getKeyDown() {
            return keyDown;
        }
    }
}
