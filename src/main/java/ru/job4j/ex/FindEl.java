package ru.job4j.ex;

public class FindEl {

    public static int indexOf(String[] value, String key)
            throws ElementNotFoundException {
        for (int i = 0; i < value.length; i++) {
            if (value[i].equals(key)) {
                return i;
            }
        }
        throw new ElementNotFoundException("Element not found");
    }

    public static void main(String[] args) {
        String[] values = {"1", "2", "3"};
        String key = "4";
        try {
            indexOf(values, key);
        } catch (ElementNotFoundException e) {
            e.printStackTrace();
        }
    }
}
