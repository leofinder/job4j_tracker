package ru.job4j.collection;

import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class DepDescComp implements Comparator<String> {
    @Override
    public int compare(String d1, String d2) {
        String[] dep1 = d1.split("/");
        String[] dep2 = d2.split("/");
        int rsl = dep2[0].compareTo(dep1[0]);
        return rsl == 0 ? d1.compareTo(d2) : rsl;
    }
}
