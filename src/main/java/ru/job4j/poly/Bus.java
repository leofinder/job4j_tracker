package ru.job4j.poly;

public class Bus implements Transport, Vehicle {
    private final static double OIL_PRICE = 0.75;
    private boolean isMoved;

    @Override
    public void drive() {
        isMoved = true;
    }

    @Override
    public void passengers(int count) {
        System.out.println("Количество пассажиров в автобусе: " + count);
    }

    @Override
    public double tankup(int count) {
        return OIL_PRICE * count;
    }

    @Override
    public void move() {
        System.out.println("Автобус двигается по скоростным трассам");
    }
}