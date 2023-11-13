package christmas.view;

import static christmas.utill.Constants.*;

import christmas.domain.Menu;
import christmas.domain.Order;
import christmas.utill.Constants;
import java.util.Map;
import org.mockito.internal.matchers.Or;

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
        StringBuilder result = new StringBuilder();
        result.append(String.format(BILL_FORMAT, totalAmount));
        return result.toString();
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
        StringBuilder result = new StringBuilder();
        result.append(String.format(SALE_BILL_FORMAT,totalBenefit));
        return result.toString();
    }

    public static String formatPayAmount(int payAmount){
        StringBuilder result = new StringBuilder();
        result.append(String.format(BILL_FORMAT, payAmount));
        return result.toString();
    }

}
