package ru.job4j.tracker;

public class DeleteItems implements UserAction {
    @Override
    public String name() {
        return "==== Delete item ====";
    }

    @Override
    public boolean execute(Input input, Tracker tracker) {
        int id = input.askInt("Enter id for delete: ");
        if (tracker.delete(id)) {
            System.out.println("File deleted");
        } else {
            System.out.println("id does not exist");
        }
        return true;
    }
}
