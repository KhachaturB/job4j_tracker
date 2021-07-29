package ru.job4j.tracker;

import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class ItemTest {

    @Test
    public void straightOrderSort() {
        Item item1 = new Item(1, "Item 1");
        Item item2 = new Item(2, "Item 2");
        Item item3 = new Item(3, "Item 3");

        List<Item> items = new ArrayList<>();
        items.add(item2);
        items.add(item3);
        items.add(item1);

        Item[] expected = {
            item1,
            item2,
            item3
        };

        Collections.sort(items);

        Assert.assertArrayEquals(expected, items.toArray());
    }

    @Test
    public void reverseOrderSort() {
        Item item1 = new Item(1, "Item 1");
        Item item2 = new Item(2, "Item 2");
        Item item3 = new Item(3, "Item 3");

        List<Item> items = new ArrayList<>();
        items.add(item2);
        items.add(item3);
        items.add(item1);

        Item[] expected = {
                item3,
                item2,
                item1
        };

        items.sort(new ItemReverseComparator());

        Assert.assertArrayEquals(expected, items.toArray());
    }
}
