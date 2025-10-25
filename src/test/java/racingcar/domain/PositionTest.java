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
    @DisplayName("이동 조건 미달이면 위치가 증가하지 않는다")
    void stayWhenConditionNotMet() {
        Position position = new Position();
        Position newPosition = position.move(3);
        assertEquals(0, newPosition.getValue());
    }

    @Test
    @DisplayName("이동 조건 충족이면 위치가 증가한다")
    void moveWhenConditionMet() {
        Position position = new Position();
        Position newPosition = position.move(4);
        assertEquals(1, newPosition.getValue());
    }

    @Test
    @DisplayName("여러 번 전진할 수 있다")
    void moveMultipleTimes() {
        Position position = new Position();
        Position movedPosition = position.move().move().move();
        assertEquals(3, movedPosition.getValue());
    }

}