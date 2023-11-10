package christmas.domain.Events;

import christmas.domain.TotalEvent;
import java.util.HashMap;
import java.util.Map;

public class WeekdayEvent {
    private static final String PRESENT_EVENT_TITLE = "평일 할인";
    private int weekdayDiscountAmount;

    public void getWeekdayDiscount(TotalEvent totalEvent){

        totalEvent.updateBenefitHistory(PRESENT_EVENT_TITLE, 2023 );
    }

}
