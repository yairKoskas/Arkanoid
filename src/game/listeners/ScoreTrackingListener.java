package game.listeners;

import game.objects.Ball;
import game.objects.Block;
import other.Counter;

/**
 * @author Yair Koskas
 * ID: 325699999
 * this class represents a score tracking hit listener
 */
public class ScoreTrackingListener implements HitListener {
    private Counter currentScore;

    /**
     * constructor.
     * @param scoreCounter the score counter we are starting with
     */
    public ScoreTrackingListener(Counter scoreCounter) {
        this.currentScore = scoreCounter;
    }

    @Override
    public void hitEvent(Block beingHit, Ball hitter) {
       currentScore.increase(5);
       beingHit.removeHitListener(this);
    }
}