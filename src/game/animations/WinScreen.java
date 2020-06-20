package game.animations;

import biuoop.DrawSurface;
import game.objects.SpriteCollection;

import java.awt.Color;

/**
 * @author Yair Koskas.
 * ID: 325699999
 * the win screen animation
 */
public class WinScreen implements Animation {
    private boolean shouldStop;
    private SpriteCollection sprites;
    private Color textColor;
    private int score;

    /**
     * constructorr
     *
     * @param s     the game's objects.
     * @param color the text color.
     * @param score the player's score.
     */
    public WinScreen(SpriteCollection s, Color color, int score) {
        shouldStop = false;
        sprites = s;
        textColor = color;
        this.score = score;
    }

    @Override
    public void doOneFrame(DrawSurface d) {
        sprites.drawAllOn(d);
        d.setColor(Color.BLACK);
        d.fillRectangle(150, 300, 400, 32);
        d.setColor(textColor);
        d.drawText(150, d.getHeight() / 2 + 25, "You Win! Your score is " + score + ".", 32);
    }

    @Override
    public boolean shouldStop() {
        return shouldStop;
    }
}
