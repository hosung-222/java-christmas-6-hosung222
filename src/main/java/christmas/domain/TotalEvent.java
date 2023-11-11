package christmas.domain;

import java.util.HashMap;
import java.util.Map;

public class TotalEvent {
    private final Map<String, Integer> benefitHistory = new HashMap<>();

    private int totalBenefit;

    public TotalEvent() {
        totalBenefit = 0;
    }

    public void updateBenefitHistory(String eventName, int discountAmount) {
        // 기존 혜택 내역이 있는지 확인 후 할인 금액 추가
        int currentAmount = benefitHistory.getOrDefault(eventName, 0);
        benefitHistory.put(eventName, currentAmount + discountAmount);
        calculateTotalBenefit();
    }

    public Map<String, Integer> getBenefitHistory() {
        return benefitHistory;
    }

    private void calculateTotalBenefit() {
        for (int discountAmount : benefitHistory.values()) {
            totalBenefit += discountAmount;
        }
    }

    public int getTotalBenefit() {
        return totalBenefit;
    }
}
