package christmas.domain;

import christmas.enums.Menus;

public class Menu {
    private String name;
    private int price;
    private String category;

    public Menu(String name, int price, String category) {
        this.name = name;
        this.price = price;
        this.category = category;
    }

    public Menu(Menus menus) {
        this.name = menus.getName();
        this.price = menus.getPrice();
        this.category = menus.getCategory();
    }

    public String getName() {
        return name;
    }

    public int getPrice() {
        return price;
    }

    public String getCategory() {
        return category;
    }
}
