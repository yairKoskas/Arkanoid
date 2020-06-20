package geometry;

/**
 * @author Yair Koskas
 * ID: 325699999
 * this class represents geometry.Velocity, which has a dx and a dy quantity to allow movement
 */
public class Velocity {
    //fields
    private double dx;
    private double dy;

    /**
     * constructor.
     * <p>
     * constructs a velocity from given dx and dy
     * </p>
     *
     * @param dx the dx quantity
     * @param dy the dy quantity
     */
    public Velocity(double dx, double dy) {
        this.dx = dx;
        this.dy = dy;
    }

    /**
     * getter.
     * name: getDx.
     *
     * @return the dx field
     */
    public double getDx() {
        return this.dx;
    }

    /**
     * setter.
     * name: setDx.
     *
     * @param a the value to set dx to
     */
    public void setDx(double a) {
        this.dx = a;
    }

    /**
     * getter.
     * name: getDy.
     *
     * @return the dx field
     */
    public double getDy() {
        return dy;
    }

    /**
     * name: getSpeed.
     *
     * @return the speed of the ball
     */
    public double getSpeed() {
        double x = Math.pow(this.dx, 2);
        double y = Math.pow(this.dy, 2);
        return Math.sqrt(x + y);
    }

    /**
     * setter.
     * name: setDy.
     *
     * @param a the value to set dy to
     */
    public void setDy(double a) {
        this.dy = a;
    }

    /**
     * name: applyToPoint.
     *
     * @param p the point we apply the velocity to
     * @return the point after the application of the velocity
     */
    public Point applyToPoint(Point p) {
        return new Point(p.getX() + this.dx, p.getY() + this.dy);
    }

    /**
     * name: fromAngleAndSpeed.
     *
     * @param angle the angle of the velocity
     * @param speed the speed of the velocity
     * @return the geometry.Velocity represented by the angle and speed given, instead of dx and dy
     */
    public static Velocity fromAngleAndSpeed(double angle, double speed) {
        //calculates dx by the angle and speed by treating dx , dy and speed as a right triangle
        double x = speed * Math.sin(Math.toRadians(angle));
        double y = speed * -Math.cos(Math.toRadians(angle));
        return new Velocity(x, y);
    }
}
