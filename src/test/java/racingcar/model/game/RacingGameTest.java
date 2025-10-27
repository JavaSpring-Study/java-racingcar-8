package racingcar.model.game;

import org.junit.jupiter.api.Test;
import racingcar.model.car.Car;
import racingcar.model.car.Cars;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class RacingGameTest {

    @Test
    void 주어진_횟수만큼_경주를_진행한다() {
        Cars cars = Cars.valueOf(List.of("pobi", "woni"));
        RacingGame game = RacingGame.of(cars, 3);

        game.play(() -> 5); // 항상 이동
        List<List<String>> results = game.getRoundResults();

        assertThat(results).hasSize(3); // 3번 라운드
        assertThat(results.get(2).get(0)).contains("-");
    }

    @Test
    void 우승자를_정확히_계산한다() {
        Cars cars = Cars.valueOf(List.of("pobi", "woni"));
        RacingGame game = RacingGame.of(cars, 1);

        // pobi만 이동
        game.play(() -> 9);
        List<String> winners = game.returnWinners();

        assertThat(winners).contains("pobi");
    }
}