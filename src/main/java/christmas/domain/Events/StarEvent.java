package christmas.domain.Events;

import christmas.domain.TotalEvent;
import java.util.Arrays;
import java.util.List;

public class StarEvent {
    private static final String EVENT_TITLE = "특별 할인";
    private static final int DISCOUNT_AMOUNT = 1000;
    private static final List<Integer> STAR_DATES = Arrays.asList(3, 10, 17, 24, 25, 31);


    public void applyStarDiscount(int date, TotalEvent totalEvent) {
        if (STAR_DATES.contains(date)) {
            // 별이 있는 날에만 할인 적용
            totalEvent.updateBenefitHistory(EVENT_TITLE, DISCOUNT_AMOUNT);
        }
    }
}
