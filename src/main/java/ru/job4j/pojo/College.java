package ru.job4j.pojo;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
public class College {
    public static void main(String[] args) {
        Student kozyavkin = new Student();
        kozyavkin.setName("Козявкин Кузьма Владленович");
        kozyavkin.setGroup("Балистики полёта козявок");
        kozyavkin.setDate(LocalDate.of(2020,02,20));


        System.out.println(kozyavkin.getName() + " зачислен на курс " + kozyavkin.getGroup() + " "
                + kozyavkin.getDate().format(DateTimeFormatter.ofPattern("dd-MMMM-EEEE-yyyy")) + " числа.");
    }
}
