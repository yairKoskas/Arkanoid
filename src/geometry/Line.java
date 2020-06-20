package geometry;

import java.util.List;

/**
 * @author Yair Koskas
 * ID: 325699999
 * represents a line segment implemented with two points
 */
public class Line {
    //fields
    private Point start;
    private Point end;

    /**
     * constructor.
     * <p>
     * creates a line from two points
     * </p>
     *
     * @param start the starting point
     * @param end   the end point
     */
    public Line(Point start, Point end) {
        this.start = start;
        this.end = end;
    }

    /**
     * constructor.
     * <p>
     * creates a line from four points.
     * </p>
     *
     * @param x1 x coordinate for the start field
     * @param y1 y coordinate for the start field
     * @param x2 x coordinate for the end field
     * @param y2 y coordinate for the end field
     */
    public Line(double x1, double y1, double x2, double y2) {
        this.start = new Point(x1, y1);
        this.end = new Point(x2, y2);
    }

    /**
     * name: length.
     * <p>
     * returns the length of the line by calculating
     * the (*)distance between the start and the end
     * </p>
     * (*) {@link Point#distance(Point)}
     *
     * @return length of the line
     */
    public double length() {
        return start.distance(end);
    }

    /**
     * name: middle.
     * <p>
     * returns the middle point of the line.
     * </p>
     *
     * @return the middle point.
     */
    public Point middle() {
        double x = (this.start.getX() + this.end.getX()) / 2;
        double y = (this.start.getY() + this.end.getY()) / 2;
        return new Point(x, y);
    }

    /**
     * accessor.
     * name: start.
     * <p>
     * getter function for the start field
     * </p>
     *
     * @return the start field
     */
    public Point start() {
        return this.start;
    }

    /**
     * accessor.
     * name: end.
     * <p>
     * getter function for the end field
     * </p>
     *
     * @return the end field
     */
    public Point end() {
        return this.end;
    }

    /**
     * name: isIntersecting.
     *
     * @param other other line we check if is intersecting this line
     * @return returns true if the lines are intersecting, false otherwise
     */
    public boolean isIntersecting(Line other) {
        if (other == null) {
            return false;
        }
        if (this.intersectionWith(other) == null) {
            return false;
        }
        return true;
    }

    /**
     * name: intersectionWith.
     * <p>
     * the function returns the point of intersection between this and the other line
     * if it exists, otherwise returns null
     * </p>
     *
     * @param other the line we calculate the point of intersection with
     * @return the point of intersection or null
     */
    public Point intersectionWith(Line other) {
        //if one of them is a point on the other line
        if (this.isPoint() && other.isOnLine(this.start)) {
            return this.start;
        }
        if (other.isPoint() && this.isOnLine(other.start)) {
            return other.start;
        }
        //if both are straight
        if (this.isStraight() && other.isStraight()) {
            //if they "made" it to this check, neither of them are points, so if they both are the same "x=a"
            //line they have at least 2 points of intersection(actually infinity).
            return null;
        } else if (this.isStraight() && !other.isStraight()) { //if this is straight and the other isn't
            double slope = other.slope();
            double x0 = other.start.getX();
            double y0 = other.start.getY();
            double x = this.start.getX();
            //y=slope*(x-x0)+y0
            double y = slope * (x - x0) + y0;
            Point p = new Point(x, y);
            if (this.isOnLine(p) && other.isOnLine(p)) {
                return p;
            }
            return null;
        } else if (!this.isStraight() && other.isStraight()) { // if this isn't straight and the other is
            //sets the slope,x0,y0,x variables accordingly
            double slope = this.slope();
            double x0 = this.start.getX();
            double y0 = this.start.getY();
            double x = other.start.getX();
            //y=slope*(x-x0)+y0
            double y = slope * (x - x0) + y0;
            Point p = new Point(x, y);
            //if the point we found is on both lines, return it
            if (this.isOnLine(p) && other.isOnLine(p)) {
                return p;
            }
            //return null otherwise
            return null;
        } else { //if both of them aren't straight
            double error = Math.pow(10, -10);
            //if their slopes are equal
            if (Math.abs(this.slope() - other.slope()) < error) {
                //we check if they have the same slope, and just barely touching, like (1, 1, 2, 2) , (2, 2, 3, 3)
                //creates an array which stores the start and end points of the lines
                Point[] arr = new Point[4];
                arr[0] = this.start;
                arr[1] = this.end;
                arr[2] = other.start;
                arr[3] = other.end;
                //sets min to be the minimun distance between two points in the array
                double min = closestPoints(arr);
                //if min isn't zero, that means they are contained in on another
                if (min != 0) {
                    return null;
                } else if ((this.isOnLine(other.start) && this.isOnLine(other.end))
                        || (other.isOnLine(this.start) && other.isOnLine(this.end))) {
                    //if it's zero, we check if one is an extention of the other, if it is, return null.
                    return null;
                } else {
                    //if we reached this point the lines have only one point in common, we find it by checking
                    //every possible coordinate this point can have, which are only two because one pair of points
                    //is equal
                    if (this.start.equals(other.start)) {
                        return this.start;
                    } else if (this.start.equals(other.end)) {
                        return this.start;
                    } else if (this.end.equals(other.start)) {
                        return this.end;
                    } else if (this.end.equals(other.end)) {
                        return this.end;
                    } else { //if we didn't find anything
                        return null;
                    }
                }
            } else { //if both of them aren't straight and don't have the same slope
                //sets the variables which allow us to calculate the intersection point
                double slopeThis = this.slope();
                double slopeOther = other.slope();
                double x0 = this.start.getX();
                double y0 = this.start.getY();
                double x1 = other.start.getX();
                double y1 = other.start.getY();
                //y=slopeThis*(x-x0)+y0
                //y=slopeOther*(x-x1)+y1
                //y=slopeThis*x - slopeThis*x0 + y0
                //y=slopeOther*x - slopeOther*x1 +y1
                //x*(slopeThis-slopeOther)=slopeOther*x1+y1-slopeThis*x0+y0
                //x = (slopeThis * x0 - y0 - slopeOther * x1 + y1) / (slopeThis - slopeOther);
                double x = (slopeThis * x0 - y0 - slopeOther * x1 + y1) / (slopeThis - slopeOther);
                double y = slopeThis * x - slopeThis * x0 + y0;
                Point p = new Point(x, y);
                //if the point we found is on the two lines, return it, otherwise return null
                if (this.isOnLine(p) && other.isOnLine(p)) {
                    return p;
                }
                return null;
            }
        }
    }

