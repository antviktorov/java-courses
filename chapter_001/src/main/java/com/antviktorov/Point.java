package com.antviktorov;

/**
 * Vector point class.
 * @author Anton Viktorov
 * @since 1.0
 */
public class Point {
    /**
     * Point x.
     */
    public double x;
    /**
     * Point y.
     */
    public double y;

    /**
     * Point constructor.
     * @param x - x axis coordinate
     * @param y - y axis coordinate
     */
    public Point(double x, double y) {
        this.x = x;
        this.y = y;
    }

    /**
     * Distance to the point.
     * @param point - provided point
     * @return distance
     */
    public double distanceTo(Point point) {
        return Math.sqrt(Math.pow(point.x - this.x, 2) + Math.pow(point.y - this.y, 2));
    }
}