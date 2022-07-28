package ru.job4j.tracker;

import java.time.format.DateTimeFormatter;

public class StartUI {
    public static void main(String[] args) {
        Item item = new Item();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MMMM-EEEE-yyyy HH:mm:ss");
        System.out.println("Item created: " + item.getCreated().format(formatter));
        Item item2 = new Item(2, "Item 2");
        System.out.println(item2);
    }
}
