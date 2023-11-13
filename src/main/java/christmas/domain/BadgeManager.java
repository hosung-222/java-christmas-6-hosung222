package christmas.domain;

import static christmas.enums.Badge.*;

import christmas.enums.Badge;

public class BadgeManager {

    private String badge;

    public BadgeManager(int totalBenefit) {
        badge = NONE.getName();
        setBadge(totalBenefit);
    }

    public void setBadge(int totalBenefit){
        if (totalBenefit > SANTA.getMinValue()){
            badge = SANTA.getName();
        } else if (totalBenefit > TREE.getMinValue()) {
            badge = TREE.getName();
        } else if (totalBenefit > STAR.getMinValue()) {
            badge = SANTA.getName();
        }
    }

    public String getBadge(){
        return badge;
    }
}
