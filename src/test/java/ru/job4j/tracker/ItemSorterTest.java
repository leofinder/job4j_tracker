package ru.job4j.tracker;

import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import static org.assertj.core.api.Assertions.*;

class ItemSorterTest {
    @Test
    public void whenSortItemAscByName() {
        Item first = new Item(1, "Первый");
        Item second = new Item(2, "Второй");
        Item third = new Item(3, "Третий");
        List<Item> items = Arrays.asList(
                first,
                second,
                third
        );
        Collections.sort(items, new ItemAscByName());
        List<Item> expected = Arrays.asList(
                second,
                first,
                third
        );
        assertThat(items).isEqualTo(expected);
    }

    @Test
    public void whenSortItemDescByName() {
        Item first = new Item(1, "Первый");
        Item second = new Item(2, "Второй");
        Item third = new Item(3, "Третий");
        List<Item> items = Arrays.asList(
                first,
                second,
                third
        );
        Collections.sort(items, new ItemDescByName());
        List<Item> expected = Arrays.asList(
                third,
                first,
                second
        );
        assertThat(items).isEqualTo(expected);
    }
}