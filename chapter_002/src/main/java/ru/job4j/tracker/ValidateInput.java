package ru.job4j.tracker;

public class ValidateInput implements Input {

    private final Input input;

    public ValidateInput(final Input input) {
        this.input = input;
    }

    @Override
    public String ask(String question) {
        return this.input.ask(question);
    }

    public int ask(String question, int[] range) {

        boolean invalid = true;
        int value = -1;
        do {
            try {
                value = this.input.ask(question, range);
                invalid = false;
            } catch (MenuOutException moe) {
                System.out.println("Необходимо ввести цифру из диапазона меню. Введите ещё раз");
            } catch (NumberFormatException nfe) {
                System.out.println("Введённые данные некорректны. Введите цифру");
            }
        } while (invalid);
        return value;
    }
}
