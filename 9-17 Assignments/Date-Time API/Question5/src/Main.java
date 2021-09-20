import java.time.*;

public class Main {

    /*  Date-Time API Question 5
    *   Write an example that, for a given year, reports the length of each month within that year. */

    public static void main(String[] args) {
        // Given year
        Year year = Year.of(2012);

        System.out.println("Lengths of each month in the year " + year + ":");

        for (int i = 1; i <= 12; ++i) {
            YearMonth month = YearMonth.of(year.getValue(), i);
            System.out.print(month.getMonth() + ": ");
            int days = month.lengthOfMonth();
            System.out.println(days + " days");
        }
    }
}
