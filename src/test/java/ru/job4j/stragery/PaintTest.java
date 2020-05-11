package ru.job4j.stragery;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.StringJoiner;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

/**
 *
 * 1. Класс PrintStream — общее назначение - вывод информации в какой-то поток.
 *
 * 2. Класс ByteArrayOutputStream — это поток вывода в массив байтов в качестве места вывода.
 *
 *
 */

public class PaintTest {
    private final PrintStream defaultOut = System.out; // поле содержит дефолтный вывод в консоль.
    private final ByteArrayOutputStream byteArrayOut = new ByteArrayOutputStream(); // поле содержит поток вывода в массив байтов в качестве места вывода

    @Before
    public void loadOutput() {
        System.setOut(new PrintStream(this.byteArrayOut));
    }

    @After
    public void backOutput() {
        System.setOut(this.defaultOut);
    }

    @Test
    public void whenDrawSquare() {
        new Paint().draw(new Square()); // выполняем действия пишушиее в консоль.

        StringJoiner pic = new StringJoiner(System.lineSeparator());
        pic.add("+++++++");
        pic.add("+     +");
        pic.add("+     +");
        pic.add("+++++++");
        pic.add("");

        assertThat(this.byteArrayOut.toString(), is(pic.toString()));
    }

    @Test
    public void whenDrawTriangle() {
        new Paint().draw(new Triangle()); // выполняем действия пишушиее в консоль.

        StringJoiner pic = new StringJoiner(System.lineSeparator());
        pic.add("    +  ");
        pic.add("  +   +");
        pic.add(" +     +");
        pic.add("+++++++++");
        pic.add("");

        assertThat(this.byteArrayOut.toString(), is(pic.toString()));
    }
}
