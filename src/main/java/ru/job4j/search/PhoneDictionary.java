package ru.job4j.search;

import java.util.ArrayList;
import java.util.function.Predicate;

public class PhoneDictionary {
    private ArrayList<Person> persons = new ArrayList<>();

    public void add(Person person) {
        this.persons.add(person);
    }

    public ArrayList<Person> find(String key) {
        Predicate<Person> isName = p -> p.getName().contains(key);
        Predicate<Person> isSurname = p -> p.getSurname().contains(key);
        Predicate<Person> isAddress = p -> p.getAddress().contains(key);
        Predicate<Person> isPhone = p -> p.getPhone().contains(key);
        Predicate<Person> combine = isName.or(isSurname.or(isAddress.or(isPhone)));
        var result = new ArrayList<Person>();
        for (var person : persons) {
            if (combine.test(person)) {
                result.add(person);
            }
        }
        return result;
    }
}
