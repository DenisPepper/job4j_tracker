package ru.job4j.tracker;

import java.util.StringJoiner;

public class RenameAction implements UserAction {

    @Override
    public String showMenuHeader() {
        return "Rename item";
    }

    @Override
    public boolean execute(Input input, Tracker tracker) {
        System.out.println();
        System.out.println(" Rename item ... ");
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
