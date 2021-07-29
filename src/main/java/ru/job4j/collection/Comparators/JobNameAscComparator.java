package ru.job4j.collection.Comparators;

import ru.job4j.collection.Job;

import java.util.Comparator;

public class JobNameAscComparator implements Comparator<Job> {

    @Override
    public int compare(Job o1, Job o2) {
        return o1.getName().compareTo(o2.getName());
    }
}
