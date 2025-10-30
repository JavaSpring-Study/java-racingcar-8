package racingcar.domain;

import racingcar.strategy.MoveStrategy;

public class Car {

    private final Name name;
    private Position position;

    public Car(String nameValue) {
        name = new Name(nameValue);
        position = new Position();
    }

    public void move(MoveStrategy strategy) {
        if (strategy.isMovable()) {
            position = position.move();
        }
    }

    public int getPosition() {
        return position.getValue();
    }

    public String getName() {
        return name.getValue();
    }

    public String displayCar() {
        return name.getValue() + " : " + position.displayPosition();
    }

}
