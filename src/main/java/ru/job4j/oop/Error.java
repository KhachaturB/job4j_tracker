package ru.job4j.oop;

public class Error {

    private boolean active;

    private int status;

    private String message;

    public Error() {

    }

    public Error(boolean active, int status, String message) {
        this.active = active;
        this.status = status;
        this.message = message;
    }

    public void printInfo() {
        System.out.println("Ошибка активан: " + active);
        System.out.println("Статус ошибки: " + status);
        System.out.println("Сообщение: " + message);
        System.out.println();
    }

    public static void main(String[] args) {
        Error emptyError = new Error();
        Error error1 = new Error(false, 3, "Error 1");
        Error error2 = new Error(true, 1, "Error 2");
        Error error3 = new Error(true, 2, "Error 3");

        emptyError.printInfo();
        error1.printInfo();
        error2.printInfo();
        error3.printInfo();
    }
}
