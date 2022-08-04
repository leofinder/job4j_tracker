package ru.job4j.ex;

public class FindEl {

    public static int indexOf(String[] value, String key) throws ElementNotFoundException {
        int rsl = -1;
        for (int i = 0; i < value.length; i++) {
            if (key.equals(value[i])) {
                rsl = i;
                break;
            }
        }
        if (rsl == -1) {
            throw new ElementNotFoundException("Не найден индекс искомого элемента");
        }
        return rsl;
    }

    public static void main(String[] args) {
        try {
            int index = FindEl.indexOf(new String[]{"I", "wanna", "find", "index"}, "yandex");
        } catch (ElementNotFoundException e) {
            e.printStackTrace();
        }
    }
}
