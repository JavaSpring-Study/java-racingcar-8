package racingcar.model.game;

import racingcar.model.car.CarStatus;
import racingcar.model.car.Cars;
import racingcar.model.generator.ValueGenerator;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class RacingGame {

    private final Cars cars;
    private final int attempts;
    private final List<List<CarStatus>> roundSnapshots = new ArrayList<>();

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

    public void playRound(ValueGenerator generator) {
        cars.moveAll(generator);
        roundSnapshots.add(cars.getSnapshots());
    }

    public List<CarStatus> getCurrentRoundSnapshots() {
        if (roundSnapshots.isEmpty()) {
            return List.of();
        }
        List<CarStatus> lastRound = roundSnapshots.get(roundSnapshots.size() - 1);
        return lastRound.stream()
                .map(status -> new CarStatus(status.name(), status.position()))
                .collect(Collectors.toList());
    }

    public List<List<CarStatus>> getAllRoundSnapshots() {
        return roundSnapshots.stream()
                .map(round -> round.stream()
                        .map(status -> new CarStatus(status.name(), status.position()))
                        .collect(Collectors.toList()))
                .collect(Collectors.toList());
    }

    public List<String> returnWinners() {
        return cars.findWinners();
    }
}