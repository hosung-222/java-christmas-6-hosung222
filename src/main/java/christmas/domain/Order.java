package christmas.domain;

import java.util.HashMap;
import java.util.Map;

public class Order {
    private MenuBoard menuManager;
    private Map<Menu, Integer> orderedItems;

    public Order() {
        this.orderedItems = new HashMap<>();
        this.menuManager = new MenuBoard();
    }

    public void addMenu(String menuName, int quantity) {
        Menu menu = menuManager.getMenuByName(menuName);
        orderedItems.put(menu, quantity);
    }


}
