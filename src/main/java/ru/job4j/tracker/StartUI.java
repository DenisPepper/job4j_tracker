package ru.job4j.tracker;

public class StartUI {

    public void init( Input input, Tracker tracker) {
        boolean run = true;
        while (run) {
            this.showMenu();
            int select = input.askInt("Select: ");

            if (select == 0) {
                this.showHeader(select);
                String name = input.askStr("Enter name: ");
                Item item = new Item(name);
                tracker.add(item);
            } else if (select == 1) {
                this.showHeader(select);
                Item[] items = tracker.findAll();
                if (items.length == 0) {
                    System.out.println("is empty ...");
                } else {
                    for (Item item : items) {
                        System.out.println(item.getId() + ". " + item.getName());
                    }
                }
            } else if (select == 2) {
                this.showHeader(select);
                String id = input.askStr("Enter id: ");
                Item item = new Item(input.askStr("Enter new name: "));
                if (tracker.replace(id,item)) {
                    System.out.print(" Replace well done ...");
                } else {
                    System.out.print(" Replace error! Try again ...");
                }
            } else if (select == 3) {
                this.showHeader(select);
                if (tracker.delete(input.askStr("Enter id: "))) {
                    System.out.print(" Delete well done ...");
                } else {
                    System.out.print(" Delete error! Try again ...");
                }
            } else if (select == 4) {
                this.showHeader(select);
                Item item = tracker.findById(input.askStr("Enter id: "));
                if (item != null) {
                    System.out.println(item.getId() + ". " + item.getName());
                } else {
                    System.out.print(" Incorrect id! Try again ...");
                }
            } else if (select == 5) {
                this.showHeader(select);
                Item[] items = tracker.findByName(input.askStr("Enter name: "));
                if (items.length == 0) {
                    System.out.println("is empty ...");
                } else {
                    for (Item item : items) {
                        System.out.println(item.getId() + ". " + item.getName());
                    }
                }
            } else if (select == 6) {
                run = false;
            }
        }
    }

    private void showMenu() {
        this.showNewline();
        System.out.println("Menu.");
        System.out.println("0. Add new Item");
        System.out.println("1. Show all items");
        System.out.println("2. Replace item");
        System.out.println("3. Delete item");
        System.out.println("4. Find item by Id");
        System.out.println("5. Find items by name");
        System.out.println("6. Exit Program");
    }

    private void showHeader(int number) {
        if (number == 0) {
            this.showNewline();
            System.out.println(" Create a new item ... ");
        } else if (number == 1) {
            this.showNewline();
            System.out.println(" The list of items: ");
        } else if (number == 2) {
            this.showNewline();
            System.out.println(" Replace item ... ");
        } else if (number == 3) {
            this.showNewline();
            System.out.println(" Delete item ... ");
        } else if (number == 4) {
            this.showNewline();
            System.out.println(" Find item by id ... ");
        } else if (number == 5) {
            this.showNewline();
            System.out.println(" Find items by name ... ");
        }

    }

    private void showNewline() {
        System.out.println();
    }

    public static void main(String[] args) {
        Input input = new ConsoleInput();
        Tracker tracker = new Tracker();
        new StartUI().init(input, tracker);
    }
}
