package racingcar.domain;

public class Name {

    private static final int MAX_NAME_LENGTH = 5;
    private static final String EMPTY_NAME_MESSAGE = "자동차 이름은 빈 값일 수 없습니다.";
    private static final String LENGTH_EXCEED_MESSAGE = "자동차 이름은 5자 이하만 가능합니다.";

    private final String value;

    public Name(String value) {
        validate(value);
        this.value = value.trim();
    }

    private void validate(String value) {
        if (isNullOrEmpty(value)) {
            throw new IllegalArgumentException(EMPTY_NAME_MESSAGE);
        }
        if (value.trim().length() > MAX_NAME_LENGTH) {
            throw new IllegalArgumentException(LENGTH_EXCEED_MESSAGE);
        }
    }

    public String getValue() {
        return value;
    }

    private static boolean isNullOrEmpty(String str) {
        return str == null || str.isBlank();
    }

}
