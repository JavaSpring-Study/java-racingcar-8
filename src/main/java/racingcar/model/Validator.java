package racingcar.model;

import racingcar.model.constant.ExceptionMessages;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Validator {

    private Validator() {
    }

    public static void validateNames(List<String> names) {
        if (names == null || names.isEmpty()) {
            throw new IllegalArgumentException(ExceptionMessages.INPUT_EMPTY);
        }

        for (String name : names) {
            if (name == null || name.isBlank()) {
                throw new IllegalArgumentException(ExceptionMessages.INPUT_EMPTY);
            }
            if (name.length() > 5) {
                throw new IllegalArgumentException(ExceptionMessages.INVALID_NAME_LENGTH);
            }
        }

        Set<String> unique = new HashSet<>(names);
        if (unique.size() != names.size()) {
            throw new IllegalArgumentException(ExceptionMessages.DUPLICATE_NAME);
        }
    }

    public static int validateAttempts(String input) {
        if (input == null || input.isBlank()) {
            throw new IllegalArgumentException(ExceptionMessages.INPUT_EMPTY);
        }

        int count;
        try {
            count = Integer.parseInt(input);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(ExceptionMessages.INVALID_NUMBER_FORMAT);
        }

        if (count <= 0) {
            throw new IllegalArgumentException(ExceptionMessages.INVALID_NUMBER_RANGE);
        }

        return count;
    }
}