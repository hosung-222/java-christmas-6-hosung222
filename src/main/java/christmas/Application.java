package christmas;

import christmas.domain.BadgeManager;
import christmas.domain.BillCalculator;
import christmas.domain.Order;
import christmas.domain.TotalEvent;
import christmas.view.InputHandler;
import christmas.view.InputView;
import christmas.view.OutputView;

public class Application {
    public static void main(String[] args) {
        int date = InputHandler.receiveValidatedDate();
        Order order = InputHandler.receiveValidatedMenu();
        OutputView.printStartEventMessage(date);
        OutputView.printOrderList(order);
        OutputView.printBeforeSalePrice(order);

        TotalEvent totalEvent = new TotalEvent();
        BillCalculator billCalculator = new BillCalculator(totalEvent, order, date);
        OutputView.printPresentList(billCalculator);
        OutputView.printEventList(totalEvent);
        OutputView.printTotalSaleAmount(totalEvent);

        OutputView.printPayAmount(billCalculator);

        BadgeManager badgeManager = new BadgeManager(totalEvent.getTotalBenefit());
        OutputView.printBadge(badgeManager);

    }
}
