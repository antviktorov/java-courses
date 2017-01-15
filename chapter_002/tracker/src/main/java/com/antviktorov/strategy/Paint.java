package com.antviktorov.strategy;

/**
 * Paint class.
 */
public class Paint {
    /**
     * Drawing shapes.
     * @param shape - provided shape
     * @return shape as String
     */
    public String draw(Shape shape) {
        String shapeStr = shape.pic();
        System.out.println(shapeStr);
        return shapeStr;
    }
}