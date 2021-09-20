import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class MainTest {

    @Test
    void isOddTest() {
        assertEquals(Main.isOdd().performOperation(17), "ODD");
        assertEquals(Main.isOdd().performOperation(18), "EVEN");
    }

    @Test
    void isPrimeTest() {
        assertEquals(Main.isPrime().performOperation(29), "PRIME");
        assertEquals(Main.isPrime().performOperation(30), "COMPOSITE");
    }

    @Test
    void isPalindromeTest() {
        // Palindrome with odd number of digits
        assertEquals(Main.isPalindrome().performOperation(147858741), "PALINDROME");
        // Palindrome with even number of digits
        assertEquals(Main.isPalindrome().performOperation(1783443871), "PALINDROME");

        assertEquals(Main.isPalindrome().performOperation(1783447436), "NOT PALINDROME");
    }
}