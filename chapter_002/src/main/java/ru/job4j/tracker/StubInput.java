package ru.job4j.tracker;

public class StubInput implements Input {

    private final String[] value;
    private int position = 0;

    public StubInput(final String[] value) {
        this.value = value;
    }

    public String ask(String question) {
        System.out.println(question);
        return this.value[this.position++];
    }

    public int ask(String question, int[] range) {
        System.out.println(question);
        int key = Integer.valueOf(this.value[this.position++]);
        boolean exist = false;
        for (int value: range) {
            if (value == key) {
                exist = true;
                break;
            }
        }
        if (!exist) {
            throw new MenuOutException("Необходимо ввести цифру из диапазона меню. Введите ещё раз");
        }
        return key;
    }
}
