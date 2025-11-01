package racingcar;

import org.junit.jupiter.api.Test;

import racingcar.controller.RacingController;
import racingcar.domain.Car;
import racingcar.view.Output;

import java.util.List;

import static org.assertj.core.api.Assertions.*;

class RacingControllerTest {

	@Test
	void playGame_movesAllCars_correctly() {
		List<Car> cars = List.of(new Car("pobi"), new Car("jun"));
		RacingController game = new RacingController(cars, new NumberGeneratorStub(5));

		Output output = new Output();
		game.play(3, output); // 3번 라운드

		// 이동 거리 검증
		assertThat(cars.get(0).getDistance()).isEqualTo(3);
		assertThat(cars.get(1).getDistance()).isEqualTo(3);

		// 우승자 확인
		List<String> winners = game.getWinners();
		assertThat(winners).containsExactlyInAnyOrder("pobi", "jun");
	}
}
