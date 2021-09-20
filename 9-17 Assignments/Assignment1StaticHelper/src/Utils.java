public class Utils {
    public static int compareByLength(String s1, String s2) {
        return s1.length() - s2.length();
    }

    public static int compareByReverseLength(String s1, String s2) {
        return s2.length() - s1.length();
    }

    public static int compareByFirstChar(String s1, String s2) {
        return s1.charAt(0) - s2.charAt(0);
    }

    public static int compareByContainE(String s1, String s2) {
        if (s1.contains("e") && !s2.contains("e")) {
            return -1;
        } else if (s1.contains("e") == s2.contains("e")) {
            return 0;
        } else {
            return 1;
        }
    }
}
