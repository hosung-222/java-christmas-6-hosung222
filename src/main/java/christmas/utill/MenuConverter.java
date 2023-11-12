package christmas.utill;

import static christmas.utill.Constants.*;
import static christmas.utill.Validator.changeQuantityToInt;
import static christmas.utill.Validator.validateAndAddToOrder;
import static christmas.utill.Validator.validateOrder;
import static christmas.utill.Validator.validateQuantity;

import christmas.domain.MenuBoard;
import christmas.domain.Order;
import java.util.Arrays;

public class MenuConverter {
    public static Order convertToOrderedMenu(String menuInput) {
        MenuBoard menuBoard = new MenuBoard();
        String[] menuArray = menuInput.split(COMA);
        Order order = new Order();

        Arrays.stream(menuArray)
                .forEach(menu -> processMenu(menu, menuBoard, order));

        return order;
    }

    public static void processMenu(String menu, MenuBoard menuBoard, Order order) {
        String[] parts = menu.split(AMOUNT_PREFIX);
        String menuName = parts[NAME_INDEX];
        int quantity = changeQuantityToInt(parts[QUANTITY_INDEX]);
        validateQuantity(quantity);
        validateAndAddToOrder(menuName, quantity, menuBoard, order);
        validateOrder(order);
    }

}


