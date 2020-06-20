package game.listeners;

import game.levels.GameLevel;
import game.objects.Ball;
import game.objects.Block;
import other.Counter;

/**
 * @author Yair Koskas
 * ID: 325699999
 * this class represents a ball removing hit listener
 */
public class BallRemover implements HitListener {
    private Counter remainingBalls;
    private GameLevel gameLevel;

    /**
     * constructor.
     *
     * @param remainingBalls the balls that remain
     * @param gameLevel the gameLevel we are monitoring
     */
    public BallRemover(GameLevel gameLevel, Counter remainingBalls) {
        this.remainingBalls = remainingBalls;
        this.gameLevel = gameLevel;
    }

    @Override
    public void hitEvent(Block beingHit, Ball hitter) {
        hitter.removeFromGame(this.gameLevel);
        remainingBalls.decrease(1);
    }
}
