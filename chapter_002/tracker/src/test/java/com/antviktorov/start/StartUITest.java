package com.antviktorov.start;

import com.antviktorov.menu.exceptions.MenuOutException;
import org.junit.Test;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

import com.antviktorov.models.Task;
import com.antviktorov.models.Item;

public class StartUITest {

    /**
     * Add tasks to tracker instance.
     */
    private void addTasks(Tracker tracker) {
        tracker.add(new Task("First Task", "Cool first task, hello World!"));
        tracker.add(new Task("Second Task", "I am cool man, keep adding tasks"));
        tracker.add(new Task("Third Task", "Hey, please add this to the footer"));
    }
    @Test
    public void whenAddTaskThenCheckItInTracker() {
        Tracker tracker = new Tracker();
        Input input = new StubInput(
                new String[] {"0", "Task", "Task Description", "y"}
        );
        new StartUI(input,tracker).init();
        assertThat("Add task: ", tracker.getItems()[0].getName(), is("Task"));
    }

    @Test
    public void whenShowTasks() {
        Tracker tracker = new Tracker();
        Input input = new StubInput(
                new String[] {
                        "0", "Task 1", "Task 1 Description", "n",
                        "0", "Task 2", "Task 2 Description", "n",
                        "1", "y",
                }
        );
        new StartUI(input, tracker).init();
    }

    @Test
    public void whenUpdateTaskThenCheckItInTracker() {
        Tracker tracker = new Tracker();
        this.addTasks(tracker);
        Item[] items = tracker.getItems();
        Input input = new StubInput(
                new String[] {
                        "2", items[0].getId(), "First Task Updated", "Updated description", "y",
                }
        );
        new StartUI(input, tracker).init();
        items = tracker.getItems();
        assertThat("Update task, test name ", items[0].getName(), is("First Task Updated"));
        assertThat("Update task, test description ", items[0].getDescription(), is("Updated description"));
    }

    @Test
    public void whenDeleteTaskThenCheckItInTracker() {
        Tracker tracker = new Tracker();
        this.addTasks(tracker);

        Item[] items = tracker.getItems();

        Input input = new StubInput(
                new String[] {
                        "3", items[1].getId(), "y",
                }
        );
        new StartUI(input, tracker).init();

        items = tracker.getItems();

        assertThat("Delete task ", items.length, is(2));
    }

    @Test
    public void whenFindByIdTask() {
        Tracker tracker = new Tracker();
        this.addTasks(tracker);

        Item[] items = tracker.getItems();

        Input input = new StubInput(
                new String[] {
                        "4", items[1].getId(), "y",
                }
        );
        new StartUI(input, tracker).init();
    }

    @Test
    public void whenFindByNameTask() {
        Tracker tracker = new Tracker();
        this.addTasks(tracker);

        Item[] items = tracker.getItems();

        Input input = new StubInput(
                new String[] {
                        "5", items[2].getName(), "y",
                }
        );
        new StartUI(input, tracker).init();
    }

    @Test
    public void whenShowFilteredTasks() {
        Tracker tracker = new Tracker();
        Input input = new StubInput(
                new String[] {
                        "0", "Task 1", "Task 1 Description", "n",
                        "0", "Task 2", "Task 2 Description", "n",
                        "6", "Task", "123", "123",
                        "y"
                }
        );
        new StartUI(input, tracker).init();
    }

    @Test
    public void whenAddCommentsThenCheckItInTracker() {
        Tracker tracker = new Tracker();
        this.addTasks(tracker);

        Item[] items = tracker.getItems();

        Input input = new StubInput(
                new String[] {
                        "7", items[1].getId(), "First comment!", "n",
                        "7", items[1].getId(), "Second comment!", "n",
                        "7", items[1].getId(), "Third comment!", "y",
                }
        );
        new StartUI(input, tracker).init();

        items = tracker.getItems();
        Item item = items[1];

        assertThat("Check comments", item.getComments().length, is(3));
    }

    @Test
    public void whenAddMaxTasksThenWatchTracker() {
        Tracker tracker = new Tracker();
        Input input = new StubInput(
                new String[] {
                        "0", "Test task", "Test description", "n",
                        "0", "Test task", "Test description", "n",
                        "0", "Test task", "Test description", "n",
                        "0", "Test task", "Test description", "n",
                        "0", "Test task", "Test description", "n",
                        "0", "Test task", "Test description", "n",
                        "0", "Test task", "Test description", "n",
                        "0", "Test task", "Test description", "n",
                        "0", "Test task", "Test description", "n",
                        "0", "Test task", "Test description", "n",
                        "0", "Test task", "Test description", "n",
                        "0", "Test task", "Test description", "y",
                }
        );
        new StartUI(input, tracker).init();
    }

    @Test
    public void whenDeleteWrongTaskThenWatchTracker() {
        Tracker tracker = new Tracker();
        Input input = new StubInput(
                new String[] {
                        "3", "12312312312312312313412412", "y",
                }
        );
        new StartUI(input, tracker).init();
    }

    @Test
    public void whenInputWrongCommandThenWatchTracker() {
        Tracker tracker = new Tracker();
        Input input = new StubInput(
                new String[] {
                        "1000",
                        "test test",
                        "0", "Test task", "Test description", "y",
                }
        );

        try {
            new StartUI(input, tracker).init();
        } catch (MenuOutException e) {
            System.out.println("Please select key from menu");
        } catch (NumberFormatException e) {
            System.out.println("Please enter validated data again");
        }
    }
}