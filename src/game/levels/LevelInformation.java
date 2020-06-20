package game.levels;

import game.animations.Animation;
import game.objects.Ball;
import game.objects.Block;
import game.objects.Sprite;
import geometry.Velocity;

import java.util.List;

/**
 * @author Yair Koskas.
 * ID: 325699999
 * this interface is saving a level's information
 */
public interface LevelInformation {
    /**
     * name: numberOfBalls.
     * @return the number of balls in the level
     */
    int numberOfBalls();

    /**
     * name: initialBallVelocities.
     * The initial velocity of each ball
     * @return the list of the initial velocities of the balls in the level
     */
    List<Velocity> initialBallVelocities();

    /**
     * name: initialBalls.
     * @return a list of the balls in the level.
     */
    List<Ball> initialBalls();

    /**
     * name: paddleSpeed.
     * @return the paddle speed of the level.
     */
    int paddleSpeed();

    /**
     * name: paddleWidth.
     * @return the width of the paddle in the level
     */
    int paddleWidth();

    /**
     * name: levelName.
     * the level name will be displayed at the top of the screen.
     * @return the name of the level
     */
    String levelName();

    /**
     * name: getBackground.
     * Returns a sprite with the background of the level
     * @return the sprite of the background
     */
    Sprite getBackground();

    /**
     * name: blocks.
     * The Blocks that make up this level, each block contains
     * its size, color and location.
     * @return the list of blocks in the level.
     */
    List<Block> blocks();

    /**
     * name: numberOfBlocksToRemove.
     * Number of blocks that should be removed
     * before the level is considered to be "cleared".
     * This number should be <= blocks.size();
     * @return the number of blocks to be removed
     */
    int numberOfBlocksToRemove();

    /**
     * name: animations.
     * @return the list of animations of the level.
     */
    List<Animation> animations();
}