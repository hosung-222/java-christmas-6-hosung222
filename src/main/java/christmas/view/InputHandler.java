package christmas.view;

import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Supplier;

public class InputHandler {

    public static int receiveValidatedDate() {
        return receiveValidatedInput(InputView::readDate, Validator::validateDate, Integer::parseInt);
    }

    private static <T> T receiveValidatedInput(Supplier<String> inputSupplier, Consumer<String> validator, Function<String, T> resultConverter) {
        while (true) {
            try {
                String input = inputSupplier.get();
                validator.accept(input);
                return resultConverter.apply(input);
            } catch (IllegalArgumentException exception) {
                OutputView.printErrorMessageFor(exception);
            }
        }
    }
}
