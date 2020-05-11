package ru.job4j.tracker;

import java.util.StringJoiner;

public class FindAllAction implements UserAction {

    @Override
    public String showMenuHeader() {
        return "Find all items";
    }

    @Override
    public boolean execute(Input input, Tracker tracker) {
        System.out.println();
        System.out.println(" The list of all items: ");
            for (Item item : tracker.findAll()) {
                System.out.println(item.getId() + ". " + item.getName());
            }
        return true;
    }
}
