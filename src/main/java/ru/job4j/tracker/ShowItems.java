package ru.job4j.tracker;

public class ShowItems implements UserAction {
    @Override
    public String name() {
        return "==== Show all items ====";
    }

    @Override
    public boolean execute(Input input, Tracker tracker) {
        System.out.println("==== Show all items ====");
        Item[] all = tracker.findAll();
        for (Item value : all) {
            System.out.println(value);
        }
        return true;
    }
}
