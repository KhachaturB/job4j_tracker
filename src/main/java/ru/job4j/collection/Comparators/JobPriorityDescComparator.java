package ru.job4j.collection.Comparators;

import ru.job4j.collection.Job;

import java.util.Comparator;

public class JobPriorityDescComparator implements Comparator<Job> {

    @Override
    public int compare(Job o1, Job o2) {
        return Integer.compare(o2.getPriority(), o1.getPriority());
    }
}
