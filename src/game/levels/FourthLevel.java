package game.levels;

import biuoop.DrawSurface;
import game.animations.Animation;
import game.objects.Ball;
import game.objects.Block;
import game.objects.Sprite;
import geometry.Point;
import geometry.Rectangle;
import geometry.Velocity;

import java.awt.*;
import java.util.ArrayList;
import java.util.List;

/**
 * @author Yair Koskas
 * ID: 325699999
 * the fourth level of the game
 */
public class FourthLevel implements LevelInformation {
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
    public FourthLevel() {
        numberOfBalls = 3;
        paddleSpeed = 5;
        paddleWidth = 80;
        background = new Sprite() {
            @Override
            public void drawOn(DrawSurface d) {
                for (int i = 600; i >= 0; i -= 30) {
                    if (i % 60 == 0) {
                        d.setColor(Color.BLACK);
                    } else {
                        d.setColor(Color.WHITE);
                    }
                    d.fillCircle(400, 300, i);
                }

            }

            @Override
            public void timePassed() {

            }

            @Override
            public void addToGame(GameLevel g) {
                g.addSprite(this);
            }
        };
        final int ballSpeed = 3;
        animations = new ArrayList<>();
        levelName = "Final Four";
        blockList = new ArrayList<>();
        createBlocks(blockList);
        velocityList = new ArrayList<>();
        velocityList.add(Velocity.fromAngleAndSpeed(60, ballSpeed));
        velocityList.add(Velocity.fromAngleAndSpeed(-60, ballSpeed));
        velocityList.add(Velocity.fromAngleAndSpeed(180, -ballSpeed));
        ballList = new ArrayList<>();
        ballList.add(new Ball(new geometry.Point(395, 530), 8, Color.RED));
        ballList.add(new Ball(new geometry.Point(395, 530), 8, Color.RED));
        ballList.add(new Ball(new geometry.Point(395, 530), 8, Color.RED));
    }

    @Override
    public int numberOfBalls() {
        return this.ballList.size();
    }

    @Override
    public List<Velocity> initialBallVelocities() {
        return this.velocityList;
    }

    @Override
    public List<Ball> initialBalls() {
        return this.ballList;
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
    public List<Animation> animations() {
        return this.animations;
    }

    /**
     * name: createBlocks.
     * creates the block pattern of the level.
     *
     * @param b the list of blocks.
     */
    public void createBlocks(List<Block> b) {
        int levelCounter = 0;
        int index = 0;
        final int blockWidth = 40;
        final int blockHeight = 20;
        Color[] colors = new Color[6];
        colors[0] = Color.RED;
        colors[1] = Color.PINK;
        colors[2] = Color.YELLOW;
        colors[3] = Color.CYAN;
        colors[4] = Color.GREEN;
        colors[5] = Color.MAGENTA;
        //starting point for the upper left block
        Point p = new Point(20, 200);
        for (int y = 0; y < 6; y++) {
            for (int x = 0; x < 19; x++) {
                //this adds blocks in the horizontal direction
                Rectangle rect = new Rectangle(p.getX() + x * blockWidth, p.getY() + y * blockHeight,
                        blockWidth, blockHeight);
                Block block = new Block(rect, colors[y]);
                b.add(block);
                //the check that 1 decreases in every line
            }
            levelCounter++;
        }
    }
}
