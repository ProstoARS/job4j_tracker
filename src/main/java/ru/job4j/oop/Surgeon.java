package ru.job4j.oop;

public class Surgeon extends Doctor {
    private int price;

    public Surgeon(String name, String surname, String education, String birthday, Pacient pacient,
                   String journal, String receptionTime, int salary, int price) {
        super(name, surname, education, birthday, pacient, journal, receptionTime, salary);
        this.price = price;
    }

    public String diagnosis(Pacient pacient) {
        return " ";
    }

    public boolean xRay(Pacient pacient) {
        return false;
    }

    public boolean surgery(Pacient pacient) {
        return false;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }
}
