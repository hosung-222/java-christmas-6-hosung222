package christmas.domain;

import christmas.domain.Events.DdayEvent;
import christmas.domain.Events.WeekdayEvent;
import christmas.domain.Events.WeekendEvent;
import christmas.utill.DateValidator;

public class BillCalculator {
    private final TotalEvent totalEvent;
    private final Order order;

    public BillCalculator(TotalEvent totalEvent, Order order) {
        this.totalEvent = totalEvent;
        this.order = order;
    }

    public void calculateTotalAmount(){

    }
    public void calculateAllEvent(int date){
        DdayEvent ddayEvent = new DdayEvent();
        ddayEvent.getDdayDiscount(date, totalEvent);
        calculateWeekEvent(date);
    }

    public void calculateWeekEvent(int date){
        if (DateValidator.isWeekday(date)){
            WeekdayEvent weekdayEvent = new WeekdayEvent();
            weekdayEvent.getWeekdayDiscount(totalEvent, order);

        } else if (DateValidator.isWeekend(date)) {
            WeekendEvent weekendEvent = new WeekendEvent();
            weekendEvent.getWeekendDiscount(totalEvent, order);
        }
    }
}
