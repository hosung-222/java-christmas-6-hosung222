package christmas.view;

import static christmas.utill.Constants.*;

import christmas.domain.Menu;
import java.util.Map;

public class OutputFormatter {
    private static final String BILL_FORMAT = "%,d원\n";
    private static final String SALE_BILL_FORMAT = "-%,d원\n";
    private static final String EVENT_BENEFIT_FORMAT = "%s: -%,d원\n";
    private static final String ORDER_MENU_FORMAT = "%s %d개\n";

    public static String formatOrderList(Map<Menu,Integer> orders){
        StringBuilder result = new StringBuilder();
        for (Map.Entry<Menu, Integer> entry : orders.entrySet()) {
            Menu menu = entry.getKey();
            int quantity = entry.getValue();
            result.append(String.format(ORDER_MENU_FORMAT, menu.getName(), quantity));
        }
        return result.toString();
    }

    public static String formatBeforeSalePrice(int totalAmount){
        return String.format(BILL_FORMAT, totalAmount);
    }

    public static String formatPresentList(Map<String, Integer> presentList) {
        StringBuilder result = new StringBuilder();
        if (presentList.size() == 0){
            result.append(NON_AMOUNT).append(NEW_LINE);
            return result.toString();
        }
        for (Map.Entry<String, Integer> entry : presentList.entrySet()) {
            String present = entry.getKey();
            int quantity = entry.getValue();
            result.append(String.format(ORDER_MENU_FORMAT, present, quantity));
        }
        return result.toString();
    }


    public static String formatEventList(Map<String, Integer> eventHistory) {
        StringBuilder result = new StringBuilder();
        if (eventHistory.size() == 0){
            result.append(NON_AMOUNT).append(NEW_LINE);
            return result.toString();
        }
        for (Map.Entry<String, Integer> entry : eventHistory.entrySet()) {
            String eventName = entry.getKey();
            int eventAmount = entry.getValue();
            result.append(String.format(EVENT_BENEFIT_FORMAT, eventName, eventAmount));
        }
        return result.toString();
    }
    public static String formatTotalSaleAmount(int totalBenefit){
        return String.format(totalBenefit > 0 ? SALE_BILL_FORMAT : BILL_FORMAT, totalBenefit);

    }

    public static String formatPayAmount(int payAmount){
        return String.format(BILL_FORMAT, payAmount);
    }

}
