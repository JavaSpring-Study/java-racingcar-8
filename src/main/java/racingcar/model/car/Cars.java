package racingcar.model.car;

import racingcar.model.constant.ExceptionMessages;
import racingcar.model.generator.ValueGenerator;

import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

public class Cars {

    private final List<Car> cars;

    private Cars(List<Car> cars) {
        validateDuplicateNames(cars);
        this.cars = cars;
    }

    public static Cars of(List<String> names) {
        if (names == null || names.isEmpty()) {
            throw new IllegalArgumentException(ExceptionMessages.INPUT_EMPTY.get());
        }

        List<Car> carList = names.stream()
                .map(Car::new)
                .collect(Collectors.toUnmodifiableList());

        return new Cars(carList);
    }

    private void validateDuplicateNames(List<Car> cars) {
        Set<String> uniqueNames = cars.stream()
                .map(Car::name)
                .collect(Collectors.toSet());
        if (uniqueNames.size() != cars.size()) {
            throw new IllegalArgumentException(ExceptionMessages.DUPLICATE_NAME.get());
        }
    }

    public void moveAll(ValueGenerator generator) {
        cars.forEach(car -> car.move(generator));
    }

    public int maxPosition() {
        return cars.stream()
                .mapToInt(Car::position)
                .max()
                .orElse(0);
    }

    public List<String> findWinners() {
        int maxPosition = maxPosition();
        return cars.stream()
                .filter(car -> car.isWinner(maxPosition))
                .map(Car::name)
                .collect(Collectors.toUnmodifiableList());
    }

    public List<CarStatus> snapshots() {
        return cars.stream()
                .map(Car::snapshot)
                .collect(Collectors.toList());
    }

    public List<Car> cars() {
        return List.copyOf(cars);
    }
}
