package ru.job4j.oop;

public class VehicleTrainingGround {

    public static void main(String[] args) {
        Vehicle aircraft = new Aircraft();
        Vehicle train = new Train();
        Vehicle car = new Car();

        Vehicle[] vehicles = { aircraft, train, car };
        for (Vehicle vehicle : vehicles) {
            vehicle.move();
        }
    }
}
