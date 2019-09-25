package ru.job4j.tracker;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

public class StartUITest {

    private final PrintStream stdout = System.out;
    private final ByteArrayOutputStream out = new ByteArrayOutputStream();
    private final String menu = "Меню.\r\n"
            + "0. Add new item\r\n"
            + "1. Show all items\r\n"
            + "2. Edit item\r\n"
            + "3. Delete item\r\n"
            + "4. Find item by ID\r\n"
            + "5. Find items by name\r\n"
            + "6. Exit program\r\n"
            + "Введите пункт меню : \r\n";

    @Before
    public void loadOutput() {
        System.out.println("execute before method");
        System.setOut(new PrintStream(this.out));
    }

    @After
    public void backOutput() {
        System.setOut(this.stdout);
        System.out.println("execute after method");
    }

    @Test
    public void whenUserAddItemThenTrackerHasNewItemWithSameName() {
        Tracker tracker = new Tracker();
        Input input = new StubInput(new String[]{"0", "test name", "desc", "6"});
        new StartUI(input, tracker).init();
        assertThat(tracker.getAll()[0].getName(), is("test name"));
    }

    @Test
    public void whenUpdateThenTrackerHasUpdatedValue() {
        Tracker tracker = new Tracker();
        long create = System.currentTimeMillis();
        Item item = tracker.add(new Item("test name", "desc", create));
        Input input = new StubInput(new String[]{"2", item.getId(), "test replace", "заменили заявку", "6"});
        new StartUI(input, tracker).init();
        assertThat(tracker.findById(item.getId()).getName(), is("test replace"));
    }

    @Test
    public void whenUserDeleteAloneItemThenTrackerIsEmpty() {
        Tracker tracker = new Tracker();
        long create = System.currentTimeMillis();
        Item item = tracker.add(new Item("test name", "desc", create));
        Input input = new StubInput(new String[]{"3", item.getId(), "6"});
        new StartUI(input, tracker).init();
        assertThat(tracker.getAll().length, is(0));
    }

    @Test
    public void whenCallGetAllThenTrackerHasShowedAllItems() {
        Tracker tracker = new Tracker();
        long create = System.currentTimeMillis();
        Item item = tracker.add(new Item("name 1", "desc 1", create));
        Input input = new StubInput(new String[]{"1", "6"});
        new StartUI(input, tracker).init();
        assertThat(
                out.toString(),
                is(
                        new StringBuilder()
                                .append(menu
                                        + "------------ Список всех заявок --------------\r\n"
                                        + "Имя заявки: name 1\r\n"
                                        + "Описание заявки: desc 1\r\n"
                                        + "ID заявки: ")
                                .append(item.getId() + "\r\n")
                                .append("\r\n"
                                        + "------------ Конец списка --------------\r\n"
                                        + menu)
                                .toString()
                )
        );
        System.setOut(stdout);
    }

    @Test
    public void whenFindByIdThenTrackerHasShowedThisItem() {
        Tracker tracker = new Tracker();
        long create = System.currentTimeMillis();
        Item item = tracker.add(new Item("name 1", "desc 1", create));
        Input input = new StubInput(new String[]{"4", item.getId(), "6"});
        new StartUI(input, tracker).init();
        assertThat(
                out.toString(),
                is(
                        new StringBuilder()
                                .append(menu
                                        + "------------ Поиск заявки по ID --------------\r\n"
                                        + "Введите ID заявки для поиска\r\n"
                                        + "Имя заявки: name 1\r\n"
                                        + "Описание заявки: desc 1\r\n"
                                        + "ID заявки: ")
                                .append(item.getId() + "\r\n")
                                .append("\r\n"
                                        + "------------ Результат поиска --------------\r\n"
                                        + menu)
                                .toString()
                )
        );
        System.setOut(stdout);
    }

    @Test
    public void whenFindByNameThenTrackerHasShowedThisItems() {
        Tracker tracker = new Tracker();
        long create = System.currentTimeMillis();
        Item item = tracker.add(new Item("name 1", "desc 1", create));
        Input input = new StubInput(new String[]{"5", "name 1", "6"});
        new StartUI(input, tracker).init();
        assertThat(
                out.toString(),
                is(
                        new StringBuilder()
                                .append(menu
                                        + "------------ Поиск заявки по имени --------------\r\n"
                                        + "Введите имя заявки для поиска\r\n"
                                        + "Имя заявки: name 1\r\n"
                                        + "Описание заявки: desc 1\r\n"
                                        + "ID заявки: ")
                                .append(item.getId() + "\r\n")
                                .append("\r\n"
                                        + "------------ Все заявки с таким именем --------------\r\n"
                                        + menu)
                                .toString()
                )
        );
        System.setOut(stdout);
    }

    @Test
    public void whenInvalidInput() {
        ValidateInput input = new ValidateInput(
                new StubInput(new String[]{"invalid", "1"})
        );
        input.ask("Введите пункт меню : ", new int[]{1});
        assertThat(
                out.toString(),
                is(
                        String.format("Введите пункт меню : \r\n"
                                + "Введённые данные некорректны. Введите цифру\r\n"
                                + "Введите пункт меню : \r\n")
                )
        );
    }
}