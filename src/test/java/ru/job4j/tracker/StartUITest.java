package ru.job4j.tracker;

import org.junit.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.List;
import java.util.StringJoiner;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.*;

public class StartUITest {

    @Test
    public void whenExit() {
        StubInput input = new StubInput(new String[] {"0"}); // 0 - индекс элемента в массиве действий
        StubAction action = new StubAction();
        List<UserAction> actions = new ArrayList<>();
        actions.add(action);
        new StartUI().init(input, new Tracker(), actions);

        assertThat(action.isCall(), is(true));
    }

    @Test
    public void whenPrtMenu() {
        PrintStream defaultOut = System.out;
        ByteArrayOutputStream byteArrayOut = new ByteArrayOutputStream();
        System.setOut(new PrintStream(byteArrayOut));
        StubInput input = new StubInput(new String[] {"0"}); // 0 - индекс элемента в массиве действий
        StubAction action = new StubAction();
        List<UserAction> actions = new ArrayList<>();
        actions.add(action);
        new StartUI().init(input, new Tracker(), actions);

        StringJoiner expected = new StringJoiner(System.lineSeparator());
        expected.add("");
        expected.add("Menu.");
        expected.add("0. Stub action");
        expected.add("");

        assertThat(byteArrayOut.toString(), is(expected.toString()));

        System.setOut(defaultOut);
    }
}
