package ru.job4j.tracker;

public interface UserAction {
    String showMenuHeader();
    boolean execute(Input input, Tracker tracker);
}
