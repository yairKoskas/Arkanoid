package game;

import biuoop.DrawSurface;
import game.levels.GameLevel;
import game.objects.Sprite;
import other.Counter;

import java.awt.Color;

/**
 * @author Yair Koskas
 * ID: 325699999
 * this class represents the score indicator
 */
public class ScoreIndicator implements Sprite {
    private Counter scoreCounter;

    /**
     * constructor.
     * @param scoreCounter the scoreCounter of the score indicator
     */
    public ScoreIndicator(Counter scoreCounter) {
        this.scoreCounter = scoreCounter;
    }

    /**
     * name: getScoreCounter.
     * @return the score counter.
     */
    public Counter getScoreCounter() {
        return scoreCounter;
    }

    @Override
    public void drawOn(DrawSurface d) {
        d.setColor(Color.white);
        d.drawText(320, 17, "Score : " + scoreCounter.getValue(), 20);
    }

    @Override
    public void timePassed() {
    }

    @Override
    public void addToGame(GameLevel g) {
        g.addSprite(this);
    }
}
