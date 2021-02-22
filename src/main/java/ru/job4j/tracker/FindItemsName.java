package ru.job4j.tracker;

public class FindItemsName implements UserAction {
    @Override
    public String name() {
        return "==== Find item by name ====";
    }

    @Override
    public boolean execute(Input input, Tracker tracker) {
        String name = input.askStr("Enter name for find item: ");
        Item[] item = tracker.findByName(name);
        if (item.length > 0) {
            for (Item value : item) {
                System.out.println(value);
            }
        } else {
            System.out.println("name does not exist");
        }
        return true;
    }
}
