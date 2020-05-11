package ru.job4j.tracker;

import org.junit.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.StringJoiner;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.*;

public class StartUITest {

    @Test
    public void whenExit() {
        StubInput input = new StubInput(new String[] {"0"}); // 0 - индекс элемента в массиве действий
        StubAction action = new StubAction();
        new StartUI().init(input, new Tracker(), new UserAction[] {action});
        assertThat(action.isCall(), is(true));
    }

    @Test
    public void whenPrtMenu() {
        PrintStream defaultOut = System.out;
        ByteArrayOutputStream byteArrayOut = new ByteArrayOutputStream();
        System.setOut(new PrintStream(byteArrayOut));

        // вызов метода showMenu
        StubInput input = new StubInput(new String[] {"0"}); // 0 - индекс элемента в массиве действий
        StubAction action = new StubAction();
        new StartUI().init(input, new Tracker(), new UserAction[] {action});

        // печать меню
        StringJoiner pic = new StringJoiner(System.lineSeparator());
        pic.add("");
        pic.add("Menu.");
        pic.add("0. Stub action");
        pic.add("");

        // сравнение
        assertThat(byteArrayOut.toString(), is(pic.toString()));

        System.setOut(defaultOut);
    }
}
