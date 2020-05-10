package ru.job4j.tracker;

import java.util.StringJoiner;

public class FindByIDAction implements UserAction {

    @Override
    public String showMenuHeader() {
        return "Find item by Id";
    }

    @Override
    public boolean execute(Input input, Tracker tracker) {
        showMethodHeader();
        Item item = tracker.findById(input.askStr("Enter id: "));
        if (item != null) {
            System.out.println(item.getId() + ". " + item.getName());
        } else {
            System.out.print(" Incorrect id! Try again ...");
        }
        return true;
    }

    private void showMethodHeader() {
        System.out.println();
        System.out.println(" Find item by id ... ");
    }
}
