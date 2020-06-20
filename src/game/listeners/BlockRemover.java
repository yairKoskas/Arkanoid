package game.listeners;

import game.objects.Ball;
import game.objects.Block;
import game.levels.GameLevel;
import other.Counter;

/**
 * @author Yair Koskas
 * ID: 325699999
 * this class represents a block removing hit listener
 */
public class BlockRemover implements HitListener {
    private GameLevel gameLevel;
    private Counter remainingBlocks;

    /**
     *
     * @param gameLevel the gameLevel we remove the block from
     * @param removedBlocks the number of removed Blocks
     */
    public BlockRemover(GameLevel gameLevel, Counter removedBlocks) {
            this.gameLevel = gameLevel;
            this.remainingBlocks = removedBlocks;
    }

    @Override
    public void hitEvent(Block beingHit, Ball hitter) {
        beingHit.removeHitListener(this);
        beingHit.removeFromGame(this.gameLevel);
        remainingBlocks.decrease(1);
    }
}
