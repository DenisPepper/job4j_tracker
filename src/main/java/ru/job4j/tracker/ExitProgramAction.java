package ru.job4j.tracker;

import java.util.StringJoiner;

public class ExitProgramAction implements UserAction {

    @Override
    public String showMenuHeader() {
        return "Exit Program";
    }

    @Override
    public boolean execute(Input input, Tracker tracker) {
        System.out.println();
        System.out.println(" Exit ... ");
        return false;
    }
}
