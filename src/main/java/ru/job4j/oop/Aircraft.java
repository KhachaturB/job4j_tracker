package ru.job4j.oop;

public class Aircraft implements Vehicle {

    @Override
    public void move() {
        System.out.println("Летит по небу.");
    }
}
