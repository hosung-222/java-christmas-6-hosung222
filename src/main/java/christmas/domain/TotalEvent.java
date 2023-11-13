package christmas.domain;


import christmas.domain.Events.DdayEvent;
import christmas.domain.Events.PresentEvent;
import christmas.domain.Events.StarEvent;
import christmas.domain.Events.WeekdayEvent;
import christmas.domain.Events.WeekendEvent;
import christmas.utill.DateValidator;
import java.util.HashMap;
import java.util.Map;

public class TotalEvent {
    private static final String EVENT_TITLE = "증정 이벤트";
    private final Map<String, Integer> benefitHistory = new HashMap<>();
    private final DdayEvent ddayEvent;
    private final StarEvent starEvent;
    private final PresentEvent presentEvent;
    private final WeekdayEvent weekdayEvent;
    private final WeekendEvent weekendEvent;
    private Order order;
    private int totalBenefit;

    public TotalEvent() {
        totalBenefit = 0;
        ddayEvent = new DdayEvent();
        weekdayEvent = new WeekdayEvent();
        weekendEvent = new WeekendEvent();
        presentEvent = new PresentEvent();
        starEvent = new StarEvent();
    }

    public void applyDdayEvent(int date) {

        ddayEvent.getDdayDiscount(date, this);

    }

    public void applyWeekEvent(int date, Order order) {
        if (DateValidator.isWeekday(date)) {
            weekdayEvent.getWeekdayDiscount(this, order);
        } else if (DateValidator.isWeekend(date)) {
            weekendEvent.getWeekendDiscount(this, order);
        }
    }

    public void applyStarEvent(int date) {
        starEvent.getStarDiscount(date, this);
    }

    public void applyPresentEvent(int totalPrice) {
        presentEvent.getPresentEvent(totalPrice, this);
    }

    public void updateBenefitHistory(String eventName, int discountAmount) {
        // 기존 혜택 내역이 있는지 확인 후 할인 금액 추가
        int currentAmount = benefitHistory.getOrDefault(eventName, 0);
        benefitHistory.put(eventName, currentAmount + discountAmount);
    }

    public Map<String, Integer> getBenefitHistory() {
        return benefitHistory;
    }

    // 실 할인 금액
    public int getTotalBenefitWithoutPresent() {
        int realTotalBenefit = 0;
        for (Map.Entry<String, Integer> entry : benefitHistory.entrySet()) {
            String benefitName = entry.getKey();
            Integer benefitAmount = entry.getValue();

            // 증정 상품이 아닌 경우에만 실 할인 적용
            if (!benefitName.equals(EVENT_TITLE)) {
                realTotalBenefit += benefitAmount;
            }
        }
        return realTotalBenefit;
    }

    // 총 할인 금액
    public int getTotalBenefit() {
        int totalBenefit = 0;
        for (Map.Entry<String, Integer> entry : benefitHistory.entrySet()) {
            Integer benefitAmount = entry.getValue();
            totalBenefit += benefitAmount;
        }
        return totalBenefit;
    }

    public Map<String, Integer> getPresent() {
        return presentEvent.getPresent();
    }
}
