package racingcar.domain;

public class Position {

    private static final int INITIAL_POSITION = 0;
    private static final int MOVE_DISTANCE = 1;
    private static final String NEGATIVE_POSITION_MESSAGE = "위치는 음수일 수 없습니다.";

    private final int value;

    public Position() {
        this(INITIAL_POSITION);
    }

    private Position(int value) {
        validate(value);
        this.value = value;
    }

    public Position move() {
        return new Position(value + MOVE_DISTANCE);
    }

    public int getValue() {
        return value;
    }

    private void validate(int value) {
        if (value < 0) {
            throw new IllegalArgumentException(NEGATIVE_POSITION_MESSAGE);
        }
    }

}