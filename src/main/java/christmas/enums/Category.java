package christmas.enums;

public enum Category {
    APPETIZER("애피타이저", "Appetizer"),
    MAIN("메인", "Main"),
    DESSERT("디저트", "Dessert"),
    DRINK("음료", "Drink");

    private final String koreanName;
    private final String englishName;

    Category(String koreanName, String englishName) {
        this.koreanName = koreanName;
        this.englishName = englishName;
    }

    public String getKoreanName() {
        return koreanName;
    }

    public String getEnglishName() {
        return englishName;
    }
}
