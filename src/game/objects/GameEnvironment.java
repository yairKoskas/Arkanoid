package game.objects;

import geometry.Line;
import geometry.Point;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * @author Yair Koskas
 * ID: 325699999
 */
public class GameEnvironment {
    //fields
    private List<Collidable> list;

    /**
     * constructor.
     */
    public GameEnvironment() {
        list = new LinkedList<>();
    }

    /**
     * name: addCollidable.
     * adds a new collidable object to the list
     *
     * @param c the new collidable object
     */
    public void addCollidable(Collidable c) {
        this.list.add(c);
    }

    // Assume an object moving from line.start() to line.end().
    // If this object will not collide with any of the collidables
    // in this collection, return null. Else, return the information
    // about the closest collision that is going to occur.

    /**
     * name: getClosestCollision.
     *
     * @param trajectory the trajectory of the object
     * @return the collision info of the collision, if there's any
     */
    public CollisionInfo getClosestCollision(Line trajectory) {
        if (trajectory.isPoint()) {
            return null;
        }
        //creates a new list of points
        List<geometry.Point> pointList = new ArrayList<>();
        geometry.Rectangle r;
        geometry.Point closestPoint = new Point(0, 0);
        double min = Double.MAX_VALUE;
        //for all collidables add the closest points of intersection
        for (Collidable c : this.list) {
            r = c.getColissionRectangle();
            if (!r.intersectionPoints(trajectory).isEmpty()
                    && !pointList.contains(trajectory.closestIntersectionToStartOfLine(r))) {
                pointList.add(trajectory.closestIntersectionToStartOfLine(r));
            }
        }
        //if there are no points of intersection within the trajectory, return null
        if (pointList.isEmpty()) {
            return null;
        }
        //finds the closest point
        for (geometry.Point p : pointList) {
            if (p.distance(trajectory.start()) < min) {
                min = p.distance(trajectory.start());
                closestPoint = p;
            }
        }
        // finds the object of closest collision
        for (Collidable c : this.list) {
            r = c.getColissionRectangle();
            if (trajectory.closestIntersectionToStartOfLine(r).equals(closestPoint)) {
                return new CollisionInfo(closestPoint, c);
            }
        }
        return null;
    }

    /**
     * name: removeCollidable.
     *
     * @param c the collidable we remove from the list
     */
    public void removeCollidable(Collidable c) {
        this.list.remove(c);
    }
}
