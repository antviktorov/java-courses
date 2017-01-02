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
    private double x;
    /**
     * Point y.
     */
    private double y;

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
        return Math.sqrt(Math.pow(point.getX() - this.x, 2) + Math.pow(point.getY() - this.y, 2));
    }

    /**
     * Get x value.
     * @return value
     */
    public double getX() {
        return this.x;
    }

    /**
     * Get y value.
     * @return value
     */
    public double getY() {
        return this.y;
    }
}