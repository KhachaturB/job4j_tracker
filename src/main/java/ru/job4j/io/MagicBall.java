package ru.job4j.io;

import java.util.Random;
import java.util.Scanner;

public class MagicBall {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Я великий Оракул. Что ты хочешь узнать? ");
        String question = scanner.nextLine();
        int answerCode = new Random().nextInt(3);
        switch (answerCode) {
            case 0 -> System.out.println("Да");
            case 1 -> System.out.println("Нет");
            default -> System.out.println("Может быть");
        }
    }
}
