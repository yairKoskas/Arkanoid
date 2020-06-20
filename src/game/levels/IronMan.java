package game.levels;

import biuoop.DrawSurface;
import game.animations.Animation;
import game.animations.Beam;
import game.objects.Sprite;

import java.awt.Color;

/**
 * @author Yair Koskas
 * ID: 325699999
 * the iron man background / animation in the third level.
 */
public class IronMan implements Sprite, Animation {
    private Beam b;

    /**
     * constructor.
     */
    public IronMan() {
        int xPivot = 600, yPivot = 550, xfactor = 10, yfactor = 10;
        this.b = new Beam(xPivot - 3 * xfactor, yPivot - 7 * yfactor,
                new Color(102, 255, 255));
        this.b.setSize(0);
    }

    @Override
    public void drawOn(DrawSurface d) {
        int xPivot = 600, yPivot = 550, xfactor = 10, yfactor = 10;
        d.setColor(Color.GRAY);
        d.fillRectangle(xPivot + 5 * xfactor, yPivot - 3 * yfactor, xfactor, 3 * yfactor);
        d.fillRectangle(xPivot + xfactor, yPivot - 3 * yfactor, xfactor, 2 * yfactor);
        d.setColor(new Color(102, 255, 255));
        d.fillRectangle(xPivot + 5 * xfactor, yPivot, 2 * xfactor, yfactor);
        d.fillRectangle(xPivot + xfactor, yPivot - yfactor, 2 * xfactor, yfactor);
        d.fillRectangle(xPivot + 4 * xfactor, yPivot - yfactor, xfactor, yfactor);
        d.fillRectangle(xPivot + 6 * xfactor, yPivot - yfactor, xfactor, yfactor);
        d.fillRectangle(xPivot + 2 * xfactor, yPivot - 8 * yfactor, xfactor, yfactor);
        d.fillRectangle(xPivot, yPivot - 2 * yfactor, xfactor, yfactor);
        d.fillRectangle(xPivot + 2 * xfactor, yPivot - 2 * yfactor, xfactor, yfactor);
        d.fillRectangle(xPivot + 4 * xfactor, yPivot - 2 * yfactor, xfactor, yfactor);
        d.fillRectangle(xPivot + 6 * xfactor, yPivot - 2 * yfactor, xfactor, yfactor);
        d.fillRectangle(xPivot, yPivot - 3 * yfactor, xfactor, yfactor);
        d.fillRectangle(xPivot + 2 * xfactor, yPivot - 3 * yfactor, xfactor, yfactor);
        d.fillRectangle(xPivot + 4 * xfactor, yPivot - 3 * yfactor, xfactor, yfactor);
        d.fillRectangle(xPivot + 6 * xfactor, yPivot - 3 * yfactor, xfactor, yfactor);
        d.fillRectangle(xPivot + xfactor, yPivot - 9 * yfactor, 3 * xfactor, yfactor);
        d.setColor(Color.BLACK);
        d.fillRectangle(xPivot, yPivot - 4 * yfactor, 3 * yfactor, yfactor);
        d.fillRectangle(xPivot + 4 * xfactor, yPivot - 4 * yfactor, 3 * xfactor, yfactor);
        d.fillRectangle(xPivot - xfactor, yPivot - 5 * yfactor, 2 * xfactor, yfactor);
        d.fillRectangle(xPivot + 2 * xfactor, yPivot - 5 * yfactor, 2 * xfactor, yfactor);
        d.fillRectangle(xPivot + 6 * xfactor, yPivot - 5 * yfactor, xfactor, yfactor);
        d.fillRectangle(xPivot - 4 * xfactor, yPivot - 6 * yfactor, 2 * xfactor, yfactor);
        d.fillRectangle(xPivot + 8 * xfactor, yPivot - 6 * yfactor, 2 * xfactor, yfactor);
        d.fillRectangle(xPivot - xfactor, yPivot - 6 * yfactor, xfactor, yfactor);
        d.fillRectangle(xPivot + 6 * xfactor, yPivot - 6 * yfactor, xfactor, yfactor);
        d.fillRectangle(xPivot - 4 * xfactor, yPivot - 7 * yfactor, xfactor, yfactor);
        d.fillRectangle(xPivot + 9 * xfactor, yPivot - 7 * yfactor, xfactor, yfactor);
        d.fillRectangle(xPivot - 2 * xfactor, yPivot - 7 * yfactor, 2 * xfactor, yfactor);
        d.fillRectangle(xPivot + 6 * xfactor, yPivot - 7 * yfactor, 2 * xfactor, yfactor);
        d.fillRectangle(xPivot - 3 * xfactor, yPivot - 8 * yfactor, xfactor, yfactor);
        d.fillRectangle(xPivot - xfactor, yPivot - 8 * yfactor, xfactor, yfactor);
        d.fillRectangle(xPivot + 6 * xfactor, yPivot - 8 * yfactor, xfactor, yfactor);
        d.fillRectangle(xPivot + 8 * xfactor, yPivot - 8 * yfactor, xfactor, yfactor);
        d.fillRectangle(xPivot - 3 * xfactor, yPivot - 9 * yfactor, xfactor, yfactor);
        d.fillRectangle(xPivot - xfactor, yPivot - 9 * yfactor, xfactor, yfactor);
        d.fillRectangle(xPivot + 6 * xfactor, yPivot - 9 * yfactor, xfactor, yfactor);
        d.fillRectangle(xPivot + 8 * xfactor, yPivot - 9 * yfactor, xfactor, yfactor);
        d.fillRectangle(xPivot - 2 * xfactor, yPivot - 10 * yfactor, xfactor, yfactor);
        d.fillRectangle(xPivot + 7 * xfactor, yPivot - 10 * yfactor, xfactor, yfactor);
        d.fillRectangle(xPivot - xfactor, yPivot - 11 * yfactor, 8 * xfactor, yfactor);
        d.fillRectangle(xPivot - 3 * xfactor, yPivot - 12 * yfactor, 2 * xfactor, yfactor);
        d.fillRectangle(xPivot + 7 * xfactor, yPivot - 12 * yfactor, 2 * xfactor, yfactor);
        d.fillRectangle(xPivot - 3 * xfactor, yPivot - 13 * yfactor, xfactor, yfactor);
        d.fillRectangle(xPivot + 8 * xfactor, yPivot - 13 * yfactor, xfactor, yfactor);
        d.fillRectangle(xPivot + xfactor, yPivot - 13 * yfactor, 3 * xfactor, yfactor);
        d.fillRectangle(xPivot - 3 * xfactor, yPivot - 14 * yfactor, xfactor, yfactor);
        d.fillRectangle(xPivot + 8 * xfactor, yPivot - 14 * yfactor, xfactor, yfactor);
        d.fillRectangle(xPivot - 3 * xfactor, yPivot - 15 * yfactor, xfactor, yfactor);
        d.fillRectangle(xPivot + 8 * xfactor, yPivot - 15 * yfactor, xfactor, yfactor);
        d.fillRectangle(xPivot - 3 * xfactor, yPivot - 16 * yfactor, xfactor, yfactor);
        d.fillRectangle(xPivot + 8 * xfactor, yPivot - 16 * yfactor, xfactor, yfactor);
        d.fillRectangle(xPivot - 3 * xfactor, yPivot - 17 * yfactor, xfactor, yfactor);
        d.fillRectangle(xPivot + 8 * xfactor, yPivot - 17 * yfactor, xfactor, yfactor);
        d.fillRectangle(xPivot - 3 * xfactor, yPivot - 18 * yfactor, xfactor, yfactor);
        d.fillRectangle(xPivot + 8 * xfactor, yPivot - 18 * yfactor, xfactor, yfactor);
        d.fillRectangle(xPivot - 2 * xfactor, yPivot - 19 * yfactor, xfactor, yfactor);
        d.fillRectangle(xPivot + 7 * xfactor, yPivot - 19 * yfactor, xfactor, yfactor);
        d.fillRectangle(xPivot - xfactor, yPivot - 20 * yfactor, 8 * xfactor, yfactor);
        d.setColor(Color.RED);
        d.fillRectangle(xPivot + xfactor, yPivot - 5 * yfactor, xfactor, yfactor);
        d.fillRectangle(xPivot + 4 * xfactor, yPivot - 5 * yfactor, 2 * xfactor, yfactor);
        d.fillRectangle(xPivot, yPivot - 6 * yfactor, 6 * xfactor, yfactor);
        d.fillRectangle(xPivot, yPivot - 7 * yfactor, 6 * xfactor, yfactor);
        d.fillRectangle(xPivot - 3 * xfactor, yPivot - 7 * yfactor, xfactor, yfactor);
        d.fillRectangle(xPivot + 8 * xfactor, yPivot - 7 * yfactor, xfactor, yfactor);
        d.fillRectangle(xPivot, yPivot - 8 * yfactor, 2 * xfactor, yfactor);
        d.fillRectangle(xPivot + 3 * xfactor, yPivot - 8 * yfactor, 3 * xfactor, yfactor);
        d.fillRectangle(xPivot, yPivot - 9 * yfactor, xfactor, yfactor);
        d.fillRectangle(xPivot + 4 * xfactor, yPivot - 9 * yfactor, 2 * xfactor, yfactor);
        d.fillRectangle(xPivot - xfactor, yPivot - 10 * yfactor, 8 * xfactor, yfactor);
        d.fillRectangle(xPivot - xfactor, yPivot - 12 * yfactor, xfactor, yfactor);
        d.fillRectangle(xPivot + 5 * xfactor, yPivot - 12 * yfactor, 2 * xfactor, yfactor);
        d.fillRectangle(xPivot - 2 * xfactor, yPivot - 13 * yfactor, xfactor, yfactor);
        d.fillRectangle(xPivot + 6 * xfactor, yPivot - 13 * yfactor, 2 * xfactor, yfactor);
        d.fillRectangle(xPivot - 2 * xfactor, yPivot - 14 * yfactor, xfactor, yfactor);
        d.fillRectangle(xPivot + 6 * xfactor, yPivot - 14 * yfactor, 2 * xfactor, yfactor);
        d.fillRectangle(xPivot + 7 * xfactor, yPivot - 15 * yfactor, xfactor, yfactor);
        d.fillRectangle(xPivot + 7 * xfactor, yPivot - 16 * yfactor, xfactor, yfactor);
        d.fillRectangle(xPivot + xfactor, yPivot - 17 * yfactor, xfactor * 3, yfactor);
        d.fillRectangle(xPivot + 7 * xfactor, yPivot - 17 * xfactor, xfactor, yfactor);
        d.fillRectangle(xPivot + xfactor, yPivot - 18 * yfactor, xfactor * 3, yfactor);
        d.fillRectangle(xPivot + 7 * xfactor, yPivot - 18 * yfactor, xfactor, yfactor);
        d.fillRectangle(xPivot - xfactor, yPivot - 19 * yfactor, 8 * xfactor, yfactor);
        d.setColor(Color.YELLOW);
        d.fillRectangle(xPivot - 2 * xfactor, yPivot - 8 * yfactor, xfactor, yfactor);
        d.fillRectangle(xPivot + 7 * xfactor, yPivot - 8 * yfactor, xfactor, yfactor);
        d.fillRectangle(xPivot - 2 * xfactor, yPivot - 9 * yfactor, xfactor, yfactor);
        d.fillRectangle(xPivot + 7 * xfactor, yPivot - 9 * yfactor, xfactor, yfactor);
        d.fillRectangle(xPivot, yPivot - 12 * yfactor, 5 * xfactor, yfactor);
        d.fillRectangle(xPivot - xfactor, yPivot - 13 * yfactor, 2 * xfactor, yfactor);
        d.fillRectangle(xPivot + 4 * xfactor, yPivot - 13 * yfactor, 2 * xfactor, yfactor);
        d.fillRectangle(xPivot - xfactor, yPivot - 14 * yfactor, 7 * xfactor, yfactor);
        d.fillRectangle(xPivot - 2 * xfactor, yPivot - 15 * yfactor, 9 * xfactor, yfactor);
        d.fillRectangle(xPivot - 2 * xfactor, yPivot - 16 * yfactor, xfactor, yfactor);
        d.fillRectangle(xPivot + xfactor, yPivot - 16 * yfactor, 3 * xfactor, yfactor);
        d.fillRectangle(xPivot + 6 * xfactor, yPivot - 16 * yfactor, xfactor, yfactor);
        d.fillRectangle(xPivot - 2 * xfactor, yPivot - 17 * yfactor, xfactor * 3, yfactor);
        d.fillRectangle(xPivot + 4 * xfactor, yPivot - 17 * yfactor, xfactor * 3, yfactor);
        d.fillRectangle(xPivot - 2 * xfactor, yPivot - 18 * yfactor, xfactor * 3, yfactor);
        d.fillRectangle(xPivot + 4 * xfactor, yPivot - 18 * yfactor, xfactor * 3, yfactor);
    }

    @Override
    public void timePassed() {

    }

    @Override
    public void addToGame(GameLevel g) {
        g.addSprite(this);
    }

    @Override
    public void doOneFrame(DrawSurface d) {
        if (b.getSize() <= 0) {
            b.setDirect(1);
        }
        if (b.getSize() > 54) {
            b.setDirect(-1);
        }
        if (b.getDirect() == -1) {
            b.setSize(b.getSize() - 1);
        } else {
            b.setSize(b.getSize() + 1);
        }
        b.drawOn(d);
    }

    @Override
    public boolean shouldStop() {
        return false;
    }
}
