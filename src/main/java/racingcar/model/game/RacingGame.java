package racingcar.model.game;

import racingcar.model.car.Cars;
import racingcar.model.generator.ValueGenerator;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class RacingGame {

    private final Cars cars;
    private final int attempts;
    private final List<List<String>> roundResults = new ArrayList<>();

    private RacingGame(Cars cars, int attempts) {
        this.cars = cars;
        this.attempts = attempts;
    }

    public static RacingGame of(Cars cars, int attempts) {
        if (attempts <= 0) {
            throw new IllegalArgumentException("시도 횟수는 1 이상이어야 합니다.");
        }
        return new RacingGame(cars, attempts);
    }

    public void play(ValueGenerator generator) {
        for (int i = 0; i < attempts; i++) {
            cars.moveAll(generator);
            roundResults.add(cars.getStatus());
        }
    }

    public List<List<String>> getRoundResults() {
        return roundResults.stream()
                .map(inner -> new ArrayList<>(inner))
                .collect(Collectors.toList());
    }

    public List<String> returnWinners() {
        return cars.findWinners();
    }
}