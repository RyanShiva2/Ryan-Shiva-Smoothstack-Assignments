package Comparators;

import java.util.Comparator;

public class FirstCharComparator implements Comparator<String> {

    @Override
    public int compare(String s, String t1) {
        return s.charAt(0) - t1.charAt(0);
    }
}