package christmas.domain;

import static christmas.enums.Category.*;

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
        Menu menu = menuBoard.findMenuByName(menuName);
        if (orderedItems.containsKey(menu)) {
            throw new IllegalArgumentException();
        }
        orderedItems.put(menu, quantity);
    }

    public int getDesertCount() {
        int desertCount = 0;
        for (Map.Entry<Menu, Integer> entry : orderedItems.entrySet()) {
            Menu menu = entry.getKey();
            int quantity = entry.getValue();
            if (menu.getCategory().equals(DESSERT.getKoreanName())) {
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
            if (menu.getCategory().equals(MAIN.getKoreanName())) {
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
            if (menu.getCategory().equals(DRINK.getKoreanName())) {
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

    public void isRightOrder() {
        if (getTotalCount() > 20 || getDrinkCount() == getTotalCount()) {
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

    public Map<Menu, Integer> getOrderItems(){
        return orderedItems;
    }
}
