package ru.job4j.tracker;

import java.util.Arrays;
import java.util.Random;

/**
 * Выполнение пунктов меню
 * @author Radchenko Andrey (radchenko@yandex.ru)
 * @since 12.07.2019
 * @version 1.0
 */
public class Tracker {

    /**
     * Массив для хранение заявок.
     */
    private Item[] items = new Item[100];

    /**
     * Указатель ячейки для новой заявки.
     */
    private int position = 0;

    /**
     * Генерация номера ID
     */
    private static final Random RN = new Random();

    /**
     * Метод реализующий добавление заявки в хранилище
     * @param item новая заявка
     * @return возвращает добавленный объект
     */
    public Item add(Item item) {
        item.setId(this.generateId());
        this.items[this.position++] = item;
        return item;
    }

    /**
     * Замена ячейки в массиве
     * @param id ячейки для замены
     * @param item заявка на которую производится замена
     * @return результат замены
     */
    public boolean replace(String id, Item item) {
        boolean result = false;
        if (item != null) {
            for (int i = 0; i < position; i++) {
                if (items[i].getId().equals(id)) {
                    items[i] = item;
                    result = true;
                    break;
                }
            }
        }

        return result;
    }

    /**
     * Удаление заявки в массиве
     * @param id заявки
     * @return результат удаления
     */
    public boolean delete(String id) {
        boolean result = false;
        for (int index = 0; index < position; index++) {
            if (items[index].getId().equals(id)) {
                System.arraycopy(items, index + 1, items, index, position - index);
                position--;
                result = true;
                break;
            }
        }
        return result;
    }

    /**
     * Получение списка всех заявок
     * @return список заявок
     */
    public Item[] getAll() {
        return Arrays.copyOf(this.items, this.position);
    }

    /**
     * Поиск заявки по имени
     * @param key Имя для поиска
     * @return результат поиска
     */
    public Item[] findByName(String key) {
        Item[] tmp = new Item[this.position];
        int pos = 0;
        for (int i = 0; i < position; i++) {
            if (items[i] != null && key.equals(items[i].getName())) {
                tmp[pos++] = items[i];
            }
        }
        Item[] result = new Item[pos];
        System.arraycopy(tmp, 0, result, 0, pos);
        return result;
    }

    /**
     * Поиск заявки по id
     * @param id заявки
     * @return результат поиска
     */
    public Item findById(String id) {
        Item result = null;
        if (items.length != 0) {
            for (int i = 0; i < position; i++) {
                if (items[i] != null && items[i].getId().equals(id)) {
                    result = items[i];
                    break;
                }
            }
        }
        return result;
    }

    /**
     * Метод генерирует уникальный ключ для заявки.
     * Так как у заявки нет уникальности полей, имени и описание. Для идентификации нам нужен уникальный ключ.
     * @return Уникальный ключ.
     */
    private String generateId() {
        return String.valueOf(System.currentTimeMillis() + RN.nextInt());
    }
}
