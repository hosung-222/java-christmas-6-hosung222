package christmas.domain.Events;

import christmas.domain.Order;
import christmas.domain.TotalEvent;

public class WeekendEvent {
    private static final String EVENT_TITLE = "주말 할인";
    private static final int DISCOUNT_DEFAULT = 2023;

    public void getWeekendDiscount(TotalEvent totalEvent, Order order) {
        totalEvent.updateBenefitHistory(EVENT_TITLE, calculateDiscount(order));
    }

    private int calculateDiscount(Order order) {
        return DISCOUNT_DEFAULT *order.getMainCount();
    }
}
