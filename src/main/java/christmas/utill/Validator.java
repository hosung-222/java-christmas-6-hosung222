package christmas.utill;

import christmas.domain.Menu;
import christmas.domain.MenuBoard;
import christmas.domain.Order;

public class Validator {

    private static final String DATE_ERROR = "[ERROR] 유효하지 않은 날짜입니다. 다시 입력해 주세요.";
    private static final String MENU_ERROR = "[ERROR] 유효하지 않은 주문입니다. 다시 입력해 주세요.";
    private static final int EVENT_START_DAY = 1;
    private static final int EVENT_END_DAY = 31;

    public static void validateDate(String date) {
        try {
            int parsedDate = Integer.parseInt(date);
            if (parsedDate < EVENT_START_DAY || parsedDate > EVENT_END_DAY) {
                throw new IllegalArgumentException(DATE_ERROR);
            }
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(DATE_ERROR);
        }
    }

    public static void validateMenu(String menuInput) {
        String regex = "([가-힣\\w]+-\\d+)(,[가-힣\\w]+-\\d+)*";
        if (!menuInput.matches(regex)) {
            throw new IllegalArgumentException(MENU_ERROR);
        }
    }

    public static int changeQuantityToInt(String input) {
        try {
            return Integer.parseInt(input);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(MENU_ERROR);
        }
    }

    public static void validateQuantity(int quantity) {
        if (quantity < 1) {
            throw new IllegalArgumentException(MENU_ERROR);
        }
    }

    public static void validateAndAddToOrder(String menuName, int quantity, MenuBoard menuBoard, Order order) {
        try {
            Menu boardMenu = menuBoard.findMenuByName(menuName);
            order.addMenu(menuName, quantity);
        } catch (IllegalArgumentException e) {
            throw new IllegalArgumentException(MENU_ERROR);
        }
    }

    public static void validateOrder(Order order) {
        try {
            order.isRightOrder();
        } catch (IllegalArgumentException e) {
            throw new IllegalArgumentException(MENU_ERROR);
        }
    }
}
