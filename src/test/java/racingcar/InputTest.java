package racingcar;

import static org.assertj.core.api.Assertions.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import racingcar.message.ErrorMessage;
import racingcar.view.Input;

class InputTest {

	private final Input input = new Input();

	@DisplayName("입력값에 공백이 포함된 경우 예외 발생")
	@ParameterizedTest
	@ValueSource(strings = {"", " ", "  ", "po by"})
	void invalid_input(String inputs) {
		assertThatThrownBy(() -> input.validateInput(inputs))
			.isInstanceOf(IllegalArgumentException.class)
			.hasMessageContaining(ErrorMessage.TRIM_ERROR);
	}

}
