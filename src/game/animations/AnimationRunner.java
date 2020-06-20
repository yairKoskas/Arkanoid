package game.animations;

import biuoop.DrawSurface;
import biuoop.GUI;
import biuoop.Sleeper;

/**
 * @author Yair Koskas
 * ID: 325699999
 * this class is used for running game.animations.
 */
public class AnimationRunner {
    private GUI gui;
    private int framesPerSecond;
    private Sleeper sleeper;

    /**
     * constructor.
     *
     * @param gui             the gui of the animation
     * @param framesPerSecond the fps of the animation
     */
    public AnimationRunner(GUI gui, int framesPerSecond) {
        this.gui = gui;
        this.framesPerSecond = framesPerSecond;
        this.sleeper = new Sleeper();
    }

    /**
     * the function that runs the animation.
     *
     * @param animation the animation we run
     */
    public void run(Animation animation) {
        int millisecondsPerFrame = 1000 / framesPerSecond;
        while (!animation.shouldStop()) {
            DrawSurface d = gui.getDrawSurface();
            long startTime = System.currentTimeMillis(); // timing
            animation.doOneFrame(d);
            gui.show(d);
            long usedTime = System.currentTimeMillis() - startTime;
            long milliSecondLeftToSleep = millisecondsPerFrame - usedTime;
            if (milliSecondLeftToSleep > 0) {
                this.sleeper.sleepFor(milliSecondLeftToSleep);
            }
        }
    }

    /**
     * accessor.
     * name: getGui.
     * @return the gui
     */
    public GUI getGui() {
        return gui;
    }
}