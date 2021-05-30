package ru.job4j.professions;

public class Builder extends Engineer {

    public Drawing createDrawing(){
        return new Drawing();
    }

    public boolean testItem(ConstructionItem item){
        return false;
    }
}
