import java.util.Scanner;

public class Main {

    /*  Assignment 1: Lambdas
        Write the following methods that return a lambda expression performing a specified action
        PerformOperation isOdd(): The lambda expression must return  if a number is odd or  if it is even.
        PerformOperation isPrime(): The lambda expression must return  if a number is prime or  if it is composite.
        PerformOperation isPalindrome(): The lambda expression must return  if a number is a palindrome or  if it is not.

*/

    public static void main(String[] args) {
        // Get number of test cases
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();

        for (int i = 0; i < n; ++i) {
            // Get operation number
            int opCode = scanner.nextInt();

            // Get number to be checked
            int value = scanner.nextInt();

            switch (opCode) {
                case 1:
                    System.out.println(isOdd().performOperation(value));
                    break;
                case 2:
                    System.out.println(isPrime().performOperation(value));
                    break;
                case 3:
                    System.out.println(isPalindrome().performOperation(value));
                    break;
            }
        }
    }

    public static PerformOperation isOdd() {
        return num -> {
            if (num % 2 == 0) {
                return "EVEN";
            } else {
                return "ODD";
            }
        };
    }

    public static PerformOperation isPrime() {
        return num -> {
            for (int i = 2; i < num; ++i) {
                if (num % i == 0) {
                    return "COMPOSITE";
                }
            }
            return "PRIME";
        };
    }

    public static PerformOperation isPalindrome() {
        return num -> {
            String numString = num.toString();
            for (int i = 0; i < numString.length() / 2 - 1; ++i) {
                if (numString.charAt(i) != numString.charAt(numString.length() - 1 - i)) {
                    return "NOT PALINDROME";
                }
            }
            return "PALINDROME";
        };
    }
}