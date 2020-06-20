package game.objects;

import biuoop.DrawSurface;

import java.util.LinkedList;
import java.util.List;

/**
 * @author Yair Koskas
 * this class represents a collection of sprites
 */
public class SpriteCollection {
    private List<Sprite> list;

    /**
     * constructor.
     */
    public SpriteCollection() {
        this.list = new LinkedList<>();
    }

    /**
     * name: addSprite.
     *
     * @param s the sprite we add
     */
    public void addSprite(Sprite s) {
        this.list.add(s);
    }

    /**
     * name: notifyAllTimePassed.
     * call timePassed() on all sprites.
     */
    public void notifyAllTimePassed() {
        List<Sprite> newS = new LinkedList<>(this.list);
        for (Sprite s : newS) {
            s.timePassed();
        }
    }

    /**
     * name: drawAllOn.
     * call drawOn(d) on all sprites.
     *
     * @param d the drawing surface
     */
    public void drawAllOn(DrawSurface d) {
        List<Sprite> newS = new LinkedList<>(this.list);
        for (Sprite s : newS) {
            s.drawOn(d);
        }
    }

    /**
     * name: removeSprite.
     * @param s the sprite we remove
     */
    public void removeSprite(Sprite s) {
        this.list.remove(s);
    }
}
