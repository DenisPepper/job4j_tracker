package ru.job4j.tracker;

import org.junit.Test;

import static org.hamcrest.CoreMatchers.nullValue;
import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertThat;

public class TrackerTest {

    @Test
    public void whenAddNewItemThenTrackerHasSameItem() {
        Tracker tracker = new Tracker();
        Item item = new Item("test1");
        tracker.add(item);
        Item result = tracker.findById(item.getId());
        assertThat(result.getName(), is(item.getName()));
    }

    @Test
    public void findByName() {
        Tracker tracker = new Tracker();

        Item Item1 = new Item("test1");
        Item Item2 = new Item("test1");
        Item Item3 = new Item("test1");

        tracker.add(Item1);
        tracker.add(Item2);
        tracker.add(Item3);

        Item[] items = {Item1, Item2, Item3};
        Item[] result = tracker.findByName("test1");

        assertThat(result, is(items));
    }

    @Test
    public void findAll() {
        Tracker tracker = new Tracker();
        Item firstItem = new Item("test1");
        tracker.add(firstItem);
        Item secondItem = new Item("test1");
        tracker.add(secondItem);
        Item[] items = {firstItem, secondItem};
        Item[] result = tracker.findAll();
        assertThat(result, is(items));
    }

    @Test
    public void whenReplace() {
        Tracker tracker = new Tracker();
        Item bug = new Item("Bug");
        tracker.add(bug);
        String id = bug.getId();
        Item bugWithDesc = new Item("Bug with description");
        tracker.replace(id, bugWithDesc);
        assertThat(tracker.findById(id).getName(), is("Bug with description"));
    }

    @Test
    public void whenDelete() {
        Tracker tracker = new Tracker();
        Item bug = new Item("Bug");
        tracker.add(bug);
        String id = bug.getId();
        tracker.delete(id);
        assertThat(tracker.findById(id), is(nullValue()));
    }
}