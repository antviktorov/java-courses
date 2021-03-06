package com.antviktorov.menu;

import java.util.Arrays;

import com.antviktorov.filters.Filter;
import com.antviktorov.filters.IdFIlter;
import com.antviktorov.filters.NameFilter;
import com.antviktorov.filters.TimestampFilter;
import com.antviktorov.models.Item;
import com.antviktorov.start.Input;
import com.antviktorov.start.Tracker;
import com.antviktorov.models.Task;


/**
 * Edit item class.
 * @author antonviktorov
 * @since 1.0
 */
class EditItem extends BaseAction implements UserAction {
    /**
     * Edit item constructor.
     */
    EditItem() {
        super("Edit task");
    }
    /**
     * Get action key.
     * @return key
     */
    public int key() {
        return 2;
    }
    /**
     * Execute action.
     * @param input - input flow
     * @param tracker - tracker entity
     */
    public void execute(Input input, Tracker tracker) {
        String id = input.ask("Please input task id: ");
        String name = input.ask("Please enter task name:");
        String description = input.ask("Please enter task description:");
        Item task = new Task(name, description);
        task.setId(id);
        tracker.update(task);
    }
}

/**
 * Delete item class.
 * @author antonviktorov
 * @since 1.0
 */
class DeleteItem extends BaseAction implements UserAction {
    /**
     * Delete item constructor.
     */
    DeleteItem() {
        super("Delete item");
    }
    /**
     * Get action key.
     * @return key
     */
    public int key() {
        return 3;
    }
    /**
     * Execute action.
     * @param input - input flow
     * @param tracker - tracker entity
     */
    public void execute(Input input, Tracker tracker) {
        String id = input.ask("Please input task id: ");
        Item item = tracker.findById(id);
        tracker.delete(item);
    }
}

/**
 * Find by id item class.
 * @author antonviktorov
 * @since 1.0
 */
class FindById extends BaseAction implements UserAction {
    /**
     * Find by id item constructor.
     */
    FindById() {
        super("Find item by id");
    }
    /**
     * Get action key.
     * @return key
     */
    public int key() {
        return 4;
    }
    /**
     * Execute action.
     * @param input - input flow
     * @param tracker - tracker entity
     */
    public void execute(Input input, Tracker tracker) {
        String id = input.ask("Please input task id: ");
        Item item = tracker.findById(id);

        System.out.println(String.format("Fond item: %s", item.getName()));
    }
}
/**
 * Find by name item class.
 * @author antonviktorov
 * @since 1.0
 */
class FindByName extends BaseAction implements UserAction {
    /**
     * Find by name item constructor.
     */
    FindByName() {
        super("Find items by name");
    }
    /**
     * Get action key.
     * @return key
     */
    public int key() {
        return 5;
    }
    /**
     * Execute action.
     * @param input - input flow
     * @param tracker - tracker entity
     */
    public void execute(Input input, Tracker tracker) {
        String name = input.ask("Please input task name: ");
        Item[] items = tracker.findByName(name);

        System.out.println("Fond items:");

        for (Item item : items) {
            System.out.println(item.getName());
        }
    }
}
/**
 * Add comment action class.
 * @author antonviktorov
 * @since 1.0
 */
class AddComment extends BaseAction implements UserAction {
    /**
     * Add comment to tracker constructor.
     */
    AddComment() {
        super("Add comment to the task");
    }
    /**
     * Get action key.
     * @return key
     */
    public int key() {
        return 7;
    }
    /**
     * Execute action.
     * @param input - input flow
     * @param tracker - tracker entity
     */
    public void execute(Input input, Tracker tracker) {
        String id = input.ask("Please input task id: ");
        Item item = tracker.findById(id);

        String comment = input.ask("Please input task comment: ");
        item.addComment(comment);
    }
}

/**
 * CLI Menu tracker class.
 * @author antonviktorov
 * @since 1.0
 */
public class MenuTracker {
    /**
     * Action position.
     */
    private int position = 0;
    /**
     * Input flow.
     */
    private Input input;
    /**
     * Tracker class.
     */
    private Tracker tracker;
    /**
     * User actions array.
     */
    protected UserAction[] actions = new UserAction[9];

