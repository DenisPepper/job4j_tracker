package ru.job4j.tracker;

import org.junit.Test;
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
        Item firstItem = new Item("test1");
        tracker.add(firstItem);
        Item secondItem = new Item("test1");
        tracker.add(secondItem);
        Item[] items = {firstItem, secondItem};
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
        Item[] itemsWithNull = {firstItem, null, secondItem};
        Item[] result = tracker.findAll(itemsWithNull);
        assertThat(result, is(items));
    }
}