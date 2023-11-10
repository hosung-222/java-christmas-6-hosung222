package christmas.domain;

import java.util.HashMap;
import java.util.Map;

public class MenuBoard {
    private static final String CATEGORY_APPETIZER = "애피타이저";
    private static final String CATEGORY_MAIN = "메인";
    private static final String CATEGORY_DESERT = "디저트";
    private static final String CATEGORY_DRINK = "음료";

    private Map<String, Menu> menuMap;

    public MenuBoard() {
        this.menuMap = new HashMap<>();
        initializeMenu();
    }

    private void initializeMenu() {
        addMenu(new Menu("양송이수프", 6000, CATEGORY_APPETIZER));
        addMenu(new Menu("타파스", 5500, CATEGORY_APPETIZER));
        addMenu(new Menu("시저샐러드", 8000, CATEGORY_APPETIZER));

        addMenu(new Menu("티본스테이크", 55000, CATEGORY_MAIN));
        addMenu(new Menu("바비큐립", 54000, CATEGORY_MAIN));
        addMenu(new Menu("해산물파스타", 35000, CATEGORY_MAIN));
        addMenu(new Menu("크리스마스파스타", 25000, CATEGORY_MAIN));

        addMenu(new Menu("초코케이크", 15000, CATEGORY_DESERT));
        addMenu(new Menu("아이스크림", 5000, CATEGORY_DESERT));

        addMenu(new Menu("제로콜라", 3000, CATEGORY_DRINK));
        addMenu(new Menu("레드와인", 60000, CATEGORY_DRINK));
        addMenu(new Menu("샴페인", 25000, CATEGORY_DRINK));
    }

    private void addMenu(Menu menu) {
        menuMap.put(menu.getName(), menu);
    }

    public Menu getMenuByName(String menuName) {
        return menuMap.get(menuName);
    }
}
