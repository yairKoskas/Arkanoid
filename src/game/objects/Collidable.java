package game.objects;

import game.levels.GameLevel;
import geometry.Point;
import geometry.Rectangle;
import geometry.Velocity;

/**
 * @author Yair Koskas
 * ID: 325699999
 * interface of a collidable object
 */
public interface Collidable {
    /**
     *
     * @return the shape of the collision
     */
    Rectangle getColissionRectangle();
    /**
     *
     * @param collisionPoint the point of the collision
     * @param currentVelocity the velocity of the body colliding
     * @param hitter the ball that hits us
     * @return the new velocity after the hit
     */
    Velocity hit(Ball hitter, Point collisionPoint, Velocity currentVelocity);

    /**
     * name: addtoGame.
     * @param g the game we add the collidable to
     */
    void addToGame(GameLevel g);
}
