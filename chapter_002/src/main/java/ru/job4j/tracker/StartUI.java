package ru.job4j.tracker;


public class StartUI {
    /**
     * Константа меню для добавления новой заявки.
     */
    private static final String ADD = "0";

    /**
     * Константа меню для получения списка всех заявок.
     */
    private static final String GETALL = "1";

    /**
     * Константа меню для редактирования заявки.
     */
    private static final String EDIT = "2";

    /**
     * Константа меню для удаления заявки.
     */
    private static final String DELETE = "3";

    /**
     * Константа меню для поиска заявки по ID.
     */
    private static final String FINDBYID = "4";

    /**
     * Константа меню для поиска заявки по имени.
     */
    private static final String FINDBYNAME = "5";
    /**
     * Константа для выхода из цикла.
     */
    private static final String EXIT = "6";
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
        boolean exit = false;
        while (!exit) {
            this.showMenu();
            String answer = this.input.ask("Введите пункт меню : ");
            if (ADD.equals(answer)) {
                this.createItem();
            } else if (GETALL.equals(answer)) {
                this.getAllItems();
            } else  if (EDIT.equals(answer)) {
                this.editItem();
            } else  if (DELETE.equals(answer)) {
                this.deleteItem();
            } else  if (FINDBYID.equals(answer)) {
                this.findByIdItem();
            } else  if (FINDBYNAME.equals(answer)) {
                this.findByNameItem();
            } else if (EXIT.equals(answer)) {
                exit = true;
            }
        }
    }

    /**
     * Метод реализует добавленяи новый заявки в хранилище.
     */
    private void createItem() {
        System.out.println("------------ Добавление новой заявки --------------");
        String name = this.input.ask("Введите имя заявки :");
        String desc = this.input.ask("Введите описание заявки :");
        long create = System.currentTimeMillis();
        Item item = new Item(name, desc, create);
        this.tracker.add(item);
        System.out.println("------------ Новая заявка с getId : " + item.getId() + "-----------");
    }

    private void getAllItems() {
        System.out.println("------------ Список всех заявок --------------");
        Item[] item = this.tracker.getAll();
        for (Item i : item) {
            System.out.println("Имя заявки: " + i.getName());
            System.out.println("Описание заявки: " + i.getDesc());
            System.out.println("ID заявки: " + i.getId());
            System.out.println();
        }
        System.out.println("------------ Конец списка --------------");
    }

    private void editItem() {
        System.out.println("------------ Замена заявки --------------");
        String id = this.input.ask("Введите ID заявки для редактирования:");
        String name = this.input.ask("Введите новое имя заявки :");
        String desc = this.input.ask("Введите новое описание заявки :");
        long create = System.currentTimeMillis();
        Item item = new Item(name, desc, create);
        this.tracker.replace(id, item);
        System.out.println("------------ Заявка изменена --------------");
    }

    private void deleteItem() {
        System.out.println("------------ Удаление заявки --------------");
        String id = this.input.ask("Введите ID заявки для удаления");
        this.tracker.delete(id);
        System.out.println("------------ Заявка удалена --------------");
    }

    private void findByIdItem() {
        System.out.println("------------ Поиск заявки по ID--------------");
        String id = this.input.ask("Введите ID заявки для поиска");
        Item item = this.tracker.findById(id);
        System.out.println("Имя заявки: " + item.getName());
        System.out.println("Описание заявки: " + item.getDesc());
        System.out.println("ID заявки: " + item.getId());
        System.out.println();
        System.out.println("------------ Результат поиска --------------");
    }

    private void findByNameItem() {
        System.out.println("------------ Поиск заявки по имени--------------");
        String key = this.input.ask("Введите имя заявки для поиска");
        Item[] item = this.tracker.findByName(key);
        for (Item i : item) {
            System.out.println("Имя заявки: " + i.getName());
            System.out.println("Описание заявки: " + i.getDesc());
            System.out.println("ID заявки: " + i.getId());
            System.out.println();
        }
        System.out.println("------------ Все заявки с таким именем --------------");
    }

    private void showMenu() {
        System.out.println("Меню.");
        System.out.println("0. Add new item");
        System.out.println("1. Show all items");
        System.out.println("2. Edit item");
        System.out.println("3. Delete item");
        System.out.println("4. Find item by ID");
        System.out.println("5. Find items by name");
        System.out.println("6. Exit program");
        // добавить остальные пункты меню.
    }

    /**
     * Запуск программы.
     * @param args аргументы
     */
    public static void main(String[] args) {
        new StartUI(new ConsoleInput(), new Tracker()).init();
    }
}
