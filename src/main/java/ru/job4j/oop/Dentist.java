package ru.job4j.oop;

public class Dentist extends Doctor {
    private int price;

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
