package com.antviktorov.strategy;

/**
 * Triangle implementation class.
 */
public class Trianlge implements Shape {
    /**
     * Prepare char string.
     * @return shape as string
     */
    public String pic() {
        int h = 3;
        int level = h;
        StringBuilder builder = new StringBuilder();

        while (level > 0) {
            //Fill with spaces before ^
            for (int i = 1; i <= level - 1; i++) {
                builder.append(" ");
            }
            //Fill with ^ after spaces
            for (int i = 1; i <= h - level + 1; i++) {
                builder.append("^");
            }
            level--;
            builder.append(System.getProperty("line.separator"));
        }

        return builder.toString();
    }
}
