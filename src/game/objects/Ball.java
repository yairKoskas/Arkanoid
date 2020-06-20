package game.objects;

import biuoop.DrawSurface;
import game.levels.GameLevel;
import geometry.Line;
import geometry.Point;
import geometry.Rectangle;
import geometry.Velocity;

import java.awt.Color;

/**
 * @author Yair Koskas
 * ID: 325699999
 * this class represents a ball, which has radius, center point and a color
 */
public class Ball implements Sprite {
    //fields
    private Point center;
    private int r;
    private Color color;
    private GameEnvironment gameEnvironment;
    private Velocity v;

    /**
     * constructor.
     * <p>
     * creates a ball from a center point, a radius and a color
     * </p>
     *
     * @param center          the center of the ball
     * @param r               the radius of the ball
     * @param color           the color of the ball
     * @param gameEnvironment the game environment of the ball
     */
    public Ball(Point center, int r, Color color, GameEnvironment gameEnvironment) {
        this.center = center;
        this.r = r;
        this.color = color;
        this.gameEnvironment = gameEnvironment;
        this.v = new Velocity(0, 0);
    }

    /**
     * constructor.
     * <p>
     * creates a ball from a center point, a radius and a color
     * </p>
     *
     * @param center the center of the ball
     * @param r      the radius of the ball
     * @param color  the color of the ball
     */
    public Ball(Point center, int r, Color color) {
        this.center = center;
        this.r = r;
        this.color = color;
    }

    /**
     * constructor.
     * <p>
     * creates a ball from a center point, a radius and a color
     * </p>
     *
     * @param x     the x coordinate of the center
     * @param y     the y coordinate of the center
     * @param r     the radius of the ball
     * @param color the color of the ball
     */
    public Ball(double x, double y, int r, Color color) {
        this.center = new Point(x, y);
        this.r = r;
        this.color = color;
    }

    /**
     * accessor.
     * name: getX.
     *
     * @return returns the center's x coordinate
     */
    public int getX() {
        return (int) this.center.getX();
    }

    @Override
    public void timePassed() {
        moveOneStep();
    }

    @Override
    public void addToGame(GameLevel g) {
        g.addSprite(this);
    }

    /**
     * accessor.
     * name: getY.
     *
     * @return returns the center's y coordinate
     */
    public int getY() {
        return (int) this.center.getY();
    }

    /**
     * accessor.
     * name: getSize.
     *
     * @return the radius of the ball
     */
    public int getSize() {
        return this.r;
    }

    @Override
    public void drawOn(DrawSurface surface) {
        surface.setColor(this.color);
        surface.fillCircle(this.getX(), this.getY(), this.getSize());
        surface.setColor(Color.BLACK);
        surface.drawCircle(this.getX(), this.getY(), this.getSize());
    }

    /**
     * setter.
     * name: setVelocity.
     *
     * @param dx the dx quantity
     * @param dy the dy quantity
     */
    public void setVelocity(double dx, double dy) {
        this.v = new Velocity(dx, dy);
    }

    /**
     * setter.
     * name: setGameEnvironment.
     * @param g the game environment
     */
    public void setGameEnvironment(GameEnvironment g) {
        this.gameEnvironment = g;
    }

    /**
     * name:moveOneStep.
     * <p>
     * applies velocity to the ball
     * </p>
     */
    public void moveOneStep() {
        double error = Math.pow(10, -1);
        Point now = this.center;
        Point after = new Point(this.center.getX() + this.v.getDx(), this.center.getY() + this.v.getDy());
        Line trajectory = new Line(now, after);
        CollisionInfo cI = this.gameEnvironment.getClosestCollision(trajectory);
        if (cI == null) {
            this.center = this.v.applyToPoint(this.center);
        } else {
            Rectangle rect = cI.collisionObject().getColissionRectangle();
            /*
            upperLeft=p1
            upperRight=p4
            lowerLeft=p2
            lowerRight=p3
            */
            Point p1 = rect.getUpperLeft();
            Point p2 = new Point(rect.getUpperLeft().getX(),
                    rect.getUpperLeft().getY() + rect.getHeight());
            Point p3 = new Point(rect.getUpperLeft().getX() + rect.getWidth(),
                    rect.getUpperLeft().getY() + rect.getHeight());
            Point p4 = new Point(rect.getUpperLeft().getX() + rect.getWidth(),
                    rect.getUpperLeft().getY());
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
            //moving the ball really close to the collision point
            if (line1.isOnLine(cI.collisionPoint())) {
                this.center.setY(cI.collisionPoint().getY() - error - this.r);
            } else if (line2.isOnLine(cI.collisionPoint())) {
                this.center.setX(cI.collisionPoint().getX() - error - this.r);
            } else if (line3.isOnLine(cI.collisionPoint())) {
                this.center.setY(cI.collisionPoint().getY() + error + this.r);
            } else if (line4.isOnLine(cI.collisionPoint())) {
                this.center.setX(cI.collisionPoint().getX() + error + this.r);
            }
            this.v = cI.collisionObject().hit(this, cI.collisionPoint(), this.v);
        }
    }

    /**
     * name: removeFromGame.
     * @param gameLevel the gameLevel we remove the ball from
     */
    public void removeFromGame(GameLevel gameLevel) {
        gameLevel.removeSprite(this);
        this.r = 0;
    }
}