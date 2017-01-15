package com.antviktorov.strategy;

/**
 * Square implementation class.
 */
public class Square implements Shape {
    /**
     * Prepare char string.
     * @return shape as string
     */
    public String pic() {
        int h = 5;
        int level = h;
        StringBuilder builder = new StringBuilder();

        while (level > 0) {
            for (int i = 1; i <= h; i++) {
                builder.append("^");
            }
            level--;
            builder.append(System.getProperty("line.separator"));
        }

        return builder.toString();
    }
}
