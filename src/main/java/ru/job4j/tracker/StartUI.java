package ru.job4j.tracker;

import java.util.ArrayList;
import java.util.List;

public class StartUI {

    public void init(Input input, Tracker tracker, List<UserAction> actions) {
        boolean run = true;
        while (run) {
            this.showMenu(actions);
            int select = input.askInt("Select: ", actions.size());
            UserAction action = actions.get(select);
            run = action.execute(input, tracker);
        }
    }

    private void showMenu(List<UserAction> actions) {
        System.out.println();
        System.out.println("Menu.");
        byte number = 0;
        for (UserAction action:actions) {
            System.out.println(number + ". " + action.showMenuHeader());
            number++;
        }

        for (int index = 0; index < actions.size(); index++) {
            System.out.println(index + ". " + actions.get(index).showMenuHeader());
        }
    }

    public static void main(String[] args) {
        Input input = new ValidateInput(new ConsoleInput());
        Tracker tracker = new Tracker();
        List<UserAction> actions = new ArrayList<>();
        actions.add(new CreateAction());
        actions.add(new FindAllAction());
        actions.add(new RenameAction());
        actions.add(new DeleteAction());
        actions.add(new FindByIDAction());
        actions.add(new FindByNameAction());
        actions.add(new ExitProgramAction());

        new StartUI().init(input, tracker, actions);
    }
}
