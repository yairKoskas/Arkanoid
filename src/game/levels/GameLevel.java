package game.levels;

import biuoop.DrawSurface;
import biuoop.GUI;
import biuoop.KeyboardSensor;
import game.ScoreIndicator;
import game.animations.KeyPressStoppableAnimation;
import game.animations.Animation;
import game.animations.AnimationRunner;
import game.animations.PauseScreen;
import game.animations.CountdownAnimation;
import game.listeners.BallRemover;
import game.listeners.BlockRemover;
import game.listeners.ScoreTrackingListener;
import game.objects.Sprite;
import game.objects.SpriteCollection;
import game.objects.Collidable;
import game.objects.Paddle;
import game.objects.GameEnvironment;
import game.objects.Ball;
import game.objects.Block;
import geometry.Point;
import geometry.Rectangle;
import other.Counter;
import other.Text;

import java.awt.Color;

/**
 * @author Yair Koskas
 * ID: 325699999
 * this class represents the game, initializes it and runs it
 */
public class GameLevel implements Animation {
    private AnimationRunner runner;
    private KeyboardSensor keyboard;
    private boolean running;
    private final int width = 800;
    private final int height = 600;
    private LevelInformation l;
    private Counter numberOfBlocks;
    private Counter numberOfBalls;
    private BlockRemover b;
    private SpriteCollection sprites;
    private ScoreIndicator scoreIndicator;
    private Counter score;
    private GameEnvironment environment;
    private GUI gui;

    /**
     * constructor.
     *
     * @param l               the level information
     * @param animationRunner the animation runner
     * @param keyboardSensor  the keyboard
     * @param score           the score counter
     * @param gui             the gui of the level
     */
    public GameLevel(LevelInformation l, KeyboardSensor keyboardSensor, AnimationRunner animationRunner,
                     Counter score, GUI gui) {
        environment = new GameEnvironment();
        sprites = new SpriteCollection();
        runner = animationRunner;
        keyboard = keyboardSensor;
        this.score = score;
        this.gui = gui;
        this.l = l;
        numberOfBlocks = new Counter(l.blocks().size());
        numberOfBalls = new Counter(l.numberOfBalls());
    }

    /**
     * name: addCollidable.
     * <p>
     * adds a collidable object to the game environment
     * </p>
     *
     * @param c the collidable we add to the environment
     */
    public void addCollidable(Collidable c) {
        environment.addCollidable(c);
    }

    /**
     * name: addSprite.
     * <p>
     * adds a sprite object to the game
     * </p>
     *
     * @param s the sprite we add to the game
     */
    public void addSprite(Sprite s) {
        sprites.addSprite(s);
    }

    /**
     * accessor.
     *
     * @return the gui
     */
    public GUI getGui() {
        return gui;
    }

    /**
     * getter.
     * name: getEnvironment.
     *
     * @return the game environment of the game
     */
    public GameEnvironment getEnvironment() {
        return environment;
    }

    /**
     * name: initialize.
     * <p>
     * Initialize a new game: create the Blocks and game.objects.Ball (and game.objects.Paddle)
     * and add them to the game.
     * </p>
     */
    public void initialize() {
        l.getBackground().addToGame(this);
        scoreIndicator = new ScoreIndicator(score);
        b = new BlockRemover(this, numberOfBlocks);
        //initializes the GUI, the balls and creates the borders and the block patterns
        runner = new AnimationRunner(this.gui, 60);
        keyboard = gui.getKeyboardSensor();
        createBorders();
        createBlocks();
        Paddle paddle = new Paddle(this.keyboard, l.paddleWidth(), l.paddleSpeed());
        paddle.addToGame(this);
        int index = 0;
        for (Ball ball : l.initialBalls()) {
            ball.addToGame(this);
            ball.setVelocity(l.initialBallVelocities().get(index).getDx(),
                    l.initialBallVelocities().get(index).getDy());
            ball.setGameEnvironment(this.environment);
            index++;
        }
        scoreIndicator.addToGame(this);
        Text text = new Text(new Point(550, 15), "Level Name: " + this.l.levelName(), 20);
        text.addToGame(this);
    }

