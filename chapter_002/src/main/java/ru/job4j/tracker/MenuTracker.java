package ru.job4j.tracker;

public class MenuTracker {

    /**
     *  хранит ссылку на объект .
     */
    private Input input;
    /**
     *  хранит ссылку на объект .
     */
    private Tracker tracker;
    /**
     * хранит ссылку на массив типа UserAction.
     */
    private UserAction[] actions = new UserAction[7];

    /**
     * Конструктор.
     *
     * @param input   объект типа Input
     * @param tracker объект типа Tracker
     */
    public MenuTracker(Input input, Tracker tracker) {
        this.input = input;
        this.tracker = tracker;
    }

    /**
     * Метод для получения массива меню.
     *
     * @return длину массива
     */
    public int getActionsLength() {
        return this.actions.length;
    }

    /**
     * Внутренний класс для создания заявки
     */
    private class CreateItem implements UserAction {

        public int key() {
            return 0;
        }

        public  void execute(Input input, Tracker tracker) {

            System.out.println("------------ Добавление новой заявки --------------");
            String name = input.ask("Введите имя заявки :");
            String desc = input.ask("Введите описание заявки :");
            long create = System.currentTimeMillis();
            Item item = new Item(name, desc, create);
            tracker.add(item);
            System.out.println("------------ Новая заявка с ID : " + item.getId() + " -----------");

        }

        public  String info() {
            return String.format("%s. %s", this.key(), "Add new item");
        }
    }

    /**
     * Внутренний класс для получения списка всех заявок
     */
    private class GetAllItems implements UserAction {

        public int key() {
            return 1;
        }

        public  void execute(Input input, Tracker tracker) {

            Item[] item = tracker.getAll();
            if (item.length != 0) {
                System.out.println("------------ Список всех заявок --------------");
                for (Item i : item) {
                    System.out.println("Имя заявки: " + i.getName());
                    System.out.println("Описание заявки: " + i.getDesc());
                    System.out.println("ID заявки: " + i.getId());
                    System.out.println();
                }
                System.out.println("------------ Конец списка --------------");
            } else {
                System.out.println("------------ Список заявок пуст --------------");
            }

        }

        public  String info() {
            return String.format("%s. %s", this.key(), "Show all items");
        }
    }

    /**
     * Внутренний класс для редактирования заявки
     */
    private class EditItem implements UserAction {

        public int key() {
            return 2;
        }

        public  void execute(Input input, Tracker tracker) {

            System.out.println("------------ Замена заявки --------------");
            String id = input.ask("Введите ID заявки для редактирования:");
            if (tracker.findById(id) != null) {
                String name = input.ask("Введите новое имя заявки :");
                String desc = input.ask("Введите новое описание заявки :");
                long create = System.currentTimeMillis();
                Item item = new Item(name, desc, create);
                tracker.replace(id, item);
                System.out.println("------------ Заявка изменена --------------");
            } else {
                System.out.println("------------ Заявка с данным ID не найдена --------------");
            }

        }

        public  String info() {
            return String.format("%s. %s", this.key(), "Edit item");
        }
    }


    /**
     * Внутренний класс для удаления заявки
     */
    private class DeleteItem implements UserAction {

        public int key() {
            return 3;
        }

        public  void execute(Input input, Tracker tracker) {

            System.out.println("------------ Удаление заявки --------------");
            String id = input.ask("Введите ID заявки для удаления");
            if (tracker.delete(id)) {
                System.out.println("------------ Заявка удалена --------------");
            } else {
                System.out.println("------------ Заявка с данным ID не найдена --------------");
            }

        }

        public  String info() {
            return String.format("%s. %s", this.key(), "Delete item");
        }
    }

    /**
     * Внутренний класс для поиска заявки по ID
     */
    private class FindByIdItem implements UserAction {

        public int key() {
            return 4;
        }

        public  void execute(Input input, Tracker tracker) {

            System.out.println("------------ Поиск заявки по ID --------------");
            String id = input.ask("Введите ID заявки для поиска");
            Item item = tracker.findById(id);
            if (item != null) {
                System.out.println("Имя заявки: " + item.getName());
                System.out.println("Описание заявки: " + item.getDesc());
                System.out.println("ID заявки: " + item.getId());
                System.out.println();
                System.out.println("------------ Результат поиска --------------");
            } else {
                System.out.println("------------ Заявка с данным ID не найдена --------------");
            }

        }

        public  String info() {
            return String.format("%s. %s", this.key(), "Find item by ID");
        }
    }

    /**
     * Внутренний класс для поиска заявки по названию
     */
    private class FindItemsByName implements UserAction {

        public int key() {
            return 5;
        }

        public  void execute(Input input, Tracker tracker) {

            System.out.println("------------ Поиск заявки по имени --------------");
            String key = input.ask("Введите имя заявки для поиска");
            Item[] item = tracker.findByName(key);
            if (item.length != 0) {
                for (Item i : item) {
                    System.out.println("Имя заявки: " + i.getName());
                    System.out.println("Описание заявки: " + i.getDesc());
                    System.out.println("ID заявки: " + i.getId());
                    System.out.println();
                }
                System.out.println("------------ Все заявки с таким именем --------------");
            } else {
                System.out.println("------------ Заявки с таким именем не найдено --------------");
            }

        }

        public  String info() {
            return String.format("%s. %s", this.key(), "Find items by name");
        }
    }

    /**
     * Внутренний класс для выхода из программы
     */
    private class ExitProgram implements UserAction {

        private final StartUI ui;

        ExitProgram(StartUI ui) {
            this.ui = ui;
        }
        public int key() {
            return 6;
        }

        public  void execute(Input input, Tracker tracker) {
            this.ui.stop();
        }

        public  String info() {
            return String.format("%s. %s", this.key(), "Exit program");
        }
    }

    /**
     * Метод заполняет массив.
     */
    public void fillActions(StartUI ui) {
        this.actions[0] = this.new CreateItem();
        this.actions[1] = this.new GetAllItems();
        this.actions[2] = this.new EditItem();
        this.actions[3] = this.new DeleteItem();
        this.actions[4] = this.new FindByIdItem();
        this.actions[5] = this.new FindItemsByName();
        this.actions[6] = this.new ExitProgram(ui);
    }

    /**
     * Метод в зависимости от указанного ключа, выполняет соотвествующие действие.
     *
     * @param key ключ операции
     */
    public void select(int key) {
        this.actions[key].execute(this.input, this.tracker);
    }

    /**
     * Метод выводит на экран меню.
     */
    public void show() {

        System.out.println("Меню.");
        for (UserAction action : this.actions) {
            if (action != null) {
                System.out.println(action.info());
            }
        }
    }
}
