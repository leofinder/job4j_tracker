package ru.job4j.pojo;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class College {
    public static void main(String[] args) {
        Student student = new Student();
        student.setFullName("Пупкин Иван Сергеевич");
        student.setGroup("ax-002023");
        student.setEntryDate(LocalDate.now());

        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy.MM.dd");
        String ln = System.lineSeparator();
        System.out.println("ФИО: " + student.getFullName() + ln
                            + "Группа: " + student.getGroup() + ln
                            + "Дата поступления: " + student.getEntryDate().format(formatter));
    }
}
