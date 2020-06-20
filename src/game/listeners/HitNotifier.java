package game.listeners;

/**
 *
 */
public interface HitNotifier {
    /**
     * name: addHitListener.
     * Add hl as a listener to hit events.
     * @param hl the hit listener we give to the function
     */
    void addHitListener(HitListener hl);
    /**
     * name: removeHitListener.
     * Remove hl from the list of listeners to hit events.
     * @param hl the hit listener we give to the function
     */
    void removeHitListener(HitListener hl);
}