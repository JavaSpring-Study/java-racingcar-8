package racingcar.model.constant;

public enum ExceptionMessages {

    INPUT_EMPTY("입력값이 비어있습니다."),
    INPUT_NULL("입력값이 존재하지 않습니다."),
    INPUT_BLANK("입력값에 공백만 포함될 수 없습니다."),

    INVALID_NAME_EMPTY("자동차 이름은 비어있을 수 없습니다."),
    INVALID_NAME_LENGTH("자동차 이름은 1자 이상 5자 이하만 가능합니다."),
    DUPLICATE_NAME("자동차 이름은 중복될 수 없습니다."),

    INVALID_NUMBER_FORMAT("시도 횟수는 숫자여야 합니다."),
    INVALID_NUMBER_RANGE("시도 횟수는 1 이상의 정수여야 합니다."),
    EXCEEDED_ROUND_LIMIT("라운드 한도를 초과했습니다.");

    private final String message;

    ExceptionMessages(String message) {
        this.message = message;
    }

    public String get() {
        return message;
    }
}
