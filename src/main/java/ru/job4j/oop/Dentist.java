package ru.job4j.oop;

public class Dentist extends Doctor {
    private int price;

    public Dentist(String name, String surname, String education, String birthday, Pacient pacient,
                   String journal, String receptionTime, int salary, int price) {
        super(name, surname, education, birthday, pacient, journal, receptionTime,salary);
        this.price = price;
    }

    public String diagnosis(Pacient pacient) {
        return " ";
    }

    public boolean xRay(Pacient pacient) {
        return false;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }
}
