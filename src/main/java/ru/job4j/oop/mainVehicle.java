package ru.job4j.oop;

public class mainVehicle {
    public static void main(String[] args) {
        Vehicle plane = new Plane();
        Vehicle train = new Train();
        Vehicle bus = new Bus();
        Vehicle[] vehicles = {plane, train, bus};
        for (Vehicle obj : vehicles) {
            obj.move();
        }
    }
}
