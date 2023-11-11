package christmas.view;

public class OutputView {
    public static void printErrorMessageFor(IllegalArgumentException exception) {
        System.out.println(exception.getMessage());
    }
}
