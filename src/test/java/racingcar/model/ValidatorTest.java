package racingcar.model;

import org.junit.jupiter.api.Test;
import racingcar.model.constant.ExceptionMessages;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.assertj.core.api.Assertions.assertThat;

class ValidatorTest {

    @Test
    void 이름이_null이거나_빈문자열이면_예외() {
        assertThatThrownBy(() -> Validator.validateNames(null))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(ExceptionMessages.INPUT_EMPTY);

        assertThatThrownBy(() -> Validator.validateNames(List.of()))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(ExceptionMessages.INPUT_EMPTY);
    }

    @Test
    void 이름이_공백이거나_5자초과이면_예외() {
        assertThatThrownBy(() -> Validator.validateNames(List.of(" ")))
                .isInstanceOf(IllegalArgumentException.class);

        assertThatThrownBy(() -> Validator.validateNames(List.of("abcdef")))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(ExceptionMessages.INVALID_NAME_LENGTH);
    }

    @Test
    void 이름이_중복이면_예외() {
        assertThatThrownBy(() -> Validator.validateNames(List.of("pobi", "pobi")))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(ExceptionMessages.DUPLICATE_NAME);
    }

    @Test
    void 시도횟수가_null이거나_공백이면_예외() {
        assertThatThrownBy(() -> Validator.validateAttempts(null))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(ExceptionMessages.INPUT_EMPTY);

        assertThatThrownBy(() -> Validator.validateAttempts(" "))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(ExceptionMessages.INPUT_EMPTY);
    }

    @Test
    void 시도횟수가_숫자가_아니면_예외() {
        assertThatThrownBy(() -> Validator.validateAttempts("abc"))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(ExceptionMessages.INVALID_NUMBER_FORMAT);
    }

    @Test
    void 시도횟수가_0이하면_예외() {
        assertThatThrownBy(() -> Validator.validateAttempts("0"))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(ExceptionMessages.INVALID_NUMBER_RANGE);
    }

    @Test
    void 시도횟수가_유효하면_정수로_반환한다() {
        int count = Validator.validateAttempts("3");
        assertThat(count).isEqualTo(3);
    }
}