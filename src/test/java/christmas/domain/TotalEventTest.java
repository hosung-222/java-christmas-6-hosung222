package christmas.domain;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

import java.util.Map;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class TotalEventTest {
    @Test
    @DisplayName("혜택 내역에 할인 금액을 정상적으로 추가하는지 확인")
    void updateBenefitHistory_validDiscountAmount_addDiscountAmountToBenefitHistory() {
        TotalEvent totalEvent = new TotalEvent();
        totalEvent.updateBenefitHistory("크리스마스 디데이 할인", 2000);

        Map<String, Integer> benefitHistory = totalEvent.getBenefitHistory();
        assertThat(benefitHistory).containsExactly(Map.entry("크리스마스 디데이 할인", 2000));
    }

    @Test
    @DisplayName("기존에 있는 혜택 내역에 할인 금액을 정상적으로 추가하는지 확인")
    void updateBenefitHistory_existingBenefitHistory_addDiscountAmountToExistingBenefitHistory() {
        TotalEvent totalEvent = new TotalEvent();
        totalEvent.updateBenefitHistory("크리스마스 디데이 할인", 2000);
        totalEvent.updateBenefitHistory("평일 할인", 2023);
        totalEvent.updateBenefitHistory("특별 할인", 1000);
        totalEvent.updateBenefitHistory("증정 이벤트", 25000);

        Map<String, Integer> benefitHistory = totalEvent.getBenefitHistory();
        assertThat(benefitHistory)
                .contains(Map.entry("크리스마스 디데이 할인", 2000), Map.entry("평일 할인", 2023)
                        , Map.entry("특별 할인", 1000), Map.entry("증정 이벤트", 25000));
    }

    @Test
    @DisplayName("증정 이벤트를 제외한 총 할인 금액을 정상적으로 계산하는지 확인")
    void getTotalBenefitWithoutPresent_validBenefitHistory_calculateTotalBenefitWithoutPresent() {
        TotalEvent totalEvent = new TotalEvent();
        totalEvent.updateBenefitHistory("크리스마스 디데이 할인", 2000);
        totalEvent.updateBenefitHistory("평일 할인", 4046);
        totalEvent.updateBenefitHistory("증정 이벤트", 25000);

        int totalBenefitWithoutPresent = totalEvent.getTotalBenefitWithoutPresent();

        assertThat(totalBenefitWithoutPresent).isEqualTo(6046); // "크리스마스 할인" + "생일 이벤트"
    }

    @Test
    @DisplayName("총 할인 금액을 정상적으로 계산하는지 확인")
    void getTotalBenefit_validBenefitHistory_calculateTotalBenefit() {
        TotalEvent totalEvent = new TotalEvent();
        totalEvent.updateBenefitHistory("크리스마스 디데이 할인", 1100);
        totalEvent.updateBenefitHistory("평일 할인", 3000);
        totalEvent.updateBenefitHistory("증정 이벤트", 25000);

        int totalBenefit = totalEvent.getTotalBenefit();

        assertThat(totalBenefit).isEqualTo(29100); // "크리스마스 할인" + "생일 이벤트" + "증정 이벤트"
    }
}