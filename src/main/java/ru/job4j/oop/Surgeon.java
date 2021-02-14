package ru.job4j.oop;

public class Surgeon extends Doctor {
    private int price;

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
