package ru.job4j.tracker;

public class ValidateInput extends ConsoleInput {

    public int ask(String question, int[] range) {

        boolean invalid = true;
        int value = -1;
        do {
            try {
                value = super.ask(question, range);
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
