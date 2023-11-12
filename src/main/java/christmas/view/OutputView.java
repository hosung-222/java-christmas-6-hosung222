package christmas.view;

import christmas.domain.BillCalculator;
import christmas.domain.Order;
import christmas.domain.TotalEvent;

public class OutputView {

    private static final String START_EVENT_MESSAGE = "12월 %d일에 우테코 식당에서 받을 이벤트 혜택 미리 보기! \n";
    private static final String ORDER_MENU_TITLE = "<주문 메뉴>";
    private static final String BEFORE_SALE_PRICE_TITLE = "<할인 전 총주문 금액>";
    private static final String KOREA_WON = "원";
    private static final String EVENT_LIST_TITLE = "<혜택 내역>";
    private static final String TOTAL_EVENT_AMOUNT_TITLE = "<총혜택 금액>";
    private static final String PAY_PRICE_TITLE = "<할인 후 예상 결제 금액>";
    private static final String NEW_LINE = "\n";


    public static void printErrorMessageFor(IllegalArgumentException exception) {
        System.out.println(exception.getMessage());
    }

    public static void printStartEventMessage(int date){
        System.out.printf(START_EVENT_MESSAGE, date);
    }

    public static void printOrderList(Order order){
        System.out.println(ORDER_MENU_TITLE);
        System.out.println(order.toString());
    }

    public static void printBeforeSalePrice(Order order){
        System.out.println(BEFORE_SALE_PRICE_TITLE);
        StringBuilder result = new StringBuilder();
        result.append(String.format("%,d", order.getTotalPrice())).append(KOREA_WON).append(NEW_LINE);
        System.out.println(result);
    }

    public static void printEventList(TotalEvent totalEvent){
        System.out.println(EVENT_LIST_TITLE);
        System.out.println(totalEvent.toString());
    }

    public static void printTotalSaleAmount(TotalEvent totalEvent){
        System.out.println(TOTAL_EVENT_AMOUNT_TITLE);
        StringBuilder result = new StringBuilder();
        result.append(String.format("%,d", totalEvent.getTotalBenefit())).append(KOREA_WON).append(NEW_LINE);
        System.out.println(result);
    }

    public static void printPayAmount(BillCalculator billCalculator){
        System.out.println(PAY_PRICE_TITLE);
        System.out.println(billCalculator.toString());
    }
}
