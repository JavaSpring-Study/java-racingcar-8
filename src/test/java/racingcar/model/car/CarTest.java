package racingcar.model.car;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.NullAndEmptySource;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class CarTest {

    @ParameterizedTest
    @ValueSource(ints = {4, 5, 6, 9})
    void 값이_4이상이면_전진한다(int value) {
        Car car = new Car("pobi");
        car.move(() -> value);
        assertThat(car.getPosition()).isEqualTo(1);
    }

    @ParameterizedTest
    @ValueSource(ints = {0, 1, 2, 3})
    void 값이_4미만이면_이동하지_않는다(int value) {
        Car car = new Car("pobi");
        car.move(() -> value);
        assertThat(car.getPosition()).isEqualTo(0);
    }

    @ParameterizedTest
    @NullAndEmptySource
    @ValueSource(strings = {"     "})
    void 이름이_null_또는_공백이면_예외(String input) {
        assertThatThrownBy(() -> new Car(input))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void 이름이_5자초과면_예외() {
        assertThatThrownBy(() -> new Car("abcdef"))
                .isInstanceOf(IllegalArgumentException.class);
    }
}
