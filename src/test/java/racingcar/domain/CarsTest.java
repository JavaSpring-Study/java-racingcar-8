package racingcar.domain;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class CarsTest {

    @Test
    @DisplayName("가장 많이 이동한 자동차를 우승자로 반환한다")
    void returnsCorrectWinner() {
        Cars cars = new Cars(List.of("pobi", "woni", "jun"));

        // pobi 2칸, woni 1칸, jun 2칸
        cars.getCars().get(0).move(4);
        cars.getCars().get(0).move(4);
        cars.getCars().get(1).move(4);
        cars.getCars().get(2).move(4);
        cars.getCars().get(2).move(4);

        List<String> winners = cars.getWinners();

        assertThat(winners).containsExactlyInAnyOrder("pobi", "jun");
    }
}