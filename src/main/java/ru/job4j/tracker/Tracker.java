package ru.job4j.tracker;

import ru.job4j.search.Person;

import java.util.ArrayList;
import java.util.List;

public class Tracker {
    private final List<Item> items = new ArrayList<>();
    private int ids = 1;

    public Item add(Item item) {
        item.setId(generateId());
        items.add(item);
        return item;
    }

    private String generateId() {
        return String.valueOf(ids++);
    }

    public Item findById(String id) {
        int index = indexOf(id);
        return index != -1 ? items.get(index) : null;
    }

    private int indexOf(String id) {
        int rsl = -1;
        for (int index = 0; index < items.size(); index++) {
            if (items.get(index).getId().equals(id)) {
                rsl = index;
                break;
            }
        }
        return rsl;
    }

    public List<Item> findByName(String key) {
        List<Item> result = new ArrayList<>();
        for (Item item:items) {
            if (item.getName().contains(key)) {
                result.add(item);
            }
        }
        return result;
    }

    public List<Item> findAll() {
       return items.subList(0, items.size());
    }

    public boolean replace(String id, Item item) {
        int index = indexOf(id);
        boolean isValid = index != -1;
        if (isValid) {
            item.setId(id);
            items.set(index, item);
        }
        return isValid;
    }

    public boolean delete(String id) {
        int index = indexOf(id);
        boolean isValid = index != -1;
        if (isValid) {
            items.remove(index);
        }
        return isValid;
    }
}