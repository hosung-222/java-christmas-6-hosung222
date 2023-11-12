package christmas.domain;

import java.util.HashMap;
import java.util.Map;

public class TotalEvent {
    private static final String NEW_LINE = "\n";
    private static final String SPACE = " ";
    public static final String BENEFIT_AMOUNT_PREFIX = "-";
    public static final String BENEFIT_AMOUNT_SUFFIX = "원";
    public static final String NON_AMOUNT = "없음";
    public static final String COLON = ":";

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
            if (!benefitName.equals("증정 이벤트")) {
                realTotalBenefit += benefitAmount;
            }
        }
        return realTotalBenefit;
    }

    public int getTotalBenefit() {
        int totalBenefit = 0;
        for (Map.Entry<String, Integer> entry : benefitHistory.entrySet()) {
            Integer benefitAmount = entry.getValue();
            totalBenefit += benefitAmount;
        }
        return totalBenefit;
    }

    @Override
    public String toString() {
        StringBuilder result = new StringBuilder();
        for (Map.Entry<String, Integer> entry : benefitHistory.entrySet()) {
            String benefitName = entry.getKey();
            Integer benefitAmount = entry.getValue();
            result.append(benefitName)
                    .append(COLON)
                    .append(SPACE)
                    .append(BENEFIT_AMOUNT_PREFIX)
                    .append(String.format("%,d", benefitAmount))
                    .append(BENEFIT_AMOUNT_SUFFIX)
                    .append(NEW_LINE);
        }
        if (result.length() == 0) {
            result.append(NON_AMOUNT)
                    .append(NEW_LINE);
        }
        return result.toString();
    }
}
