import java.time.*;

public class Main {

    /*  Question 6
        Write an example that, for a given month of the current year, lists all of the Mondays in that month.*/

    public static void main(String[] args) {
        // Get Current Year
        Year year = Year.now();

        // Given Month
        YearMonth month = YearMonth.of(year.getValue(), Month.JANUARY);

        System.out.println("List of all of the Mondays in the month of " + month.getMonth() + " " + month.getYear() + ":");

        for (int i = 1; i <= month.atEndOfMonth().getDayOfMonth(); ++i) {
            LocalDate date = month.atDay(i);
            if (date.getDayOfWeek().equals(DayOfWeek.MONDAY)) {
                System.out.println(date);
            }
        }
    }
}
