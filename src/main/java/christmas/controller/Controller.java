package christmas.controller;

import christmas.domain.BadgeManager;
import christmas.domain.BillCalculator;
import christmas.domain.Order;
import christmas.domain.TotalEvent;
import christmas.view.InputHandler;
import christmas.view.OutputView;

public class Controller {
    private final TotalEvent totalEvent;

    public Controller(TotalEvent totalEvent) {
        this.totalEvent = totalEvent;
    }

    public void run() {
        int date = InputHandler.receiveValidatedDate();
        Order order = InputHandler.receiveValidatedMenu();
        printOrderInfo(date, order);
        BillCalculator billCalculator = new BillCalculator(totalEvent, order, date);
        printTotalSaleInfo(billCalculator);
        printBadgeInfo();
    }

    public void printOrderInfo(int date, Order order) {
        OutputView.printStartEventMessage(date);
        OutputView.printOrderList(order);
        OutputView.printBeforeSalePrice(order);
    }

    public void printTotalSaleInfo(BillCalculator billCalculator) {
        OutputView.printPresentList(totalEvent);
        OutputView.printEventList(totalEvent);
        OutputView.printTotalSaleAmount(totalEvent);
        OutputView.printPayPrice(billCalculator);
    }

    public void printBadgeInfo() {
        BadgeManager badgeManager = new BadgeManager(totalEvent.getTotalBenefit());
        OutputView.printBadge(badgeManager);
    }

}
