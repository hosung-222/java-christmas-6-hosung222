package christmas.domain;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

import java.util.Map;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class OrderTest {

    @DisplayName("중복된 메뉴 추가 시 예외 처리")
    @Test
    void addMenu_duplicateMenu_throwIllegalArgumentException() {
        Order order = new Order();
        order.addMenu("양송이수프", 2);

        assertThrows(IllegalArgumentException.class, () -> order.addMenu("양송이수프", 3));
    }

    @DisplayName("유효한 주문에서 디저트 개수 계산")
    @Test
    void getDesertCount_validOrder_desertCountCalculatedSuccessfully() {
        Order order = new Order();
        order.addMenu("타파스", 10);
        order.addMenu("바비큐립", 2);
        order.addMenu("아이스크림", 2);

        assertThat(order.getDesertCount()).isEqualTo(2);
    }

    @DisplayName("유효한 주문에서 메인 메뉴 개수 계산")
    @Test
    void getMainCount_validOrder_mainCountCalculatedSuccessfully() {
        Order order = new Order();
        order.addMenu("티본스테이크", 1);
        order.addMenu("크리스마스파스타", 2);
        order.addMenu("레드와인", 2);
        order.addMenu("제로콜라", 1);
        order.addMenu("타파스", 1);

        assertThat(order.getMainCount()).isEqualTo(3);
    }

    @DisplayName("주문이 제한을 초과하면 예외 처리")
    @Test
    void isRightOrder_orderExceedsLimit_throwIllegalArgumentException() {
        Order order = new Order();
        order.addMenu("바비큐립", 2);
        order.addMenu("해산물파스타", 3);
        order.addMenu("제로콜라", 10);
        order.addMenu("아이스크림", 3);
        order.addMenu("샴페인", 2);
        order.addMenu("양송이수프", 1);

        assertThrows(IllegalArgumentException.class, order::isRightOrder);
    }

    @DisplayName("음료만 주문된 경우 예외 처리")
    @Test
    void isRightOrder_onlyDrinksOrdered_throwIllegalArgumentException() {
        Order order = new Order();
        order.addMenu("제로콜라", 3);
        order.addMenu("샴페인", 2);
        order.addMenu("레드와인", 2);

        assertThrows(IllegalArgumentException.class, order::isRightOrder);
    }

    @DisplayName("유효한 주문에서 총 가격 계산")
    @Test
    void getTotalPrice_validOrder_totalPriceCalculatedSuccessfully() {
        Order order = new Order();
        order.addMenu("양송이수프", 3);
        order.addMenu("해산물파스타", 2);

        assertThat(order.getTotalPrice()).isEqualTo(88000);
    }

}