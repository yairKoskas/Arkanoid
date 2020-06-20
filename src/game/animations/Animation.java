package game.animations;

import biuoop.DrawSurface;

/**
 * @author Yair Koskas
 * ID: 325699999
 */
public interface Animation {
    /**
     * name: doOneFrame.
     * do one frame of the animation
     * @param d the drawing surface
     */
    void doOneFrame(DrawSurface d);

    /**
     * name: shouldStop.
     * @return true if the animation should stop
     */
    boolean shouldStop();
}