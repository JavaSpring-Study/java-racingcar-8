package racingcar.domain;

import racingcar.view.Input;

public class CarController {

	public void run() {
		Input input = new Input();
		String value = input.readInput();
	}
}
