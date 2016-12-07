package com.antviktorov;

/**
 * Paint class for pyramid building.
 * @author Anton Viktorov
 * @since 1.0
 */
public class Paint {
    /**
     * Build pyramid.
     * @param h - pyramid height
     * @return
     */
    public  String piramid(int h) {
        //Return emty string if height = 0
        if (h == 0) return "";
        //Return one height pyramid
        if (h == 1) return "^";

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