package ru.job4j.tracker;

import java.util.StringJoiner;

public class DeleteAction implements UserAction {

    @Override
    public String showMenuHeader() {
        StringJoiner pic = new StringJoiner(System.lineSeparator());
        pic.add("Delete item");
        return pic.toString();
    }

    @Override
    public boolean execute(Input input, Tracker tracker) {
        showMethodHeader();
        if (tracker.delete(input.askStr("Enter id: "))) {
            System.out.print(" Delete well done ...");
        } else {
            System.out.print(" Delete error! Try again ...");
        }
        return true;
    }

    private void showMethodHeader() {
        System.out.println();
        System.out.println(" Delete item ... ");
    }
}
