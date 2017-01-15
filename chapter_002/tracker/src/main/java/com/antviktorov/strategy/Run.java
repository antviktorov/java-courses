package com.antviktorov.strategy;

/**
 * Base run class.
 */
public class Run {
    /**
     * Java CLI start point.
     * @param args - array of arguments provided in CLI
     */
    public static void main(String[] args) {
        Paint paint = new Paint();
        paint.draw(new Trianlge());
        paint.draw(new Square());
    }
}
