package ru.job4j.professions;

import java.util.Date;

public class Programmer extends Engineer {

    private String language;

    public Programmer(String name, String surname, String education, Date birthday,
                      String language) {
        super(name, surname, education, birthday);
        this.language = language;
    }

    public String getLanguage() {
        return language;
    }

    public void performTask() {

    }
}
