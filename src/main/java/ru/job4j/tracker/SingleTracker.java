package ru.job4j.tracker;

public class SingleTracker {
    private Tracker tracker;
    private static SingleTracker inctance = null;

    public SingleTracker(Tracker tracker) {
        this.tracker = tracker;
    }

    public static SingleTracker getTracker() {
        if (inctance == null) {
            inctance = new SingleTracker(new Tracker());
        }
        return inctance;
    }

    public Item add(Item item) {
        return tracker.add(item);
    }

    public Item findById(int id) {
        return tracker.findById(id);
    }

    public Item[] findAll() {
        return tracker.findAll();
    }

    public Item[] findByName(String key) {
        return tracker.findByName(key);
    }

    public boolean replace(int id, Item item) {
        return tracker.replace(id,item);
    }

    public boolean delete(int id) {
        return tracker.delete(id);
    }
}
