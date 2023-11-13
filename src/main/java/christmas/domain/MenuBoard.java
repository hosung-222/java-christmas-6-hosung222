package christmas.domain;

import static christmas.enums.Menus.*;
import java.util.HashMap;
import java.util.Map;

public class MenuBoard {
    private Map<String, Menu> menuMap;

    public MenuBoard() {
        this.menuMap = new HashMap<>();
        initializeMenu();
    }

    private void initializeMenu() {
        addMenu(new Menu(YANG_SONG_SOUP));
        addMenu(new Menu(TAPAS));
        addMenu(new Menu(CAESAR_SALAD));

        addMenu(new Menu(T_BONE_STEAK));
        addMenu(new Menu(BBQ_RIBS));
        addMenu(new Menu(SEAFOOD_PASTA));
        addMenu(new Menu(CHRISTMAS_PASTA));

        addMenu(new Menu(CHOCO_CAKE));
        addMenu(new Menu(ICE_CREAM));

        addMenu(new Menu(ZERO_COLA));
        addMenu(new Menu(RED_WINE));
        addMenu(new Menu(CHAMPAGNE));
    }

    private void addMenu(Menu menu) {
        menuMap.put(menu.getName(), menu);
    }

    public Menu getMenuByName(String menuName) {
        Menu menu = menuMap.get(menuName);
        if (menu == null){
            throw new IllegalArgumentException();
        }
        return menu;
    }
}
