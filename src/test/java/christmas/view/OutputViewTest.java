package christmas.view;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

import christmas.domain.BadgeManager;
import christmas.domain.BillCalculator;
import christmas.domain.Menu;
import christmas.domain.Order;
import christmas.domain.TotalEvent;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.HashMap;
import java.util.Map;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class OutputViewTest {
    private final ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
    private final PrintStream originalOutput = System.out;

    @DisplayName("예외 메시지를 정상적으로 출력하는지 확인")
    @Test
    void printErrorMessageFor_validException_printErrorMessage() {
        System.setOut(new PrintStream(outputStream));
        IllegalArgumentException exception = new IllegalArgumentException("[ERROR]");

        OutputView.printErrorMessageFor(exception);

        assertThat(outputStream.toString()).isEqualTo("[ERROR]\n");
    }

    @DisplayName("이벤트 시작 메시지를 정상적으로 출력하는지 확인")
    @Test
    void printStartEventMessage_validDate_printStartEventMessage() {
        System.setOut(new PrintStream(outputStream));

        OutputView.printStartEventMessage(25);

        assertThat(outputStream.toString()).isEqualTo("12월 25일에 우테코 식당에서 받을 이벤트 혜택 미리 보기!\n\n");
    }

    @DisplayName("주문 메뉴 목록을 정상적으로 출력하는지 확인")
    @Test
    void printOrderList_validOrder_printFormattedOrderList() {
        System.setOut(new PrintStream(outputStream));
        Order order = new Order();
        order.addMenu("양송이수프",2);
        order.addMenu("타파스",1);
        OutputView.printOrderList(order);

        assertThat(outputStream.toString()).contains("<주문 메뉴>","양송이수프 2개","타파스 1개");
    }

    @DisplayName("할인 전 주문 총 금액을 정상적으로 출력하는지 확인")
    @Test
    void printBeforeSalePrice_validOrder_printFormattedBeforeSalePrice() {
        System.setOut(new PrintStream(outputStream));
        Order order = new Order();
        order.addMenu("양송이수프", 2);
        order.addMenu("타파스", 1);

        OutputView.printBeforeSalePrice(order);

        assertThat(outputStream.toString()).isEqualTo("<할인 전 총주문 금액>\n17,500원\n\n");
    }

    @DisplayName("증정 메뉴 목록을 정상적으로 출력하는지 확인")
    @Test
    void printPresentList_validBillCalculator_printFormattedPresentList_yes() {
        System.setOut(new PrintStream(outputStream));
        Order order = new Order();
        order.addMenu("양송이수프",2);
        order.addMenu("티본스테이크",2);
        TotalEvent totalEvent = new TotalEvent();
        BillCalculator billCalculator = new BillCalculator(totalEvent, order, 13);
        OutputView.printPresentList(totalEvent);

        assertThat(outputStream.toString()).isEqualTo("<증정 메뉴>\n샴페인 1개\n\n");
    }

    @DisplayName("증정 메뉴 목록이 비어있을 때 '없음'을 정상적으로 출력하는지 확인")
    @Test
    void printPresentList_validBillCalculator_printFormattedPresentList_no() {
        System.setOut(new PrintStream(outputStream));
        Order order = new Order();
        order.addMenu("양송이수프",2);
        TotalEvent totalEvent = new TotalEvent();
        BillCalculator billCalculator = new BillCalculator(totalEvent, order, 13);

        OutputView.printPresentList(totalEvent);

        assertThat(outputStream.toString()).isEqualTo("<증정 메뉴>\n없음\n\n");
    }

    @DisplayName("혜택 내역을 정상적으로 출력하는지 확인")
    @Test
    void printEventList_validTotalEvent_printFormattedEventList() {
        System.setOut(new PrintStream(outputStream));
        TotalEvent totalEvent = new TotalEvent();
        totalEvent.updateBenefitHistory("크리스마스 디데이 할인", 2000);
        totalEvent.updateBenefitHistory("평일 할인", 4046);

        OutputView.printEventList(totalEvent);

        assertThat(outputStream.toString()).contains("<혜택 내역>","크리스마스 디데이 할인: -2,000원","평일 할인: -4,046원");
    }

    @DisplayName("총 혜택 금액을 정상적으로 출력하는지 확인")
    @Test
    void printTotalSaleAmount_validTotalEvent_printFormattedTotalSaleAmount() {
        System.setOut(new PrintStream(outputStream));
        TotalEvent totalEvent = new TotalEvent();
        totalEvent.updateBenefitHistory("크리스마스 디데이 할인", 2000);
        totalEvent.updateBenefitHistory("평일 할인", 4046);

        OutputView.printTotalSaleAmount(totalEvent);

        assertThat(outputStream.toString()).isEqualTo("<총혜택 금액>\n-6,046원\n\n");
    }

    @DisplayName("할인 후 결제 예상 금액을 정상적으로 출력하는지 확인")
    @Test
    void printPayPrice_validBillCalculator_printFormattedPayPrice() {
        System.setOut(new PrintStream(outputStream));
        BillCalculator billCalculator = new BillCalculator(new TotalEvent(),new Order(),3);

        OutputView.printPayPrice(billCalculator);

        assertThat(outputStream.toString()).isEqualTo("<할인 후 예상 결제 금액>\n0원\n\n");
    }

    @DisplayName("이벤트 배지(산타) 를 정상적으로 출력하는지 확인")
    @Test
    void printBadge_validBadgeManager_printFormattedBadge() {
        System.setOut(new PrintStream(outputStream));
        BadgeManager badgeManager = new BadgeManager(20000);

        OutputView.printBadge(badgeManager);

        assertThat(outputStream.toString()).isEqualTo("<12월 이벤트 배지>\n산타\n");
    }

    @DisplayName("이벤트 배지(트리)를 정상적으로 출력하는지 확인")
    @Test
    void printBadge_invalidBadgeManager_printFormattedBadge() {
        System.setOut(new PrintStream(outputStream));
        BadgeManager badgeManager = new BadgeManager(10000);

        OutputView.printBadge(badgeManager);

        assertThat(outputStream.toString()).isEqualTo("<12월 이벤트 배지>\n트리\n");
    }
    @DisplayName("이벤트 배지가 없을 때 '없음'을 정상적으로 출력하는지 확인")
    @Test
    void printBadge_validBadgeManagerWithZeroTotalBenefit_printFormattedBadge() {
        System.setOut(new PrintStream(outputStream));
        BadgeManager badgeManager = new BadgeManager(0);

        OutputView.printBadge(badgeManager);

        assertThat(outputStream.toString()).isEqualTo("<12월 이벤트 배지>\n없음\n");
    }

    @DisplayName("이벤트 배지(별)를 정상적으로 출력하는지 확인")
    @Test
    void printBadge_validBadgeManagerWithPositiveTotalBenefit_printFormattedBadge() {
        System.setOut(new PrintStream(outputStream));
        BadgeManager badgeManager = new BadgeManager(5000);

        OutputView.printBadge(badgeManager);

        assertThat(outputStream.toString()).isEqualTo("<12월 이벤트 배지>\n별\n");
    }
}