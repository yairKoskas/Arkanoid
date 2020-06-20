package game.listeners;

import game.objects.Ball;
import game.objects.Block;

/**
 * interfacr game.listeners.HitListener.
 */
public interface HitListener {
    /**
     * name: hitEvent.
     * This method is called whenever the beingHit object is hit.
     * The hitter parameter is the game.objects.Ball that's doing the hitting.
     * @param beingHit the block being hit
     * @param hitter the ball hitting the block
     */
    void hitEvent(Block beingHit, Ball hitter);
}
