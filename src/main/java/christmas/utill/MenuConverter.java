package christmas.utill;

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
        String[] menuArray = menuInput.split(",");
        Order order = new Order();

        Arrays.stream(menuArray)
                .forEach(menu -> processMenu(menu, menuBoard, order));

        return order;
    }

    public static void processMenu(String menu, MenuBoard menuBoard, Order order) {
        String[] parts = menu.split("-");
        String menuName = parts[0];
        int quantity = changeQuantityToInt(parts[1]);
        validateQuantity(quantity);
        validateAndAddToOrder(menuName, quantity, menuBoard, order);
        validateOrder(order);
    }

}


