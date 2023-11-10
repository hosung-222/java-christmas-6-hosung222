package christmas.utill;

import java.time.DayOfWeek;
import java.time.LocalDate;

public class DateValidator {

    // 숫자로 받은 날짜가 평일인지 체크하는 메서드
    public static boolean isWeekday(int dayOfMonth) {
        LocalDate date = LocalDate.of(2023, 12, dayOfMonth);
        DayOfWeek dayOfWeek = date.getDayOfWeek();
        return dayOfWeek != DayOfWeek.FRIDAY && dayOfWeek != DayOfWeek.SATURDAY;
    }

    // 숫자로 받은 날짜가 주말인지 체크하는 메서드
    public static boolean isWeekend(int dayOfMonth) {
        return !isWeekday(dayOfMonth);
    }

}
