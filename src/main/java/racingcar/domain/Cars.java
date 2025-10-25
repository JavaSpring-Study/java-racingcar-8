package racingcar.domain;

import racingcar.strategy.RandomNumberMoveStrategy;

import java.util.List;

public class Cars {

    private final List<Car> cars;

    public Cars(List<String> names) {
        this.cars = names.stream()
                .map(Car::new)
                .toList();
    }

    public int getSize() {
        return cars.size();
    }

    public void moveAll() {
        for (Car car : cars) {
            car.move(new RandomNumberMoveStrategy());
        }
    }

    public List<String> getWinners() {
        int maxPosition = findMaxPosition();
        return cars.stream()
                .filter(car -> car.getPosition() == maxPosition)
                .map(Car::getName)
                .toList();
    }

    private int findMaxPosition() {
        return cars.stream()
                .mapToInt(Car::getPosition)
                .max()
                .orElse(0);
    }
}
