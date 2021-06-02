package ru.job4j.poly;

public class Bus implements Transport {

    private int passengers;

    private int fuel;

    private int fuelPrice;

    @Override
    public void go() {
        System.out.println("Bus is gone");
    }

    @Override
    public void passengers(int count) {
        passengers = count;
    }

    @Override
    public int refuel(int liters) {
        fuel += liters;
        return liters * fuelPrice;
    }
}
