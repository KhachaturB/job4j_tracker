package ru.job4j.pojo;

import java.time.LocalDate;

public class College {

    public static void main(String[] args) {
        Student student = new Student();
        student.setFio("Иван Васильевич Иванов");
        student.setGroup("6G-13");
        student.setReceiptDate(LocalDate.now());

        System.out.println(student.getFio() +
                " учится в группе " + student.getGroup() +
                " и принят на учебу " + student.getReceiptDate());
    }
}
