package christmas.enums;

public enum Badge {
    NONE("없음", 0),
    STAR("별", 5000),
    TREE("트리", 10000),
    SANTA("산타", 20000);

    private final String name;
    private final int minValue;

    Badge(String name, int minValue) {
        this.name = name;
        this.minValue = minValue;
    }

    public String getName() {
        return name;
    }

    public int getMinValue() {
        return minValue;
    }
}
