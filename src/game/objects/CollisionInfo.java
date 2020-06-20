package game.objects;

import geometry.Point;

/**
 * @author Yair Koskas
 * ID: 325699999
 * this class represents a structure that will keep the point and object of collision
 */
public class CollisionInfo {
    //fields
    private Point collisionPoint;
    private Collidable collisionObject;

    /**
     * constructor.
     * @param collisionPoint the point of collision
     * @param collisionObject the object we collide with
     */
    public CollisionInfo(Point collisionPoint, Collidable collisionObject) {
        this.collisionPoint = collisionPoint;
        this.collisionObject = collisionObject;
    }

    /**
     * name: collisionPoint.
     * returns the point of the collision
     *
     * @return the collision point
     */
    public Point collisionPoint() {
        return this.collisionPoint;
    }

    /**
     * name: collisionObject.
     * returns the object we collided with
     * @return the collision object
     */
    public Collidable collisionObject() {
        return this.collisionObject;
    }
}