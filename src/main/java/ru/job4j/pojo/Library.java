package ru.job4j.pojo;

public class Library {
    public static void main(String[] args) {
        Book robinzon = new Book("Robinzon Kruzo");
        Book lolita = new Book("Lolita");
        Book cleanCode = new Book("Clean code");
        Book kapital = new Book("Kapital");
        Book[] lib = new Book[4];
        lib[0] = robinzon;
        lib[1] = lolita;
        lib[2] = cleanCode;
        lib[3] = kapital;
        for (int i = 0; i < lib.length; i++) {
            System.out.println(lib[i].getName());
        }
        System.out.println("Переставляем книги '0' и '3'");
        lib[0] = kapital;
        lib[3] = robinzon;
        for (int i = 0; i < lib.length; i++) {
            System.out.println(lib[i].getName());
        }
        System.out.println("Выводим только Clean code");
        for (int i = 0; i < lib.length; i++) {
            if (lib[i].getName().equals("Clean code")){
                System.out.println(lib[i].getName());
            }
        }
    }
}
