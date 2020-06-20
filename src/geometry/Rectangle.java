package geometry;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Yair Koskas
 * ID: 325699999
 * this class represents a rectangle
 */
public class Rectangle {
    //fields
    private Point upperLeft;
    private double width;
    private double height;

    /**
     * constructor.
     *
     * @param upperLeft the upper left point of the rectangle
     * @param width     the width of the rectangle
     * @param height    the height of the rectangle
     */
    public Rectangle(Point upperLeft, double width, double height) {
        this.upperLeft = upperLeft;
        this.width = width;
        this.height = height;
    }

    /**
     * constructor.
     * @param x the x coordinate of the upper left point
     * @param y the y coordinate of the upper left point
     * @param width the width of the rectangle
     * @param height the height of the rectangle
     */
    public Rectangle(double x, double y, double width, double height) {
        Point p = new Point(x, y);
        this.upperLeft = p;
        this.width = width;
        this.height = height;
    }

    /**
     * accessor.
     * name: getUpperLeft.
     * @return the upper left point
     */
    public Point getUpperLeft() {
        return upperLeft;
    }

    /**
     * accessor.
     * name: getWidth.
     * @return the width
     */
    public double getWidth() {
        return width;
    }

    /**
     * accessor.
     * name: getHeight.
     * @return the height
     */
    public double getHeight() {
        return height;
    }

    /**
     * name: intersectionPoints.
     *
     * @param line the line we check the intersection points for
     * @return the list of the intersection points
     */
    public List<Point> intersectionPoints(Line line) {
        List<Point> list = new ArrayList<>();
        /*
        upperLeft=p1
        upperRight=p4
        lowerLeft=p2
        lowerRight=p3
         */
        Point p1 = this.upperLeft;
        Point p2 = new Point(this.upperLeft.getX(), this.upperLeft.getY() + this.height);
        Point p3 = new Point(this.upperLeft.getX() + this.width, this.upperLeft.getY() + this.height);
        Point p4 = new Point(this.upperLeft.getX() + this.width, this.upperLeft.getY());
        /*
        upper line=line1
        left line=line2
        lower line=line3
        right line=line4
         */
        Line line1 = new Line(p1, p4);
        Line line2 = new Line(p1, p2);
        Line line3 = new Line(p2, p3);
        Line line4 = new Line(p4, p3);
        //adds all points of intersection if not already there (like corners are on 2 different lines)
        if (line1.isIntersecting(line)) {
            list.add(line1.intersectionWith(line));
        }
        if (line2.isIntersecting(line) && !list.contains(line2.intersectionWith(line))) {
            list.add(line2.intersectionWith(line));
        }
        if (line3.isIntersecting(line) && !list.contains(line3.intersectionWith(line))) {
            list.add(line3.intersectionWith(line));
        }
        if (line4.isIntersecting(line) && !list.contains(line4.intersectionWith(line))) {
            list.add(line4.intersectionWith(line));
        }
        return list;
    }
}
