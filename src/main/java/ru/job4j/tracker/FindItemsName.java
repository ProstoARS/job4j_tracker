package ru.job4j.tracker;

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
