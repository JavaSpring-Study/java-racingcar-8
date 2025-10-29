package racingcar.model.vo;

import racingcar.model.constant.ExceptionMessages;

public record CarName(String value) {
    private static final int NAME_MAX_LENGTH = 5;

    public CarName {
        if (value == null || value.isBlank()) {
            throw new IllegalArgumentException(ExceptionMessages.INVALID_NAME_EMPTY.get());
        }
        if (value.length() > NAME_MAX_LENGTH) {
            throw new IllegalArgumentException(ExceptionMessages.INVALID_NAME_LENGTH.get());
        }
    }

    @Override
    public String toString() {
        return value;
    }
}
