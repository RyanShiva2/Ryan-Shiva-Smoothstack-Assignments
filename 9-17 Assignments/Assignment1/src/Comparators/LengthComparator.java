package Comparators;

import java.util.Comparator;

public class LengthComparator implements Comparator<String> {

    @Override
    public int compare(String s, String t1) {
        return s.length() - t1.length();
    }
}
