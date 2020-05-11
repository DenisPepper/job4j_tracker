package ru.job4j.tracker;

import java.util.StringJoiner;

public class FindByNameAction implements UserAction {

    @Override
    public String showMenuHeader() {
        return "Find items by name";
    }

    @Override
    public boolean execute(Input input, Tracker tracker) {
        System.out.println();
        System.out.println(" Find items by name ... ");
        Item[] items = tracker.findByName(input.askStr("Enter name: "));
        for (Item item : items) {
                System.out.println(item.getId() + ". " + item.getName());
        }
        return true;
    }
}
