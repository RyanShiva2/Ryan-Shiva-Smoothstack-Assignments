import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.Month;

public class Main {

    /*  Question 7
        Write an example that tests whether a given date occurs on Friday the 13th.*/

    public static void main(String[] args) {
	    // Given Date
        LocalDate date = LocalDate.of(2021, Month.AUGUST, 13);

        // Test if Friday the 13th
        if (date.getDayOfWeek() == DayOfWeek.FRIDAY && date.getDayOfMonth() == 13) {
            System.out.println("The day " + date + " is Friday the 13th.");
        } else {
            System.out.println("The day " + date + " is not Friday the 13th.");
        }
    }
}
