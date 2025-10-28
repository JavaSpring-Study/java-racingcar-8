package racingcar.domain;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class CarTest {

    @Test
    @DisplayName("랜덤 값이 4 이상이면 자동차가 한 칸 전진한다")
    void carMovesWhenRandomAboveOrEqual4() {
        Car car = new Car("pobi");
        car.move(4);
        assertThat(car.getPosition()).isEqualTo(1);
    }

    @Test
    @DisplayName("랜덤 값이 3 이하이면 자동차가 멈춘다")
    void carStopsWhenRandomBelow4() {
        Car car = new Car("pobi");
        car.move(3);
        assertThat(car.getPosition()).isEqualTo(0);
    }
}
