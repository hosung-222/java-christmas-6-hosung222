package christmas.view;

import static christmas.utill.Constants.*;
import static christmas.view.OutputFormatter.*;

import christmas.domain.BadgeManager;
import christmas.domain.BillCalculator;
import christmas.domain.Events.PresentEvent;
import christmas.domain.Menu;
import christmas.domain.Order;
import christmas.domain.TotalEvent;
import java.util.Map;

public class OutputView {
    private static final String START_EVENT_MESSAGE = "12월 %d일에 우테코 식당에서 받을 이벤트 혜택 미리 보기!";
    private static final String ORDER_MENU_TITLE = "<주문 메뉴>";
    private static final String BEFORE_SALE_PRICE_TITLE = "<할인 전 총주문 금액>";
    private static final String PRESENT_LIST_TITLE = "<증정 메뉴>";
    private static final String EVENT_LIST_TITLE = "<혜택 내역>";
    private static final String TOTAL_EVENT_AMOUNT_TITLE = "<총혜택 금액>";
    private static final String PAY_PRICE_TITLE = "<할인 후 예상 결제 금액>";
    private static final String BADGE_TITLE = "<12월 이벤트 배지>";

    public static void printErrorMessageFor(IllegalArgumentException exception) {
        System.out.println(exception.getMessage());
    }

    // 혜택 미리보기 시작
    public static void printStartEventMessage(int date) {
        StringBuilder result = new StringBuilder();
        result.append(START_EVENT_MESSAGE).append(NEW_LINE).append(NEW_LINE);
        System.out.printf(result.toString(), date);
    }

    // 주문 메뉴
    public static void printOrderList(Order order) {
        System.out.println(ORDER_MENU_TITLE);
        System.out.println(formatOrderList(order.getOrderItems()));
    }

    // 할인 전 총 주문 금액
    public static void printBeforeSalePrice(Order order) {
        System.out.println(BEFORE_SALE_PRICE_TITLE);
        System.out.println(formatBeforeSalePrice(order.getTotalPrice()));
    }

    // 증정 메뉴
    public static void printPresentList(TotalEvent totalEvent) {
        System.out.println(PRESENT_LIST_TITLE);
        System.out.println(formatPresentList(totalEvent.getPresent()));
    }

    // 혜택 내역
    public static void printEventList(TotalEvent totalEvent) {
        System.out.println(EVENT_LIST_TITLE);
        System.out.println(formatEventList(totalEvent.getBenefitHistory()));
    }

    // 총 혜택 금액
    public static void printTotalSaleAmount(TotalEvent totalEvent) {
        System.out.println(TOTAL_EVENT_AMOUNT_TITLE);
        System.out.println(formatTotalSaleAmount(totalEvent.getTotalBenefit()));
    }

    // 할인 후 예상 결제 금액
    public static void printPayPrice(BillCalculator billCalculator) {
        System.out.println(PAY_PRICE_TITLE);
        System.out.println(formatPayAmount(billCalculator.getPayAmount()));
    }

    // 배지
    public static void printBadge(BadgeManager badge) {
        System.out.println(BADGE_TITLE);
        System.out.println(badge.getBadge());
    }
}
