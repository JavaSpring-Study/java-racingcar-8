package racingcar.model.car;

import racingcar.model.generator.ValueGenerator;
import racingcar.model.vo.CarName;
import racingcar.model.vo.Position;

public class Car {

    private final CarName name;
    private final Position position;

    public Car(String name) {
        this.name = new CarName(name);
        this.position = new Position();
    }

    public void move(ValueGenerator generator) {
        position.move(generator.getValue());
    }

    public String name() {
        return name.value();
    }

    public int position() {
        return position.value();
    }

    public boolean isWinner(int maxPosition) {
        return position.value() == maxPosition;
    }

    public CarStatus snapshot() {
        return new CarStatus(name.value(), position.value());
    }
}
