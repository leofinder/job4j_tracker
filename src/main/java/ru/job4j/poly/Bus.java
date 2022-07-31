package ru.job4j.poly;

public class Bus implements Transport, Vehicle {
    @Override
    public void drive() {

    }

    @Override
    public void passengers(int count) {

    }

    @Override
    public double tankup(int count) {
        return 0;
    }

    @Override
    public void move() {
        System.out.println("Автобус двигается по скоростным трассам");
    }
}