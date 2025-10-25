package racingcar.domain;

public class Car {

    private final Name name;
    private Position position;

    public Car(String nameValue) {
        name = new Name(nameValue);
        position = new Position();
    }

    public int getPosition() {
        return position.getValue();
    }

    public String getName() {
        return name.getValue();
    }

}
