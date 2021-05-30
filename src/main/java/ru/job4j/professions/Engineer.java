package ru.job4j.professions;

public class Engineer extends Profession {

    public Model createModel(){
        return new Model();
    }

    public boolean testModel(Model model) {
        return false;
    }
}
