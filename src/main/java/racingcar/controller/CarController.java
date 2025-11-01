package racingcar.controller;

import racingcar.domain.*;
import racingcar.external.RandomNumberGenerator;
import racingcar.view.Input;
import racingcar.view.Output;

import java.util.List;

public class CarController {

	public void run() {
		Input input = new Input();
		Output output = new Output();

		// 자동차 이름 입력
		List<String> carNames = input.readCarNameInput();

		// 생성자 참조 대신 람다로 안전하게 변환
		List<Car> cars = carNames.stream()
			.map(name -> new Car(name))
			.toList();

		// 시도 횟수 입력
		int tryCount = input.readCount();

		// 게임 실행
		RacingController game = new RacingController(cars, new RandomNumberGenerator());
		game.play(tryCount, output);

		// 최종 우승자 출력
		List<String> winners = game.getWinners();
		output.printWinners(winners);
	}
}
