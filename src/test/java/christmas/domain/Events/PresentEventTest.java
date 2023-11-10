package christmas.domain.Events;

import static org.junit.jupiter.api.Assertions.*;

import christmas.domain.TotalEvent;
import java.util.Map;
import org.junit.jupiter.api.Test;

class PresentEventTest {
    @Test
    void testGetPresentEventWhenApplicable() {
        PresentEvent presentEvent = new PresentEvent();
        TotalEvent totalEvent = new TotalEvent();

        // 테스트를 위한 가상의 주문 금액
        int totalAmount = 130000;

        // PresentEvent가 적용될 경우 증정 메뉴와 할인 금액을 가져옴
        Map<String, Integer> presentEventResult = presentEvent.getPresentEvent(totalAmount, totalEvent);

        // 예상 결과와 비교
        assertEquals(1, presentEventResult.get("샴페인"));
        assertEquals(25000, totalEvent.getBenefitHistory().get("증정 이벤트"));
    }

    @Test
    void testGetPresentEventWhenNotApplicable() {
        PresentEvent presentEvent = new PresentEvent();
        TotalEvent totalEvent = new TotalEvent();

        // 테스트를 위한 가상의 주문 금액
        int totalAmount = 110000;

        // PresentEvent가 적용되지 않을 경우 빈 맵을 반환
        Map<String, Integer> presentEventResult = presentEvent.getPresentEvent(totalAmount, totalEvent);

        // 결과가 빈 맵인지 확인
        assertEquals(0, presentEventResult.size());
        assertEquals(0, totalEvent.getBenefitHistory().size());
    }
}