package ru.job4j.tracker;

import java.util.StringJoiner;

public class FindByNameAction implements UserAction {

    @Override
    public String showMenuHeader() {
        StringJoiner pic = new StringJoiner(System.lineSeparator());
        pic.add("Find items by name");
        return pic.toString();
    }

    @Override
    public boolean execute(Input input, Tracker tracker) {
        showMethodHeader();
        Item[] items = tracker.findByName(input.askStr("Enter name: "));
        if (items.length == 0) {
            System.out.println("not found ...");
        } else {
            for (Item item : items) {
                System.out.println(item.getId() + ". " + item.getName());
            }
        }
        return true;
    }

    private void showMethodHeader() {
        System.out.println();
        System.out.println(" Find items by name ... ");
    }
}
