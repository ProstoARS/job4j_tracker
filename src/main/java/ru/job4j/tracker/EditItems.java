package ru.job4j.tracker;

public class EditItems implements UserAction {
    @Override
    public String name() {
        return "==== Edit item ====";
    }

    @Override
    public boolean execute(Input input, Tracker tracker) {
        int id = input.askInt("Enter id for change: ");
        String name = input.askStr("Enter name a new Item: ");
        Item item = new Item(name);
        if (tracker.replace(id, item)) {
            System.out.println("The replacement was successful");
        } else {
            System.out.println("id does not exist");
        }
        return true;
    }
}
