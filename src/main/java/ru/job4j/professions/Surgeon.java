package ru.job4j.professions;

import java.util.Date;

public class Surgeon extends Doctor {

    public Surgeon(String name, String surname, String education, Date birthday,
                   boolean hasLicense) {
        super(name, surname, education, birthday, hasLicense);
    }

    public void performOperation() {

    }
}
