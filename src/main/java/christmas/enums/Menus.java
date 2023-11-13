package christmas.enums;

import static christmas.enums.Category.*;

public enum Menus {
    // Appetizers
    YANG_SONG_SOUP("양송이수프", 6000, APPETIZER),
    TAPAS("타파스", 5500, APPETIZER),
    CAESAR_SALAD("시저샐러드", 8000, APPETIZER),

    // Main Courses
    T_BONE_STEAK("티본스테이크", 55000, MAIN),
    BBQ_RIBS("바비큐립", 54000, MAIN),
    SEAFOOD_PASTA("해산물파스타", 35000, MAIN),
    CHRISTMAS_PASTA("크리스마스파스타", 25000, MAIN),

    // Desserts
    CHOCO_CAKE("초코케이크", 15000, DESSERT),
    ICE_CREAM("아이스크림", 5000, DESSERT),

    // Drinks
    ZERO_COLA("제로콜라", 3000, DRINK),
    RED_WINE("레드와인", 60000, DRINK),
    CHAMPAGNE("샴페인", 25000, DRINK);

    private final String name;
    private final int price;
    private final Category category;

    Menus(String name, int price, Category category) {
        this.name = name;
        this.price = price;
        this.category = category;
    }

    public String getName() {
        return name;
    }

    public int getPrice() {
        return price;
    }

    public String getCategory() {
        return category.getKoreanName();
    }

}
