package christmas.domain;

public class DdayEvent {

    private final int EVENT_START_DAY = 1;
    private final int EVENT_END_DAY = 25;
    private final int DISCOUNT_START_POINT = 1000;
    private final int DISCOUNT_AMOUNT = 100;
    private int dDayDiscountAmount;

    public boolean validateDate(int date){
        return EVENT_START_DAY <= date && date <= EVENT_END_DAY;
    }

    public int getDdayDiscount(int date){
        if(validateDate(date)){
            dDayDiscountAmount = DISCOUNT_START_POINT + DISCOUNT_AMOUNT * (date-EVENT_START_DAY);
        }
        return dDayDiscountAmount;
    }


}
