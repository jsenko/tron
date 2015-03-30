package net.jsenko.pv260;

import java.util.List;

import net.jsenko.pv260.geometry.Point;

/**
 * @author Jakub Senko
 */
public class CollisionManager {

    private List<CollisionAware> entities;


    public CollisionManager(List<CollisionAware> entities) {
        this.entities = entities;
    }

    public void detectCollisions() {
        // sorry:)
        for (CollisionAware entity1 : entities) {
            for (Point collidingPoint : entity1.getCollidingPoints()) {
                for (CollisionAware entity2 : entities) {
                    for (Point hitboxPoint : entity2.getHitboxPoints()) {
                        if(collidingPoint.equals(hitboxPoint))
                            entity1.hasCollision(collidingPoint, entity2);
                    }
                }
            }
        }
    }
}
