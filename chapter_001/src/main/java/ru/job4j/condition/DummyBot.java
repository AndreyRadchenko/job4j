package ru.job4j.condition;

/**
 * Программа отвечает на переданные строки
 * @author Radchenko Andrey (radchenko@yandex.ru)
 * @since 27.05.2019
 * @version 1.0
 */
public class DummyBot {
    /**
     * Отвечает на вопросы.
     * @param question Вопрос от клиента.
     * @return Ответ.
     */
    public String answer(String question) {
        String rsl = "Это ставит меня в тупик. Задайте другой вопрос.";
        if ("Привет, Бот.".equals(question)) {
            rsl = "Привет, умник.";
        } else if ("Пока.".equals(question)) {
              rsl = "До скорой встречи.";
        }
        return rsl;
    }
}
