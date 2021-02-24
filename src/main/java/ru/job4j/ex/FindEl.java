package ru.job4j.ex;

public class FindEl {
    public static int indexOf(String[] value, String key) throws ElementNotFoundException {
        int rsl = -1;
        for (int i = 0; i < value.length; i++) {
            if (value[i].equals(key)) {
                rsl = i;
            } else {
                throw new ElementNotFoundException("Element Not Found");
            }
        }
        return rsl;
    }

    public static void main(String[] args) {
        try {
           int index =  indexOf(new String[] {"not bug"}, "bug");
        } catch (ElementNotFoundException e) {
            e.printStackTrace();
        }
    }

}

