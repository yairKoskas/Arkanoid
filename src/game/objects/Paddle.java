package game.objects;

import biuoop.DrawSurface;
import biuoop.KeyboardSensor;
import game.levels.GameLevel;
import geometry.Point;
import geometry.Rectangle;
import geometry.Velocity;

import java.awt.Color;

/**
 * @author Yair Koskas
 * ID: 325699999
 * this class represents a paddle in the game
 */
public class Paddle implements Sprite, Collidable {
    private int paddleWidth;
    private final int blockWidth = 20;
    private final int guiXSize = 800;
    private final int paddleHeight = 20;
    private int speed;
    private KeyboardSensor keyboard;
    private Block block;

    /**
     * constructor.
     *
     * @param keyboard    the keyboard the paddle moves with
     * @param paddleWidth the width of the paddle
     * @param s           the speed of the paddle
     */
    public Paddle(KeyboardSensor keyboard, int paddleWidth, int s) {
        this.keyboard = keyboard;
        this.paddleWidth = paddleWidth;
        Rectangle r = new Rectangle(400, 560, paddleWidth, paddleHeight);
        this.block = new Block(r, Color.black);
        this.speed = s;
    }

    /**
     * name: moveLeft.
     * <p>
     * makes the paddle move left by 5 pixels
     * </p>
     */
    public void moveLeft() {
        double x = block.getColissionRectangle().getUpperLeft().getX();
        double y = block.getColissionRectangle().getUpperLeft().getY();
        //if the gui border have been crossed
        if (x < blockWidth) {
            return;
        }
        Point p = new Point(x - speed, y);
        Rectangle r = new Rectangle(p, block.getColissionRectangle().getWidth(),
                block.getColissionRectangle().getHeight());
        block.setRect(r);
    }

    /**
     * name: moveRight.
     * <p>
     * makes the paddle move right by 5 pixels
     * </p>
     */
    public void moveRight() {
        double x = block.getColissionRectangle().getUpperLeft().getX();
        double y = block.getColissionRectangle().getUpperLeft().getY();
        //if the gui border have been crossed
        if (x > guiXSize - paddleWidth - blockWidth) {
            return;
        }
        Point p = new Point(x + speed, y);
        Rectangle r = new Rectangle(p, block.getColissionRectangle().getWidth(),
                block.getColissionRectangle().getHeight());
        block.setRect(r);
    }

    // game.objects.Sprite


    @Override
    public void drawOn(DrawSurface d) {
        d.setColor(Color.red);
        double x = this.block.getColissionRectangle().getUpperLeft().getX();
        double y = this.block.getColissionRectangle().getUpperLeft().getY();
        double width = this.block.getColissionRectangle().getWidth();
        double height = this.block.getColissionRectangle().getHeight();
        d.fillRectangle((int) x, (int) y, (int) width, (int) height);
    }

    @Override
    public void timePassed() {
        if (keyboard.isPressed(keyboard.LEFT_KEY)) {
            moveLeft();
        }
        if (keyboard.isPressed(keyboard.RIGHT_KEY)) {
            moveRight();
        }
    }

    @Override
    public Rectangle getColissionRectangle() {
        return this.block.getColissionRectangle();
    }

    @Override
    public Velocity hit(Ball hitter, Point collisionPoint, Velocity currentVelocity) {
        //initializes the array of angles and the x coordinates
        double x1 = collisionPoint.getX();
        double x2 = this.block.getColissionRectangle().getUpperLeft().getX();
        int[] angles = new int[5];
        angles[0] = -120;
        angles[1] = -150;
        angles[2] = 0;
        angles[3] = 150;
        angles[4] = 120;
        double speedOfBall = currentVelocity.getSpeed();
        //if the x coordinate of the paddle relative to the x coordinate of the ball is in a certain area, return the
        //matching angle and speed to create velocity
        for (int i = 1; i <= 5; i++) {
            if ((i - 1) * paddleWidth / 5 < x1 - x2 && x1 - x2 < i * paddleWidth / 5) {
                Velocity v = Velocity.fromAngleAndSpeed(angles[i - 1], speedOfBall);
                if (i == 3) {
                    return this.block.hit(null, collisionPoint, currentVelocity);
                } else {
                    return this.block.hit(null, collisionPoint, v);
                }
            }
        }
        return this.block.hit(null, collisionPoint, currentVelocity);
    }

    /**
     * name: addToGame.
     *
     * @param g the game we add the sprite to
     */
    public void addToGame(GameLevel g) {
        g.addSprite(this);
        g.addCollidable(this);
    }
}