    /**
     * name: equals.
     * <p>
     * this function checks if this line is equal to the other line
     * </p>
     *
     * @param other the other line we compare to
     * @return true if they are equal, false otherwise
     */
    public boolean equals(Line other) {
        if (other == null) {
            return false;
        }
        if (this.start.equals(other.start) && this.end.equals(other.end)) {
            return true;
        } else if (this.end.equals(other.start) && this.start.equals(other.end)) {
            return true;
        }
        return false;
    }

    /**
     * name: slope.
     * <p>
     * this function calculates the slope of the line and returns it
     * we don't use this function on straight lines
     * </p>
     *
     * @return the slope of the line
     */
    private double slope() {
        double x1 = this.start.getX();
        double x2 = this.end.getX();
        double y1 = this.start.getY();
        double y2 = this.end.getY();
        return (y2 - y1) / (x2 - x1);
    }

    /**
     * name: isStraight.
     * <p>
     * checks if a line is straight (parallel to the y axis)
     * </p>
     *
     * @return true if the line is straight parallel to the y axis), false otherwise
     */
    private boolean isStraight() {
        double error = Math.pow(10, -10);
        //if the x coordinates are equal
        if (Math.abs(this.start.getX() - this.end.getX()) < error) {
            return true;
        }
        return false;
    }

    /**
     * name: isPoint.
     * <p>
     * checks if a line is a point, which happens if start is equal to end.
     * </p>
     *
     * @return true if the line is a point, false otherwise
     */
    public boolean isPoint() {
        if (this.start.equals(this.end)) {
            return true;
        }
        return false;
    }

    /**
     * name: isOnLine.
     * <p>
     * checks if a given point is on this line
     * </p>
     *
     * @param p the point we check
     * @return true if p is on this line, false otherwise
     */
    public boolean isOnLine(Point p) {
        if (this.start.equals(p) || this.end.equals(p)) {
            return true;
        }
        if (this.isStraight()) { //if this line is straight
            double error = Math.pow(10, -10);
            double y = p.getY();
            //if the y coordinate is in the range of the line and the x coordinate is equal
            if (Math.abs(p.getX() - this.start.getX()) < error && y < Math.max(this.start.getY(), this.end.getY())
                    && y > Math.min(this.start.getY(), this.end.getY())) {
                return true;
            }
            return false;
        } else { //if the line's not straight
            double slope = this.slope();
            double x0 = this.start.getX();
            double y0 = this.start.getY();
            //y=slope*(x-x0)+y0
            double x = p.getX();
            double y = slope * (x - x0) + y0;
            //if the y coordinate we found isn't in the range of the line, return false
            if (y > Math.max(this.start.getY(), this.end.getY()) || y < Math.min(this.start.getY(), this.end.getY())) {
                return false;
            }
            //if the x coordinate we found isn't in the range of the line, return false
            if (x > Math.max(this.start.getX(), this.end.getX()) || x < Math.min(this.start.getX(), this.end.getX())) {
                return false;
            }
            Point p2 = new Point(x, y);
            //if the point we found from the x vakue is equal to the given one, return true
            if (p.equals(p2)) {
                return true;
            }
            return false;
        }
    }

    /**
     * name: closestPoints.
     * <p>
     * returns the length of the two closest points in an array
     * </p>
     *
     * @param arr array of points we check
     * @return the length of the two closest points in an array
     */
    public static double closestPoints(Point[] arr) {
        double min = Double.MAX_VALUE;
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr.length; j++) {
                //if we found a closer pair of points, put their distance in min
                if (arr[i].distance(arr[j]) < min) {
                    min = arr[i].distance(arr[j]);
                }
            }
        }
        return min;
    }

    /**
     * name: closestIntersectionToStartOfLine.
     *
     * @param rect the rectangle we check the intersection with
     * @return the closest point of intersection
     */
    public Point closestIntersectionToStartOfLine(Rectangle rect) {
        List<Point> list = rect.intersectionPoints(this);
        Point minP = new Point(0, 0);
        double min = Double.MAX_VALUE;
        for (Point p : list) {
            if (this.start.distance(p) < min) {
                minP = p;
                min = this.start.distance(p);
            }
        }
        return minP;
    }
}