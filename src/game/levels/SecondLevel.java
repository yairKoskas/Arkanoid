package game.levels;

import game.animations.Animation;
import game.objects.Ball;
import game.objects.Block;
import game.objects.Sprite;
import geometry.Velocity;

import java.awt.Color;
import java.util.ArrayList;
import java.util.List;

/**
 * @author Yair Koskas.
 * ID: 325699999
 * the second level of the game
 */
public class SecondLevel implements LevelInformation {
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
    public SecondLevel() {
        final int ballSpeed = 4;
        numberOfBalls = 10;
        background = new HarryPotter();
        animations = new ArrayList<>();
        animations.add(new HarryPotter());
        animations.add(new Voldemort());
        velocityList = new ArrayList<>();
        velocityList.add(Velocity.fromAngleAndSpeed(50, ballSpeed));
        velocityList.add(Velocity.fromAngleAndSpeed(40, ballSpeed));
        velocityList.add(Velocity.fromAngleAndSpeed(30, ballSpeed));
        velocityList.add(Velocity.fromAngleAndSpeed(20, ballSpeed));
        velocityList.add(Velocity.fromAngleAndSpeed(10, ballSpeed));
        velocityList.add(Velocity.fromAngleAndSpeed(-10, ballSpeed));
        velocityList.add(Velocity.fromAngleAndSpeed(-20, ballSpeed));
        velocityList.add(Velocity.fromAngleAndSpeed(-30, ballSpeed));
        velocityList.add(Velocity.fromAngleAndSpeed(-40, ballSpeed));
        velocityList.add(Velocity.fromAngleAndSpeed(-50, ballSpeed));
        blockList = new ArrayList<>();
        paddleWidth = 300;
        Color[] colors = {Color.BLACK, Color.RED, Color.WHITE, Color.GREEN, Color.YELLOW, Color.MAGENTA};
        for (int i = 0; i < 19; i++) {
            blockList.add(new Block(new geometry.Rectangle(20 + 40 * i, 200, 40, 20),
                    colors[i % colors.length]));
        }
        ballList = new ArrayList<>();
        ballList.add(new Ball(new geometry.Point(395, 530), 8, Color.WHITE));
        ballList.add(new Ball(new geometry.Point(395, 530), 8, Color.WHITE));
        ballList.add(new Ball(new geometry.Point(395, 530), 8, Color.WHITE));
        ballList.add(new Ball(new geometry.Point(395, 530), 8, Color.WHITE));
        ballList.add(new Ball(new geometry.Point(395, 530), 8, Color.WHITE));
        ballList.add(new Ball(new geometry.Point(395, 530), 8, Color.WHITE));
        ballList.add(new Ball(new geometry.Point(395, 530), 8, Color.WHITE));
        ballList.add(new Ball(new geometry.Point(395, 530), 8, Color.WHITE));
        ballList.add(new Ball(new geometry.Point(395, 530), 8, Color.WHITE));
        ballList.add(new Ball(new geometry.Point(395, 530), 8, Color.WHITE));
        paddleSpeed = 5;
        levelName = "Wide Easy";
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
