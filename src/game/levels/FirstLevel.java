package game.levels;

import biuoop.DrawSurface;
import game.animations.Animation;
import game.objects.Ball;
import game.objects.Block;
import game.objects.Sprite;
import geometry.Velocity;
import geometry.Rectangle;
import geometry.Point;
import java.awt.Color;
import java.util.ArrayList;
import java.util.List;

/**
 * @author Yair Koskas
 * ID: 325699999
 * the first level of the game
 */
public class FirstLevel implements LevelInformation {
    private int numberOfBalls;
    private int paddleSpeed;
    private int paddleWidth;
    private String levelName;
    private Sprite background;
    private List<Block> blockList;
    private List<Velocity> velocityList;
    private List<Ball> ballList;
    private List<Animation> animations;

    /**
     * constructor.
     */
    public FirstLevel() {
        numberOfBalls = 1;
        animations = new ArrayList<>();
        background = new Sprite() {
            @Override
            public void drawOn(DrawSurface d) {
                d.setColor(Color.BLACK);
                d.fillRectangle(0, 0, 800, 600);
                d.setColor(Color.BLUE);
                d.drawLine(220, 225, 370, 225);
                d.drawLine(420, 225, 570, 225);
                d.drawLine(395, 50, 395, 250);
                d.drawLine(395, 200, 395, 400);
                d.drawCircle(395, 225, 100);
                d.drawCircle(395, 225, 150);
                d.drawCircle(395, 225, 50);
            }

            @Override
            public void timePassed() {
            }

            @Override
            public void addToGame(GameLevel g) {
                g.addSprite(this);
            }
        };
        velocityList = new ArrayList<>();
        velocityList.add(Velocity.fromAngleAndSpeed(180, -3));
        blockList = new ArrayList<>();
        blockList.add(new Block(new Rectangle(370, 200, 50, 50), Color.WHITE));
        ballList = new ArrayList<>();
        ballList.add(new Ball(new Point(395, 530), 10, Color.BLUE));
        paddleSpeed = 5;
        paddleWidth = 100;
        levelName = "Direct Hit";
    }

    @Override
    public int numberOfBalls() {
        return this.numberOfBalls;
    }
    @Override
    public List<Velocity> initialBallVelocities() {
        return this.velocityList;
    }

    @Override
    public int paddleSpeed() {
        return this.paddleSpeed;
    }

    @Override
    public int paddleWidth() {
        return this.paddleWidth;
    }

    @Override
    public String levelName() {
        return this.levelName;
    }

    @Override
    public Sprite getBackground() {
        return this.background;
    }

    @Override
    public List<Block> blocks() {
        return this.blockList;
    }

    @Override
    public int numberOfBlocksToRemove() {
        return this.blockList.size();
    }

    @Override
    public List<Ball> initialBalls() {
        return this.ballList;
    }

    @Override
    public List<Animation> animations() {
        return this.animations;
    }
}
