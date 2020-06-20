package game.animations;

import biuoop.DrawSurface;
import game.levels.GameLevel;
import game.objects.Sprite;

import java.awt.Color;

/**
 * @author Yair Koskas
 * ID: 325699999
 * this class represents the bolt seen in the second level background
 */
public class Bolt implements Sprite {
    private int x;
    private int y;
    private int startX;
    private int startY;
    private Color color;

    /**
     * constructor.
     *
     * @param x     the x coordinate
     * @param y     the y coordinate
     * @param color the color of the bolt
     */
    public Bolt(int x, int y, Color color) {
        this.x = x;
        this.y = y;
        startX = x;
        startY = y;
        this.color = color;
    }

    /**
     * accessor.
     * name: getX.
     * @return the x coorsindate
     */
    public int getX() {
        return x;
    }

    @Override
    public void drawOn(DrawSurface d) {
        int xfactor = 10, yfactor = 10;
        if (color.equals(Color.GREEN)) {
            Color lightGreen = new Color(0, 100, 0);
            d.setColor(Color.GREEN);
            d.fillRectangle(x - 4 * xfactor, y, 4 * xfactor, yfactor);
            d.setColor(lightGreen);
            d.fillRectangle(x, y, xfactor, yfactor);
            d.fillRectangle(x - 5 * xfactor, y, xfactor, yfactor);
            d.fillRectangle(x - 4 * xfactor, y - yfactor, 4 * xfactor, yfactor);
            d.fillRectangle(x - 4 * xfactor, y + yfactor, 4 * xfactor, yfactor);
        } else if (color.equals(Color.RED)) {
            Color lightRed = new Color(240, 128, 128);
            d.setColor(Color.RED);
            d.fillRectangle(x - 4 * xfactor, y, 4 * xfactor, yfactor);
            d.setColor(lightRed);
            d.fillRectangle(x, y, xfactor, yfactor);
            d.fillRectangle(x - 5 * xfactor, y, xfactor, yfactor);
            d.fillRectangle(x - 4 * xfactor, y - yfactor, 4 * xfactor, yfactor);
            d.fillRectangle(x - 4 * xfactor, y + yfactor, 4 * xfactor, yfactor);
        }
    }

    @Override
    public void timePassed() {
    }

    @Override
    public void addToGame(GameLevel g) {
        g.addSprite(this);
    }

    /**
     * name: moveOneStep.
     * moves the bolt 2 pixels in the direction of movement.
     * @param direct the direction of the bolt
     */
    public void moveOneStep(String direct) {
        if (direct.equals("Left") || direct.equals("left")) {
            this.x = x - 2;
        } else if (direct.equals("Right") || direct.equals("right")) {
            this.x = x + 2;
        }
    }

    /**
     * name: resetPosition.
     * resets the position of the bolt.
     */
    public void resetPosition() {
        this.x = startX;
        this.y = startY;
    }
}
