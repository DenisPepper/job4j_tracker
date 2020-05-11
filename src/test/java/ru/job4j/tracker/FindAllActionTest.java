package ru.job4j.tracker;

import org.junit.Test;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.StringJoiner;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.*;

public class FindAllActionTest {

    @Test
    public void whenCheckOutput() {
        PrintStream defaultOut = System.out;
        ByteArrayOutputStream byteArrayOut = new ByteArrayOutputStream();
        System.setOut(new PrintStream(byteArrayOut));

        StringJoiner expected = new StringJoiner(System.lineSeparator());
        expected.add("");
        expected.add(" The list of all items: ");

        StubInput input = new StubInput(new String[] {""});
        Tracker tracker = new Tracker();
        for (int index = 1; index <= 3; index++) {
            Item item = new Item("test" + index);
            tracker.add(item);
            expected.add(item.getId() + ". " + item.getName());
        }
        expected.add("");
        UserAction[] actions = {new FindAllAction()};
        new FindAllAction().execute(input, tracker);

        assertThat(byteArrayOut.toString(), is(expected.toString()));

        System.setOut(defaultOut);
    }



}
