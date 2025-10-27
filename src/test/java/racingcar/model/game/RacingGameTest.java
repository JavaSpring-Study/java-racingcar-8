package racingcar.model.game;

import org.junit.jupiter.api.Test;
import racingcar.model.car.Cars;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class RacingGameTest {

    @Test
    void 주어진_횟수만큼_경주를_진행한다() {
        Cars cars = Cars.valueOf(List.of("pobi", "woni"));
        RacingGame game = RacingGame.of(cars, 3);

        game.play(() -> 5);
        List<List<String>> results = game.getRoundResults();

        assertThat(results).hasSize(3);
        assertThat(results.get(2).get(0)).contains("-");
    }

    @Test
    void 시도_횟수가_0이면_예외() {
        Cars cars = Cars.valueOf(List.of("pobi"));
        assertThatThrownBy(() -> RacingGame.of(cars, 0))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void 시도_횟수가_음수면_예외() {
        Cars cars = Cars.valueOf(List.of("pobi"));
        assertThatThrownBy(() -> RacingGame.of(cars, -1))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void 라운드_결과는_깊은_복사이다() {
        Cars cars = Cars.valueOf(List.of("pobi"));
        RacingGame game = RacingGame.of(cars, 1);

        game.play(() -> 9);

        List<List<String>> firstCall = game.getRoundResults();
        List<List<String>> secondCall = game.getRoundResults();

        assertThat(firstCall).isNotSameAs(secondCall);

        assertThat(firstCall.get(0)).isNotSameAs(secondCall.get(0));
    }

    @Test
    void 최종_우승자를_반환한다() {
        Cars cars = Cars.valueOf(List.of("pobi", "woni"));
        RacingGame game = RacingGame.of(cars, 1);
        game.play(() -> 9);
        List<String> winners = game.returnWinners();
        assertThat(winners).containsExactlyInAnyOrder("pobi", "woni");
    }
}
