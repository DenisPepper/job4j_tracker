package ru.job4j.collection;

import java.util.ArrayList;

public class UsageArrayList {

    public static void add(ArrayList arrayList, int index, String value) {
        arrayList.add(index);
        arrayList.set(index, value);
    }

    public static void main(String[] args) {
        ArrayList<String> names = new ArrayList<String>();
        add(names, 0, "Petr");
        add(names, 1, "Ivan");
        add(names, 2, "Stepan");
        for (Object name:names) {
            System.out.println(name);
        }
    }
}
