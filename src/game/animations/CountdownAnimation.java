package game.animations;

import biuoop.DrawSurface;
import game.objects.SpriteCollection;
import other.Text;

import java.awt.Color;

/**
 * @author Yair Koskas
 * ID: 325699999
 * the countdown animation class
 */
public class CountdownAnimation implements Animation {
    private double numOfSeconds;
    private int countFrom;
    private int counter;
    private SpriteCollection gameScreen;
    private boolean end;
    private int frameNum;
    private Color color;

    /**
     * A constructor for the game.animations.CountdownAnimation class.
     *
     * @param numOfSeconds the number of seconds the count will last.
     * @param countFrom    the number that the count starts from.
     * @param gameScreen   the game's screen.
     * @param c            the color of the text.
     */
    public CountdownAnimation(double numOfSeconds, int countFrom, SpriteCollection gameScreen, Color c) {
        this.numOfSeconds = numOfSeconds;
        this.countFrom = countFrom;
        this.counter = countFrom;
        this.gameScreen = gameScreen;
        this.end = false;
        this.frameNum = 1;
        this.color = c;
    }

    @Override
    public void doOneFrame(DrawSurface d) {
        this.gameScreen.drawAllOn(d);
        this.gameScreen.drawAllOn(d);

        if (this.counter > 0) {
            d.setColor(Color.LIGHT_GRAY);
            d.fillRectangle(200, d.getHeight() / 2 + 25 - 30, 375, 32);
            d.setColor(color);
            Text t = new Text(new geometry.Point(200, 320),
                    "Game will be started in " + this.counter + "...", 20);
            t.drawOn(d);
            this.frameNum++;
            if (this.frameNum == 60 * numOfSeconds / countFrom) {
                this.counter--;
                this.frameNum = 1;
            }
        } else {
            this.end = true;
        }
    }

    @Override
    public boolean shouldStop() {
        return this.end;
    }
}