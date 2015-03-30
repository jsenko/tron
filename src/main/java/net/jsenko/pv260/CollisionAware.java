package net.jsenko.pv260;

import net.jsenko.pv260.geometry.Point;

/**
 * @author Jakub Senko
 */
public interface CollisionAware {

    /**
     * Mine points that others may collide with
     */
    Iterable<Point> getHitboxPoints();

    /**
     * Points that I may collide into others
     */
    Iterable<Point> getCollidingPoints();

    /**
     * This is called by collision detector, when
     * collision happens.
     * @param point where the collision happened.
     * @param other the other object involved in collision (in addition to me)
     */
    void hasCollision(Point point, CollisionAware other);
}
