package ru.job4j.tracker;

import java.util.StringJoiner;

public class FindByIDAction implements UserAction {

    @Override
    public String showMenuHeader() {
        StringJoiner pic = new StringJoiner(System.lineSeparator());
        pic.add("Find item by Id");
        return pic.toString();
    }

    @Override
    public boolean execute(Input input, Tracker tracker) {
        Item item = tracker.findById(input.askStr("Enter id: "));
        if (item != null) {
            System.out.println(item.getId() + ". " + item.getName());
        } else {
            System.out.print(" Incorrect id! Try again ...");
        }
        return true;
    }
}
