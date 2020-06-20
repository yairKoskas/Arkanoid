package game;

import game.animations.AnimationRunner;
import game.animations.KeyPressStoppableAnimation;
import game.animations.LoseScreen;
import game.animations.WinScreen;
import biuoop.KeyboardSensor;
import game.levels.GameLevel;
import game.levels.LevelInformation;
import game.objects.SpriteCollection;
import other.Counter;

import java.awt.Color;
import java.util.List;

/**
 * @author Yair Koskas
 * ID: 325699999
 * this class represents the flow of the game, traversal between levels, winning and losing etc.
 */
public class GameFlow {
    private KeyboardSensor keyboardSensor;
    private AnimationRunner animationRunner;
    private Counter score;

    /**
     * constructor.
     *
     * @param keyboardSensor  the keyboard
     * @param animationRunner the animation runner of the game
     */
    public GameFlow(KeyboardSensor keyboardSensor, AnimationRunner animationRunner) {
        this.keyboardSensor = keyboardSensor;
        this.animationRunner = animationRunner;
        score = new Counter(0);
    }

    /**
     * name: runLevels.
     *
     * @param levels the levels of the game
     */
    public void runLevels(List<LevelInformation> levels) {
        boolean isWinning = true;
        SpriteCollection lastLevel = new SpriteCollection();
        for (LevelInformation levelInfo : levels) {
            GameLevel level = new GameLevel(levelInfo, this.keyboardSensor, this.animationRunner, score,
                    this.animationRunner.getGui());
            lastLevel = level.getSprites();
            level.initialize();
            while (level.getNumberOfBalls() > 0 && level.getNumberOfBlocks() > 0) {
                level.run();
            }
            if (level.getNumberOfBlocks() > 0 && level.getNumberOfBalls() == 0) {
                isWinning = false;
                break;
            }
            score = level.getScore();
        }
        if (isWinning) {
            this.animationRunner.run(new KeyPressStoppableAnimation(KeyboardSensor.SPACE_KEY, keyboardSensor,
                    new WinScreen(lastLevel, Color.WHITE, score.getValue())));
            this.animationRunner.getGui().close();
        } else {

            this.animationRunner.run(new KeyPressStoppableAnimation(KeyboardSensor.SPACE_KEY, keyboardSensor,
                    new LoseScreen(lastLevel, Color.WHITE, score.getValue())));
            this.animationRunner.getGui().close();
        }
    }
}