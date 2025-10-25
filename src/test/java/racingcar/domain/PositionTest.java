package racingcar.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class PositionTest {

    @Test
    @DisplayName("초기 위치는 0이다")
    void createInitialPosition() {
        Position position = new Position();
        assertEquals(0, position.getValue());
    }

    @Test
    @DisplayName("전진하면 위치가 1 증가한다")
    void moveForward() {
        Position position = new Position();
        Position movedPosition = position.move();
        assertEquals(1, movedPosition.getValue());
    }

    @Test
    @DisplayName("여러 번 전진할 수 있다")
    void moveMultipleTimes() {
        Position position = new Position();
        Position movedPosition = position.move().move().move();
        assertEquals(3, movedPosition.getValue());
    }

}