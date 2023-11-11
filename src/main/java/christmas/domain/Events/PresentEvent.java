package christmas.domain.Events;

import christmas.domain.TotalEvent;
import java.util.HashMap;
import java.util.Map;

public class PresentEvent {
    private static final String EVENT_TITLE = "증정 이벤트";
    private static final int MINIMUM_AMOUNT_FOR_PRESENT = 120000;
    private static final int CHAMPAGNE_PRESENT_PRICE = 25000;
    private static final String CHAMPAGNE_PRESENT_NAME = "샴페인";
    private static final int CHAMPAGNE_PRESENT_AMOUNT = 1;
    private final Map<String, Integer> present = new HashMap<>();   // Map < 증정 선물 이름 : 수량 >

    public PresentEvent() {
        present.put(CHAMPAGNE_PRESENT_NAME, CHAMPAGNE_PRESENT_AMOUNT);
    }

    public boolean isPresentEventApplicable(int totalAmount) {
        return totalAmount > MINIMUM_AMOUNT_FOR_PRESENT;
    }

    public Map<String, Integer> getPresentEvent(int totalAmount, TotalEvent totalEvent) {
        Map<String, Integer> presentEventResult = new HashMap<>();
        if (isPresentEventApplicable(totalAmount)) {
            //<증정 메뉴> return "샴페인" : 1
            presentEventResult.put(CHAMPAGNE_PRESENT_NAME, present.get(CHAMPAGNE_PRESENT_NAME));
            // <혜택 내역> 업데이트 "증정 이벤트" : 25000
            totalEvent.updateBenefitHistory(EVENT_TITLE, CHAMPAGNE_PRESENT_PRICE);
        }
        return presentEventResult;
    }

}
