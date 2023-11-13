package christmas;

import christmas.controller.Controller;
import christmas.domain.TotalEvent;

public class Application {
    public static void main(String[] args) {
        Controller controller = new Controller(new TotalEvent());
        controller.run();
    }
}
