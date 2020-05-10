package ru.job4j.tracker;

import java.util.StringJoiner;

public class CreateAction implements UserAction {

    @Override
    public String showMenuHeader() {
        return "Add new Item";
    }

    @Override
    public boolean execute(Input input, Tracker tracker) {
        showMethodHeader();
        String name = input.askStr("Enter name: ");
        Item item = new Item(name);
        tracker.add(item);
        return true;
    }

    private void showMethodHeader() {
            System.out.println();
            System.out.println(" Create a new item ... ");
    }
}