package ru.job4j.professions;

import java.util.Date;

public class Doctor extends Profession {

    private boolean hasLicense;

    public Doctor(String name, String surname, String education, Date birthday, boolean hasLicense) {
        super(name, surname, education, birthday);
        this.hasLicense = hasLicense;
    }

    public boolean getHasLicense() {
        return hasLicense;
    }
}
