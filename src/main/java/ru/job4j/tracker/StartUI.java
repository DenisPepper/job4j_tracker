package ru.job4j.tracker;

public class StartUI {

    public void init( Input input, Tracker tracker) {
        boolean run = true;
        while (run) {
            this.showMenu();
            int select = input.askInt("Select: ");

            if (select == 0) {
                this.showHeader(select);
                StartUI.createItem(input, tracker);

            } else if (select == 1) {
                this.showHeader(select);
                StartUI.findAllItems(tracker);

            } else if (select == 2) {
                this.showHeader(select);
                StartUI.renameItem(input, tracker);

            } else if (select == 3) {
                this.showHeader(select);
                StartUI.deleteItem(input, tracker);

            } else if (select == 4) {
                this.showHeader(select);
                StartUI.findItemById(input, tracker);
                
            } else if (select == 5) {
                this.showHeader(select);
                StartUI.findItemByName(input, tracker);

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
        System.out.println("2. Rename item");
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

    public static void createItem(Input input, Tracker tracker) {
        String name = input.askStr("Enter name: ");
        Item item = new Item(name);
        tracker.add(item);
    }

    public static void findAllItems(Tracker tracker) {
        Item[] items = tracker.findAll();
        if (items.length == 0) {
            System.out.println("is empty ...");
        } else {
            for (Item item : items) {
                System.out.println(item.getId() + ". " + item.getName());
            }
        }
    }

    public static void renameItem(Input input, Tracker tracker) {
        String id = input.askStr("Enter id: ");
        Item item = new Item(input.askStr("Enter new name: "));
        if (tracker.replace(id,item)) {
            System.out.print(" Replace well done ...");
        } else {
            System.out.print(" Replace error! Try again ...");
        }
    }

    public static void deleteItem(Input input, Tracker tracker) {
        if (tracker.delete(input.askStr("Enter id: "))) {
            System.out.print(" Delete well done ...");
        } else {
            System.out.print(" Delete error! Try again ...");
        }
    }

    public static void findItemById(Input input, Tracker tracker) {
        Item item = tracker.findById(input.askStr("Enter id: "));
        if (item != null) {
            System.out.println(item.getId() + ". " + item.getName());
        } else {
            System.out.print(" Incorrect id! Try again ...");
        }
    }

    public static void findItemByName(Input input, Tracker tracker) {
        Item[] items = tracker.findByName(input.askStr("Enter name: "));
        if (items.length == 0) {
            System.out.println("is empty ...");
        } else {
            for (Item item : items) {
                System.out.println(item.getId() + ". " + item.getName());
            }
        }
    }
    
    public static void main(String[] args) {
        Input input = new ConsoleInput();
        Tracker tracker = new Tracker();
        new StartUI().init(input, tracker);
    }
}
