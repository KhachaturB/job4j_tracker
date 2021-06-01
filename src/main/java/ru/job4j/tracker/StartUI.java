package ru.job4j.tracker;

import java.util.Scanner;

public class StartUI {

    public void init(Scanner scanner, Tracker tracker) {
        while (true) {
            this.showMenu();
            System.out.print("Select: ");
            int choice = Integer.parseInt(scanner.nextLine());
            Item item;
            Item[] items;
            String name;
            int id;
            switch (choice) {
                case 0:
                    System.out.println("=== Create a new Item ====");
                    System.out.print("Enter name: ");
                    name = scanner.nextLine();
                    item = new Item(name);
                    tracker.add(item);
                    System.out.println("Item added (id: " + item.getId() + " name: " + item.getName() + ")");
                    System.out.println();
                    break;

                case 1:
                    System.out.println("=== Show all Items ====");
                    items = tracker.findAll();
                    if (items.length == 0) {
                        System.out.println("No items");
                    } else {
                        for (Item itm : items) {
                            System.out.println("id: " + itm.getId() + " name: " + itm.getName());
                        }
                    }
                    System.out.println();
                    break;

                case 2:
                    System.out.println("=== Edit Item ====");
                    System.out.print("Enter id: ");
                    id = Integer.parseInt(scanner.nextLine());
                    System.out.print("Enter name: ");
                    name = scanner.nextLine();
                    item = new Item(name);
                    if (tracker.replace(id, item)) {
                        System.out.println("Element has been changed:");
                        System.out.println("id: " + item.getId() + " name: " + item.getName());
                    } else {
                        System.out.println("Element has not been changed.");
                    }
                    System.out.println();
                    break;

                case 3:
                    System.out.println("=== Delete Item ====");
                    System.out.print("Enter id: ");
                    id = Integer.parseInt(scanner.nextLine());
                    if (tracker.delete(id)) {
                        System.out.println("Element has been deleted.");
                    } else {
                        System.out.println("Element has not been deleted.");
                    }
                    System.out.println();
                    break;

                case 4:
                    System.out.println("=== Find Item by Id ====");
                    System.out.print("Enter id: ");
                    id = Integer.parseInt(scanner.nextLine());
                    item = tracker.findById(id);
                    if (item == null) {
                        System.out.println("Item with id " + id + " not found.");
                    } else {
                        System.out.println("id: " + item.getId() + " name: " + item.getName());
                    }
                    System.out.println();
                    break;

                case 5:
                    System.out.println("=== Find Item by name ====");
                    System.out.print("Enter name: ");
                    name = scanner.nextLine();
                    items = tracker.findByName(name);
                    if (items.length == 0) {
                        System.out.println("Items with name " + name + " not found.");
                    } else {
                        for (Item itm : items) {
                            System.out.println("id: " + itm.getId() + " name: " + itm.getName());
                        }
                    }
                    System.out.println();
                    break;

                case 6:
                    return;

                default:
                    System.out.println("No matches.");
                    System.out.println();
                    break;
            }
        }
    }

    private void showMenu() {
        System.out.println("Menu.");
        System.out.println("0. Add new Item");
        System.out.println("1. Show all items");
        System.out.println("2. Edit item");
        System.out.println("3. Delete item");
        System.out.println("4. Find item by Id");
        System.out.println("5. Find items by name");
        System.out.println("6. Exit Program");
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Tracker tracker = new Tracker();
        new StartUI().init(scanner, tracker);
    }
}
