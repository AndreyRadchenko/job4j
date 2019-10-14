package ru.job4j.tracker;

public abstract class BaseAction implements UserAction {

    private  final  int key;
    private  final String name;
    StartUI ui = new StartUI(new ValidateInput(new ConsoleInput()), new Tracker());

    protected BaseAction(final int key, final String name) {
        this.key = key;
        this.name = name;
    }

    protected BaseAction(final StartUI ui, final int key, final String name) {
        this.key = key;
        this.name = name;
        this.ui = ui;
    }

    @Override
    public int key() {
        return this.key;
    }

    @Override
    public String info() {
        return String.format("%s. %s", this.key, this.name);
    }
}
