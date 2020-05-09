package ru.job4j.tracker;

/**
 * интерфейс определяет, что умеет делать класс, но он не знает, как класс это будет делать
 */

public interface Input {

    String askStr(String question);

    int askInt(String question);
}
