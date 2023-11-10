package christmas.domain.Events;

import christmas.domain.Order;
import christmas.domain.TotalEvent;
import java.util.HashMap;
import java.util.Map;

public class WeekdayEvent {
    private static final String EVENT_TITLE = "평일 할인";
    private static final int DISCOUNT_DEFAULT = 2023;
    private int weekdayDiscountAmount;
    public int calculateDiscount(Order order){
        return DISCOUNT_DEFAULT *order. getDesertCount();
    }

    public void getWeekdayDiscount(TotalEvent totalEvent, Order order){

        totalEvent.updateBenefitHistory(EVENT_TITLE, calculateDiscount(order));
    }

}
