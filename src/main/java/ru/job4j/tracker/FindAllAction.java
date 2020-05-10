package ru.job4j.tracker;

import java.util.StringJoiner;

public class FindAllAction implements UserAction {

    @Override
    public String showMenuHeader() {
        StringJoiner pic = new StringJoiner(System.lineSeparator());
        pic.add("Find all items");
        return pic.toString();
    }

    @Override
    public boolean execute(Input input, Tracker tracker) {
        showMethodHeader();
        Item[] items = tracker.findAll();
        if (items.length == 0) {
            System.out.println("is empty ...");
        } else {
            for (Item item : items) {
                System.out.println(item.getId() + ". " + item.getName());
            }
        }
        return true;
    }

    private void showMethodHeader() {
        System.out.println();
        System.out.println(" The list of all items: ");
    }
}
