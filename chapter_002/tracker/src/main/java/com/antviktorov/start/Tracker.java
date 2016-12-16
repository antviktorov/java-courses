package com.antviktorov.start;

import com.antviktorov.models.*;

/**
 * Created by antonviktorov on 13.12.16.
 */
public class Tracker {
    public  Item[] items = new Item[3];
    public static void main(String[] args) {

        Tracker tracker = new Tracker();

        tracker.items[0] = new Item("Anton", "test",0);
        tracker.items[1] = new Task("Vasia", "Must be Pupkin");
        tracker.items[2] = new Bug();

        for (Item item : tracker.items) {
            if (item instanceof Task) {
                System.out.println(((Task) item).calculatePrice());
            }
            System.out.println(item.getName() + " " + item.getDescription());
        }
    }
}
