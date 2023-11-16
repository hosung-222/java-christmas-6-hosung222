package christmas.domain.Events;

import static christmas.enums.Menus.*;
import christmas.domain.TotalEvent;
import java.util.HashMap;
import java.util.Map;

public class PresentEvent {
    private static final String EVENT_TITLE = "증정 이벤트";
    private static final int MINIMUM_AMOUNT_FOR_PRESENT = 120000;
    private static final int CHAMPAGNE_PRESENT_PRICE = 25000;
    private static final int CHAMPAGNE_PRESENT_AMOUNT = 1;
    private final Map<String, Integer> present = new HashMap<>();   // Map < 증정 선물 이름 : 수량 >
    private final Map<String, Integer> presentEventResult = new HashMap<>();

    public boolean isPresentEventApplicable(int totalAmount) {
        return totalAmount >= MINIMUM_AMOUNT_FOR_PRESENT;
    }

    public void applyPresentEvent(int totalAmount, TotalEvent totalEvent) {
        if (isPresentEventApplicable(totalAmount)) {
            present.put(CHAMPAGNE.getName(), CHAMPAGNE_PRESENT_AMOUNT);
            //<증정 메뉴>  추가 "샴페인" : 1
            presentEventResult.put(CHAMPAGNE.getName(), present.get(CHAMPAGNE.getName()));
            // <혜택 내역> 업데이트 "증정 이벤트" : 25000
            totalEvent.updateBenefitHistory(EVENT_TITLE, CHAMPAGNE_PRESENT_PRICE);
        }
    }

    public Map<String,Integer> getPresentEventResult(){
        return presentEventResult;
    }

    public Map<String, Integer> getPresent(){
        return present;
    }
}
