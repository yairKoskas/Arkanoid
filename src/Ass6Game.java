import game.levels.FourthLevel;
import game.levels.SecondLevel;
import game.levels.ThirdLevel;
import game.levels.FirstLevel;
import game.animations.AnimationRunner;
import biuoop.GUI;
import game.GameFlow;
import game.levels.LevelInformation;

import java.util.LinkedList;
import java.util.List;

/**
 * @author Yair koskas
 * ID: 325699999
 */
public class Ass6Game {

    /**
     * The main method, which operates the gameOperation.trying.Ass5Game class.
     *
     * @param args command line arguments.
     */
    public static void main(String[] args) {
        GUI gui = new GUI("Arkanoid", 800, 600);
        AnimationRunner runner = new AnimationRunner(gui, 60);
        GameFlow game = new GameFlow(runner.getGui().getKeyboardSensor(), runner);
        List<LevelInformation> levels = new LinkedList<>();
        levels.add(new FirstLevel());
        levels.add(new SecondLevel());
        levels.add(new ThirdLevel());
        levels.add(new FourthLevel());

        List<Integer> levelsFlow = new LinkedList<>();
        for (String str : args) {
            try {
                int num = Integer.parseInt(str);
                if (1 <= num && num <= levels.size()) {
                    levelsFlow.add(num);
                }
            } catch (Exception e) {
            }
        }
        if (levelsFlow.size() == 0) {
            levelsFlow.add(1);
            levelsFlow.add(2);
            levelsFlow.add(3);
            levelsFlow.add(4);
        }

        List<LevelInformation> currentGameLevels = new LinkedList<>();
        for (int levelNumber : levelsFlow) {
            switch (levelNumber) {
                case 1:
                    currentGameLevels.add(new FirstLevel());
                    break;
                case 2:
                    currentGameLevels.add(new SecondLevel());
                    break;
                case 3:
                    currentGameLevels.add(new ThirdLevel());
                    break;
                case 4:
                    currentGameLevels.add(new FourthLevel());
                    break;
                default:
                    break;
            }
        }
        game.runLevels(currentGameLevels);
    }
}
