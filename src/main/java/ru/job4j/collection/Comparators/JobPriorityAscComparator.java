package ru.job4j.collection.Comparators;

import ru.job4j.collection.Job;

import java.util.Comparator;

public class JobPriorityAscComparator implements Comparator<Job> {

    @Override
    public int compare(Job o1, Job o2) {
        return Integer.compare(o1.getPriority(), o2.getPriority());
    }
}
