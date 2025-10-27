package racingcar.view;

import camp.nextstep.edu.missionutils.Console;
import racingcar.message.ErrorMessage;
import racingcar.message.SuccessMessage;

public class Input {
	public String readInput() {

		System.out.println(SuccessMessage.INPUT_MESSAGE);
		String input = Console.readLine();
		return validateInput(input);
	}
	public String validateInput(String input) {
		//자동차 이름을 입력하지않은 경우
		if(input == null) {
			throw new IllegalArgumentException(ErrorMessage.DO_NOT_ENTER_CAR_NAME);
		}
		//자동차 이름에 공백이 포함된 경우
		if(input.trim().isEmpty() || input.contains(" ")){
			throw new IllegalArgumentException(ErrorMessage.TRIM_ERROR);
		}
		return input;
	}
}
