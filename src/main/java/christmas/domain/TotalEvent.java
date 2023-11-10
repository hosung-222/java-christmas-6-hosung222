package christmas.domain;
import java.util.HashMap;
import java.util.Map;

public class TotalEvent {
    private final Map<String, Integer> benefitHistory = new HashMap<>();

    public void updateBenefitHistory(String eventName, int discountAmount) {
        // 기존 혜택 내역이 있는지 확인 후 할인 금액 추가
        int currentAmount = benefitHistory.getOrDefault(eventName, 0);
        benefitHistory.put(eventName, currentAmount + discountAmount);
    }

    public Map<String,Integer> getBenefitHistory(){
        return benefitHistory;
    }


}
