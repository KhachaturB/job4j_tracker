package ru.job4j.professions;

import java.util.Date;

public class Dentist extends Doctor {

    public Dentist(String name, String surname, String education, Date birthday, boolean hasLicense) {
        super(name, surname, education, birthday, hasLicense);
    }

    public void healTooth() {

    }
}
