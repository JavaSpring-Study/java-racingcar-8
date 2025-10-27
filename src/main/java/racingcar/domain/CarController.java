package racingcar.domain;

import racingcar.view.Input;

public class CarController {

	public void run() {
		Input input = new Input();
		String carname = input.readCardNameInput();
		Integer count = input.readCount();
	}
}
