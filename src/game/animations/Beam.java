package game.animations;

import biuoop.DrawSurface;
import game.levels.GameLevel;
import game.objects.Sprite;

import java.awt.Color;

/**
 * @author Yair Koskas
 * ID: 325699999
 * this class represents the beams seen in the third level background.
 */
public class Beam implements Sprite {
    private int xOrigin;
    private int yOrigin;
    private int size;
    private Color color;
    private int direct;

    /**
     * constructor.
     * @param xOrigin the x coordinate of the origin of the beam
     * @param yOrigin the y coordinate of the origin of the beam
     * @param c the color of the beam
     */
    public Beam(int xOrigin, int yOrigin, Color c) {
        this.xOrigin = xOrigin;
        this.yOrigin = yOrigin;
        size = 1;
        this.color = c;
    }

    @Override
    public void drawOn(DrawSurface d) {
        d.setColor(this.color);
        int xfactor = 10, yfactor = 10;
        d.fillRectangle(xOrigin - this.size * xfactor, yOrigin, this.size * xfactor, yfactor);
    }

    @Override
    public void timePassed() {

    }

    @Override
    public void addToGame(GameLevel g) {

    }

    /**
     * bane: setSize.
     * sets the size of the beam.
     * @param s the new size of the beam
     */
    public void setSize(int s) {
        this.size = s;
    }

    /**
     * accessor.
     * name: getSize.
     * @return the size of the beam
     */
    public int getSize() {
        return size;
    }

    /**
     * name: getDirect.
     * @return returns the direction of the beam(1 if left, 0 if right)
     */
    public int getDirect() {
        return direct;
    }

    /**
     * name: setDirect.
     * @param d the new direction of the beam
     */
    public void setDirect(int d) {
        this.direct = d;
    }
}
