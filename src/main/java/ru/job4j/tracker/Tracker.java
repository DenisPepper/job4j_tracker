package ru.job4j.tracker;

import java.util.Arrays;

public class Tracker {
    private final Item[] items = new Item[100];
    private int ids = 1;
    private int size = 0;

    public Item add(Item item) {
        item.setId(generateId());
        items[size++] = item;
        return item;
    }

    private String generateId() {
        return String.valueOf(ids++);
    }

    public Item findById(String id) {
        int index = indexOf(id);
        return index != -1 ? items[index] : null;
    }

    private int indexOf(String id) {
        int rsl = -1;
        for (int index = 0; index < size; index++) {
            if (items[index].getId().equals(id)) {
                rsl = index;
                break;
            }
        }
        return rsl;
    }

    public Item[] findByName(String key) {
        Item[] itemsSameNames = new Item[items.length];
        int size = 0;
        for (int index = 0; index <= size; index++) {
            Item item = items[index];
            if (item != null && item.getName().equals(key)) {
                itemsSameNames[size] = item;
                size++;
            }
        }
        return Arrays.copyOf(itemsSameNames, size);
    }

    public Item[] findAll(Item[] items) {
        Item[] itemsCutNull = new Item[items.length];
        int size = 0;
        for (Item item : items) {
            if (item != null) {
                itemsCutNull[size] = item;
                size++;
            }
        }
        return Arrays.copyOf(itemsCutNull, size);
    }

    public boolean replace(String id, Item item) {
        int index = indexOf(id);
        if (index != -1) {
            item.setId(id);
            items[index] = item;
        }
        return index != -1;
    }
}