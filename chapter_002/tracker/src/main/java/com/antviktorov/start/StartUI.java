package com.antviktorov.start;

import com.antviktorov.models.Item;
import com.antviktorov.models.Task;


/**
 * Application start point.
 * @author antonviktorov
 * @since 1.0
 */
public class StartUI {
    /**
     * Java CLI start point.
     * @param args - array of arguments provided in CLI
     */
    public static void main(String[] args) {
        Tracker tracker = new Tracker();
        tracker.add(new Task("First task", "first description"));
        tracker.add(new Task("Second task", "second description"));
        for (Item item : tracker.getItems()) {
            System.out.println(item.getName());
        }

        /*
        TODO remove this code or refactor if it's needed
        Tracker tracker = new Tracker();

        tracker.items[0] = new Item("Anton", "test",0);
        tracker.items[1] = new Task("Vasia", "Must be Pupkin");
        tracker.items[2] = new Bug();

        for (Item item : tracker.items) {
            if (item instanceof Task) {
                System.out.println(((Task) item).calculatePrice());
            }
            System.out.println(item.getName() + " " + item.getDescription());
        }*/
    }
}
