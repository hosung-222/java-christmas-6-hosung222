package christmas.domain;

import static christmas.utill.Constants.*;

import christmas.utill.Constants;
import java.util.HashMap;
import java.util.Map;

public class TotalEvent {
    private static final String EVENT_TITLE = "증정 이벤트";
    private final Map<String, Integer> benefitHistory = new HashMap<>();
    private int totalBenefit;

    public TotalEvent() {
        totalBenefit = 0;
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

}
