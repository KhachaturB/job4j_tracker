package ru.job4j.collection;

import java.util.Comparator;

public class LexSort implements Comparator<String> {

    @Override
    public int compare(String left, String right) {
        var leftParts = left.split("\\.");
        var leftIndex = Integer.parseInt(leftParts[0]);
        var rightParts = right.split("\\.");
        var rightIndex = Integer.parseInt(rightParts[0]);

        return Integer.compare(leftIndex, rightIndex);
    }
}
