package christmas.domain.Events;

import static org.junit.jupiter.api.Assertions.*;

import christmas.domain.TotalEvent;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class DdayEventTest {

    @DisplayName("날짜별 할인 계산이 제대로 작동하는지 확인")
    @Test
    public void getDiscountAmount_shouldReturnCorrectDiscount() {
        DdayEvent ddayEvent = new DdayEvent();

        assertEquals(1000, ddayEvent.calculateDiscountAmount(1));
        assertEquals(1100, ddayEvent.calculateDiscountAmount(2));
        assertEquals(3400, ddayEvent.calculateDiscountAmount(25));

    }
    @DisplayName("1~25일에서만 할인이 적용되는지 확인")
    @Test
    public void validateDate_shouldReturnTrueForValidDate() {
        DdayEvent ddayEvent = new DdayEvent();

        assertTrue(ddayEvent.validateDate(1));
        assertTrue(ddayEvent.validateDate(25));
        assertFalse(ddayEvent.validateDate(30));
        assertFalse(ddayEvent.validateDate(0));
    }

    @DisplayName("총 이벤트 결과지에 할인 종류에 해당하는 금액 저장 확인")
    @Test
    public void getDdayDiscount_shouldApplyDiscountForValidDate() {
        DdayEvent ddayEvent = new DdayEvent();
        TotalEvent totalEvent = new TotalEvent();

        ddayEvent.applyDdayDiscount(1, totalEvent);
        // 혜택 내역 확인
        assertEquals(1000, totalEvent.getBenefitHistory().get("크리스마스 디데이 할인"));

        ddayEvent.applyDdayDiscount(2, totalEvent);
        // 혜택 내역 확인
        assertEquals(2100, totalEvent.getBenefitHistory().get("크리스마스 디데이 할인"));
    }
}