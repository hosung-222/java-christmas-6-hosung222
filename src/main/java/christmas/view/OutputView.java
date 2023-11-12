package christmas.view;

import christmas.domain.Order;

public class OutputView {

    private static final String ORDER_MENU_TITLE = "<주문 메뉴>";

    public static void printErrorMessageFor(IllegalArgumentException exception) {
        System.out.println(exception.getMessage());
    }

    public static void printOrderList(Order order){
        System.out.println(ORDER_MENU_TITLE);
        System.out.println(order.toString());
    }

}
