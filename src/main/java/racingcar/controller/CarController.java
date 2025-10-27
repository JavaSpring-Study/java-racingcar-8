package racingcar.domain;

import java.util.List;

import racingcar.view.Input;

public class CarController {

	public void run() {
		Input input = new Input();
		List<String> carname = input.readCarNameInput();
		Integer count = input.readCount();
	}
}
