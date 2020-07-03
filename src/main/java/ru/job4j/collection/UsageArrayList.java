package ru.job4j.collection;

import java.util.ArrayList;

public class UsageArrayList {

    private static void addTo(ArrayList arrayList, int index, String value) {
        arrayList.add(index);
        arrayList.set(index, value);
    }

    private static void add(ArrayList arrayList, String value) {
        arrayList.add(value);
    }

    private static void print(ArrayList arrayList) {
        for (Object name:arrayList) {
            System.out.println(name);
        }
    }

    public static void main(String[] args) {
        ArrayList<String> names = new ArrayList<String>();
        addTo(names, 0, "Petr");
        addTo(names, 1, "Ivan");
        addTo(names, 2, "Stepan");
        print(names);

        names.clear();
        add(names, "Petr");
        add(names, "Ivan");
        add(names, "Stepan");
        print(names);
    }
}
