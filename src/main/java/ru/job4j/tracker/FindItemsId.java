package ru.job4j.tracker;

public class FindItemsId implements UserAction {
    @Override
    public String name() {
        return "==== Find item by Id ====";
    }

    @Override
    public boolean execute(Input input, Tracker tracker) {
        int id = input.askInt("Enter id for find item: ");
        Item item = tracker.findById(id);
        if (item != null) {
            System.out.println(item);
        } else {
            System.out.println("id does not exist");
        }
        return true;
    }
}
