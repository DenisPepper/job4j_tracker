package ru.job4j.tracker;

public class StartUI {

    public void init(Input input, Tracker tracker, UserAction[] actions) {
        boolean run = true;
        while (run) {
            this.showMenu(actions);
            int select = input.askInt("Select: ");
            this.showMethodHeader(select);
            UserAction action = actions[select];
            run = action.execute(input, tracker);
        }
    }

    private void showMenu(UserAction[] actions) {
        System.out.println();
        System.out.println("Menu.");
        for (int index = 0; index < actions.length; index++) {
            System.out.println(index + ". " + actions[index].showMenuHeader());
        }
    }

    private void showMethodHeader(int select) {
        if (select == 0) {
            System.out.println();
            System.out.println(" Create a new item ... ");
        } else if (select == 1) {
            System.out.println();
            System.out.println(" The list of items: ");
        } else if (select == 2) {
            System.out.println();
            System.out.println(" Replace item ... ");
        } else if (select == 3) {
            System.out.println();
            System.out.println(" Delete item ... ");
        } else if (select == 4) {
            System.out.println();
            System.out.println(" Find item by id ... ");
        } else if (select == 5) {
            System.out.println();
            System.out.println(" Find items by name ... ");
        }
    }

    public static void main(String[] args) {
        Input input = new ConsoleInput();
        Tracker tracker = new Tracker();
        UserAction[] actions = {
                new CreateAction(),
                new FindAllAction(),
                new RenameAction(),
                new DeleteAction(),
                new FindByIDAction(),
                new FindByNameAction(),
                new ExitProgramAction()
        };
        new StartUI().init(input, tracker, actions);
    }
}
