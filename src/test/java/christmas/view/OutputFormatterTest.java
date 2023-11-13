package christmas.view;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

import christmas.domain.Menu;
import java.util.HashMap;
import java.util.Map;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class OutputFormatterTest {
    @DisplayName("주문 목록을 정상적으로 포맷하는지 확인")
    @Test
    void formatOrderList_validOrderMap_formattedString() {
        Map<Menu, Integer> orders = new HashMap<>();
        Menu menu1 = new Menu("양송이수프", 6000, "Appetizer");
        orders.put(menu1, 2);

        String result = OutputFormatter.formatOrderList(orders);

        assertThat(result).isEqualTo("양송이수프 2개\n");
    }

    @DisplayName("할인 전 주문 총 금액을 정상적으로 포맷하는지 확인")
    @Test
    void formatBeforeSalePrice_validTotalAmount_formattedString() {
        int totalAmount = 15000;

        String result = OutputFormatter.formatBeforeSalePrice(totalAmount);

        assertThat(result).isEqualTo("15,000원\n");
    }

    @DisplayName("증정 메뉴 목록을 정상적으로 포맷하는지 확인")
    @Test
    void formatPresentList_validPresentList_formattedString() {
        Map<String, Integer> presentList = new HashMap<>();
        presentList.put("샴페인", 1);
        String result = OutputFormatter.formatPresentList(presentList);

        assertThat(result).isEqualTo("샴페인 1개\n");
    }

    @DisplayName("증정이 없는 경우에 정상적으로 포맷하는지 확인")
    @Test
    void formatPresentList_emptyPresentList_formattedString() {
        Map<String, Integer> presentList = new HashMap<>();

        String result = OutputFormatter.formatPresentList(presentList);

        assertThat(result).isEqualTo("없음\n");
    }

    @DisplayName("이벤트 내역을 정상적으로 포맷하는지 확인")
    @Test
    void formatEventList_validEventHistory_formattedString() {
        Map<String, Integer> eventHistory = new HashMap<>();
        eventHistory.put("크리스마스 디데이 할인", 2000);
        eventHistory.put("평일 할인", 2046);
        eventHistory.put("특별 할인", 1000);

        String result = OutputFormatter.formatEventList(eventHistory);

        assertThat(result).contains("크리스마스 디데이 할인: -2,000원","평일 할인: -2,046원","특별 할인: -1,000원");
    }

    @DisplayName("이벤트 내역이 비어있는 경우 정상적으로 포맷하는지 확인")
    @Test
    void formatEventList_emptyEventHistory_formattedString() {
        Map<String, Integer> eventHistory = new HashMap<>();

        String result = OutputFormatter.formatEventList(eventHistory);

        assertThat(result).isEqualTo("없음\n");
    }

    @DisplayName("총 할인 금액을 정상적으로 포맷하는지 확인")
    @Test
    void formatTotalSaleAmount_validTotalBenefit_formattedString() {
        int totalBenefit = 5000;

        String result = OutputFormatter.formatTotalSaleAmount(totalBenefit);

        assertThat(result).isEqualTo("-5,000원\n");
    }

    @DisplayName("결제 예상 금액을 정상적으로 포맷하는지 확인")
    @Test
    void formatPayAmount_validPayAmount_formattedString() {
        int payAmount = 12000;

        String result = OutputFormatter.formatPayAmount(payAmount);

        assertThat(result).isEqualTo("12,000원\n");
    }
}