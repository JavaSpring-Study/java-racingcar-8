package racingcar.model.car;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import racingcar.model.generator.ValueGenerator;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class CarsTest {

    private List<String> names;

    @BeforeEach
    void setUp() {
        names = List.of("pobi", "woni", "jun");
    }

    @Test
    void 중복된_이름이_있으면_예외() {
        List<String> duplicateNames = List.of("pobi", "pobi");
        assertThatThrownBy(() -> Cars.of(duplicateNames))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void 빈_리스트면_예외() {
        assertThatThrownBy(() -> Cars.of(List.of()))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void null_입력이면_예외() {
        assertThatThrownBy(() -> Cars.of(null))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void 모든_자동차가_한번씩_전진한다() {
        Cars cars = Cars.of(names);
        ValueGenerator alwaysMove = () -> 9;
        cars.moveAll(alwaysMove);
        assertThat(cars.cars())
                .extracting(Car::position)
                .containsExactly(1, 1, 1);
    }

    @Test
    void 최대_이동_거리를_반환한다() {
        Cars cars = Cars.of(names);
        ValueGenerator generator = () -> 9;
        cars.moveAll(generator); // 모두 한 번 전진
        cars.moveAll(generator); // 두 번 전진

        assertThat(cars.maxPosition()).isEqualTo(2);
    }

    @Test
    void 공동_우승자가_존재할_수_있다() {
        Cars cars = Cars.of(List.of("pobi", "woni"));
        cars.moveAll(() -> 9);
        List<String> winners = cars.findWinners();
        assertThat(winners).containsExactlyInAnyOrder("pobi", "woni");
    }

    @Test
    void 가장_먼_위치의_자동차가_우승자이다() {
        Cars cars = Cars.of(names);
        ValueGenerator moveOnlyPobi = new ValueGenerator() {
            private int count = 0;
            @Override
            public int getValue() {
                return count++ == 0 ? 9 : 0;
            }
        };
        cars.moveAll(moveOnlyPobi);
        List<String> winners = cars.findWinners();
        assertThat(winners)
                .containsExactly("pobi");
    }
}