package christmas.domain.Events;

import static org.junit.jupiter.api.Assertions.*;

import christmas.domain.Order;
import christmas.domain.TotalEvent;
import org.junit.jupiter.api.Test;

class WeekendEventTest {

    @Test
    public void calculateDiscount_shouldReturnCorrectDiscount() {
        // WeekdayEvent 객체 생성
        WeekendEvent weekendEvent = new WeekendEvent();

        // Order 객체 생성 (여기서는 가정한 메뉴 개수)
        Order order = new Order();
        order.addMenu("티본스테이크", 2); // 예시 메뉴: 티본스테이크 2개 주문

        // 주문 메뉴 확인
        assertEquals(2, order.getMainCount());

        // 할인 계산 확인
        assertEquals(4046, weekendEvent.calculateDiscount(order));
    }

    @Test
    public void calculateDiscount_shouldReturnNoDiscount() {
        // WeekdayEvent 객체 생성
        WeekendEvent weekendEvent = new WeekendEvent();

        // Order 객체 생성 (여기서는 가정한 메뉴 개수)
        Order order = new Order();
        order.addMenu("초코케이크", 1); // 예시 메뉴: 초코케이크 1개 주문 -> 메인 메뉴

        // 디저트 주문 메뉴 확인
        assertEquals(0, order.getMainCount());

        // 할인 계산 확인
        assertEquals(0, weekendEvent.calculateDiscount(order));
    }

    @Test
    public void getWeekdayDiscount_shouldApplyDiscountToTotalEvent() {
        // WeekdayEvent 객체 생성
        WeekendEvent weekendEvent = new WeekendEvent();

        // TotalEvent 객체 생성
        TotalEvent totalEvent = new TotalEvent();

        // Order 객체 생성 (여기서는 가정한 메뉴 개수)
        Order order = new Order();
        order.addMenu("초코케이크", 2); // 예시 메뉴: 초코케이크 2개 주문
        order.addMenu("티본스테이크", 1);

        // 주문 메뉴 확인
        assertEquals(1, order.getMainCount());

        // 평일 할인 적용 확인
        weekendEvent.getWeekendDiscount(totalEvent, order);

        // 혜택 내역 확인
        assertEquals(2023, totalEvent.getBenefitHistory().get("주말 할인"));
    }

}