package racingcar.model.game;

import racingcar.model.car.CarStatus;
import racingcar.model.car.Cars;
import racingcar.model.constant.ExceptionMessages;
import racingcar.model.generator.ValueGenerator;
import racingcar.model.vo.RoundLimit;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class RacingGame {

    private final Cars cars;
    private final RoundLimit roundLimit;
    private final List<List<CarStatus>> roundSnapshots = new ArrayList<>();

    private RacingGame(Cars cars, RoundLimit roundLimit) {
        this.cars = cars;
        this.roundLimit = roundLimit;
    }

    public static RacingGame of(Cars cars, RoundLimit roundLimit) {
        return new RacingGame(cars, roundLimit);
    }

    public void playRound(ValueGenerator generator) {
        if (!roundLimit.hasRemaining(roundSnapshots.size())) {
            throw new IllegalStateException(ExceptionMessages.EXCEEDED_ROUND_LIMIT.get());
        }
        cars.moveAll(generator);
        roundSnapshots.add(cars.snapshots());
    }

    public List<CarStatus> currentRoundSnapshots() {
        if (roundSnapshots.isEmpty()) {
            return List.of();
        }
        List<CarStatus> lastRound = roundSnapshots.get(roundSnapshots.size() - 1);
        return lastRound.stream()
                .map(status -> new CarStatus(status.name(), status.position()))
                .collect(Collectors.toList());
    }

    public List<List<CarStatus>> allRoundSnapshots() {
        return roundSnapshots.stream()
                .map(round -> round.stream()
                        .map(status -> new CarStatus(status.name(), status.position()))
                        .collect(Collectors.toList()))
                .collect(Collectors.toList());
    }

    public List<String> findWinners() {
        return cars.findWinners();
    }
}
