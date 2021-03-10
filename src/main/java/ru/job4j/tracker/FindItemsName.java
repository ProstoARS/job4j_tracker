package ru.job4j.tracker;

import java.util.List;

public class FindItemsName implements UserAction {
    private final Output out;

    public FindItemsName(Output out) {
        this.out = out;
    }

    @Override
    public String name() {
        return "Find item by name";
    }

    @Override
    public boolean execute(Input input, Tracker tracker) {
        out.println("==== Find item by name ====");
        String name = input.askStr("Enter name for find item: ");
        List<Item> item = tracker.findByName(name);
        if (item.size() > 0) {
            for (Item value : item) {
                out.println(value);
            }
        } else {
            out.println("name does not exist");
        }
        return true;
    }
}
