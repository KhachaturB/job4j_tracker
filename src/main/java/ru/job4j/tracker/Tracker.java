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
        return index == -1 ? null : items[index];
    }

    public Item[] findAll() {
        Item[] result = new Item[items.length];
        int size = 0;
        for (Item item : items) {
            if (item != null) {
                result[size++] = item;
            }
        }
        return Arrays.copyOf(result, size);
    }

    public Item[] findByName(String key) {
        Item[] result = new Item[items.length];
        int size = 0;
        for (Item item : items) {
            if (item.getName().equals(key)) {
                result[size++] = item;
            }
        }
        return Arrays.copyOf(result, size);
    }

    public boolean replace(int id, Item item) {
        int index = indexOf(id);
        if (index == -1) {
            return false;
        }
        item.setId(items[index].getId());
        items[index] = item;
        return true;
    }

    private int indexOf(int id) {
        for (int index = 0; index < size; index++) {
            if (items[index].getId() == id) {
                return index;
            }
        }
        return -1;
    }
}
