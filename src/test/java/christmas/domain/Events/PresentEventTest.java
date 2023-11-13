package christmas.domain.Events;

import static org.junit.jupiter.api.Assertions.*;

import christmas.domain.TotalEvent;
import java.util.Map;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class PresentEventTest {
    @DisplayName("12만원 이상일때 샴폐인 증정")
    @Test
    void testGetPresentEventWhenApplicable() {
        PresentEvent presentEvent = new PresentEvent();
        TotalEvent totalEvent = new TotalEvent();

        int totalAmount = 120000;

        Map<String, Integer> presentEventResult = presentEvent.getPresentEvent(totalAmount, totalEvent);

        // 예상 결과와 비교
        assertEquals(1, presentEventResult.get("샴페인"));
        assertEquals(25000, totalEvent.getBenefitHistory().get("증정 이벤트"));
    }

    @DisplayName("12만원 아래일때 샴폐인 증정 안됨")
    @Test
    void testGetPresentEventWhenNotApplicable() {
        PresentEvent presentEvent = new PresentEvent();
        TotalEvent totalEvent = new TotalEvent();

        int totalAmount = 110000;

        Map<String, Integer> presentEventResult = presentEvent.getPresentEvent(totalAmount, totalEvent);

        // 결과가 빈 맵인지 확인
        assertEquals(0, presentEventResult.size());
        assertEquals(0, totalEvent.getBenefitHistory().size());
    }
}