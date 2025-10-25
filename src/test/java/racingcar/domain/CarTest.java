package racingcar.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import racingcar.strategy.MoveStrategy;

import static org.junit.jupiter.api.Assertions.assertEquals;

class CarTest {

    @Test
    @DisplayName("자동차는 이름과 위치를 가진다")
    void createCar() {
        Car car = new Car("pobi");
        assertEquals("pobi", car.getName());
        assertEquals(0, car.getPosition());
    }

    @Test
    @DisplayName("랜덤 값이 4 미만이면 이동하지 않는다")
    void stayWhenNumberLessThanFour() {
        Car car = new Car("pobi");
        MoveStrategy notMovableStrategy = () -> false;
        car.move(notMovableStrategy);
        assertEquals(0, car.getPosition());
    }

    @Test
    @DisplayName("랜덤 값이 4 이상이면 전진한다")
    void moveWhenNumberGreaterThanOrEqualToFour() {
        Car car = new Car("pobi");
        MoveStrategy movableStrategy = () -> true;
        car.move(movableStrategy);
        assertEquals(1, car.getPosition());
    }

    @Test
    @DisplayName("여러 번 이동할 수 있다")
    void moveMultipleTimes() {
        Car car = new Car("pobi");

        MoveStrategy movableStrategy = () -> true;
        MoveStrategy notMovableStrategy = () -> false;

        car.move(movableStrategy);
        car.move(notMovableStrategy);
        car.move(movableStrategy);
        car.move(movableStrategy);

        assertEquals(3, car.getPosition());
    }

}