package ru.job4j.collection;

import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class DepDescComp implements Comparator<String> {
    @Override
    public int compare(String d1, String d2) {
        List<String> dep1 = Departments.fillGaps(Collections.singletonList(d1));
        List<String> dep2 = Departments.fillGaps(Collections.singletonList(d2));
        for (int i = 0; i < Math.min(dep1.size(), dep2.size()); i++) {
            int rsl = i == 0 ? dep2.get(i).compareTo(dep1.get(i)) : dep1.get(i).compareTo(dep2.get(i));
            if (rsl != 0) {
                return rsl;
            }
        }
        return Integer.compare(dep1.size(), dep2.size());
    }
}
