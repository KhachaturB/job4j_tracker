package ru.job4j.pojo;

public class Library {

    public static void main(String[] args) {
        Book book1 = new Book("Униженные и оскорбленные", 520);
        Book book2 = new Book("Атлант расправил плечи", 1130);
        Book book3 = new Book("Гиперболоид инженера Гарина", 350);
        Book book4 = new Book("Приключения капитана Врунгеля", 250);
        Book book5 = new Book("Clean code", 500);

        Book[] books = { book1, book2, book3, book4, book5 };

        for (Book book : books) {
            System.out.println(book.getName() + ": " + book.getPagesCount() + " стр.");
        }
        System.out.println();

        Book temp = books[0];
        books[0] = books[3];
        books[3] = temp;
        for (Book book : books) {
            System.out.println(book.getName() + ": " + book.getPagesCount() + " стр.");
        }
        System.out.println();

        for (Book book : books) {
            if ("Clean code".equals(book.getName())) {
                System.out.println(book.getName() + ": " + book.getPagesCount() + " стр.");
                break;
            }
        }
    }
}
