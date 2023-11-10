package christmas.domain;

import java.util.HashMap;
import java.util.Map;

public class Order {
    private MenuBoard menuBoard;
    private Map<Menu, Integer> orderedItems;

    public Order() {
        this.orderedItems = new HashMap<>();
        this.menuBoard = new MenuBoard();
    }

    public void addMenu(String menuName, int quantity) {
        Menu menu = menuBoard.getMenuByName(menuName);
        orderedItems.put(menu, quantity);
    }

    public Map<Menu, Integer> getOrderedItems() {
        return orderedItems;
    }

    public int getDesertCount(){
        int desertCount = 0;
        for (Map.Entry<Menu, Integer> entry : orderedItems.entrySet()){
            Menu menu = entry.getKey();
            int quantity = entry.getValue();
            if(menu.getCategory().equals("디저트")){
                desertCount += quantity;
            }
        }
        return desertCount;
    }

    public int getTotalPrice() {
        int totalPrice = 0;
        for (Map.Entry<Menu, Integer> entry : orderedItems.entrySet()) {
            Menu menu = entry.getKey();
            int quantity = entry.getValue();
            totalPrice += menu.getPrice() * quantity;
        }
        return totalPrice;
    }

}
