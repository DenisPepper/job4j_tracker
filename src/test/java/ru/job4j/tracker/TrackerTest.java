package ru.job4j.tracker;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

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
        Item Item1 = new Item("test1");
        Item Item2 = new Item("test1");
        Item Item3 = new Item("test1");

        Tracker tracker = new Tracker();
        tracker.add(Item1);
        tracker.add(Item2);
        tracker.add(Item3);

        List<Item> items = new ArrayList<>();
        items.add(Item1);
        items.add(Item2);
        items.add(Item3);

        List<Item> result = tracker.findByName("test1");

        assertThat(result, is(items));
    }

    @Test
    public void findAll() {
        Item firstItem = new Item("test1");
        Item secondItem = new Item("test1");

        Tracker tracker = new Tracker();
        tracker.add(firstItem);
        tracker.add(secondItem);

        List<Item> items = new ArrayList<>();
        items.add(firstItem);
        items.add(secondItem);

        List<Item> result = tracker.findAll();

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