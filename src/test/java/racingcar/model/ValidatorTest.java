package racingcar.model;

import org.junit.jupiter.api.Test;
import racingcar.model.constant.ExceptionMessages;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

class ValidatorTest {

    private final Validator validator = new Validator();

    @Test
    void 입력값이_null이면_예외() {
        assertThatThrownBy(() -> validator.validateInputExists(null))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(ExceptionMessages.INPUT_NULL.get());
    }

    @Test
    void 입력값이_공백이면_예외() {
        assertThatThrownBy(() -> validator.validateInputExists("   "))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(ExceptionMessages.INPUT_BLANK.get());
    }

    @Test
    void 입력값이_정상이라면_예외가_발생하지_않는다() {
        validator.validateInputExists("pobi"); // 예외 발생하지 않아야 함
    }
}
