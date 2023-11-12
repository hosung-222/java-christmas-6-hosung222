package christmas.domain;

import java.util.HashMap;
import java.util.Map;

public class Order {
    private static final String CATEGORY_MAIN = "메인";
    private static final String CATEGORY_DESERT = "디저트";
    private static final String CATEGORY_DRINK = "음료";
    private MenuBoard menuBoard;
    private Map<Menu, Integer> orderedItems;

    public Order() {
        this.orderedItems = new HashMap<>();
        this.menuBoard = new MenuBoard();
    }

    public void addMenu(String menuName, int quantity) {
        Menu menu = menuBoard.getMenuByName(menuName);
        if (orderedItems.containsKey(menu)) {
            throw new IllegalArgumentException();
        }
        orderedItems.put(menu, quantity);
    }

    public Map<Menu, Integer> getOrderedItems() {
        return orderedItems;
    }

    public int getDesertCount() {
        int desertCount = 0;
        for (Map.Entry<Menu, Integer> entry : orderedItems.entrySet()) {
            Menu menu = entry.getKey();
            int quantity = entry.getValue();
            if (menu.getCategory().equals(CATEGORY_DESERT)) {
                desertCount += quantity;
            }
        }
        return desertCount;
    }

    public int getMainCount() {
        int mainCount = 0;
        for (Map.Entry<Menu, Integer> entry : orderedItems.entrySet()) {
            Menu menu = entry.getKey();
            int quantity = entry.getValue();
            if (menu.getCategory().equals(CATEGORY_MAIN)) {
                mainCount += quantity;
            }
        }
        return mainCount;
    }

    private int getDrinkCount() {
        int drinkCount = 0;
        for (Map.Entry<Menu, Integer> entry : orderedItems.entrySet()) {
            Menu menu = entry.getKey();
            int quantity = entry.getValue();
            if (menu.getCategory().equals(CATEGORY_DRINK)) {
                drinkCount += quantity;
            }
        }
        return drinkCount;
    }

    private int getTotalCount() {
        int drinkCOunt = 0;
        for (Map.Entry<Menu, Integer> entry : orderedItems.entrySet()) {
            int quantity = entry.getValue();
            drinkCOunt += quantity;
        }
        return drinkCOunt;
    }

    public void isRightOrder(){
        if (getTotalCount() >20 || getDrinkCount() == getTotalCount()){
            throw new IllegalArgumentException();
        }
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
