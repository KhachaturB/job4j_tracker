package ru.job4j.professions;

import java.util.Date;

public class Builder extends Engineer {

    public Builder(String name, String surname, String education, Date birthday) {
        super(name, surname, education, birthday);
    }

    public Drawing createDrawing(){
        return new Drawing();
    }

    public boolean testItem(ConstructionItem item){
        return false;
    }
}
