package christmas.domain;


public class BillCalculator {
    private final TotalEvent totalEvent;
    private final Order order;
    private final int payAmount;

    public BillCalculator(TotalEvent totalEvent, Order order, int date) {
        this.totalEvent = totalEvent;
        this.order = order;
        calculateAllEvent(date, order.getTotalPrice());
        payAmount = calculatePayAmount();
    }

    private void calculateAllEvent(int date, int totalPrice) {
        if (totalPrice >= 10000) {
            totalEvent.applyDdayEvent(date);
            totalEvent.applyWeekEvent(date, order);
            totalEvent.applyStarEvent(date);
            totalEvent.applyPresentEvent(totalPrice);
        }
    }


    private int calculatePayAmount() {
        return order.getTotalPrice() - totalEvent.getTotalBenefitWithoutPresent();
    }


    public int getPayAmount(){
        return payAmount;
    }


}
