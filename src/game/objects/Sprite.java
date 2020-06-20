package game.objects;

import biuoop.DrawSurface;
import game.levels.GameLevel;

/**
 * @author Yair Koskas
 * ID: 325699999
 * this interface represents a sprite which we can draw on the gui
 */
public interface Sprite {
    /**
     * name: drawOn.
     * draw the sprite to the screen
     * @param d the draw surface
      */
    void drawOn(DrawSurface d);

    /**
     * name: drawOn.
     * notify the sprite that time has passed
     */
    void timePassed();

    /**
     * nane: addToGame.
     * @param g the game we add the sprite to
     */
    void addToGame(GameLevel g);
}
