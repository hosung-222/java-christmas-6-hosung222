package christmas.utill;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatCode;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.*;

import christmas.domain.MenuBoard;
import christmas.domain.Order;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

class ValidatorTest {
    private MenuBoard menuBoard;

    @BeforeEach
    void setUp() {
        // 테스트를 위한 MenuBoard 초기화
        menuBoard = new MenuBoard();
    }

    @DisplayName("방문 날짜에 대한 올바른 입력")
    @ValueSource(strings = {"1", "25", "31"})
    @ParameterizedTest
    void validateDate_validDate_noExceptionThrown(String input) {
        assertThatCode(() -> Validator.validateDate(input)).doesNotThrowAnyException();
    }

    @DisplayName("1~31 사이의 수가 아닌경우에 대한 예외처리")
    @ValueSource(strings = {"-1", "0", "32", "dl", "하나"})
    @ParameterizedTest
    void validateDate_invalidDate_exceptionThrown(String input) {
        assertThatThrownBy(() -> Validator.validateDate(input))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("메뉴주문에 대한 올바른 입력")
    @ValueSource(strings = {"양송이수프-1,타파스-2", "아이스크림-1",
            "타파스-1,제로콜라-1", "타파스-20",
            "티본스테이크-1,바비큐립-1,초코케이크-2,제로콜라-1",
            "해산물파스타-2,레드와인-1,초코케이크-1"})
    @ParameterizedTest
    void validateMenu_validMenuInput_noExceptionThrown(String input) {
        assertThatCode(() -> Validator.validateMenu(input)).doesNotThrowAnyException();
    }

    @DisplayName("메뉴주문에 대한 잘못된 형식(메뉴(문자)-수량(숫자)) 예외 처리")
    @ValueSource(strings = {"양송이수프-1,타파스-dv", "아이스크림1개",
            "타파스-1,", "20-아이스크림", "1-양송이수프", "아무거나",
            "티본스테이크,바비큐립,초코케이크,제로콜라",
            "해산물,레드와인-1,초코케이크-1"})
    @ParameterizedTest
    void validateMenu_invalidMenuInput_exceptionThrown(String input) {
        assertThatThrownBy(() -> Validator.validateMenu(input))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("주문 수량을 int 형식으로 변환")
    @Test
    void changeQuantityToInt_validInput_validQuantity() {
        int quantity = Validator.changeQuantityToInt("3");
        assertThat(quantity).isEqualTo(3);
    }

    @DisplayName("주문 수량을 int 형식으로 변환 예외처리")
    @ValueSource(strings = {"dkc","1개"})
    @ParameterizedTest
    void changeQuantityToInt_invalidInput_exceptionThrown(String input) {
        assertThatThrownBy(() -> Validator.changeQuantityToInt(input))
                .isInstanceOf(IllegalArgumentException.class);
    }
    @DisplayName("메뉴 주문 수량이 1개 이상 입력")
    @ValueSource(ints = {1, 3, 5})
    @ParameterizedTest
    void validateQuantity_validQuantity_noExceptionThrown(int input) {
        assertThatCode(() -> Validator.validateQuantity(input)).doesNotThrowAnyException();
    }

    @DisplayName("메뉴 주문 수량이 0개 이하 입력에 대한 예외처리")
    @ValueSource(ints = {0, -1, -11})
    @ParameterizedTest
    void validateQuantity_invalidQuantity_exceptionThrown(int input) {
        assertThatThrownBy(() -> Validator.validateQuantity(input))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("존재하는 메뉴에 대해 메뉴 주문")
    @ValueSource(strings = {"양송이수프","타파스","시저샐러드","티본스테이크","바비큐립","해산물파스타","크리스마스파스타",
    "초코케이크","아이스크림","제로콜라","레드와인","샴페인"})
    @ParameterizedTest
    void validateAndAddToOrder_validMenuNameAndQuantity_noExceptionThrown(String input) {
        Order order = new Order();
        assertThatCode(() -> Validator.validateAndAddToOrder(input, 2, menuBoard, order))
                .doesNotThrowAnyException();
    }

    @DisplayName("존재하지 않는 메뉴에 대해 메뉴 주문 예외처리")
    @ValueSource(strings = {"양송이","파스타","바베큐","코카콜라","삼겹살","아무거나"})
    @ParameterizedTest
    void validateAndAddToOrder_invalidMenuName_exceptionThrown(String input) {
        Order order = new Order();
        assertThatThrownBy(() -> Validator.validateAndAddToOrder(input, 2, menuBoard, order))
                .isInstanceOf(IllegalArgumentException.class);
    }
}