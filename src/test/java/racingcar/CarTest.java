package racingcar;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;

import racingcar.domain.Car;

class CarTest {

	@Test
	void moveCar_whenRandomAbove4_increasesDistance() {
		Car car = new Car("pobi");
		car.move(5);
		assertThat(car.getDistance()).isEqualTo(1);
	}

	@Test
	void moveCar_whenRandomBelow4_distanceUnchanged() {
		Car car = new Car("pobi");
		car.move(3);
		assertThat(car.getDistance()).isEqualTo(0);
	}

	@Test
	void carToString_printDistanceCorrectly() {
		Car car = new Car("pobi");
		car.move(5); // 1칸 전진
		assertThat(car.toString()).isEqualTo("pobi : -");
	}
}
