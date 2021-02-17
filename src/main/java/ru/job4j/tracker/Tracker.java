package ru.job4j.tracker;

import java.util.Arrays;

public class Tracker {
    private final Item[] items = new Item[100];
    private int ids = 1;
    private int size = 0;

    public Item add(Item item) {
        item.setId(ids++);
        items[size++] = item;
        return item;
    }

    public Item findById(int id) {
        int index = indexOf(id);
        return index != -1 ? items[index] : null;
    }

    public Item[] findAll(Item[] items) {
        Item[] copy = new Item[items.length];
        int size = 0;
        for (int i = 0; i < items.length; i++) {
            if (items[i] != null) {
                copy[size] = items[i];
                size ++;
            }
        }
        return Arrays.copyOf(copy,size);
    }

    public Item[] findByName(String key) {
        Item[] copy = new Item[items.length];
        int size = 0;
        for (int i = 0; i < items.length; i++) {
            if (items[i].getName().equals(key)) {
                copy[size] = items[i];
                size ++;
            }
        }
        return Arrays.copyOf(copy,size);
    }

    private int indexOf(int id) {
        int rsl = -1;
        for (int index = 0; index < size; index++) {
            if (items[index].getId() == id) {
                rsl = index;
                break;
            }
        }
        return rsl;
    }

    public Item[] replace(int id, Item item) {
        int index = indexOf(id);
        int oldId = items[index].getId();
        item.setId(oldId);
        items[index] = item;
        return items;
    }

    public boolean delete(int id) {
        int index = indexOf(id);
        if (index != -1) {
            items[index] = null;
            System.arraycopy(items, index + 1, items, index,
                    size - index);
            items[size - 1] = null;
            size--;
            return true;
        } else {
            return false;
        }
    }
}