package racingcar.model;

import org.junit.jupiter.api.Test;
import racingcar.model.constant.ExceptionMessages;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.assertj.core.api.Assertions.assertThat;

class ValidatorTest {

    private final Validator validator = new Validator();

    @Test
    void 이름이_null이거나_빈문자열이면_예외() {
        assertThatThrownBy(() -> validator.validateNames(null))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(ExceptionMessages.INPUT_EMPTY);

        assertThatThrownBy(() -> validator.validateNames(List.of()))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(ExceptionMessages.INPUT_EMPTY);
    }

    @Test
    void 이름이_공백이거나_5자초과이면_예외() {
        assertThatThrownBy(() -> validator.validateNames(List.of(" ")))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(ExceptionMessages.INPUT_EMPTY);

        assertThatThrownBy(() -> validator.validateNames(List.of("abcdef")))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(ExceptionMessages.INVALID_NAME_LENGTH);
    }

    @Test
    void 이름이_중복이면_예외() {
        assertThatThrownBy(() -> validator.validateNames(List.of("pobi", "pobi")))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(ExceptionMessages.DUPLICATE_NAME);
    }

    @Test
    void 시도횟수가_null이거나_공백이면_예외() {
        assertThatThrownBy(() -> validator.validateAttempts(null))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(ExceptionMessages.INPUT_EMPTY);

        assertThatThrownBy(() -> validator.validateAttempts(" "))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(ExceptionMessages.INPUT_EMPTY);
    }

    @Test
    void 시도횟수가_숫자가_아니면_예외() {
        assertThatThrownBy(() -> validator.validateAttempts("abc"))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(ExceptionMessages.INVALID_NUMBER_FORMAT);
    }

    @Test
    void 시도횟수가_0이하면_예외() {
        assertThatThrownBy(() -> validator.validateAttempts("0"))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(ExceptionMessages.INVALID_NUMBER_RANGE);
    }

    @Test
    void 시도횟수가_유효하면_정수로_반환한다() {
        int count = validator.validateAttempts("3");
        assertThat(count).isEqualTo(3);
    }
}