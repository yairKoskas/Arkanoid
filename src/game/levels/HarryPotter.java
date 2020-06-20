package game.levels;

import biuoop.DrawSurface;
import game.animations.Animation;
import game.animations.Bolt;
import game.objects.Sprite;

import java.awt.Polygon;
import java.awt.Color;

/**
 * @author Yair Koskas
 * ID: 325699999
 * the harry potter background / animation in the second level
 */
public class HarryPotter implements Sprite, Animation {
    private Bolt bolt;

    /**
     * constructor.
     */
    public HarryPotter() {
        Color c = Color.RED;
        int xfactor = 10, yfactor = 10, xPivot = 615, yPivot = 550;
        bolt = new Bolt(xPivot - 5 * xfactor, yPivot - 15 * yfactor, c);
    }

    @Override
    public void drawOn(DrawSurface d) {
        d.setColor(Color.CYAN);
        d.fillRectangle(0, 0, 800, 600);
        d.setColor(Color.YELLOW);
        int[] xpoints = {350, 300, 375, 350, 500, 400, 425};
        int[] ypoint = {0, 100, 100, 200, 50, 50, 0};
        d.fillPolygon(new Polygon(xpoints, ypoint, 7));
        d.setColor(Color.BLACK);
        d.drawPolygon(new Polygon(xpoints, ypoint, 7));
        drawHarryPartOne(d);
        drawHarryPartTwo(d);
        Sprite s = new Voldemort();
        s.drawOn(d);
    }

