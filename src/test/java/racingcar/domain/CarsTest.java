package racingcar.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import racingcar.strategy.MoveStrategy;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class CarsTest {

    @Test
    @DisplayName("자동차 이름 리스트로 Cars를 생성할 수 있다")
    void createCars() {
        List<String> names = List.of("pobi", "woni", "jun");
        Cars cars = new Cars(names);

        assertEquals(3, cars.getSize());
    }

    @Test
    @DisplayName("가장 멀리 이동한 자동차가 우승자이다 - 단일")
    void findWinner() {
        List<String> names = List.of("pobi", "woni", "jun");
        Cars cars = new Cars(names);
        MoveStrategy movableStrategy = () -> true;
        MoveStrategy notMovableStrategy = () -> false;

        cars.moveAll(movableStrategy);
        cars.moveAll(notMovableStrategy);
        cars.moveAll(notMovableStrategy);

        List<String> winners = cars.getWinner();

        assertEquals(1, winners.size());
        assertTrue(winners.contains("pobi"));
        assertFalse(winners.contains("woni"));
        assertFalse(winners.contains("jun"));
    }

    @Test
    @DisplayName("가장 멀리 이동한 자동차가 우승자이다 - 여러명")
    void findWinners() {
        List<String> names = List.of("pobi", "woni", "jun");
        Cars cars = new Cars(names);
        MoveStrategy movableStrategy = () -> true;

        cars.moveAll(movableStrategy);
        cars.moveAll(movableStrategy);
        cars.moveAll(movableStrategy);

        List<String> winners = cars.getWinners();

        assertEquals(3, winners.size());
        assertTrue(winners.contains("pobi"));
        assertTrue(winners.contains("woni"));
        assertTrue(winners.contains("jun"));
    }

}