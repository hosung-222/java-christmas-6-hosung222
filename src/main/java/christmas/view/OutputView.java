package christmas.view;

import christmas.domain.Order;

public class OutputView {

    private static final String ORDER_MENU_TITLE = "<주문 메뉴>";
    private static final String BEFORE_SALE_PRICE_TITLE = "<할인 전 총주문 금액>";
    private static final String KOREA_WON = "원";


    public static void printErrorMessageFor(IllegalArgumentException exception) {
        System.out.println(exception.getMessage());
    }

    public static void printOrderList(Order order){
        System.out.println(ORDER_MENU_TITLE);
        System.out.println(order.toString());
    }

    public static void printBeforeSalePrice(Order order){
        System.out.println(BEFORE_SALE_PRICE_TITLE);
        StringBuilder result = new StringBuilder();
        result.append(String.format("%,d", order.getTotalPrice())).append(KOREA_WON);
        System.out.println(result);
    }
}
