package christmas.domain.Events;

import christmas.domain.TotalEvent;

public class DdayEvent {
    private static final String EVENT_TITLE = "크리스마스 디데이 할인";
    private static final int EVENT_START_DAY = 1;
    private static final int EVENT_END_DAY = 25;
    private static final int DISCOUNT_START_POINT = 1000;
    private static final int DISCOUNT_AMOUNT = 100;

    public int calculateDiscountAmount(int date){
        return DISCOUNT_START_POINT + DISCOUNT_AMOUNT * (date-EVENT_START_DAY);
    }

    public boolean validateDate(int date){
        return EVENT_START_DAY <= date && date <= EVENT_END_DAY;
    }

    public void applyDdayDiscount(int date , TotalEvent totalEvent){
        if(validateDate(date)){
            // <혜택 내역> 업데이트 "크리스마스 디데이 할인" : discountAmount
            totalEvent.updateBenefitHistory(EVENT_TITLE, calculateDiscountAmount(date));
        }
    }


}
