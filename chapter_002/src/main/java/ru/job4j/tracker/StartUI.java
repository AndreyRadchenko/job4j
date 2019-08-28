package ru.job4j.tracker;


public class StartUI {

    /**
     * @param хранит переменную для выхода из программы
     */
    private String exit = "n";

    /**
     * Получение данных от пользователя.
     */
    private final Input input;

    /**
     * Хранилище заявок.
     */
    private final Tracker tracker;

    /**
     * Конструтор инициализирующий поля.
     * @param input ввод данных.
     * @param tracker хранилище заявок.
     */
    public StartUI(Input input, Tracker tracker) {
        this.input = input;
        this.tracker = tracker;
    }

    /**
     * Основой цикл программы.
     */
    public void init() {
        MenuTracker menu = new MenuTracker(this.input, tracker);
        menu.fillActions(this);
        do {
            menu.show();
            int key = Integer.valueOf(input.ask("Введите пункт меню : "));
            menu.select(key);
        } while (!"y".equals(this.exit));
    }

    public void stop() {
        this.exit = "y";
    }

    /**
     * Запуск программы.
     * @param args аргументы
     */
    public static void main(String[] args) {
        new StartUI(new ConsoleInput(), new Tracker()).init();
    }
}
