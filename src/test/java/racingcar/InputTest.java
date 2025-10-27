package racingcar;

import static org.assertj.core.api.Assertions.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import racingcar.message.ErrorMessage;
import racingcar.view.Input;

class InputTest {

	private final Input input = new Input();

	@DisplayName("자동차 이름 입력값에 공백이 포함된 경우 예외 발생")
	@ParameterizedTest
	@ValueSource(strings = {"yang    ", "po by"})
	void invalid_input(String inputs) {
		assertThatThrownBy(() -> input.validateCarNameInput(inputs))
			.isInstanceOf(IllegalArgumentException.class)
			.hasMessageContaining(ErrorMessage.TRIM_ERROR);
	}

	@DisplayName("자동차 이름 입력을 안한 경우 예외 발생")
	@ParameterizedTest
	@ValueSource(strings = {" ", ""})
	void no_input(String inputs) {
		assertThatThrownBy(() -> input.validateCarNameInput(inputs))
			.isInstanceOf(IllegalArgumentException.class)
			.hasMessage(ErrorMessage.DO_NOT_ENTER_CAR_NAME);
	}

	@DisplayName("시도 횟수가 음수, 0, 숫자가 아닌 경우 예외 발생")
	@ParameterizedTest
	@ValueSource(strings = {"-1", "0", "abc", "", " "})
	void invalidCountInput(String countInput) {
		assertThatThrownBy(() -> input.validateCountInput(countInput))
			.isInstanceOf(IllegalArgumentException.class)
			.satisfies(ex -> {
				String msg = ex.getMessage();
				if (countInput == null || countInput.isBlank()) {
					assert msg.equals(ErrorMessage.DO_NOT_ENTER_COUNT);
				} else if (countInput.equals("-1") || countInput.equals("0")) {
					assert msg.equals(ErrorMessage.NEGATIVE_NUMBER_NOT_ALLOWED);
				} else {
					assert msg.equals(ErrorMessage.ENTERED_NON_NUMERIC_VALUE);
				}
			});
	}

	@DisplayName("시도 횟수가 정상 입력인 경우 예외 없음")
	@ParameterizedTest
	@ValueSource(strings = {"1", "5", "10"})
	void validCountInput(String countInput) {
		assertThatCode(() -> input.validateCountInput(countInput))
			.doesNotThrowAnyException();
	}

}
