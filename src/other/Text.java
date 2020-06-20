package other;

import biuoop.DrawSurface;
import game.levels.GameLevel;
import game.objects.Sprite;
import geometry.Point;

import java.awt.Color;

/**
 * @author Yair Koskas
 * ID: 325699999
 * this class draws a text string on the gui
 */
public class Text implements Sprite {
    private String text;
    private Point upperLeft;
    private int fontSize;

    /**
     * constructor.
     * @param upperLeft the upper left point of the text
     * @param text the string of the text
     * @param fontSize the size of the font of the text
     */
    public Text(Point upperLeft, String text, int fontSize) {
        this.text = text;
        this.upperLeft = upperLeft;
        this.fontSize = fontSize;
    }

    @Override
    public void drawOn(DrawSurface d) {
        d.setColor(Color.BLACK);
        d.drawText((int) this.upperLeft.getX(), (int) this.upperLeft.getY(), this.text, fontSize);
    }

    @Override
    public void timePassed() {
    }

    @Override
    public void addToGame(GameLevel g) {
        g.addSprite(this);
    }
}
