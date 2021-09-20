import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.Month;

public class Main {

    public static void main(String[] args) {
        LocalDate randomDate = LocalDate.of(2018, Month.AUGUST, 27);
        DayOfWeek dayOfWeek = randomDate.getDayOfWeek();
        System.out.println(dayOfWeek);
        int dayOfWeekEnumValue = dayOfWeek.getValue();
        System.out.println(dayOfWeekEnumValue);

    }
}
