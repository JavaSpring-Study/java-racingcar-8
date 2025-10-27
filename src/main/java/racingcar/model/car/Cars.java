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

    public static Cars valueOf(List<String> names) {
        if (names == null || names.isEmpty()) {
            throw new IllegalArgumentException(ExceptionMessages.INPUT_EMPTY);
        }

        List<Car> carList = names.stream()
                .map(Car::new)
                .collect(Collectors.toUnmodifiableList());

        return new Cars(carList);
    }

    private void validateDuplicateNames(List<Car> cars) {
        Set<String> uniqueNames = cars.stream()
                .map(Car::getName)
                .collect(Collectors.toSet());
        if (uniqueNames.size() != cars.size()) {
            throw new IllegalArgumentException(ExceptionMessages.DUPLICATE_NAME);
        }
    }

    public void moveAll(ValueGenerator generator) {
        cars.forEach(car -> car.move(generator));
    }

    public int getMaxPosition() {
        return cars.stream()
                .mapToInt(Car::getPosition)
                .max()
                .orElse(0);
    }

    public List<Car> getWinners() {
        int maxPosition = getMaxPosition();
        return cars.stream()
                .filter(car -> car.isWinner(maxPosition))
                .collect(Collectors.toUnmodifiableList());
    }

    public List<Car> getCars() {
        return List.copyOf(cars);
    }
}
