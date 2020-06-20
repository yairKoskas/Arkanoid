package game.animations;

import biuoop.DrawSurface;
import game.objects.SpriteCollection;

import java.awt.Color;

/**
 * This is the game.animations.WinScreen class.
 *
 * @author Yair Koskas.
 */
public class LoseScreen implements Animation {
    private boolean shouldStop;
    private SpriteCollection sprites;
    private Color textColor;
    private int score;

    /**
     * A constructor for the game.animations.WinScreen class.
     *
     * @param s     the game's objects.
     * @param color the text color.
     * @param score the player's score.
     */
    public LoseScreen(SpriteCollection s, Color color, int score) {
        shouldStop = false;
        sprites = s;
        textColor = color;
        this.score = score;
    }

    @Override
    public void doOneFrame(DrawSurface d) {
        sprites.drawAllOn(d);
        d.setColor(Color.BLACK);
        d.fillRectangle(150, 300, 475, 32);
        d.setColor(textColor);
        d.drawText(150, 332, "Game Over. Your score is " + score + ".", 32);
    }

    @Override
    public boolean shouldStop() {
        return shouldStop;
    }
}
