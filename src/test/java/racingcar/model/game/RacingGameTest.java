package racingcar.model.game;

import org.junit.jupiter.api.Test;
import racingcar.model.car.CarStatus;
import racingcar.model.car.Cars;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class RacingGameTest {

    @Test
    void 주어진_횟수만큼_경주를_진행한다() {
        Cars cars = Cars.of(List.of("pobi", "woni"));
        RacingGame game = RacingGame.of(cars, 3);
        for (int i = 0; i < 3; i++) {
            game.playRound(() -> 5);
        }
        List<List<CarStatus>> results = game.allRoundSnapshots();
        assertThat(results).hasSize(3);
        assertThat(results.get(2).get(0).position()).isGreaterThanOrEqualTo(1);
    }

    @Test
    void 시도_횟수가_0이면_예외() {
        Cars cars = Cars.of(List.of("pobi"));
        assertThatThrownBy(() -> RacingGame.of(cars, 0))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void 시도_횟수가_음수면_예외() {
        Cars cars = Cars.of(List.of("pobi"));
        assertThatThrownBy(() -> RacingGame.of(cars, -1))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void 라운드_결과는_깊은_복사이다() {
        Cars cars = Cars.of(List.of("pobi"));
        RacingGame game = RacingGame.of(cars, 1);

        game.playRound(() -> 9);

        List<List<CarStatus>> firstCall = game.allRoundSnapshots();
        List<List<CarStatus>> secondCall = game.allRoundSnapshots();

        assertThat(firstCall).isNotSameAs(secondCall);
        assertThat(firstCall.get(0)).isNotSameAs(secondCall.get(0));
        assertThat(firstCall.get(0).get(0))
                .usingRecursiveComparison()
                .isEqualTo(secondCall.get(0).get(0)); // 값은 동일해야 함
    }

    @Test
    void 최종_우승자를_반환한다() {
        Cars cars = Cars.of(List.of("pobi", "woni"));
        RacingGame game = RacingGame.of(cars, 1);
        game.playRound(() -> 9);
        List<String> winners = game.findWinners();
        assertThat(winners).containsExactlyInAnyOrder("pobi", "woni");
    }
}
