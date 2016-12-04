package com.antviktorov;

/**
 * Triangle class.
 * @author Anton Viktorov
 * @since 1.0
 */
public class Triangle {
    /**
     * Point A
     */
    public Point a;
    /**
     * Point B
     */
    public Point b;
    /**
     *
     */
    public Point c;

    /**
     * Triangle constructor.
     * @param a - first point
     * @param b - second point
     * @param c - third point
     */
    public Triangle(Point a, Point b, Point c) {
        this.a = a;
        this.b = b;
        this.c = c;
    }

    /**
     * Get square of triangle.
     * @return square
     */
    public double area() {
        //Calculate sides length
        double sideA = this.a.distanceTo(this.b);
        double sideB = this.b.distanceTo(this.c);
        double sideC = this.c.distanceTo(this.a);

        //Half of perimeter for Geron's formula
        double halfPerimeter = (sideA + sideB + sideC) * 0.5;

        //Calculation by Gerons's formula
        return Math.sqrt(halfPerimeter * (halfPerimeter - sideA) * (halfPerimeter - sideB) * (halfPerimeter - sideC));
    }
}