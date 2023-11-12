package christmas.domain;

import static christmas.utill.Constants.*;

import christmas.domain.Events.DdayEvent;
import christmas.domain.Events.PresentEvent;
import christmas.domain.Events.StarEvent;
import christmas.domain.Events.WeekdayEvent;
import christmas.domain.Events.WeekendEvent;
import christmas.utill.DateValidator;

public class BillCalculator {
    private final TotalEvent totalEvent;
    private final DdayEvent ddayEvent;
    private final StarEvent starEvent;
    private final PresentEvent presentEvent;
    private final Order order;
    private final int payAmount;

    public BillCalculator(TotalEvent totalEvent, Order order, int date) {
        this.totalEvent = totalEvent;
        this.order = order;
        this.ddayEvent = new DdayEvent();
        this.starEvent = new StarEvent();
        this.presentEvent = new PresentEvent();
        calculateAllEvent(date, order.getTotalPrice());
        payAmount = calculatePayAmount();
    }

    private void calculateAllEvent(int date, int totalPrice) {
        if (totalPrice >= 10000) {
            // 크리스마스 디데이 할인
            ddayEvent.getDdayDiscount(date, totalEvent);
            // 평일/주말 할인
            calculateWeekEvent(date);
            // 특별 할인
            starEvent.getStarDiscount(date, totalEvent);
            // 증정 이벤트
            presentEvent.getPresentEvent(order.getTotalPrice(), totalEvent);
        }
    }
    public String getPresentList(){
        return presentEvent.toString();
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
        return order.getTotalPrice() - totalEvent.getTotalBenefitWithoutPresent();
    }

    @Override
    public String toString() {
        StringBuilder result = new StringBuilder();
        return result.append(String.format("%,d", payAmount))
                .append(NEW_LINE)
                .toString();
    }
}
