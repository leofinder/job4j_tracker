package ru.job4j.tracker;

public class StudInput implements Input {
    private String[] answers;
    private int position = 0;

    public StudInput(String[] answers) {
        this.answers = answers;
    }

    @Override
    public String askString(String question) {
        return answers[position++];
    }

    @Override
    public int askInt(String question) {
        return Integer.parseInt(askString(question));
    }
}
