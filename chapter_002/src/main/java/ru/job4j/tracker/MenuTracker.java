package ru.job4j.tracker;

public class MenuTracker {

    /**
     *  хранит ссылку на объект
     */
    private Input input;
    /**
     *  хранит ссылку на объект
     */
    private Tracker tracker;
    /**
     * хранит ссылку на массив типа UserAction
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
    private class CreateItem extends BaseAction {

        public CreateItem(int key, String name) {
            super(key, name);
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
    }

    /**
     * Внутренний класс для получения списка всех заявок
     */
    private class GetAllItems extends BaseAction {

        public GetAllItems(int key, String name) {
            super(key, name);
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
    }

    /**
     * Внутренний класс для редактирования заявки
     */
    private class EditItem extends BaseAction {

        public EditItem(int key, String name) {
            super(key, name);
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
    }


    /**
     * Внутренний класс для удаления заявки
     */
    private class DeleteItem extends BaseAction {

        public DeleteItem(int key, String name) {
            super(key, name);
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
    }


    /**
     * Внутренний класс для поиска заявки по ID
     */
    private class FindByIdItem extends BaseAction {

        public FindByIdItem(int key, String name) {
            super(key, name);
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
    }

    /**
     * Внутренний класс для поиска заявки по названию
     */
    private class FindItemsByName extends BaseAction {

        public FindItemsByName(int key, String name) {
            super(key, name);
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
    }

    /**
     * Внутренний класс для выхода из программы
     */
    private class ExitProgram extends BaseAction {

        public ExitProgram(StartUI ui, int key, String name) {
            super(ui, key, name);
        }

        public void execute(Input input, Tracker tracker) {
            this.ui.stop();
        }
    }

    /**
     * Метод заполняет массив.
     */
    public void fillActions(StartUI ui) {
        this.actions[0] = this.new CreateItem(0, "Add new item");
        this.actions[1] = this.new GetAllItems(1, "Show all items");
        this.actions[2] = this.new EditItem(2, "Edit item");
        this.actions[3] = this.new DeleteItem(3, "Delete item");
        this.actions[4] = this.new FindByIdItem(4, "Find item by ID");
        this.actions[5] = this.new FindItemsByName(5, "Find items by name");
        this.actions[6] = this.new ExitProgram(ui, 6, "Exit program");
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
