package racingcar.controller;

import racingcar.domain.Car;
import racingcar.domain.NumberGenerator;
import racingcar.message.ErrorMessage;
import java.util.*;
import java.util.stream.Collectors;

public class RacingController {
	private final List<Car> cars;
	private final NumberGenerator generator;

	public RacingController(List<Car> cars, NumberGenerator generator) {
		this.cars = cars;
		this.generator = generator;
	}

	// n회 시도
	public void play(int tryCount, racingcar.view.Output output) {
		for (int i = 0; i < tryCount; i++) {
			moveAllCars();
			output.printRoundResult(cars);
		}
	}

	// 모든 자동차 이동
	private void moveAllCars() {
		for (Car car : cars) {
			int random = generator.generate();
			car.move(random);
		}
	}

	// 우승자 반환
	public List<String> getWinners() {
		int maxPosition = cars.stream()
			.mapToInt(Car::getDistance)
			.max()
			.orElseThrow(() -> new IllegalArgumentException(ErrorMessage.NO_WINNER));

		List<String> winners = cars.stream()
			.filter(car -> car.getDistance() == maxPosition)
			.map(Car::getName)
			.collect(Collectors.toList());

		if (winners.isEmpty()) {
			throw new IllegalArgumentException(ErrorMessage.NO_WINNER);
		}

		return winners;
	}
}
