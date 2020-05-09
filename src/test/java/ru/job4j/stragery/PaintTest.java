package ru.job4j.stragery;

import org.junit.Test;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;
import java.util.StringJoiner;

public class PaintTest {
    @Test
    public void whenDrawSquare() {
        PrintStream stdout = System.out; // получаем ссылку на стандартный вывод в консоль.
        ByteArrayOutputStream out = new ByteArrayOutputStream(); // Создаем буфур для хранения вывода.
        System.setOut(new PrintStream(out)); //Заменяем стандартный вывод на вывод в пямять для тестирования.
        new Paint().draw(new Square()); // выполняем действия пишушиее в консоль.

        // проверяем результат вычисления
        StringJoiner pic = new StringJoiner(System.lineSeparator());
        pic.add("+++++++");
        pic.add("+     +");
        pic.add("+     +");
        pic.add("+++++++");
        pic.add("");
        assertThat(new String(out.toByteArray()), is(pic.toString()));
        System.setOut(stdout); // возвращаем обратно стандартный вывод в консоль.
    }

    @Test
    public void whenDrawTriangle() {
        PrintStream stdout = System.out; // получаем ссылку на стандартный вывод в консоль.
        ByteArrayOutputStream out = new ByteArrayOutputStream(); // Создаем буфур для хранения вывода.
        System.setOut(new PrintStream(out)); //Заменяем стандартный вывод на вывод в пямять для тестирования.
        new Paint().draw(new Triangle()); // выполняем действия пишушиее в консоль.

        // проверяем результат вычисления
        StringJoiner pic = new StringJoiner(System.lineSeparator());
        pic.add("    +  ");
        pic.add("  +   +");
        pic.add(" +     +");
        pic.add("+++++++++");
        pic.add("");
        assertThat(new String(out.toByteArray()), is(pic.toString()));
        System.setOut(stdout); // возвращаем обратно стандартный вывод в консоль.
    }
}
