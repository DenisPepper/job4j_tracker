package ru.job4j.tracker;

import org.junit.Test;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;

public class ValidateInputTest {

    @Test
    public void whenInvalidInput() {
        ByteArrayOutputStream mem = new ByteArrayOutputStream();
        PrintStream out = System.out;
        System.setOut(new PrintStream(mem));
        String[] data = {"text instead of numbers", "1"};
        ValidateInput input = new ValidateStubInput(data);
        input.askInt("Enter");
        assertThat(
                mem.toString(),
                is(String.format("Please enter validate data again.%n"))
        );
        System.setOut(out);
    }

    @Test
    public void whenInvalidSelectKey() {
        PrintStream defaultOut = System.out;
        ByteArrayOutputStream byteArrayOut = new ByteArrayOutputStream();
        System.setOut(new PrintStream(byteArrayOut));

        String[] simulatedInputs = {"5", "1"};
        ValidateInput input = new ValidateStubInput(simulatedInputs);
        input.askInt("Enter", 5);

        assertThat(
                byteArrayOut.toString(),
                is(String.format("Please select key from menu.%n"))
        );

        System.setOut(defaultOut);
    }

}
