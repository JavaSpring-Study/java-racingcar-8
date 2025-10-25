package racingcar.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

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
        car.move(3);
        assertEquals(0, car.getPosition());
    }

    @Test
    @DisplayName("랜덤 값이 4 이상이면 전진한다")
    void moveWhenNumberGreaterThanOrEqualToFour() {
        Car car = new Car("pobi");
        car.move(4);
        assertEquals(1, car.getPosition());
    }

    @Test
    @DisplayName("여러 번 이동할 수 있다")
    void moveMultipleTimes() {
        Car car = new Car("pobi");
        car.move(5);
        car.move(6);
        car.move(3);
        car.move(7);
        assertEquals(3, car.getPosition());
    }

}