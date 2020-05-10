package ru.job4j.tracker;

import java.util.StringJoiner;

public class DeleteAction implements UserAction {

    @Override
    public String showMenuHeader() {
        return "Delete item";
    }

    @Override
    public boolean execute(Input input, Tracker tracker) {
        System.out.println();
        System.out.println(" Delete item ... ");
        if (tracker.delete(input.askStr("Enter id: "))) {
            System.out.print(" Delete well done ...");
        } else {
            System.out.print(" Delete error! Try again ...");
        }
        return true;
    }
}
