package christmas.domain.Events;

import static org.junit.jupiter.api.Assertions.*;

import christmas.domain.Order;
import christmas.domain.TotalEvent;
import org.junit.jupiter.api.Test;

class WeekdayEventTest {
    @Test
    public void calculateDiscount_shouldReturnCorrectDiscount() {
        // WeekdayEvent 객체 생성
        WeekdayEvent weekdayEvent = new WeekdayEvent();

        // Order 객체 생성 (여기서는 가정한 메뉴 개수)
        Order order = new Order();
        order.addMenu("초코케이크", 2); // 예시 메뉴: 초코케이크 2개 주문

        // 주문 메뉴 확인
        assertEquals(2, order.getDesertCount());

        // 할인 계산 확인
        assertEquals(4046, weekdayEvent.calculateDiscount(order));
    }

    @Test
    public void calculateDiscount_shouldReturnNoDiscount() {
        // WeekdayEvent 객체 생성
        WeekdayEvent weekdayEvent = new WeekdayEvent();

        // Order 객체 생성 (여기서는 가정한 메뉴 개수)
        Order order = new Order();
        order.addMenu("티본스테이크", 1); // 예시 메뉴: 티본스테이크 1개 주문 -> 메인 메뉴

        // 디저트 주문 메뉴 확인
        assertEquals(0, order.getDesertCount());

        // 할인 계산 확인
        assertEquals(0, weekdayEvent.calculateDiscount(order));
    }

    @Test
    public void getWeekdayDiscount_shouldApplyDiscountToTotalEvent() {
        // WeekdayEvent 객체 생성
        WeekdayEvent weekdayEvent = new WeekdayEvent();

        // TotalEvent 객체 생성
        TotalEvent totalEvent = new TotalEvent();

        // Order 객체 생성 (여기서는 가정한 메뉴 개수)
        Order order = new Order();
        order.addMenu("초코케이크", 2); // 예시 메뉴: 초코케이크 2개 주문

        // 주문 메뉴 확인
        assertEquals(2, order.getDesertCount());

        // 평일 할인 적용 확인
        weekdayEvent.getWeekdayDiscount(totalEvent, order);

        // 혜택 내역 확인
        assertEquals(4046, totalEvent.getBenefitHistory().get("평일 할인"));
    }

}