package christmas.domain.Events;

import static org.junit.jupiter.api.Assertions.*;

import christmas.domain.TotalEvent;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class StarEventTest {
    @DisplayName("별이 있는 날 혜택 적용 확인")
    @Test
    public void applyStarDiscount_shouldApplyDiscountOnStarDates() {
        StarEvent starEvent = new StarEvent();
        TotalEvent totalEvent = new TotalEvent();

        // 별이 있는 날인 12월 3일에 할인 적용
        starEvent.applyStarDiscount(3, totalEvent);

        // 혜택 내역 확인
        assertEquals(1000, totalEvent.getBenefitHistory().get("특별 할인"));
    }

    @DisplayName("별이 없는 날 혜택 미적용 확인")
    @Test
    public void applyStarDiscount_shouldNotApplyDiscountOnStarDates() {
        StarEvent starEvent = new StarEvent();
        TotalEvent totalEvent = new TotalEvent();

        // 별이 없는 날인 12월 11일에 할인 적용 X
        starEvent.applyStarDiscount(11, totalEvent);

        // 혜택 내역 확인
        assertNull(totalEvent.getBenefitHistory().get("특별 할인"));

    }
}