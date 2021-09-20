package Comparators;

import java.util.Comparator;

public class ContainEComparator implements Comparator<String> {

    @Override
    public int compare(String s, String t1) {
        if (s.contains("e") && !t1.contains("e")) {
            return -1;
        } else if (s.contains("e") == t1.contains("e")) {
            return 0;
        } else {
            return 1;
        }
    }
}