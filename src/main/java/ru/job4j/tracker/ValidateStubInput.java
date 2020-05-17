package ru.job4j.tracker;

public class ValidateStubInput extends ValidateInput {
    private String[] userInputs;
    private int position;

    public ValidateStubInput(String[] userInputs) {
        this.userInputs = userInputs;
    }

    @Override
    public String askStr(String question) {
        return userInputs[position++];
    }

}