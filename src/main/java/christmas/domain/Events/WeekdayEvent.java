package christmas.domain.Events;

import christmas.domain.Order;
import christmas.domain.TotalEvent;

public class WeekdayEvent {
    private static final String EVENT_TITLE = "평일 할인";
    private static final int DISCOUNT_DEFAULT = 2023;

    public int calculateDiscount(Order order) {
        return DISCOUNT_DEFAULT * order.getDesertCount();
    }

    public void getWeekdayDiscount(TotalEvent totalEvent, Order order) {
        int discountAmount = calculateDiscount(order);
        if (discountAmount > 0) {
            totalEvent.updateBenefitHistory(EVENT_TITLE, discountAmount);
        }
    }

}
