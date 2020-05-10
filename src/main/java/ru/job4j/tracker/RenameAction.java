package ru.job4j.tracker;

import java.util.StringJoiner;

public class RenameAction implements UserAction {

    @Override
    public String showMenuHeader() {
        StringJoiner pic = new StringJoiner(System.lineSeparator());
        pic.add("Rename item");
        return pic.toString();
    }

    @Override
    public boolean execute(Input input, Tracker tracker) {
        String id = input.askStr("Enter id: ");
        Item item = new Item(input.askStr("Enter new name: "));
        if (tracker.replace(id, item)) {
            System.out.print(" Rename well done ...");
        } else {
            System.out.print(" Rename error! Try again ...");
        }
        return true;
    }
}
