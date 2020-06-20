package other;

/**
 * @author Yair Koskas.
 * ID: 325699999
 * this class represents an integer counter
 */
public class Counter {
    private int num;

    /**
     * constructor.
     * @param num the starting number for the counter
     */
    public Counter(int num) {
        this.num = num;
    }

    /**
     * name: increase
     * add number to current count.
     *
     * @param number the number we increase
     */
    public void increase(int number) {
        this.num += number;
    }

    /**
     * name: decrease.
     * subtract number from current count.
     *
     * @param number the number we decrease from the conuter
     */
    public void decrease(int number) {
        this.num -= number;
    }

    /**
     * name: getValue.
     * get current count.
     *
     * @return the value of the counter
     */
    public int getValue() {
        return this.num;
    }
}