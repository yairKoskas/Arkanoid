package game.objects;

import biuoop.DrawSurface;
import game.levels.GameLevel;
import game.listeners.HitListener;
import game.listeners.HitNotifier;
import geometry.Line;
import geometry.Point;
import geometry.Rectangle;
import geometry.Velocity;

import java.awt.Color;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * @author Yair Koskas
 * ID: 325699999
 * this class represents a collidable block
 */
public class Block implements Collidable, Sprite, HitNotifier {
    //fields
    private List<HitListener> hitListeners;
    private Rectangle rect;
    private Color color;

    /**
     * constructor.
     *
     * @param rect  the rectangle of the block
     * @param color the color of the block
     */
    public Block(Rectangle rect, Color color) {
        this.rect = rect;
        this.color = color;
        this.hitListeners = new LinkedList<>();
    }

    @Override
    public Rectangle getColissionRectangle() {
        return this.rect;
    }

    /**
     * name: setRect.
     *
     * @param r the rectangle we change the rect field to
     */
    public void setRect(Rectangle r) {
        this.rect = r;
    }

    @Override
    public Velocity hit(Ball hitter, Point collisionPoint, Velocity currentVelocity) {
        /*
        upperLeft=p1
        upperRight=p4
        lowerLeft=p2
        lowerRight=p3
         */
        Point p1 = this.rect.getUpperLeft();
        Point p2 = new Point(this.rect.getUpperLeft().getX(),
                this.rect.getUpperLeft().getY() + this.rect.getHeight());
        Point p3 = new Point(this.rect.getUpperLeft().getX() + this.rect.getWidth(),
                this.rect.getUpperLeft().getY() + this.rect.getHeight());
        Point p4 = new Point(this.rect.getUpperLeft().getX() + this.rect.getWidth(),
                this.rect.getUpperLeft().getY());
        /*
        upper line=line1
        left line=line2
        lower line=line3
        right line=line4
         */
        Line line1 = new Line(p1, p4);
        Line line2 = new Line(p1, p2);
        Line line3 = new Line(p2, p3);
        Line line4 = new Line(p4, p3);
        //if it's on a horizontal line, change the sign of dc
        if (line4.isOnLine(collisionPoint) || line2.isOnLine(collisionPoint)) {
            this.notifyHit(hitter);
            return new Velocity(-currentVelocity.getDx(), currentVelocity.getDy());
        }
        //if it's on a horizontal line, change the sign of dy
        if (line1.isOnLine(collisionPoint) || line3.isOnLine(collisionPoint)) {
            this.notifyHit(hitter);
            return new Velocity(currentVelocity.getDx(), -currentVelocity.getDy());
        }
        this.notifyHit(hitter);
        return null;
    }

    @Override
    public void addToGame(GameLevel g) {
        g.addCollidable(this);
        g.addSprite(this);
    }

    @Override
    public void timePassed() {
    }

    /**
     * name: drawOn.
     * <p>
     * draws the board onto the given drawSurface
     * </p>
     *
     * @param d drawing surface
     */
    public void drawOn(DrawSurface d) {
        //fills the block and creates a black border around it
        d.setColor(this.color);
        d.fillRectangle((int) this.rect.getUpperLeft().getX(), (int) this.rect.getUpperLeft().getY(),
                (int) this.rect.getWidth(), (int) this.rect.getHeight());
        d.setColor(Color.BLACK);
        d.drawRectangle((int) this.rect.getUpperLeft().getX(), (int) this.rect.getUpperLeft().getY(),
                (int) this.rect.getWidth(), (int) this.rect.getHeight());
    }

    /**
     * name: removeFromGame.
     *
     * @param gameLevel the gameLevel we remove the block from
     */
    public void removeFromGame(GameLevel gameLevel) {
        gameLevel.removeSprite(this);
        gameLevel.removeCollidable(this);
    }

    @Override
    public void addHitListener(HitListener hl) {
        this.hitListeners.add(hl);
    }

    @Override
    public void removeHitListener(HitListener hl) {
        this.hitListeners.remove(hl);
    }

    /**
     * name: notifyHit.
     * @param hitter the ball we notify hitting us
     */
    private void notifyHit(Ball hitter) {
        // Make a copy of the hitListeners before iterating over them.
        List<HitListener> listeners = new ArrayList<>(this.hitListeners);
        // Notify all listeners about a hit event:
        for (HitListener hl : listeners) {
            hl.hitEvent(this, hitter);
        }
    }
}