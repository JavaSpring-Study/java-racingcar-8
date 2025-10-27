package racingcar.model.vo;

public class Position {
    private int value;
    private static final int MOVE_THRESHOLD = 4;

    public Position() {
        this.value = 0;
    }

    public int value() {
        return value;
    }

    public void move(int randomValue) {
        if (randomValue >= MOVE_THRESHOLD) {
            value++;
        }
    }
}
