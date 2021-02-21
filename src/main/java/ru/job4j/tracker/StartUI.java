package ru.job4j.tracker;

import java.util.Scanner;

public class StartUI {

    public void init(Scanner scanner, Tracker tracker) {
        boolean run = true;
        while (run) {
            this.showMenu();
            System.out.print("Select: ");
            int select = Integer.parseInt(scanner.nextLine());
            if (select == 0) {
                System.out.println("==== Create a new Item ====");
                System.out.print("Enter name: ");
                String name = scanner.nextLine();
                Item item = new Item(name);
                tracker.add(item);
            } else if (select == 1) {
                System.out.println("==== Show all items ====");
                Item[] all = tracker.findAll();
                for (Item value : all) {
                    System.out.println(value);
                }
            } else if (select == 2) {
                System.out.println(" ==== Edit item ====");
                System.out.println("Enter id for change: ");
                int id = Integer.parseInt(scanner.nextLine());
                System.out.println("Enter name a new Item: ");
                String name = scanner.nextLine();
                Item item = new Item(name);
                if (tracker.replace(id, item)) {
                    System.out.println("The replacement was successful");
                } else {
                    System.out.println("id does not exist");
                }
            } else if (select == 3) {
                System.out.println("==== Delete item ====");
                System.out.println("Enter id for delete: ");
                int id = Integer.parseInt(scanner.nextLine());
                if (tracker.delete(id)) {
                    System.out.println("File deleted");
                } else {
                    System.out.println("id does not exist");
                }
            } else if (select == 4) {
                System.out.println("==== Find item by Id ====");
                System.out.println("Enter id for find item: ");
                int id = Integer.parseInt(scanner.nextLine());
                Item item = tracker.findById(id);
                if (item != null) {
                    System.out.println(item);
                } else {
                    System.out.println("id does not exist");
                }
            } else if (select == 5) {
                System.out.println("==== Find item by name ====");
                System.out.println("Enter name for find item: ");
                String name = scanner.nextLine();
                Item[] item = tracker.findByName(name);
                if (item.length > 0) {
                    for (Item value : item) {
                        System.out.println(value);
                    }
                } else {
                    System.out.println("name does not exist");
                }
            } else if (select == 6) {
                run = false;
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