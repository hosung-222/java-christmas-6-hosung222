package christmas.domain;

import christmas.domain.Events.DdayEvent;
import christmas.domain.Events.PresentEvent;
import christmas.domain.Events.StarEvent;
import christmas.domain.Events.WeekdayEvent;
import christmas.domain.Events.WeekendEvent;
import christmas.utill.DateValidator;

public class BillCalculator {

    public static final String NEXT_LINE = "\n";
    public static final String PAY_AMOUNT_SUFFIX = "원";
    private final TotalEvent totalEvent;
    private final Order order;
    private final int payAmount;

    public BillCalculator(TotalEvent totalEvent, Order order, int date) {
        this.totalEvent = totalEvent;
        this.order = order;
        calculateAllEvent(date);
        payAmount = calculatePayAmount();
    }

    private void calculateAllEvent(int date) {
        DdayEvent ddayEvent = new DdayEvent();
        ddayEvent.getDdayDiscount(date, totalEvent);
        calculateWeekEvent(date);

        StarEvent starEvent = new StarEvent();
        starEvent.getStarDiscount(date, totalEvent);

        PresentEvent presentEvent = new PresentEvent();
        presentEvent.getPresentEvent(order.getTotalPrice(), totalEvent);
    }

    private void calculateWeekEvent(int date) {
        if (DateValidator.isWeekday(date)) {
            WeekdayEvent weekdayEvent = new WeekdayEvent();
            weekdayEvent.getWeekdayDiscount(totalEvent, order);

        } else if (DateValidator.isWeekend(date)) {
            WeekendEvent weekendEvent = new WeekendEvent();
            weekendEvent.getWeekendDiscount(totalEvent, order);
        }
    }

    private int calculatePayAmount() {
        return order.getTotalPrice() - totalEvent.getTotalBenefit();
    }

    @Override
    public String toString() {
        StringBuilder result = new StringBuilder();
        return result.append(String.format("%,d", payAmount))
                .append(PAY_AMOUNT_SUFFIX)
                .append(NEXT_LINE)
                .toString();
    }
}
