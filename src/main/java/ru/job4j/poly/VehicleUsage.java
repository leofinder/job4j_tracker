package ru.job4j.poly;

public class VehicleUsage {
    public static void main(String[] args) {
        Vehicle plane1 = new Plane();
        Vehicle train1 = new Train();
        Vehicle bus1 = new Bus();
        Vehicle plane2 = new Plane();
        Vehicle train2 = new Train();
        Vehicle bus2 = new Bus();

        Vehicle[] vehicles = new Vehicle[] {plane1, train1, bus1, plane2, train2, bus2};
        for (Vehicle vehicle : vehicles) {
            vehicle.move();
        }
    }
}
