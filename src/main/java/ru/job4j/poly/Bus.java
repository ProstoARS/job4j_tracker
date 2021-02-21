package ru.job4j.poly;

public class Bus implements Transport{
    @Override
    public void drive() {
        System.out.println("The Bus is driving");
    }

    @Override
    public void passengers(int count) {
        System.out.println("The bus carries "+ count + " passengers");
    }

    @Override
    public double fillUp(int fuel) {
        return fuel * 1.5;
    }
}
