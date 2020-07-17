package ru.job4j.collection;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.*;

public class NotifyAccountTest {

    @Test
    public void sent() {
        Account a1 = new Account("123", "Petr Arsentev", "eDer3432f");
        Account a2 = new Account("142", "Petr Arsentev", "000001");

        List<Account> accounts = new ArrayList<>();
        accounts.add(a1);
        accounts.add(a1);
        accounts.add(a2);
        accounts.add(a2);

        HashSet<Account> expect = new HashSet<>();
        expect.add(a1);
        expect.add(a2);

        assertThat(NotifyAccount.sent(accounts), is(expect));
    }
}