package christmas.view;

public class Validator {

    private static final String DATE_ERROR = "[ERROR] 유효하지 않은 날짜입니다. 다시 입력해 주세요.";
    private static final int EVENT_START_DAY = 1;
    private static final int EVENT_END_DAY = 31;

    public static void validateDate(String date) {
        try {
            int parsedDate = Integer.parseInt(date);
            if (parsedDate < EVENT_START_DAY || parsedDate > EVENT_END_DAY) {
                throw new IllegalArgumentException(DATE_ERROR);
            }
        }catch (NumberFormatException e){
            throw new IllegalArgumentException(DATE_ERROR);
        }
    }
}
