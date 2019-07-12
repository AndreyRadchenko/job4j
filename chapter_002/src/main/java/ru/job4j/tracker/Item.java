package ru.job4j.tracker;

import java.util.Objects;

/**
 * Каркас заявки
 * @author Radchenko Andrey (radchenko@yandex.ru)
 * @since 10.07.2019
 * @version 1.0
 */
public class Item {
    private String id;

    private String name;

    private String desc;

    private long created;

    public Item(String name, String desc, long created) {
        this.name = name;
        this.desc  = desc;
        this.created = created;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }

    public long getCreated() {
        return created;
    }

    public void setCreated(long created) {
        this.created = created;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Item item = (Item) o;
        return created == item.created &&
                Objects.equals(id, item.id) &&
                Objects.equals(name, item.name) &&
                Objects.equals(desc, item.desc);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, desc, created);
    }
}