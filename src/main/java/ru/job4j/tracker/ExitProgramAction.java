package ru.job4j.tracker;

import java.util.StringJoiner;

public class ExitProgramAction implements UserAction {

    @Override
    public String showMenuHeader() {
        StringJoiner pic = new StringJoiner(System.lineSeparator());
        pic.add("Exit Program");
        return pic.toString();
    }

    @Override
    public boolean execute(Input input, Tracker tracker) {
        return false;
    }
}