    /**
     * name: removeCollidable.
     *
     * @param c the collidable we remove from the game
     */
    public void removeCollidable(Collidable c) {
        this.environment.removeCollidable(c);
    }

    /**
     * name: removeSprite.
     *
     * @param s the sprite we remove from the game
     */
    public void removeSprite(Sprite s) {
        this.sprites.removeSprite(s);
    }

    /**
     * name: run.
     * <p>
     * makes the animation of the game
     * </p>
     */
    public void run() {
        this.running = true;
        this.runner.run(new CountdownAnimation(2, 3, this.sprites, Color.BLACK));
        // use our runner to run the current animation -- which is one turn of
        // the game.
        this.runner.run(this);
    }

    /**
     * name: createBorders.
     * <p>
     * creates the borders of the GUI
     * </p>
     */
    public void createBorders() {
        BallRemover ballR = new BallRemover(this, this.numberOfBalls);
        Rectangle r1 = new Rectangle(0, 0, 800, 20);
        Rectangle r2 = new Rectangle(0, 0, 20, 600);
        Rectangle r3 = new Rectangle(0, 580, 800, 20);
        Rectangle r4 = new Rectangle(780, 0, 20, 600);
        Block b1 = new Block(r1, Color.GRAY);
        Block b2 = new Block(r2, Color.GRAY);
        Block b3 = new Block(r3, Color.BLACK);
        Block b4 = new Block(r4, Color.GRAY);
        this.addCollidable(b1);
        this.addSprite(b1);
        this.addCollidable(b2);
        this.addSprite(b2);
        this.addCollidable(b3);
        this.addSprite(b3);
        b3.addHitListener(ballR);
        this.addCollidable(b4);
        this.addSprite(b4);
    }

    /**
     * name: createBlocks.
     * <p>
     * creates the block pattern of the GUI
     * </p>
     */
    public void createBlocks() {
        ScoreTrackingListener sTL = new ScoreTrackingListener(score);
        for (Block block : l.blocks()) {
            block.addHitListener(sTL);
            block.addHitListener(b);
            environment.addCollidable(block);
            sprites.addSprite(block);
        }
    }

    @Override
    public void doOneFrame(DrawSurface d) {
        sprites.drawAllOn(d);
        sprites.notifyAllTimePassed();
        for (Animation a : l.animations()) {
            a.doOneFrame(d);
        }
        if (numberOfBlocks.getValue() == 0) {
            this.scoreIndicator.getScoreCounter().increase(100);
            this.running = false;
        }
        if (numberOfBalls.getValue() == 0) {
            this.running = false;
        }
        if (this.gui.getKeyboardSensor().isPressed("p")) {
            this.runner.run(new KeyPressStoppableAnimation(KeyboardSensor.SPACE_KEY, this.gui.getKeyboardSensor(),
                    new PauseScreen(this.gui.getKeyboardSensor())));
            this.runner.run(new CountdownAnimation(2, 3, this.sprites, Color.BLACK));
        }
    }

    @Override
    public boolean shouldStop() {
        return !this.running;
    }

    /**
     * accessor.
     * name: getNumberOfBlocks.
     *
     * @return the number of blocks.
     */
    public int getNumberOfBlocks() {
        return numberOfBlocks.getValue();
    }

    /**
     * accessor.
     * name: getNumberOfBalls.
     *
     * @return the number of balls.
     */
    public int getNumberOfBalls() {
        return numberOfBalls.getValue();
    }

    /**
     * accessor.
     * name: getScore.
     * @return the score of the level
     */
    public Counter getScore() {
        return this.score;
    }

    /**
     * accessor.
     * name: getSprites.
     * @return the sprites of the level
     */
    public SpriteCollection getSprites() {
        return sprites;
    }
}