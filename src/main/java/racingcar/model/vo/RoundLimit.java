package racingcar.model.vo;

import racingcar.model.constant.ExceptionMessages;

public final class RoundLimit {

    private final int value;

    private RoundLimit(int value) {
        if (value <= 0) {
            throw new IllegalArgumentException(ExceptionMessages.INVALID_NUMBER_RANGE.get());
        }
        this.value = value;
    }

    public static RoundLimit of(String input) {
        if (input == null || input.isBlank()) {
            throw new IllegalArgumentException(ExceptionMessages.INPUT_EMPTY.get());
        }
        try {
            return new RoundLimit(Integer.parseInt(input));
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(ExceptionMessages.INVALID_NUMBER_FORMAT.get());
        }
    }

    public boolean hasRemaining(int currentRound) {
        return currentRound < value;
    }

    public int value() {
        return value;
    }
}