    /**
     * name: drawHarryPartOne.
     * draws the first part of harry.
     * @param d the drawSurface
     */
    public void drawHarryPartOne(DrawSurface d) {
        Color faceColor = new Color(255, 219, 172);
        int xfactor = 10, yfactor = 10, xPivot = 615, yPivot = 550;
        d.setColor(Color.BLACK);
        d.fillRectangle(xPivot, yPivot, 5 * xfactor, yfactor);
        d.fillRectangle(xPivot + 6 * xfactor, yPivot, 5 * xfactor, yfactor);
        d.fillRectangle(xPivot + xfactor, yPivot - yfactor, 4 * xfactor, yfactor);
        d.fillRectangle(xPivot + 6 * xfactor, yPivot - yfactor, 4 * xfactor, yfactor);
        d.fillRectangle(xPivot + xfactor, yPivot - 3 * yfactor, 2 * xfactor, yfactor);
        d.fillRectangle(xPivot + 8 * xfactor, yPivot - 3 * yfactor, 2 * xfactor, yfactor);
        d.fillRectangle(xPivot + xfactor, yPivot - 4 * yfactor, 2 * xfactor, yfactor);
        d.fillRectangle(xPivot + 8 * xfactor, yPivot - 4 * yfactor, 2 * xfactor, yfactor);
        d.fillRectangle(xPivot + xfactor, yPivot - 5 * yfactor, 2 * xfactor, yfactor);
        d.fillRectangle(xPivot + 8 * xfactor, yPivot - 5 * yfactor, 2 * xfactor, yfactor);
        d.fillRectangle(xPivot + xfactor, yPivot - 6 * yfactor, 2 * xfactor, yfactor);
        d.fillRectangle(xPivot + 7 * xfactor, yPivot - 6 * yfactor, 3 * xfactor, yfactor);
        d.fillRectangle(xPivot + 2 * xfactor, yPivot - 7 * yfactor, 2 * xfactor, yfactor);
        d.fillRectangle(xPivot + 7 * xfactor, yPivot - 7 * yfactor, 2 * xfactor, yfactor);
        d.fillRectangle(xPivot + 2 * xfactor, yPivot - 8 * yfactor, 2 * xfactor, yfactor);
        d.fillRectangle(xPivot + 7 * xfactor, yPivot - 8 * yfactor, 2 * xfactor, yfactor);
        d.fillRectangle(xPivot + 2 * xfactor, yPivot - 9 * yfactor, 2 * xfactor, yfactor);
        d.fillRectangle(xPivot + 7 * xfactor, yPivot - 9 * yfactor, 2 * xfactor, yfactor);
        d.fillRectangle(xPivot - xfactor, yPivot - 10 * yfactor, 2 * xfactor, yfactor);
        d.fillRectangle(xPivot + 3 * xfactor, yPivot - 10 * yfactor, xfactor, yfactor);
        d.fillRectangle(xPivot + 7 * xfactor, yPivot - 10 * yfactor, 4 * xfactor, yfactor);
        d.fillRectangle(xPivot, yPivot - 11 * yfactor, 2 * xfactor, yfactor);
        d.fillRectangle(xPivot + 3 * xfactor, yPivot - 11 * yfactor, xfactor, yfactor);
        d.fillRectangle(xPivot + 7 * xfactor, yPivot - 11 * yfactor, 4 * xfactor, yfactor);
        d.fillRectangle(xPivot - 3 * xfactor, yPivot - 12 * yfactor, 2 * xfactor, yfactor);
        d.fillRectangle(xPivot - 4 * xfactor, yPivot - 13 * yfactor, 2 * xfactor, yfactor);
        d.fillRectangle(xPivot - 5 * xfactor, yPivot - 14 * yfactor, 2 * xfactor, yfactor);
        d.fillRectangle(xPivot - 5 * xfactor, yPivot - 15 * yfactor, xfactor, yfactor);
        d.fillRectangle(xPivot, yPivot - 12 * yfactor, 4 * xfactor, yfactor);
        d.fillRectangle(xPivot + 8 * xfactor, yPivot - 12 * yfactor, 3 * xfactor, yfactor);
        d.fillRectangle(xPivot + xfactor, yPivot - 13 * yfactor, 3 * xfactor, yfactor);
        d.fillRectangle(xPivot + 7 * xfactor, yPivot - 13 * yfactor, 3 * xfactor, yfactor);
        d.fillRectangle(xPivot + 2 * xfactor, yPivot - 14 * yfactor, 2 * xfactor, yfactor);
        d.fillRectangle(xPivot + 7 * xfactor, yPivot - 14 * yfactor, 3 * xfactor, yfactor);
        d.setColor(Color.DARK_GRAY);
        d.fillRectangle(xPivot + 2 * xfactor, yPivot - 2 * yfactor, 3 * xfactor, yfactor);
        d.fillRectangle(xPivot + 6 * xfactor, yPivot - 2 * yfactor, 3 * xfactor, yfactor);
        d.fillRectangle(xPivot + 3 * xfactor, yPivot - 3 * yfactor, 2 * xfactor, yfactor);
        d.fillRectangle(xPivot + 6 * xfactor, yPivot - 3 * yfactor, 2 * xfactor, yfactor);
        d.fillRectangle(xPivot + 3 * xfactor, yPivot - 4 * yfactor, 2 * xfactor, yfactor);
        d.fillRectangle(xPivot + 6 * xfactor, yPivot - 4 * yfactor, 2 * xfactor, yfactor);
        d.fillRectangle(xPivot + 3 * xfactor, yPivot - 5 * yfactor, 2 * xfactor, yfactor);
        d.fillRectangle(xPivot + 6 * xfactor, yPivot - 5 * yfactor, 2 * xfactor, yfactor);
        d.fillRectangle(xPivot + 3 * xfactor, yPivot - 6 * yfactor, 2 * xfactor, yfactor);
        d.fillRectangle(xPivot + 6 * xfactor, yPivot - 6 * yfactor, xfactor, yfactor);
        d.fillRectangle(xPivot + 4 * xfactor, yPivot - 7 * yfactor, 3 * xfactor, yfactor);
        d.setColor(Color.LIGHT_GRAY);
        d.fillRectangle(xPivot + 4 * xfactor, yPivot - 8 * yfactor, 3 * xfactor, yfactor);
        d.fillRectangle(xPivot + 4 * xfactor, yPivot - 9 * yfactor, 3 * xfactor, yfactor);
        d.fillRectangle(xPivot + 4 * xfactor, yPivot - 10 * yfactor, 3 * xfactor, yfactor);
        d.fillRectangle(xPivot + 4 * xfactor, yPivot - 11 * yfactor, 3 * xfactor, yfactor);
        d.fillRectangle(xPivot + 4 * xfactor, yPivot - 12 * yfactor, 4 * xfactor, yfactor);
        d.fillRectangle(xPivot + 4 * xfactor, yPivot - 13 * yfactor, xfactor, yfactor);
        d.fillRectangle(xPivot + 6 * xfactor, yPivot - 13 * yfactor, xfactor, yfactor);
        d.setColor(faceColor);
        d.fillRectangle(xPivot + 9 * xfactor, yPivot - 9 * yfactor, 2 * xfactor, yfactor);
        d.fillRectangle(xPivot + 10 * xfactor, yPivot - 8 * yfactor, xfactor, yfactor);
        d.fillRectangle(xPivot - 2 * xfactor, yPivot - 11 * yfactor, 2 * xfactor, yfactor);
        d.fillRectangle(xPivot - xfactor, yPivot - 12 * yfactor, xfactor, yfactor);
        d.fillRectangle(xPivot - xfactor, yPivot - 15 * yfactor, 14 * xfactor, yfactor);
        d.fillRectangle(xPivot - 2 * xfactor, yPivot - 16 * yfactor, 16 * xfactor, yfactor);
        d.fillRectangle(xPivot - 3 * xfactor, yPivot - 17 * yfactor, 18 * xfactor, yfactor);
        d.fillRectangle(xPivot - 3 * xfactor, yPivot - 18 * yfactor, 2 * xfactor, yfactor);
        d.fillRectangle(xPivot + 3 * xfactor, yPivot - 18 * yfactor, 5 * xfactor, yfactor);
        d.fillRectangle(xPivot + 12 * xfactor, yPivot - 18 * yfactor, 3 * xfactor, yfactor);
        d.setColor(Color.DARK_GRAY);
        d.fillRectangle(xPivot - xfactor, yPivot - 18 * yfactor, 4 * xfactor, yfactor);
        d.fillRectangle(xPivot + 8 * xfactor, yPivot - 18 * yfactor, 4 * xfactor, yfactor);
        d.setColor(faceColor);
        d.fillRectangle(xPivot - 4 * xfactor, yPivot - 19 * yfactor, 2 * xfactor, yfactor);
        d.fillRectangle(xPivot - xfactor, yPivot - 19 * yfactor, 4 * xfactor, yfactor);
        d.fillRectangle(xPivot + 4 * xfactor, yPivot - 19 * yfactor, 3 * xfactor, yfactor);
        d.fillRectangle(xPivot + 8 * xfactor, yPivot - 19 * yfactor, 4 * xfactor, yfactor);
        d.fillRectangle(xPivot + 13 * xfactor, yPivot - 19 * yfactor, 3 * xfactor, yfactor);
        d.setColor(Color.DARK_GRAY);
        d.fillRectangle(xPivot - 2 * xfactor, yPivot - 19 * yfactor, xfactor, yfactor);
        d.fillRectangle(xPivot + 3 * xfactor, yPivot - 19 * yfactor, xfactor, yfactor);
        d.fillRectangle(xPivot + 7 * xfactor, yPivot - 19 * yfactor, xfactor, yfactor);
        d.fillRectangle(xPivot + 12 * xfactor, yPivot - 19 * yfactor, xfactor, yfactor);
    }

