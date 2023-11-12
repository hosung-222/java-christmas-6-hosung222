package christmas.domain.Events;

import christmas.domain.Order;
import christmas.domain.TotalEvent;

public class WeekendEvent {
    private static final String EVENT_TITLE = "주말 할인";
    private static final int DISCOUNT_DEFAULT = 2023;

    public void getWeekendDiscount(TotalEvent totalEvent, Order order) {
        int discountAmount = calculateDiscount(order);
        if (discountAmount > 0) {
            totalEvent.updateBenefitHistory(EVENT_TITLE, calculateDiscount(order));
        }
    }

    public int calculateDiscount(Order order) {
        return DISCOUNT_DEFAULT * order.getMainCount();
    }
}
