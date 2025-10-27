package racingcar.model;

import racingcar.model.constant.ExceptionMessages;

public class Validator {

    public Validator() {}

    public void validateInputExists(String input) {
        if (input == null) {
            throw new IllegalArgumentException(ExceptionMessages.INPUT_NULL.get());
        }
        if (input.isBlank()) {
            throw new IllegalArgumentException(ExceptionMessages.INPUT_BLANK.get());
        }
    }
}
