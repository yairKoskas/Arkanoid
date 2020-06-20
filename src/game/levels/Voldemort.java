package game.levels;

import biuoop.DrawSurface;
import game.objects.Sprite;
import game.animations.Animation;
import game.animations.Bolt;

import java.awt.Color;

/**
 * @author Yair Koskas
 * ID: 325699999
 * the voldemort sprite / animation of the second level.
 */
public class Voldemort implements Sprite, Animation {
    private Bolt bolt;

    /**
     * constructor.
     */
    public Voldemort() {
        int xfactor = 15, yfactor = 15, xPivot = 50, yPivot = 550;
        bolt = new Bolt(xPivot + 17 * xfactor, yPivot - 10 * yfactor, Color.GREEN);
    }

    @Override
    public void doOneFrame(DrawSurface d) {
        int xfactor = 15, yfactor = 15, xPivot = 50, yPivot = 550;
        if (bolt.getX() > 680) {
            bolt.resetPosition();
        }
        bolt.moveOneStep("Right");
        bolt.drawOn(d);
    }

    @Override
    public boolean shouldStop() {
        return false;
    }

    @Override
    public void drawOn(DrawSurface d) {
        int xfactor = 15, yfactor = 15, xPivot = 50, yPivot = 550;
        d.setColor(Color.BLACK);
        d.fillRectangle(xPivot, yPivot, 12 * xfactor, yfactor);
        d.fillRectangle(xPivot + xfactor, yPivot - yfactor, 11 * xfactor, yfactor);
        d.fillRectangle(xPivot, yPivot - 2 * yfactor, xfactor, yfactor);
        d.setColor(Color.WHITE);
        d.fillRectangle(xPivot + xfactor, yPivot - 2 * yfactor, xfactor, yfactor);
        d.setColor(Color.BLACK);
        d.fillRectangle(xPivot + 2 * xfactor, yPivot - 2 * yfactor, 10 * xfactor, yfactor);
        d.fillRectangle(xPivot, yPivot - 3 * yfactor, 12 * xfactor, yfactor);
        d.fillRectangle(xPivot + 13 * xfactor, yPivot - 3 * yfactor, 2 * xfactor, yfactor);
        d.fillRectangle(xPivot, yPivot - 4 * yfactor, 15 * xfactor, yfactor);
        d.setColor(Color.WHITE);
        d.fillRectangle(xPivot + 15 * xfactor, yPivot - 9 * yfactor, xfactor, 6 * yfactor);
        d.fillRectangle(xPivot + 7 * xfactor, yPivot - 6 * yfactor, xfactor, yfactor);
        d.fillRectangle(xPivot + 6 * xfactor, yPivot - 7 * yfactor, 3 * xfactor, yfactor);
        d.fillRectangle(xPivot + 5 * xfactor, yPivot - 8 * yfactor, 5 * xfactor, yfactor);
        d.fillRectangle(xPivot + 3 * xfactor, yPivot - 9 * yfactor, 8 * xfactor, yfactor);
        d.fillRectangle(xPivot + 2 * xfactor, yPivot - 10 * yfactor, 10 * xfactor, yfactor);
        d.fillRectangle(xPivot + xfactor, yPivot - 11 * yfactor, 5 * xfactor, yfactor);
        d.fillRectangle(xPivot + 7 * xfactor, yPivot - 11 * yfactor, xfactor, yfactor);
        d.fillRectangle(xPivot + 9 * xfactor, yPivot - 11 * yfactor, 4 * xfactor, yfactor);
        d.fillRectangle(xPivot + xfactor, yPivot - 12 * yfactor, 4 * xfactor, yfactor);
        d.fillRectangle(xPivot + 7 * xfactor, yPivot - 12 * yfactor, xfactor, yfactor);
        d.fillRectangle(xPivot + 10 * xfactor, yPivot - 12 * yfactor, 3 * xfactor, yfactor);
        d.fillRectangle(xPivot + 2 * xfactor, yPivot - 13 * yfactor, 2 * xfactor, yfactor);
        d.fillRectangle(xPivot + 6 * xfactor, yPivot - 13 * yfactor, 3 * xfactor, yfactor);
        d.fillRectangle(xPivot + 11 * xfactor, yPivot - 13 * yfactor, xfactor, yfactor);
        d.fillRectangle(xPivot + 2 * xfactor, yPivot - 14 * yfactor, 10 * xfactor, yfactor);
        d.fillRectangle(xPivot + 2 * xfactor, yPivot - 15 * yfactor, 10 * xfactor, yfactor);
        d.fillRectangle(xPivot + 3 * xfactor, yPivot - 16 * yfactor, 8 * xfactor, yfactor);
        d.fillRectangle(xPivot + 5 * xfactor, yPivot - 17 * yfactor, 4 * xfactor, yfactor);
        d.setColor(Color.BLACK);
        d.fillRectangle(xPivot, yPivot - 5 * yfactor, 15 * xfactor, yfactor);
        d.fillRectangle(xPivot, yPivot - 6 * yfactor, 7 * xfactor, yfactor);
        d.fillRectangle(xPivot + 8 * xfactor, yPivot - 6 * yfactor, 5 * xfactor, yfactor);
        d.fillRectangle(xPivot + xfactor, yPivot - 7 * yfactor, 5 * xfactor, yfactor);
        d.fillRectangle(xPivot + 9 * xfactor, yPivot - 7 * yfactor, 3 * xfactor, yfactor);
        d.fillRectangle(xPivot + 2 * xfactor, yPivot - 8 * yfactor, 3 * xfactor, yfactor);
        d.fillRectangle(xPivot + 10 * xfactor, yPivot - 8 * yfactor, xfactor, yfactor);
        d.fillRectangle(xPivot + 6 * xfactor, yPivot - 11 * yfactor, xfactor, yfactor);
        d.fillRectangle(xPivot + 8 * xfactor, yPivot - 11 * yfactor, xfactor, yfactor);
        d.setColor(Color.RED);
        d.fillRectangle(xPivot + 5 * xfactor, yPivot - 12 * yfactor, xfactor, yfactor);
        d.fillRectangle(xPivot + 9 * xfactor, yPivot - 12 * yfactor, xfactor, yfactor);
        d.setColor(Color.GRAY);
        d.fillRectangle(xPivot + 6 * xfactor, yPivot - 12 * yfactor, xfactor, yfactor);
        d.fillRectangle(xPivot + 8 * xfactor, yPivot - 12 * yfactor, xfactor, yfactor);
        d.fillRectangle(xPivot + 4 * xfactor, yPivot - 13 * yfactor, 2 * xfactor, yfactor);
        d.fillRectangle(xPivot + 9 * xfactor, yPivot - 13 * yfactor, 2 * xfactor, yfactor);
    }

    @Override
    public void timePassed() {

    }

    @Override
    public void addToGame(GameLevel g) {
        g.addSprite(this);
    }
}
