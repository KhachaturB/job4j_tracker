package ru.job4j.tracker;

public class StartUI {

    public static void main(String[] args) {
        Item item = new Item("Test item");
        Tracker tracker = new Tracker();
        tracker.add(item);

        Item foundItem = tracker.findById(item.getId());
        System.out.println(foundItem.getId() + ": " + foundItem.getName() + " - " + foundItem.getCreated());
    }
}
