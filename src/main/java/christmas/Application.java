package christmas;

import christmas.controller.Controller;
import christmas.domain.BadgeManager;
import christmas.domain.BillCalculator;
import christmas.domain.Order;
import christmas.domain.TotalEvent;
import christmas.view.InputHandler;
import christmas.view.InputView;
import christmas.view.OutputView;

public class Application {
    public static void main(String[] args) {
        Controller controller = new Controller(new TotalEvent());
        controller.run();
    }
}
