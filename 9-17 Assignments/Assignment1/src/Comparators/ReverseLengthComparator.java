package Comparators;

import java.util.Comparator;

public class ReverseLengthComparator implements Comparator<String> {

    @Override
    public int compare(String s, String t1) {
        return t1.length() - s.length();
    }
}
