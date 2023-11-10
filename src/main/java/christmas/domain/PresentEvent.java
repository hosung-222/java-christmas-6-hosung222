package christmas.domain;

import java.util.HashMap;
import java.util.Map;

public class PresentEvent {
    private static final String PRESENT_EVENT_TITLE = "증정 이벤트";
    private static final int MINIMUM_AMOUNT_FOR_PRESENT = 120000;
    private static final int CHAMPAGNE_PRESENT_PRICE = 25000;
    private static final String CHAMPAGNE_PRESENT_NAME ="샴페인";
    private static final int CHAMPAGNE_PRESENT_AMOUNT = 1;
    private final Map<String, Integer> present = new HashMap<>();

    public PresentEvent(){
        present.put(CHAMPAGNE_PRESENT_NAME, CHAMPAGNE_PRESENT_AMOUNT);
    }

    public boolean isPresentEventApplicable(int totalAmount){
        return totalAmount>MINIMUM_AMOUNT_FOR_PRESENT;
    }

    public Map<String, Integer> getPresentEvent(int totalAmount, TotalEvent totalEvent){
        Map<String, Integer> presentEventResult = new HashMap<>();
        if (isPresentEventApplicable(totalAmount)){
            presentEventResult.put(CHAMPAGNE_PRESENT_NAME, present.get(CHAMPAGNE_PRESENT_NAME));
        }
        return presentEventResult;
    }

}
