package ru.job4j.array;

/**
 * Обертка над строкой.
 * @author Radchenko Andrey (radchenko@yandex.ru)
 * @since 04.06.2019
 * @version 1.0
 */
public class ArrayChar {

    /**
     * Проверяет. что слово начинается с префикса.
     * @param prefix префикс.
     * @return true если слово начинаеться с префикса
     */
    public boolean startsWith(String word, String prefix) {
        boolean result = true;
        char[] pref = prefix.toCharArray();
        char[] wrd = word.toCharArray();
        for (int i = 0; i < pref.length; i++) {
            if (pref[i] != wrd[i]) {
                result = false;
                break;// проверить. что массив data имеет первые элементы одинаковые с value
            }
        }
        return result;
    }
}