    /**
     * name: drawHarryPartTwo.
     * draws the second part of harry.
     * @param d the drawSurface
     */
    public void drawHarryPartTwo(DrawSurface d) {
        int xfactor = 10, yfactor = 10, xPivot = 615, yPivot = 550;
        Color faceColor = new Color(255, 219, 172);
        d.setColor(faceColor);
        d.fillRectangle(xPivot - 4 * xfactor, yPivot - 20 * yfactor, 2 * xfactor, yfactor);
        d.fillRectangle(xPivot - xfactor, yPivot - 20 * yfactor, 4 * xfactor, yfactor);
        d.fillRectangle(xPivot + 4 * xfactor, yPivot - 20 * yfactor, 3 * xfactor, yfactor);
        d.fillRectangle(xPivot + 8 * xfactor, yPivot - 20 * yfactor, 4 * xfactor, yfactor);
        d.fillRectangle(xPivot + 13 * xfactor, yPivot - 20 * yfactor, 3 * xfactor, yfactor);
        d.setColor(Color.DARK_GRAY);
        d.fillRectangle(xPivot - 2 * xfactor, yPivot - 20 * yfactor, xfactor, yfactor);
        d.fillRectangle(xPivot + 3 * xfactor, yPivot - 20 * yfactor, xfactor, yfactor);
        d.fillRectangle(xPivot + 7 * xfactor, yPivot - 20 * yfactor, xfactor, yfactor);
        d.fillRectangle(xPivot + 12 * xfactor, yPivot - 20 * yfactor, xfactor, yfactor);
        d.setColor(Color.BLACK);
        d.fillRectangle(xPivot, yPivot - 21 * yfactor, 2 * xfactor, 2 * yfactor);
        d.fillRectangle(xPivot + 9 * xfactor, yPivot - 21 * yfactor, 2 * xfactor, 2 * yfactor);
        d.fillRectangle(xPivot - 4 * xfactor, yPivot - 21 * yfactor, xfactor, yfactor);
        d.fillRectangle(xPivot - 4 * xfactor, yPivot - 21 * yfactor, 2 * xfactor, yfactor);
        d.fillRectangle(xPivot + 14 * xfactor, yPivot - 21 * yfactor, 2 * xfactor, yfactor);
        d.setColor(Color.DARK_GRAY);
        d.fillRectangle(xPivot - 3 * xfactor, yPivot - 21 * yfactor, 2 * xfactor, yfactor);
        d.fillRectangle(xPivot + 3 * xfactor, yPivot - 21 * yfactor, 5 * xfactor, yfactor);
        d.fillRectangle(xPivot + 12 * xfactor, yPivot - 21 * yfactor, 2 * xfactor, yfactor);
        d.setColor(faceColor);
        d.fillRectangle(xPivot - xfactor, yPivot - 21 * yfactor, xfactor, yfactor);
        d.fillRectangle(xPivot + 2 * xfactor, yPivot - 21 * yfactor, xfactor, yfactor);
        d.fillRectangle(xPivot + 8 * xfactor, yPivot - 21 * yfactor, xfactor, yfactor);
        d.fillRectangle(xPivot + 11 * xfactor, yPivot - 21 * yfactor, xfactor, yfactor);
        d.setColor(Color.DARK_GRAY);
        d.fillRectangle(xPivot - 2 * xfactor, yPivot - 22 * yfactor, xfactor, yfactor);
        d.fillRectangle(xPivot + 3 * xfactor, yPivot - 22 * yfactor, xfactor, yfactor);
        d.fillRectangle(xPivot + 7 * xfactor, yPivot - 22 * yfactor, xfactor, yfactor);
        d.fillRectangle(xPivot + 12 * xfactor, yPivot - 22 * yfactor, xfactor, yfactor);
        d.setColor(faceColor);
        d.fillRectangle(xPivot - xfactor, yPivot - 22 * yfactor, 4 * xfactor, yfactor);
        d.fillRectangle(xPivot + 4 * xfactor, yPivot - 22 * yfactor, 3 * xfactor, yfactor);
        d.fillRectangle(xPivot + 8 * xfactor, yPivot - 22 * yfactor, 4 * xfactor, yfactor);
        d.fillRectangle(xPivot + 13 * xfactor, yPivot - 22 * yfactor, xfactor, yfactor);
        d.setColor(Color.BLACK);
        d.fillRectangle(xPivot - 4 * xfactor, yPivot - 22 * yfactor, 2 * xfactor, yfactor);
        d.fillRectangle(xPivot + 14 * xfactor, yPivot - 22 * yfactor, 2 * xfactor, yfactor);
        d.fillRectangle(xPivot - 4 * xfactor, yPivot - 23 * yfactor, 3 * xfactor, yfactor);
        d.setColor(faceColor);
        d.fillRectangle(xPivot + 3 * xfactor, yPivot - 23 * yfactor, 5 * xfactor, yfactor);
        d.setColor(Color.BLACK);
        d.fillRectangle(xPivot + 12 * xfactor, yPivot - 23 * yfactor, 4 * xfactor, yfactor);
        d.setColor(Color.DARK_GRAY);
        d.fillRectangle(xPivot - xfactor, yPivot - 23 * yfactor, 4 * xfactor, yfactor);
        d.fillRectangle(xPivot + 8 * xfactor, yPivot - 23 * yfactor, 4 * xfactor, yfactor);
        d.setColor(Color.BLACK);
        d.fillRectangle(xPivot - 4 * xfactor, yPivot - 24 * yfactor, 20 * xfactor, yfactor);
        d.fillRectangle(xPivot - 4 * xfactor, yPivot - 25 * yfactor, 20 * xfactor, yfactor);
        d.fillRectangle(xPivot - 3 * xfactor, yPivot - 26 * yfactor, 19 * xfactor, yfactor);
        d.fillRectangle(xPivot - 3 * xfactor, yPivot - 27 * yfactor, 18 * xfactor, yfactor);
        d.fillRectangle(xPivot - xfactor, yPivot - 28 * yfactor, 16 * xfactor, yfactor);
        d.fillRectangle(xPivot - xfactor, yPivot - 29 * yfactor, 14 * xfactor, yfactor);
        d.setColor(faceColor);
        d.fillRectangle(xPivot + 2 * xfactor, yPivot - 24 * yfactor, 2 * xfactor, yfactor);
        d.setColor(Color.RED);
        d.fillRectangle(xPivot + 5 * xfactor, yPivot - 14 * yfactor, xfactor, yfactor);
        d.setColor(Color.YELLOW);
        d.fillRectangle(xPivot + 5 * xfactor, yPivot - 23 * yfactor, xfactor, 2 * yfactor);
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
        if (bolt.getX() < 200) {
            bolt.resetPosition();
        }
        bolt.moveOneStep("Left");
        bolt.drawOn(d);
    }

    @Override
    public boolean shouldStop() {
        return false;
    }
}
