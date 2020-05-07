package ru.job4j.tracker;

public class StubInput implements Input {

    @Override
    public String inputStr(String question) {
        return null;
    }

    @Override
    public int inputInt(String question) {
        return 0;
    }
}
