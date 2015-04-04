package net.jsenko.pv260;

/**
 * @author Jakub Senko
 */
public enum Direction {

    UP, LEFT, RIGHT, DOWN;

    public Direction getOpposite() {
        switch (this) {
            case UP:
                return DOWN;
            case LEFT:
                return RIGHT;
            case RIGHT:
                return LEFT;
            case DOWN:
                return UP;
        }
        throw new IllegalStateException("This should really not happen in this universe.");
    }
}
