package ru.job4j.collection;

import java.util.ArrayList;

public class UsageArrayList {
    public static void main(String[] args) {
        ArrayList<String> list = new ArrayList<>();
        list.add("Petr");
        list.add("Stepan");
        list.add("Ivan");

        for (String str : list) {
            System.out.println(str);
        }
    }
}
