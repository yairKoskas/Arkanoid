package geometry;

/**
 * @author Yair Koskas
 * ID: 325699999
 * represents a point in space
 */
public class Point {
    //fields
    private double x;
    private double y;

    /**
     * constructor.
     * <p>
     *     Creates a new point by the given x and y coordinates.
     * </p>
     * @param x1 sets the x field of geometry.Point
     * @param y1 sets the x field of geometry.Point
     */
    public Point(double x1, double y1) {
        this.x = x1;
        this.y = y1;
    }
    /**
     * name: distance.
     * <p>
     *     this function returns the distance from this to the one given.
     * </p>
     * @param other the other point we measure the distance to
     * @return the distance between this point and the given one
     */
    public double distance(Point other) {
        //calculates sqrt((x1-x0)^2+(y1-y0)^2) and returns it
        double x1 = Math.pow(this.x - other.getX(), 2);
        double y1 = Math.pow(this.y - other.getY(), 2);
        return Math.sqrt(x1 + y1);
    }

    /**
     * name: equals
     * <p>
     *     this function checks if the given point is equal to this one.
     * </p>
     * @param other the point we compare to
     * @return if the two points are equal
     */
    public boolean equals(Point other) {
        double error = Math.pow(10, -10);
        if (other == null) {
            return false;
        }
        //if the difference between the two coordinates is smaller than error, we can call them equal
        if (Math.abs(this.getX() - other.getX()) < error && Math.abs(this.getY() - other.getY()) < error) {
            return true;
        }
        return false;

    }

    /**
     * accessor.
     * name: getX
     * <p>
     *     getter function for x.
     * </p>
     * @return the x field.
     */
    public double getX() {
        return this.x;
    }

    /**
     * accessor.
     * name: getY
     * <p>
     *      getter function for y.
     * </p>
     * @return the y field.
     */
    public double getY() {
        return this.y;
    }

    /**
     * name: setX.
     * setter.
     * @param a the value we set X to
     */
    public void setX(double a) {
        this.x = a;
    }
    /**
     * name: setY.
     * setter.
     * @param a the value we set Y to
     */
    public void setY(double a) {
        this.y = a;
    }
}