package racingcar.model.car;

import racingcar.model.constant.ExceptionMessages;
import racingcar.model.generator.ValueGenerator;
import java.util.Objects;

public class Car {

    private static final int MOVE_THRESHOLD = 4;
    private static final int INITIAL_POSITION = 0;

    private final String name;
    private int position = INITIAL_POSITION;

    public Car(String name) {
        validateName(name);
        this.name = name;
    }

    private void validateName(String name) {
        if (Objects.isNull(name) || name.isBlank()) {
            throw new IllegalArgumentException(ExceptionMessages.INVALID_NAME_EMPTY);
        }
        if (name.length() > 5) {
            throw new IllegalArgumentException(ExceptionMessages.INVALID_NAME_LENGTH);
        }
    }

    public void move(ValueGenerator generator) {
        if (isMovable(generator.getValue())) {
            position++;
        }
    }

    private boolean isMovable(int randomValue) {
        return randomValue >= MOVE_THRESHOLD;
    }

    public String name() {
        return name;
    }

    public int position() {
        return position;
    }

    public boolean isWinner(int maxPosition) {
        return this.position == maxPosition;
    }

    public CarStatus snapshot() {
        return new CarStatus(name, position);
    }
}
