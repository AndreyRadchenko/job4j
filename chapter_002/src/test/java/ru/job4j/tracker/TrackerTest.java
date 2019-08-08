package ru.job4j.tracker;

import org.junit.Test;
import static org.hamcrest.Matchers.is;
import static org.junit.Assert.*;

/**
 * Test
 * @author Andrey Radchenko (radchenko@yandex.ru)
 * @since 12.07.2019
 * @version 1.0
 */
public class TrackerTest {

    /**
     * Тест метода на добавление заявки
     */
    @Test
    public void whenAddNewItemThenTrackerHasSameItem() {
        Tracker tracker = new Tracker();
        long created = System.currentTimeMillis();
        Item item = new Item("test1", "testDescription", created);
        tracker.add(item);
        Item result = tracker.findById(item.getId());
        assertThat(result.getName(), is(item.getName()));
    }

    /**
     * Тест метода на замену заявки в массиве
     */
    @Test
    public void whenReplaceNameThenReturnNewName() {
        Tracker tracker = new Tracker();
        Item previous = new Item("test1", "testDescription", 123L);
        tracker.add(previous);
        Item next = new Item("test2", "testDescription2", 1234L);
        next.setId(previous.getId());
        tracker.replace(previous.getId(), next);
        assertThat(tracker.findById(previous.getId()).getName(), is("test2"));
    }
    /**
     * Тест метода на удаление заявки
     */
    @Test
    public void delete() {
        Tracker tracker = new Tracker();
        Item first = new Item("test1", "testDescription", 123L);
        tracker.add(first);
        Item second = new Item("test2", "testDescription2", 1234L);
        tracker.add(second);
        Item third = new Item("test3", "testDescription3", 12345L);
        tracker.add(third);
        assertThat(tracker.delete(second.getId()), is(true));
    }
    /**
     * Тест метода на получение списка заявок
     */
    @Test
    public void getAll() {
        Tracker tracker = new Tracker();
        Item first = new Item("test1", "testDescription", 123L);
        tracker.add(first);
        Item second = new Item("test2", "testDescription2", 1234L);
        tracker.add(second);
        Item[] control = {first, second};
        assertThat(tracker.getAll(), is(control));
    }
    /**
     * Тест метода на поиск заявки по имени
     */
    @Test
    public void findByName() {
        Tracker tracker = new Tracker();
        Item first = new Item("test1", "testDescription", 123L);
        tracker.add(first);
        Item second = new Item("test2", "testDescription2", 1234L);
        tracker.add(second);
        Item third = new Item("test1", "testDescription3", 12345L);
        tracker.add(third);
        Item[] control = {first, third};
        assertThat(tracker.findByName("test1"), is(control));
    }
    /**
     * Тест метода на поиск заявки по id
     */
    @Test
    public void findById() {
        Tracker tracker = new Tracker();
        Item first = new Item("test1", "testDescription", 123L);
        tracker.add(first);
        Item second = new Item("test2", "testDescription2", 1234L);
        tracker.add(second);
        assertThat(tracker.findById(second.getId()), is(second));
    }
}