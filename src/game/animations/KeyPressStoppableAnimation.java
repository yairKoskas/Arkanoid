package game.animations;

import biuoop.DrawSurface;
import biuoop.KeyboardSensor;

/**
 * @author Yair Koskas
 * ID: 325699999
 * key stoppable animation class
 */
public class KeyPressStoppableAnimation implements Animation {
    private String key;
    private KeyboardSensor sensor;
    private Animation animation;
    private boolean isrunning;
    private boolean isAlreadyPressed;

    /**
     * constructor.
     *
     * @param key       the key needed to press
     * @param sensor    the keyboard sensor
     * @param animation the animation to run
     */
    public KeyPressStoppableAnimation(String key, KeyboardSensor sensor, Animation animation) {
        this.key = key;
        this.sensor = sensor;
        this.animation = animation;
        isrunning = true;
        isAlreadyPressed = true;
    }

    @Override
    public void doOneFrame(DrawSurface d) {
        animation.doOneFrame(d);
        if (sensor.isPressed(key)) {
            isrunning = false;
        }
    }

    @Override
    public boolean shouldStop() {
        return !isrunning;
    }
}
