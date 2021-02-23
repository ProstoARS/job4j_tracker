package ru.job4j.tracker;

public class DeleteItems implements UserAction {
    private final Output out;

    public DeleteItems(Output out) {
        this.out = out;
    }
    @Override
    public String name() {
        return "Delete item";
    }

    @Override
    public boolean execute(Input input, Tracker tracker) {
        out.println("==== Delete item ====");
        int id = input.askInt("Enter id for delete: ");
        if (tracker.delete(id)) {
            out.println("File deleted");
        } else {
            out.println("id does not exist");
        }
        return true;
    }
}