    /**
     * Menu tracker constructor.
     * @param input - input flow
     * @param tracker - tracker entity
     */
    public MenuTracker(Input input, Tracker tracker) {
        this.input = input;
        this.tracker = tracker;
    }

    /**
     * Preset all actions.
     */
    public void fillActions() {
        this.actions[position++] = this.new AddItem();
        this.actions[position++] = new MenuTracker.ShowItems();
        this.actions[position++] = new EditItem();
        this.actions[position++] = new DeleteItem();
        this.actions[position++] = new FindById();
        this.actions[position++] = new FindByName();
        this.actions[position++] = new MenuTracker.ShowItemsFiltered();
        this.actions[position++] = new AddComment();
    }

    /**
     * Add action.
     * @param action - action entity
     */
    public void addAction(UserAction action) {
        this.actions[this.position++] = action;
    }

    /**
     * Get action keys.
     * @return keys
     */
    public int[] getActionKeys() {
        int[] keys = new int[position];
        int i = 0;
        for (UserAction action : this.actions) {
            if (action != null) {
                keys[i++] = action.key();
            }
        }
        return keys;
    }

    /**
     * Execute action.
     * @param key - action key
     */
    public void select(int key) {
        this.actions[key].execute(this.input, this.tracker);
    }

    /**
     * Show content available actions.
     */
    public void show() {
        for (UserAction action : this.actions) {
            if (action == null) {
                continue;
            }
            System.out.println(action.info());
        }
    }

    /**
     * Add item class.
     * @author antonviktorov
     * @since 1.0
     */
    private class AddItem extends BaseAction implements UserAction {
        /**
         * Add item constructor.
         */
        AddItem() {
            super("Add new item");
        }
        /**
         * Get action key.
         * @return key
         */
        public int key() {
            return 0;
        }
        /**
         * Execute action.
         * @param input - input flow
         * @param tracker - tracker entity
         */
        public void execute(Input input, Tracker tracker) {
            String name = input.ask("Please enter task name:");
            String description = input.ask("Please enter task description:");
            tracker.add(new Task(name, description));
        }
    }

    /**
     * Show items class.
     * @author antonviktorov
     * @since 1.0
     */
    private static class ShowItems implements UserAction {
        /**
         * Get action key.
         * @return key
         */
        public int key() {
            return 1;
        }
        /**
         * Execute action.
         * @param input - input flow
         * @param tracker - tracker entity
         */
        public void execute(Input input, Tracker tracker) {
            for (Item item : tracker.getItems()) {
                System.out.println(
                        String.format("%s. %s created: %d", item.getId(), item.getName(), item.getCreated())
                );

                System.out.println("Comments: ");

                for (String comment : item.getComments()) {
                    System.out.println(String.format("    %s", comment));
                }
            }
        }
        /**
         * Info string.
         * @return info data
         */
        public String info() {
            return  String.format("%s. %s", this.key(), "Show all items");
        }
    }

    /**
     * Show items filtered class.
     * @author antonviktorov
     * @since 1.0
     */
    private static class ShowItemsFiltered implements UserAction {
        /**
         * Get action key.
         * @return key
         */
        public int key() {
            return 6;
        }
        /**
         * Execute action.
         * @param input - input flow
         * @param tracker - tracker entity
         */
        public void execute(Input input, Tracker tracker) {
            Filter[] filters = new Filter[3];
            int position = 0;

            String name = input.ask("Please enter task name to filter:");
            String id = input.ask("Please enter id to filter:");
            String uts = input.ask("Please enter UTS to filter:");

            if (name != null) {
               filters[position++] = new NameFilter(name);
            }

            if (id != null) {
                filters[position++] = new IdFIlter(Long.valueOf(id));
            }

            if (uts != null) {
                filters[position++] = new TimestampFilter(Long.valueOf(id), 0);
            }

            for (Item item : tracker.getItems(Arrays.copyOfRange(filters, 0, position))) {
                System.out.println(
                        String.format("%s. %s created: %d", item.getId(), item.getName(), item.getCreated())
                );
            }
        }
        /**
         * Info string.
         * @return info data
         */
        public String info() {
            return  String.format("%s. %s", this.key(), "Show filtered items");
        }
    }
}