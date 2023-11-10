package christmas.domain;

import christmas.domain.Events.DdayEvent;
import christmas.domain.Events.WeekdayEvent;
import christmas.domain.Events.WeekendEvent;
import christmas.utill.DateValidator;

public class BillCalculator {
    private final TotalEvent totalEvent;

    public BillCalculator(TotalEvent totalEvent, DateValidator dateValidator) {
        this.totalEvent = totalEvent;
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

        } else if (DateValidator.isWeekend(date)) {
            WeekendEvent weekendEvent = new WeekendEvent();
        }
    }
}
