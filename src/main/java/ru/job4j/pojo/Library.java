package ru.job4j.pojo;

public class Library {

    public static void main(String[] args) {
        Book book1 = new Book("Униженные и оскорбленные", 520);
        Book book2 = new Book("Атлант расправил плечи", 1130);
        Book book3 = new Book("Гиперболоид инженера Гарина", 350);
        Book book4 = new Book("Приключения капитана Врунгеля", 250);
        Book book5 = new Book("Clean code", 500);

        Book[] books = { book1, book2, book3, book4, book5 };

        for (int i = 0; i < books.length; i++) {
            System.out.println(books[i].getName() + ": " + books[i].getPagesCount() + " стр.");
        }
        System.out.println();

        Book temp = books[0];
        books[0] = books[3];
        books[3] = temp;
        for (int i = 0; i < books.length; i++) {
            System.out.println(books[i].getName() + ": " + books[i].getPagesCount() + " стр.");
        }
        System.out.println();

        for (Book book : books) {
            if (book.getName().equals("Clean code")) {
                System.out.println(book.getName() + ": " + book.getPagesCount() + " стр.");
                break;
            }
        }
    }
}
