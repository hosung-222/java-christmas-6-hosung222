package christmas.domain;

public class BadgeManager {

    private static final String BADGE_NON = "없음";
    private static final String BADGE_STAR = "별";
    private static final String BADGE_TREE = "트리";
    private static final String BADGE_SANTA = "산타";
    private static final int VALUE_STAR = 5000;
    private static final int VALUE_TREE = 10000;
    private static final int VALUE_SANTA = 20000;
    private String badge;

    public BadgeManager() {
        badge = BADGE_NON;
    }

    public String getBadge(int totalBenefit){
        if (totalBenefit > VALUE_SANTA){
            badge = BADGE_SANTA;
        } else if (totalBenefit > VALUE_TREE) {
            badge = BADGE_TREE;
        } else if (totalBenefit > VALUE_STAR) {
            badge = BADGE_STAR;
        }
        return badge;
    }
}
