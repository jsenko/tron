package net.jsenko.pv260.control;

import net.jsenko.pv260.Direction;

/**
 * @author Jakub Senko
 */
public interface Control {

    /**
     * Returns true if user changed the direction
     * until reset.
     */
    boolean newEvent();

    /**
     * Contains last direction form user,
     * until reset.
     */
    Direction getDirection();

    /**
     * Client is ready for new events.
     */
    void reset();
}
